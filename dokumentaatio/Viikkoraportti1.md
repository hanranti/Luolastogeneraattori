# Viikkoraportti 1

Suunnittelin millaista tietorakennetta käytän luolan ja luolaston tallennukseen. Selvitin perusidean luolan generointiin. On yhä epäselvää millaista algoritmin käytän. En siis vielä tiedä luolan generoinnin aika- ja tilavaativuutta. Yksittäisen luolan generoinnissa tarvitaan algoritmia, joka luo satunnaisen määrän huoneita, uloskäyntejä ja näitä yhdistäviä käytäviä. Yksittäisestä huoneesta luodaan satunnaisen kokoinen ja muotoinen. Huoneiden ja uloskäyntien välisistä käytävistä luodaan satunnaisen levyisiä ja mahdollisesti kaarevia. Luolan avoimista osista ei välttämättä löydy reittiä muihin avoimiin osiin, mutta jokaisesta avoimesta kohdasta täytyy löytyä reitti uloskäyntiin luolasta. Luolaa generoidessa täytyy ottaa huomioon luolan viereisten löydettyjen luolien uloskäynnit, jotta näille saadaan vastaavat uloskäynnit myös generoitavaan luolaan.

Käytin viikon aikana noin 4 - 5 tuntia työn suunnitteluun ja koodin aloittamiseen.
