# Viikkoraportti 5

Käytin 3 tuntia,

* testien korjaamiseen
* UnionFindin korjaamiseen
  * Koska UnionFind toimii, nyt myös Kruskal toimii, joten huoneiden yhdistämisalgoritmi käytävillä toimii lähes oikein.
* lisäsin ohjelman parametrinä lisättävän todennäköisyyden, joka vähennetään joka kerta todennäköisyydestä löytää uusia reittejä uusiin luoliin, kun uusi luola generoidaan
* Korjasin kaytavan generoinnin toimimaan oikein lukuunottamatta tapausta, jossa huone sijaitsee luolan kulmassa. Tällöin, kun tähän huoneeseen yritetään luoda käytävää, ohjelma jää ikuiseen looppiin.

Kaytin 3,5 tuntia, 

* luolan generoinnin korjamiseen. Huonetta ei enää generoida luolan reunalle eikä uloskäyntiä luolan kulmaan, joten ongelmaa, jossa reittiä yritetään luoda luolan kulmaan ja generoiKaytava jää ikuiseen looppiin, ei pitäisi enää olla.
* Muutin luoHuoneet -metodin toimimaan paremmin, estäen mahdollisen virheen, jossa samoja Pisteitä generoitaisiin luolaan useasti.
* Lisäsin alarajan ohjelman saamille parametreille, joiden arvot asetetaan jos ne alitetaan
* Muutin luolan generoinnin toimimaan siten, että reunoille ei generoida avoimia alueita generoiAvoimetAlueet metodissa, jos reunoja ei aseteta luoUloskaynnit- metodissa, uloskäynneiksi huoneet listaan
  * Tämän seurauksena luolan reunat voivat generoitua kulmikkaiksi

  ```
  xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
  xxxxxxxxxx                     x
  xxxxxxxxxx                     x
  xxxxxxxxxx                     x
  xxxxxxxxxxx                    x
  xxxxxxxxxxx                    x
  xxxxxxxxxxx                    x
  xxxxxxxxxxx                    x
  xxxxxxxxxxx                    x
  xxxxxxxxxx                     x
  xxxxxxxxxxx          xx        x
  xxxxx   x            xxxxxx xx x
  xxxx          @      xxxxxx xxxx
  xx                   xxxxxxxxxxx
  xxx   x       x x    xxxxxxxxxxx
  xx    xx   xx xxx    xxxxxxxxxxx
       xxxx   xxxxx    xxxxxxxxxxx
     xxxxxxxxxxxxxx    xxxxxxxxxxx
     xxxxxxxxxxxxx    xxxxxxxxxxxx
       xxxxxxxx     x xxxxxxxxxxxx
       xxxxxxxx    xx  xxxxxxxxxxx
   xxxxxxxxxxx    xxxxxxxxxxxxxxxx
  xxxxxxxxxxxx    xxxxxxxxxxxxxxxx
  xxxxxxxxxxxxx  xxxxxxxxxxxxxxxxx
  xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
  xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
  xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
  xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
  xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
  xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
  xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
  xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
  ```
* Muutin todennäköisyyden löytää uusia uloskäyntejä todelliseksi todennäköisyydeksi vähennettävän luvun sijaan

Kaytin x tuntia,

* generoiReunat -metodin toteuttamiseen. Metodi vähentää luolan kulmikkuutta reunoissa käyttäen leveyssuuntaista läpikäyntiä, joka lisää luolaan seiniä lähtien luolan reunoilta.
* GeneroiReunat aiheutti ongelman, jossa pelaaja voitiin asettaa pelin alussa seinän sisään, joten muutin pelaajan asettamisen luolaan toimimaan leveyssuuntaisella läpikäynnillä, joka alkaa luolan keskeltä ja etenee, kunnes löydetään ensimmäinen avoin kohta. Pelaaja siis asetetaan mahdollisimman keskelle luolaan.

