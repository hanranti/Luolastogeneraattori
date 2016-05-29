#Viikkoraportti 2

Käytin 2 tuntia koodin aloittamiseen. Nyt Luolastogeneraattori luokan main metodi saa ohjelman parametreina yksittäisen luolan koon, luo ohjelman tarvitsemat luokat ja alkaa while loopissa kysymään pelaajan siirtoja ja tulostaa siirron jälkeen luolan.

Luolasto -luokka ei vielä generoi luolia satunnaisesti, vaan jokaisessa luolassa on reunoilla seinät lukuunottamatta jokaisen reunan keskellä olevaa uloskäyntiä. Luolassa pystyy nyt kulkemaan avoimilla alueilla ja uloskäynneistä toiseen luolaan. Liikkuminen luolasto -taulukon ulkopuolelle aiheuttaa virheen ArrayIndexOutOfBoundsException eli luolaston kaksinkertaistaminen ei vielä toimi.


Käytin 2,5 tuntia javadocin ja testien aloittamiseen sekä korjauksiin ja pieniin muutoksiin koodissa. Nyt Luolaston kaksinkertaistaminen toimii ensimmäisellä kerralla, mutta myöhemmin aiheuttaa virheen: Exception in thread "main" java.lang.OutOfMemoryError: Java heap space. En tiedä mikä aiheuttaa virheen. 

Korjaan luolaston kaksinkertaistamisesta aiheutuvan virheen koordinaateissa Luolaston muuttujalla int muutos. Kun luolasto kaksinkertaistetaan, vanhat luolat siirretään luolaston keskelle eli näiden koordinaatit muuttuvat. Koska käytän muuttujaa int muutos, koordinaattien muuttuminen näkyy vain luokan Luolasto sisällä. Koordinaatit siis säilyvät samoina Pelaaja luokalle, jolloin Pelaajan koordinaatit voivat saada myös negatiivisia arvoja. Tämä ei aiheuta taulukossa ArrayIndexOutOfBoundsException:ia, koska int muutoksen lisääminen Luolaston sisällä koordinaateissa korjaa kaksinkertaistamisesta johtuvan muutoksen. 

Erilliset koordinaatit Luolaston sisä- ja ulkopuolella voivat kuitenkin aiheuttaa ongelmia esimerkiksi tapauksessa, jossa luolan koko on pariton, joten koordinaatit täytyy ehkä muuttaa samoiksi kaikkialla ohjelman sisällä.


Käytin 2 tuntia javadocin ja testien tekemiseen. Korjasin myös build-impl.xml:stä johtuneen virheen, joka esti ohjelman ajamisen.

Käytin tunnin testien tekemiseen. Lisäsin testeille FieldAccess ja  aiemmassa työssä tekemäni MethodInvoker luokan. Näillä testit pääsevät käsiksi luokan yksityisiin muuttujiin ja metodeihin.
