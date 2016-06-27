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
            * Koska m = kaarten määrä * (kaarten määrä - 1), aikavaativuus on O(1 (log 1 + n)) = O(n)
      * tilavaativuus
        * max O(n³), jossa n = luolan leveys
          * Tilavaativuus on maksimissaan kaarien lisäämisestä kekoon aiheutuva O(n²) + Kruskalin tilavaativuus, johon on lisätty kaytavan luomiseen kuluva tila, O(m * n), jossa m = huoneiden ja uloskäyntien välisten kaarien määrä.
            * Koska m = n * (n-1), tilavaativuus on O(n²) + O(n² * n) eli O(n³)
        * min Ω(n), jossa n = luolan leveys
          * Minimissään tilavaativuus on O(m * n), jossa m on huoneiden ja uloskäyntien välisten kaarien määrä.
            * Koska m = kaarten määrä * (kaarten määrä - 1), tilavaativuus on O(1 * n) = O(n)
      * Luolan leveyden katsominen solmujen määräksi maksimitapauksissa perustuu siihen, että huoneiden määrä perustuu tällöin luolan leveydestä laskettavaan lukuun.
      
    * alueiden generointi(generoiAvoimetAlueet)
      * aikavaativuus O(n²), jossa n = luolan leveys
        * Leveyssuuntaisen läpikäynnin aikavaativuus on O (n² + m) eli O(n²) (m = kaarten määrä)(n² = solmujen määrä). 
      * tilavaativuus O(n²), jossa n = luolan leveys
        * Leveyssuuntaisen läpikäynnin tilavaativuus on O(n²) (n² = solmujen määrä).
      
    * aikavaativuus O(n³), jossa n = luolan leveys
      * Kaytavien luominen vie eniten aikaa eli avointen alueiden generoinnin kokonaisaikavaativuus on O(n³).
    * tilavaativuus O(n³), jossa n = luolan leveys
      * Alueiden generointi vie eniten tilaa eli avointen alueiden generoinnin kokonaistilavaativuus on O(n³).
    
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

SuorituskykyTestauksen tulokset heittelevät paljon, joten testaan metodit kertaa.

### Puutteet ja parannusehdotukset

