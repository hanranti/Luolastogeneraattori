# Viikkoraportti 4

Käytin 2 tuntia,
* Luolangenerointialgoritmin luolan reunojen korjaamiseen, nyt luolan viereisissä luolissa on samoissa kohtaa seinät ja aukeat alueet vastakkaisilla puolilla

* Huoneidenyhdistämisalgoritmin muuttamiseen, toimimaan siten, että huoneista muodostetaan pienin virittävä puu

Kaytin 2,5 tuntia,
* pienimmän virittävän puun muodostavan algoritmin toteuttamiseen
   * Kaytan algoritmissa kruskalia. Koska verkossa kaikista huoneista on kaari toisiinsa, verkko on tiheä eli Primin aikavaativuus olisi O(n²). Kruskalin aikavaativuus on O(m log n) + O(n²), jossa O(n²) tulee ajasta, joka kuluu kun kaikki kaaret luodaan ja lisätään kekoon. Käyttäen Kruskalia aikavaativuudeksi tulee siis O(m log n + n²) = O(n²) eli sama kuin Primissä. (m = kaarten määrä ja n = solmujen määrä)
   * Kruskal ei vielä toimi oikein: kaikki huoneet eivät yhdisty toisiinsa

Kaytin 2 tuntia, 
* listan korjaamiseen
* ArrayListin vaihtamiseen Listaan ohjelmassa

Kaytin x tuntia,
* jonon korjaamiseen
* ArrayDequeuen vaihtamiseen Jonoon ohjelmassa
