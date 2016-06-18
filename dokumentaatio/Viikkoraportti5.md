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

Kaytin 2,5 tuntia,

* generoiReunat -metodin toteuttamiseen. Metodi vähentää luolan kulmikkuutta reunoissa käyttäen leveyssuuntaista läpikäyntiä, joka lisää luolaan seiniä lähtien luolan reunoilta.
* GeneroiReunat aiheutti ongelman, jossa pelaaja voitiin asettaa pelin alussa seinän sisään, joten muutin pelaajan asettamisen luolaan toimimaan leveyssuuntaisella läpikäynnillä, joka alkaa luolan keskeltä ja etenee, kunnes löydetään ensimmäinen avoin kohta. Pelaaja siis asetetaan mahdollisimman keskelle luolaan.
* Muutin uloskäyntien generoinnin varmistamaan, että jos luolasta generoidaan uusia uloskäyntejä, varmistus, että luolasta luodaan vähintään 1 uusi uloskäynti ei generoi uutta uloskäyntiä vanhaan luolaan.
* Aiemmin luolaan generoitui aiemmin yleensä vain 1 uusi uloskäynti, joten lisäsin todennäköisyyttä generoitua uusi uloskäynti. Jos uloskäyntejä ei generoidu tarpeeksi, uusia reittejä ei välttämättä synny vaikka todennäköisyys -luku olisi suuri.

Käytin 5 tuntia,

* Luolageneraattorin kommentointiin
* Korjasin reunojen generoinnista aiheutuneen virheen, jossa uudet seinät, joskus tukkivat reittejä.
  * Uudet seinät tallennetaan nyt unionFind -rakenteeseen, jossa reunoilla vierekkäin olevat pisteet ja kaikki näistä lähteneet leveyssuuntaisessa läpikäynnissä lisätyt pisteet saavat saman find-arvon. Samoin, kuin vanhat ja uudet seinät, eri find-arvon saaneet seinät eivät voi generoitua vierekkäin. Aiempi virhe tukki reitin tilanteessa, jossa uloskäynnin kummallekkin puolelle generoituneet seinät yhdistyivät ja tukkivat reitin. Nyt tämä ei ole mahdollista, koska uloskäynnin eripuolille generoituneet seinät saavat eri find-arvon.

Reunojen generoinnissa viereisten seinien tarkastus aiheuttaa joskus arrayIndexoutOfBoundsExceptionin. 
Reunojen generointi saattaa myös jättää avoimia alueita, joihin ei voi päästä, mikä poissulkee joitakin testaus mahdollisuuksia
Ilmeisesti reunojen generointi voi yhä tukkia reittejä, mikä todennäköisesti johtuu vieressaSeinia -metodista.
Ohjelma voi myös ajautua ensimmäisen luolan generoinnin jälkeen ikuiseen looppiin.

Kaytin x tuntia,
 * virheen, jossa pelaajan asetus luolaan johti ikuiseen looppiin, korjaamiseen
 * generoiReunat korjaamiseen, jonka luulen nyt toimivan
   *  vieressaSeinia aiemmin aiheutti ArrayIndexOutOfBoundsExceptionin enkä ole varma onko tämä korjaantunut
 
