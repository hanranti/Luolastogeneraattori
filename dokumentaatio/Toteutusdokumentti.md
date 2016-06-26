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
    * uloskäyntien luominen
      * aikavaativuus
        * min Ω(1)
        * max O(n), jossa n = huoneen leveys
      * tilavaativuus 
        * min Ω(1)
        * max O(n)
    * käytävien luominen
      * aikavaativuus O(n²), jossa n = huoneiden ja uloskäyntien yhteismäärä
      * tilavaativuus O(n)
  * reunojen generointi
    * aikavaativuus O(n²), jossa n = huoneen leveys
