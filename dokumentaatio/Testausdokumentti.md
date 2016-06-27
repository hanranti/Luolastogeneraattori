# Testausdokumentti

Kaikki testit ovat toteutettu käyttäen JUnit 4.10.
Testit voidaan toistaa viemällä repositorion netbeans projekti Netbeansiin ja ajamalla testit ohjelmassa.

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
 
* UnionFind
  * Testaan, että unionFindille annetut oliot eivät ole valmiiksi yhdistettyjä.
  * Testaan, että yhdistämisen union -metodilla jälkeen find -metodi antaa yhdistetyille olioille saman arvon.
  * Testaan, että oliolle, jota ei ole lisätty unionFind -rakenteeseen, find antaa arvoksi -1.
  * Testaan, että unionFind toimii oikein, kun sen taulukon kokoa kasvatetaan.

### Luolasto

* Luola
  * Testaan, että luotu luola on sille alussa annetuissa koordinaateissa, ja, että sille annettu luolan leveys on oikea.
  * Testaan, että, kun luola generoidaan, huoneita on enemmän kuin 0.
 
* Luolageneraattori
  * Testaan, että luotu luola sisältää ainakin yhden uloskäynnin.
  * Testaan, että kaikista uloskäynneistä on polut toisiinsa.

* Luolasto
  * Testaan, että luolaston koon kaksinkertaistaessa luolan muutos metodi saa oikean arvon eli luolaston ulospäin näkyvät koordinaatit vastaavat luolaston sisälle näkyviä koordinaatteja oikein.
  * Testaan, että sama toimii myös kun luolaston ulkopuolelle generoidaan luolia.
  * Testaan, että luolaston kaksinkertaistaminen säilyttää luolat niiden oikeissa koordinaateissa.

* Pelaaja
  * Testaan, että pelaajan koordinaatit ovat oikeita, kun pelaaja liikkuu luolassa tai luolasta toiseen.
  * Testaan, että myös pelaajan luolakoordinaatit ovat oikeita.
  * Testaan, että pelaaja ei voi liikkua seinien läpi.

* Luolastogeneraattori
  * Testaan, että pelaajan asetus luolaan asettaa pelaajan paikkaan, josta on polu kaikkiin uloskäynteihin.

### Työkalut

* FieldAccess
  * Mahdollistaa pääsyn private näkyvyyden muuttujiin testattavassa luokassa
  * getField(Object object, String field) palauttaa field nimisen muuttujan object oliosta
  * getArray(Object object, String field) palauttaa field nimisen taulukon object oliosta
  
* MethodInvoker
  * Mahdollistaa, private näkyvyyden metodien suorittamisen testattavassa oliossa
  * MethodInvoker(Object object) luo MethodInvoker -olion, ja asettaa tälle olioksi object
  * invokeMethod(String methodName, Object... objects) suorittaa MethodInvoker -olion methodName nimisen metodin antaen tälle parametriksi objects
