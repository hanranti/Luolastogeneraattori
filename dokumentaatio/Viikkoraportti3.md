# Viikkoraportti 3

Käytin 6 tuntia,
* koordinaatiston korjaamiseen, joka toimii nyt oikein
* luolangenerointialgoritmin toteuttamiseen
  * huoneiden maara ja paikat valitaan Randomilla satunnaisesti
  * huoneiden generoinnissa käytetään muunneltua leveyssuuntaista läpikäyntiä, joka avaa luolaa aloituspisteistä alkaen kunnes käsiteltävän pisteen matka aloituspisteeseen on pituudeltaan 3. Tämän jälkeen kysytään random.nextBoolean():lla jatketaanko luolan avaamista tiettyyn suuntaan
  * luolan reunat eivät vielä toimi oikein
  * algoritmi ei generoi käytäviä tai erikseen uloskäyntejä(huoneiden generointi voi kuitenkin luoda uloskäyntejä), mutta luolaston generointi toimii jo aika hyvin
* testeihin
* linkitetyn listan toteuttamiseen
