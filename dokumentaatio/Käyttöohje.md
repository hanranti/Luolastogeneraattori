# Käyttöohje

Ohjelman parametreiksi voidaan antaa ensimmäisenä parametrina luolan leveys ja toisena todennäköisyysvähennys, joka on luku, joka vähennetään todennäköisyydestä löytää luolia, joka kerta kun uusi luola generoidaan. Luolan minimileveys on 32 ja minimitodennäköisyysvähennys on 0.

Kun ohjelma käynnistyy, ensimmäinen luola tulostetaan.

Ohjelma vuorotellen kysyy pelaajalta siirtoa ja tulostaa luolan, kunnes ohjelman suoritus lopetetaan.

Pelaaja voi antaa siirroksi merkkijonon, jossa yksi merkki vastaa yhtä ohjelmalle annettavaa komentoa. Komennot suoritetaan peräkkäin alkaen merkkijonon ensimmäisestä merkistä.

## Komennot

* a - liikuta pelaajaa yksi askel alaspäin
* y - liikuta pelaajaa yksi askel ylöspäin
* v - liikuta pelaajaa yksi askel vasemmalle
* o - liikuta pelaajaa yksi askel oikealle
* q - keskeytä ohjelman suoritus

## Luolasto

Pelaaja on merkitty luolaan merkillä @. Ainoastaan tyhjiin eli ' ' ruutuihin voidaan liikkua. Seinien x läpi ei siis voida kulkea. Kulkiessa tyhjästä kohdasta reunalta ulos luolasta siirrytään uuteen luolaan.
