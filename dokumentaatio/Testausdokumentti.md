# Testausdokumentti

Kaikki testit ovat toteutettu käyttäen JUnit 4.10.

### Tietorakenteet

* Jono
  * Testaan jonoa lisäämällä ja poistamalla olioita ja testaamalla joka välissä, että jono palauttaa oikean olion ja, että jonon koko on oikea.
  * Testaan, että jonon taulukon kaksinkertaistaminen toimii, lisäämällä olioita yli taulukon koon ja testaamalla, että oikeat oliot palautetaan jonosta.

* Kaari
  * Testaan, että kaari palauttaa sille alussa annetut arvot.

* Keko
  * Testaan minimi- ja maksimikekoa erikseen.
    * Lisään olioita insertillä kekoon ja testaan, että keko palauttaa oikean olion juuri ja poistaJuuri -metodeilla.
    * Käytän keon oikean järjestyksen tarkastamiseen metodia, joka tarkistaa, että jokaisen olion arvo on maksimikeossa pienempi kuin tämän vanhempi ja suurempi kuin tämän lapset, ja minimikeossa päinvastoin.
      * Olioiden arvoihin päästään käsiksi FieldAccess -luokalla
    * Testaan minimi- ja maksimikekoa lisäämällä niihin olioita niin, että keon taulukon koko täytyy kaksinkertaistaa kaksi kertaa, testaan onko keko järjestyksessä ja testaan, että oliot palautetaan keosta oikeassa järjestyksessä.

* Lista
  * Testaan, että oliot, jotka on lisätty listaan ja joita ei ole poistettu, löytyvät listasta contains -metodilla, ja muita ei löydy.
  * Testaan, että listan getFirst ja getLast viittaavat oikeisiin solmuihin.
  * Testaan, että lista toimii oikein, kun sen taulukko kaksinkertaistetaan.

* Matematiikka
  * Testaan, että hypotenuusan pituus lasketaan oikein eri arvoila.

* Piste
  * Testaan, että piste palauttaa sille alussa annetut arvot.

* Solmu
  * Testaan, että solmu palauttaa sille annetun olion, ja, että olion getVasen() ja getOikea() viittaa oikeisiin solmuihin.

### Luolasto

### Työkalut

* FieldAccess
  * Mahdollistaa pääsyn private näkyvyyden muuttujiin testattavassa luokassa
  
* MethodInvoker
  * Mahdollistaa, private näkyvyyden metodien suorittamisen testattavassa oliossa

## Suorituskykytestaus

* Luolastogeneraattori
  * Generoi -metodin suoritusnopeus 10000 kokeilun keskiarvolla:
    * Luolan koko :32 keskiarvo: 4466197ns eli noin 4,5ms
    * Luolan koko :50 keskiarvo: 1340217ns eli noin 1,3ms
    * Luolan koko: 100 keskiarvo: 6935111ns eli noin 6,9ms
