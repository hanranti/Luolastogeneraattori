# Määrittelydokumentti

Tarkoituksena on luoda luolastogeneraattori, joka generoi luolastoa dynaamisesti pelaaja liikkuessa uudelle alueelle. Yksittäisen luolan seinät määritellään boolean-taulukossa ja luolat tallennetaan luolastoa kuvaavaan hajautusrakenteeseen, jonka parametreinä toimivat yksittäisen luolan x- ja y- koordinaatit.

Yksittäisen luolan reunoilla olevien uloskäyntien täytyy olla avoinna myös viereisessä luolassa ja vastaavasti reunoilla olevien seinien täytyy sulkea viereisten luolien reunat samoista kohdista.

Pelaaja on olio joka sisältää tiedon pelaajan x- ja y- koordinaatit luolassa ja luolasta, jossa pelaaja on.
