# EDA - Estructuras de Datos y Algoritmos
## _Aplicación para gestionar actores/actrices y películas_

Queremos crear una aplicación que gestione un número grande (miles, decenas de miles o cientos de miles) de actores/actrices y las películas en que participan. Los datos se han tomado de IMDB (Internet Movie Database):

http://ftp.fu-berlin.de/pub/misc/movies/database/)

Un actor o actriz puede participar en numerosas películas. Se debe usar el modelo de dominio siguiente:

Actor->Película

Por cada elemento del fichero de actores/actrices se tienen líneas de la forma:
```
Cruz, Karla             2xUno (2013) [Vanesa]
                        3 y Media Vueltas en Posición C (2012) [Ella] <1>
                        Cigarros (2013) [Ana]
                        "Amor Cautivo" (2012) {(#1.1)} [Carmen] <31>
Cruz, Karmele           "Mi reino por un caballo" (2010) {(#1.38)} [Herself]
Cruz, Kassandra (II)    Kings of Bushwick (2011) [Lisa Sanchez]
Cruz, Kat               "Pinoy Idol Extra" (2008) {(#1.1)} [Herself - Stylist] <10>
```

Los nombres de las películas se han marcado en negrita para que se distingan mejor (este marcado no se encuentra presente en el fichero de datos proporcionado). Antes de cada película, como elemento separador, se tendrán uno o varios tabuladores. Esto será útil a la hora de delimitar los distintos campos de cada línea.

Entre las funcionalidades podemos tener operaciones como:
- Búsqueda de una persona determinada, dados su nombre y apellidos
- Añadir un nuevo elemento (actor o película)
- Obtener la lista de actores ordenada