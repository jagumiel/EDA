# Lab3: Enunciado

Objetivo final: obtener un sistema que permitirá hacer eficientemente (deberemos razonar los motivos de la eficiencia) las siguientes operaciones:

- boolean estanRelacionadas(a1, a2)
El resultado será true si hay una cadena de relaciones que une a a1 y a2. Por ejemplo, la llamada a 
        ```
        estanRelacionadas("Bening, Annette", "Bullock, Sandra")
        ``` dará true.
Para poder resolver este problema, previamente, en la clase Actriz deberemos tener un atributo:
        ```
        ArrayList<Actriz> colegas;
        ```
que contenga las personas que han trabajado directamente con cada actriz en una película.
Obtener esta lista será relativamente sencillo si cada Actriz contiene una lista de sus películas y además cada película tiene una lista de las actrices que han participado en ella.
Para los grupos que no hayan diseñado las clases de esta manera, se puede resolver creando una estructura auxiliar donde se guarde, por cada película, las actrices que han participado. Como esta estructura requerirá hacer búsquedas por el título de una película, conviene que tenga acceso rápido, ya que si no el proceso será muy lento. Para ello, se puede hacer uso de las clases HashSet<Pelicula> o HashMap<Titulo, Pelicula>.
Una vez calculado el valor del atributo “colegas” para cada actriz, ver si dos actrices están relacionadas se reduce a encontrar un camino entre dos elementos dados (problema del laberinto).

- int estanRelacionadas(a1, a2)
El resultado será un entero positivo si hay una cadena de relaciones que une a a1 y a2, que dará la distancia del camino mínimo entre ellos, y 0 en caso contrario. Este problema es trivial si se ha resuelto el siguiente apartado.

- OPCIONAL: ArrayList<Relacion> estanRelacionadas(a1, a2)
El resultado será una lista de relaciones desde a1 hasta a2, donde cada relación indica que esas 2 personas están unidas por haber participado en una misma película. Por ejemplo, la llamada a 
        ```
        estanRelacionadas("Bening, Annette", "Bullock, Sandra")
        ``` producirá:

        Bening, Annette         La guerra de las galaxias       Fisher, Carrie
        Fisher, Carrie          Viernes 13                      Streep, Merryl
        Streep, Merryl          Crash                           Bullock, Sandra

    Quiere decir que “Bening, Annette” y “Fisher, Carrie” participaron en “La guerra de las galaxias”, que “Fisher, Carrie” y “Streep, Merryl” participaron en “Viernes 13” y que “Streep, Merryl” y “Bullock, Sandra” participaron en “Crash”.
    
- Se deberán redefinir las clases resultantes (nuevos métodos, …)

Se deberá entregar:
- Programas que implementen lo pedido (ejecutados correctamente). Se deberá demostrar que el programa funciona realmente con conjuntos de datos no triviales (es decir, procesando millones de líneas del fichero original de actrices).

- Documentación describiendo el problema planteado, las alternativas examinadas, implementaciones, y eficiencia.

- Se debe entregar un documento que contenga:
    - Descripción general del problema.
    - Descripción general de las alternativas examinadas y las soluciones adoptadas, justificándolas en base a diferentes criterios, como eficiencia.
    - Diseño e implementación de los algoritmos.
    - Este documento será una nueva versión (modificada y ampliada) de la documentación entregada en la actividad 1.