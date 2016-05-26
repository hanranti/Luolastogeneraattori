#Viikkoraportti 2

Käytin 2 tuntia koodin aloittamiseen. Nyt Luolastogeneraattori luokan main metodi saa ohjelman parametreina yksittäisen luolan koon, luo ohjelman tarvitsemat luokat ja alkaa while loopissa kysymään pelaajan siirtoja ja tulostaa siirron jälkeen luolan.
Luolasto -luokka ei vielä generoi luolia satunnaisesti, vaan jokaisessa luolassa on reunoilla seinät lukuunottamatta jokaisen reunan keskellä olevaa uloskäyntiä. Luolassa pystyy nyt kulkemaan avoimilla alueilla ja uloskäynneistä toiseen luolaan. Liikkuminen luolasto -taulukon ulkopuolelle aiheuttaa virheen ArrayIndexOutOfBoundsException eli luolaston kaksinkertaistaminen ei vielä toimi.
