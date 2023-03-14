# Lab4: Enunciado

En la actividad 3 se implementaron las siguientes operaciones:
- boolean estanRelacionadas(p1, p2)
El resultado será true si hay una cadena de relaciones que une a p1 y p2
- int estanRelacionadas(p1, p2)
El resultado será un entero positivo si hay una cadena de relaciones que une a p1 y p2, que dará la distancia del camino mínimo entre ellos, y 0 en caso contrario

Además de esto, se quieren implementar dos nuevas funcionalidades:
1. double gradoRelaciones()
El resultado es un entero que dará el número medio correspondiente a la distancia del camino que une a cualquier par de actores, según una serie de relaciones (ver http://en.wikipedia.org/wiki/Six_degrees_of_separation)
2. double centralidad() // en la clase Actor
// Post: El resultado es una medida de la centralidad de un actor, entendiéndola como intermediación o betweenness (http://es.wikipedia.org/wiki/Centralidad#Intermediacion, o http://en.wikipedia.org/wiki/Centrality#Betweenness_centrality). Esta medida se calcula como:
    > **_NOTE:_**  The betweenness of a vertex **v** in a graph **G:=(V,E)** with **V** vertices is computed as follows:
        * For each pair of vertices (s,t), compute the shortest paths between them.
        * For each pair of vertices (s,t), determine the fraction of shortest paths that pass through the vertex in question (here, vertex v).
        * Sum this fraction over all pairs of vertices (s,t).

    El cálculo de esta medida es inviable si se quieren calcular todos los pares (s, t) en un grafo con cientos de miles de vértices (nodos) y, por ello, se deberá realizar una estimación con un número suficientemente grande de pares. De igual manera, si queremos calcular la medida para todos los vértices del grafo, tenemos dos posibilidades:
    - Coger un número grande de vértices y, para cada uno, calcular la medida de centralidad.
    - Coger un número grande de pares de vértices (s, t) y, para cada camino entre s y t, calcular las apariciones de todos los vértices del camino s..t. De esta manera, el cálculo de cada camino (s, t) aportará información sobre varios vértices y permitirá probablemente disminuir el tiempo de cálculo respecto a la opción anterior.
3. (Opcional) ArrayList<Actor> losDeMasCentralidad(int n) // en la clase ListaActores
Calcular los n actores/actrices con mayor centralidad del grafo de relaciones entre actores. Al mostrar los resultados se deberá indicar:
    - Tamaño de los datos de entrada utilizados.
    - Número de cálculos realizados (caminos o tests de centralidad para vértices).
    - Tiempo de ejecución para las distintas pruebas.

Se deberá entregar:
- Programas que implementen lo pedido (ejecutados correctamente). Se deberá demostrar que el programa funciona realmente con conjuntos de datos no triviales (es decir, procesando millones de líneas del fichero original de actrices). La documentación deberá incluir:
    - Ejemplos de ejecución de los métodos pedidos, indicando datos de prueba y resultados, junto con el número de datos usados y de pruebas realizadas. En caso de que sea relevante, también se indicará el tiempo de ejecución de cada prueba.
- Documentación describiendo el problema planteado, las alternativas examinadas, implementaciones, y eficiencia

> **_NOTE:_**  Debido a que algunos de los resultados pedidos requerirán un alto tiempo de computación, esto exigirá que los algoritmos funcionen correctamente un tiempo antes de la fecha de entrega, ya que si no no se podrán obtener los resultados.