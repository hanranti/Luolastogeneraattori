# Määrittelydokumentti

Tarkoituksena on luoda luolastogeneraattori, joka generoi luolastoa dynaamisesti pelaajan liikkuessa uudelle alueelle. Yksittäisen luolan seinät määritellään boolean-taulukossa ja luolat tallennetaan luolastoa kuvaavaan taulukkoon. Jos luolaa yritetään generoida taulukon ulkopuolelle, taulukko korvataan kaksi kertaa suuremmalla taulukolla, jonka keskelle kopioidaan tiedot vanhan taulukon luolista. Taulukon korvaus on aika- ja tilavaativuudeltaan O(n).

Yksittäisen luolan reunoilla olevien uloskäyntien täytyy olla avoinna myös viereisessä luolassa ja vastaavasti reunoilla olevien seinien täytyy sulkea viereisten luolien reunat samoista kohdista.

Pelaaja on luokka, joka sisältää tiedon pelaajan x- ja y- koordinaatit luolassa ja luolan sijainnin luolastossa.

Ohjelma ottaa aluksi parametrinä luvun joka määrittää yksittäisen luolan koon. Ohjelman suorituksen aikana ohjelma ottaa syötteenä pelaajan siirtoja.
