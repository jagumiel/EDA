# EDA - Estructuras de Datos y Algoritmos

Proyecto academico de EDA basado en una base de datos de actores/actrices y peliculas (dataset tipo IMDB - https://ftp.fu-berlin.de/pub/misc/movies/database/frozendata/)
El repositorio esta organizado por laboratorios progresivos, cada uno con nuevas estructuras y algoritmos.

## Enunciado oficial

El enunciado completo de cada fase esta en:

- `Docs/EDA-LAB1.pdf`
- `Docs/EDA-LAB2.pdf`
- `Docs/EDA-LAB3.pdf`
- `Docs/EDA-LAB4.pdf`

## Estructura del repositorio

- `lab1/`: carga de datos, busqueda, insercion/borrado y listado ordenado.
- `lab2/`: implementacion de listas doblemente enlazadas (ordenadas y desordenadas).
- `lab3/`: relaciones entre actores mediante recorridos en anchura (BFS).
- `lab4/`: grado medio de relacion y centralidad sobre el grafo de actores.
- `examen/`: ejercicios independientes.

## Modelo de dominio

Se trabaja con el grafo implicito:

- Nodo: actor/actriz.
- Arista: dos actores que han coincidido en una pelicula.

Ademas, cada actor mantiene su filmografia y cada pelicula su reparto.

## Por que estas estructuras son buenas para este problema

- `HashMap`:
  acceso promedio `O(1)` por clave para buscar actor/pelicula por nombre.
  Es clave cuando se procesan miles o millones de lineas.
- `DoubleLinkedList` (lab2):
  inserciones y borrados eficientes con referencia a nodo, recorrido en ambos sentidos y buen control de extremos.
  Es util cuando hay muchas operaciones de edicion sobre secuencias.
- `Cola` (FIFO):
  estructura natural para BFS en busqueda de caminos minimos no ponderados entre actores.
- `Pila` (LIFO):
  util para reconstruir/imprimir caminos desde destino a origen.
- `Array`:
  practico para ordenacion y para mantener un top-n fijo (por ejemplo, centralidad).

## Casos de uso que cubre el proyecto

- Cargar y parsear ficheros grandes de actores/peliculas.
- Buscar actores/peliculas rapidamente.
- Insertar y eliminar informacion del catalogo.
- Ordenar y listar actores.
- Comprobar si dos actores estan relacionados.
- Calcular distancia minima entre actores.
- Estimar medidas globales del grafo (grado medio y centralidad).

## Resumen por laboratorio

- `lab1`: base del sistema con enfasis en operaciones CRUD y eficiencia de acceso.
- `lab2`: implementacion manual de TAD lista doblemente enlazada y su analisis.
- `lab3`: paso de "catalogo" a "grafo de relaciones" con BFS.
- `lab4`: metricas de red y estimaciones para que el coste sea asumible en datasets grandes.
