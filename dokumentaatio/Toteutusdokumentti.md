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

* Luolan generointi: 
  * avointen alueiden generointi
    * huoneiden luominen
      * aikavaativuus O(1)
      * tilavaativuus O(1)
        * Huoneita luodaan aina vakiomäärä.
      
    * uloskäyntien luominen
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
        
    * käytävien luominen
      * käytävän luominen
        * aikavaativuus O(n), jossa n = luolan leveys
        * tilavaativuus O(n), jossa n = luolan leveys
          * Kaytavan luominen kulkee pisimmillään kulmasta kulmaan eli 2 n matkan. Kaytavanluomismetodi kutsuu siis itseään maksimissaan 2n kertaa eli aika- ja tilavaativuus on lineaarinen.
        
      * aikavaativuus O(n³), jossa n = huoneiden ja uloskäyntien yhteismäärä
        * Aikavaativuus on kaarien lisäämisestä kekoon aiheutuva O(n²) + Kruskalin aikavaativuus, johon on lisätty yhden kaytavan luomiseen kuluva aika, O(m (log n + n)), jossa m = huoneiden ja uloskäyntien välisten kaarien määrä.
        * Koska m = n * (n-1), aikavaativuus on O(n²) + O(n² (log n + n)) = O(n³ + n² * log n) = O(n³)
      * tilavaativuus O(n³), jossa n = huoneiden ja uloskäyntien yhteismäärä
        * Tilavaativuus on kaarien lisäämisestä kekoon aiheutuva O(n²) + Kruskalin tilavaativuus, johon on lisätty kaytavan luomiseen kuluva tila, O(m * n), jossa m = huoneiden ja uloskäyntien välisten kaarien määrä.
        * Koska m = n * (n-1), tilavaativuus on O(n²) + O(n² * n) eli O(n³)
      * Kaytavien generoinnin aika- ja tilavaativuus on kuitenkin vakio suhteessa muuhun luolan generointiin, koska huoneiden ja uloskäyntien määrä on vakio.
      
    * alueiden generointi
      * aikavaativuus O(n²), jossa n = luolan leveys
        * Leveyssuuntaisen läpikäynnin aikavaativuus on O (n² + m) eli O(n²) (m = kaarten määrä)(n² = solmujen määrä). 
      * tilavaativuus O(n²), jossa n = luolan leveys
        * Leveyssuuntaisen läpikäynnin tilavaativuus on O(n²) (n² = solmujen määrä).
      
    * aikavaativuus O(n²), jossa n = luolan leveys
      * Alueiden generointi vie eniten aikaa eli avointen alueiden generoinnin kokonaisaikavaativuus on O(n²).
    * tilavaativuus O(n²), jossa n = luolan leveys
      * Alueiden generointi vie eniten tilaa eli avointen alueiden generoinnin kokonaistilavaativuus on O(n²).
    
  * reunojen generointi
    * aikavaativuus O(n²), jossa n = luolan leveys
      * Leveyssuuntaisen läpikäynnin aikavaativuus on O (n² + m) eli O(n²) (m = kaarten määrä)(n² = solmujen määrä). 
    * tilavaativuus O(n²), jossa n = luolan leveys
      * Leveyssuuntaisen läpikäynnin tilavaativuus on O(n²) (n² = solmujen määrä).
    
  * aikavaativuus O(n²), jossa n = luolan leveys
    * Avointen alueiden generointi ja reunojen generointi vievät kumpikin aikaa O(n²) eli aikavaativuus on O(n²).
  * tilavaativuus O(n²), jossa n = luolan leveys
    * Avointen alueiden generointi ja reunojen generointi vievät kumpikin tilaa O(n²) eli tilavaativuus on O(n²).
    
* pelaajan asettaminen luokkaan
  * aikavaativuus O(n²), jossa n = luolan leveys
    * Leveyssuuntaisen läpikäynnin aikavaativuus on O (n² + m) eli O(n²) (m = kaarten määrä)(n² = solmujen määrä). 
  * tilavaativuus O(n²), jossa n = luolan leveys
      * Leveyssuuntaisen läpikäynnin tilavaativuus on O(n²) (n² = solmujen määrä).

### Suorituskykytestaus

### Puutteet ja parannusehdotukset

* Luolan koko voisi vaikuttaa huoneiden määrään, jotta suuremmissa luolissa olisi enemmän huoneita.
