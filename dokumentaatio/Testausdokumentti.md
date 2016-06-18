# Testausdokumentti

### Tietorakenteet

### Luolasto

### Työkalut

* FieldAccess
  * Mahdollistaa pääsyn private näkyvyyden muuttujiin testattavassa luokassa
  
* MethodInvoker
  * Mahdollistaa, private näkyvyyden metodien suorittamisen testattavassa oliossa

## Suorituskykytestaus

* Luolastogeneraattori
  * Generoi -metodin suoritusnopeus 10000 kokeilun keskiarvolla:
    * Luolan koko :32 keskiarvo: 4466197ns eli noin 4,5ms
    * Luolan koko :50 keskiarvo: 1340217ns eli noin 1,3ms
    * Luolan koko: 100 keskiarvo: 6935111ns eli noin 6,9ms
