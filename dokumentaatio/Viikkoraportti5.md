# Viikkoraportti 5

Käytin 3 tuntia,

* testien korjaamiseen
* UnionFindin korjaamiseen
  * Koska UnionFind toimii, nyt myös Kruskal toimii, joten huoneiden yhdistämisalgoritmi käytävillä toimii lähes oikein.
* lisäsin ohjelman parametrinä lisättävän todennäköisyyden, joka vähennetään joka kerta todennäköisyydestä löytää uusia reittejä uusiin luoliin, kun uusi luola generoidaan
* Korjasin kaytavan generoinnin toimimaan oikein lukuunottamatta tapausta, jossa huone sijaitsee luolan kulmassa. Tällöin, kun tähän huoneeseen yritetään luoda käytävää, ohjelma jää ikuiseen looppiin.
