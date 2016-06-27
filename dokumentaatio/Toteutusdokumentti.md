# Toteutusdokumentti

### Ohjelman yleisrakenne:

* Luolasto, joka sisältää taulukon luolista
  * Luolaston kokoa voidaan kasvattaa, jos sen alueen ulkopuolelle kuljetaan
* Luola, joka sisältää luolan seinät ja avoimet alueet määrittävän boolean[][] -taulukon
* Luolageneraattori, joka generoi sille annettuihin luoliin avoimia alueita
  * Luolaan luodaan huoneita ja käytäviä
  * Huoneita luodaan satunnainen määrä satunnaisiin paikkoihin
    * Huoneen generaatiossa käytetään muunneltua leveyssuuntaista läpikäyntiä
  * Käytävät yhdistävät huoneet, pienimmäksi virittäväksi puuksi käyttäen Kruskalia
* Luolastogeneraattori, joka käynnistää ohjelman ja kysyy pelaajan siirtoja
* GUI, joka tulostaa luolia ja pelaajan luolassa

### Aika- ja tilavaativuudet

* Luolan generointi(Luolageneraattori -generoi) 
  * avointen alueiden generointi
    * huoneiden luominen(luoHuoneet)
      * aikavaativuus
        * max O(n), jossa n = luolan leveys
        * min O(1)
      * tilavaativuus
        * max O(n), jossa n = luolan leveys
        * min O(1)
      * Huoneiden määrä perustuu satunaislukuun, joka on luotu käyttäen luolan leveyttä.
      ```
      int s = random.nextInt(8) + 1;
      int m = size;
      m /= 10;
      int m2 = m;
      m *= s;
      m2 *= (10 - s);
      m++;
      ```
      * Metodissa luoHuoneet lukua m käytetään huoneiden määrän maksimilukuna.
      ```
      int maara = random.nextInt(m) + 1;
      ```
      * Kun luolan leveys on n,
        * maksimiaikavaativuus on O(((n / 10) * 9 + 1) + 1) = O(n)
        * minimiaikavaativuus on O(1), jos luoHuoneet -metodissa random.nextInt(m) antaa luvun 0.
        * sama pätee tilavaativuuksiin
      
    * uloskäyntien luominen(luoUloskaynnit)
      * aikavaativuus
        * min Ω(1)
          * Jos yhtäkään viereistä luolaa ei ole generoitu, aikavaativuus on vakio, koska uusia uloskäyntejä luodaan aina vakio määrä.
        * max O(n), jossa n = luolan leveys
          * Kun luolan vieressä on generoitu luola, viereisen luolan reunan vastaisten koordinaattien lisääminen jonoon vie lineaarisen ajan.
      * tilavaativuus 
        * min Ω(1)
          * Jos yhtäkään viereistä luolaa ei ole generoitu, tilavaativuus on vakio, koska uusia uloskäyntejä luodaan aina vakio määrä.
        * max O(n), jossa n = luolan leveys
          * Kun luolan vieressä on generoitu luola, viereisen luolan reunan vastaisten koordinaattien lisääminen jonoon vie lineaarisen tilan.
        
    * käytävien luominen(luoKaytavat)
      * käytävän luominen(luoPolku)
        * aikavaativuus O(n), jossa n = luolan leveys
        * tilavaativuus O(n), jossa n = luolan leveys
          * Kaytavan luominen kulkee pisimmillään kulmasta kulmaan eli 2 n matkan. Kaytavanluomismetodi kutsuu siis itseään maksimissaan 2n kertaa eli aika- ja tilavaativuus on lineaarinen.
        
      * aikavaativuus
        * max O(n³), jossa n = luolan leveys
          * Aikavaativuus on maksimissaan kaarien lisäämisestä kekoon aiheutuva O(n²) + Kruskalin aikavaativuus, johon on lisätty yhden kaytavan luomiseen kuluva aika, O(m (log n + n)), jossa m = huoneiden ja uloskäyntien välisten kaarien määrä.
            * Koska m = n * (n-1), aikavaativuus on O(n²) + O(n² (log n + n)) = O(n³ + n² * log n) = O(n³)
        * min Ω(n), jossa n = luolan leveys
          * Minimissään aikavaativuus on O(m (log 1 + n)), jossa m on huoneiden ja uloskäyntien välisten kaarien määrä.
            * Koska m = solmujen määrä * (solmujen määrä - 1), aikavaativuus on O(1 (log 1 + n)) = O(n)
      * tilavaativuus
        * max O(n³), jossa n = luolan leveys
          * Tilavaativuus on maksimissaan kaarien lisäämisestä kekoon aiheutuva O(n²) + Kruskalin tilavaativuus, johon on lisätty kaytavan luomiseen kuluva tila, O(m * n), jossa m = huoneiden ja uloskäyntien välisten kaarien määrä.
            * Koska m = n * (n-1), tilavaativuus on O(n²) + O(n² * n) eli O(n³)
        * min Ω(n), jossa n = luolan leveys
          * Minimissään tilavaativuus on O(m * n), jossa m on huoneiden ja uloskäyntien välisten kaarien määrä.
            * Koska m = solmujen määrä * (solmujen määrä - 1), tilavaativuus on O(1 * n) = O(n)
      * Luolan leveyden katsominen solmujen määräksi maksimitapauksissa perustuu siihen, että huoneiden määrä perustuu tällöin luolan leveydestä laskettavaan lukuun.
      
    * alueiden generointi(generoiAvoimetAlueet)
      * aikavaativuus O(n²), jossa n = luolan leveys
        * Leveyssuuntaisen läpikäynnin aikavaativuus on O (n² + m) eli O(n²) (m = kaarten määrä)(n² = solmujen määrä). 
      * tilavaativuus O(n²), jossa n = luolan leveys
        * Leveyssuuntaisen läpikäynnin tilavaativuus on O(n²) (n² = solmujen määrä).
      
    * aikavaativuus 
      * max O(n³), jossa n = luolan leveys
        * Kaytavien luominen vie eniten aikaa eli avointen alueiden generoinnin kokonaisaikavaativuus on O(n³).
      * min Ω(n²), jossa n = luolan leveys
        * Parhaassa tapauksessa kaytavien luominen vie Ω(n) aikaa, jolloin alueiden generointi vie eniten aikaa.
    * tilavaativuus 
      * max O(n³), jossa n = luolan leveys
        * kaytavien luominen vie eniten tilaa eli avointen alueiden generoinnin kokonaistilavaativuus on O(n³).
      * min Ω(n²), jossa n = luolan leveys
        * Parhaassa tapauksessa kaytavien luominen vie Ω(n) tilaa, jolloin alueiden generointi vie eniten tilaa.
    
  * reunojen generointi(generoiReunat)
    * aikavaativuus O(n²), jossa n = luolan leveys
      * Leveyssuuntaisen läpikäynnin aikavaativuus on O (n² + m) eli O(n²) (m = kaarten määrä)(n² = solmujen määrä). 
    * tilavaativuus O(n²), jossa n = luolan leveys
      * Leveyssuuntaisen läpikäynnin tilavaativuus on O(n²) (n² = solmujen määrä).
    
  * aikavaativuus O(n³), jossa n = luolan leveys
    * Avointen alueiden generointi vie eniten aikaa O(n³).
  * tilavaativuus O(n³), jossa n = luolan leveys
    * Avointen alueiden generointi vie eniten tilaa O(n³).
    
* pelaajan asettaminen luokkaan(Luolastogeneraattori -asetaPelaajaLuolaan)
  * aikavaativuus O(n²), jossa n = luolan leveys
    * Leveyssuuntaisen läpikäynnin aikavaativuus on O (n² + m) eli O(n²) (m = kaarten määrä)(n² = solmujen määrä). 
  * tilavaativuus O(n²), jossa n = luolan leveys
      * Leveyssuuntaisen läpikäynnin tilavaativuus on O(n²) (n² = solmujen määrä).

### Suorituskykytestaus

SuorituskykyTestauksen tulokset heittelevät paljon, joten otan jokaisen metodin tuloksen 100000 suorituksen keskiarvosta.

Kaikki testit koskevat Luolageneraattori -luokan metodeita.

Suorituskykytestit voidaan ajaa muuttamalla tarvittavat metodit public:ksi, poistamalla halutut testit kommenteista suorituskykytestaus.luolasto.LuolaogeneraattoriSuorituskykyTest -luokassa ja ajamalla JUnit testit.

#### Tulokset

Tulokset on nimetty: "test" testattavan metodin nimi ("KunVieressaOn" X "Luolaa") "LuolanKoolla" Y

```
testLuoHuoneetLuolanKoolla32
Keskiarvo: 2231ns
testLuoHuoneetLuolanKoolla50
Keskiarvo: 3893ns
testLuoHuoneetLuolanKoolla100
Keskiarvo: 6712ns
testLuoHuoneetLuolanKoolla200
Keskiarvo: 21994ns
testLuoUlosKaynnitLuolanKoolla32
Keskiarvo: 3575ns
testLuoUlosKaynnitLuolanKoolla50
Keskiarvo: 3589ns
testLuoUlosKaynnitLuolanKoolla100
Keskiarvo: 1520ns
testLuoUlosKaynnitLuolanKoolla200
Keskiarvo: 2108ns
testLuoUloskaynnitKunVieressaOn1LuolaLuolanKoolla32
Keskiarvo: 2354ns
testLuoUloskaynnitKunVieressaOn1LuolaLuolanKoolla50
Keskiarvo: 3151ns
testLuoUloskaynnitKunVieressaOn1LuolaLuolanKoolla100
Keskiarvo: 3290ns
testLuoUloskaynnitKunVieressaOn1LuolaLuolanKoolla200
Keskiarvo: 6683ns
testLuoUloskaynnitKunVieressaOn2LuolaaLuolanKoolla32
Keskiarvo: 3520ns
testLuoUloskaynnitKunVieressaOn2LuolaaLuolanKoolla50
Keskiarvo: 3017ns
testLuoUloskaynnitKunVieressaOn2LuolaaLuolanKoolla100
Keskiarvo: 4038ns
testLuoUloskaynnitKunVieressaOn2LuolaaLuolanKoolla200
Keskiarvo: 7995ns
testLuoUloskaynnitKunVieressaOn3LuolaaLuolanKoolla32
Keskiarvo: 2971ns
testLuoUloskaynnitKunVieressaOn3LuolaaLuolanKoolla50
Keskiarvo: 4091ns
testLuoUloskaynnitKunVieressaOn3LuolaaLuolanKoolla100
Keskiarvo: 5698ns
testLuoUloskaynnitKunVieressaOn3LuolaaLuolanKoolla200
Keskiarvo: 8142ns
testLuoUloskaynnitKunVieressaOn4LuolaaLuolanKoolla32
Keskiarvo: 3803ns
testLuoUloskaynnitKunVieressaOn4LuolaaLuolanKoolla50
Keskiarvo: 4761ns
testLuoUloskaynnitKunVieressaOn4LuolaaLuolanKoolla100
Keskiarvo: 5686ns
testLuoUloskaynnitKunVieressaOn4LuolaaLuolanKoolla200
Keskiarvo: 9734ns
testLuoKaytavatLuolanKoolla32
Keskiarvo: 80059ns
testLuoKaytavatLuolanKoolla50
Keskiarvo: 124379ns
testLuoKaytavatLuolanKoolla100
Keskiarvo: 374712ns
testLuoKaytavatLuolanKoolla200
Keskiarvo: 1346867ns
testGeneroiAvoimetAlueetLuolanKoolla32
Keskiarvo: 222560ns
testGeneroiAvoimetAlueetLuolanKoolla50
Keskiarvo: 456007ns
testGeneroiAvoimetAlueetLuolanKoolla100
Keskiarvo: 1789861ns
testGeneroiAvoimetAlueetLuolanKoolla200
Keskiarvo: 7752384ns
testGeneroiReunatLuolanKoolla32
Keskiarvo: 330319ns
testGeneroiReunatLuolanKoolla50
Keskiarvo: 838605ns
testGeneroiReunatLuolanKoolla100
Keskiarvo: 3514462ns
testGeneroiReunatLuolanKoolla200
Keskiarvo: 13204524ns
testGeneroiLuolanKoolla32
Keskiarvo: 437193ns
testGeneroiLuolanKoolla50
Keskiarvo: 819044ns
testGeneroiLuolanKoolla100
Keskiarvo: 1440416ns
testGeneroiLuolanKoolla200
Keskiarvo: 4359624ns
testGeneroiKunVieressaOn1LuolaLuolanKoolla32
Keskiarvo: 357922ns
testGeneroiKunVieressaOn1LuolaLuolanKoolla50
Keskiarvo: 591842ns
testGeneroiKunVieressaOn1LuolaLuolanKoolla100
Keskiarvo: 1381234ns
testGeneroiKunVieressaOn1LuolaLuolanKoolla200
Keskiarvo: 3795622ns
testGeneroiKunVieressaOn2LuolaaLuolanKoolla32
Keskiarvo: 335604ns
testGeneroiKunVieressaOn2LuolaaLuolanKoolla50
Keskiarvo: 578248ns
testGeneroiKunVieressaOn2LuolaaLuolanKoolla100
Keskiarvo: 1371206ns
testGeneroiKunVieressaOn2LuolaaLuolanKoolla200
Keskiarvo: 3796017ns
testGeneroiKunVieressaOn3LuolaaLuolanKoolla32
Keskiarvo: 372961ns
testGeneroiKunVieressaOn3LuolaaLuolanKoolla50
Keskiarvo: 588668ns
testGeneroiKunVieressaOn3LuolaaLuolanKoolla100
Keskiarvo: 1364083ns
testGeneroiKunVieressaOn3LuolaaLuolanKoolla200
Keskiarvo: 3588200ns
testGeneroiKunVieressaOn4LuolaaLuolanKoolla32
Keskiarvo: 347043ns
testGeneroiKunVieressaOn4LuolaaLuolanKoolla50
Keskiarvo: 551724ns
testGeneroiKunVieressaOn4LuolaaLuolanKoolla100
Keskiarvo: 1351752ns
testGeneroiKunVieressaOn4LuolaaLuolanKoolla200
Keskiarvo: 3597270ns
```

Testasin generoi -metodia, sekä sen suorittamien metodien aikaa erikseen. Testasin myös generoi ja luoUloskaynnit -metodeita eri tapauksissa, joissa generoitavan luolan viereen on jo generoitu eri määrä luolia. Mitä enemmän luolan viereen on jo generoitu luolia, sitä pitempään luolan generoinnin tulisi kestää. Satunnaisuus vaikuttaa paljon kuluvaan aikaan kaikissa metodeissa, joten jokaisen metodin eri suorituksen kesto voi vaihdella paljon, mikä näkyykin tuloksissa esimerkiksi luoUloskaynnit -metodeissa. Teen kaikki suorituskykytestit erikseen 32, 50, 100, ja 200 levyisille luolille.

Repositorion dokumentaatio kansiossa on kuva ViereistenLuolienVaikutusLuolanGenerointiAikaan.png, josta näkyy y -akselilla aika nanosekunteina, ja x -akselilla erikseen eri kokoisten luolien generointi ajat, joissa on erikseen eri väreillä tulokset, generointiajoista, joissa generoitavan luolan vieressä on ollut eri määrä luolia.

### Puutteet ja parannusehdotukset

* Ohjelman olisi voinut saada toimimaan pienemmillä luolilla kuin 32. Pienet luolat generoituvat nyt usein täysin tyhjiksi.
* Luolat olisi voinut generoida siten, että jokaisesta luolan uloskäynnistä ei pääse toisiinsa. Halusin kuitenkin käyttää työssä pienimmän virittävän puun muodostavaa algoritmia.
* Ohjelmaan olisi voinut luoda lyhimmän reitin etsivän algoritmin(esim A*).
  * Ongelmana on, että kaikkia reittejä ei ole välttämättä vielä luotu, koska luolat generoidaan vasta, kun niihin kuljetaan.
  * Lyhimmän reitin etsiminen luolastossa, jossa jokaisesta luolan uloskäynnistä on reitti toisiinsa, ei tosin välttämättä olisi kovin mielenkiintoista.
