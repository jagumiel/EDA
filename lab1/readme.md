# Lab 1 - Base de catálogo de actores y películas

## Objetivo

Diseñar e implementar un sistema capaz de cargar, buscar, insertar, borrar, ordenar y guardar información de actores/películas de forma eficiente.

Referencia del enunciado y memoria: `../Docs/EDA-LAB1.pdf`.

## Funcionalidades principales

- Carga de datos desde fichero de texto.
- Búsqueda de actor/actriz por nombre.
- Inserción de nuevos actores y películas.
- Borrado de actores.
- Guardado a fichero.
- Listado ordenado de actores.

## Estructuras de datos usadas y por qué

- `HashMap<String, Actor>`:
  permite busqueda y actualización promedio `O(1)` por nombre.
  Es la mejor elección cuando el cuello de botella es localizar rápidamente actores en un dataset grande.
- `Array` temporal para ordenacion:
  las tablas hash no estan ordenadas; por eso se convierte a array para aplicar algoritmo de ordenación y generar listados alfabéticos.

## Complejidad orientativa

- Carga de fichero: `O(n)` (recorrido lineal de lineas).
- Buscar actor: promedio `O(1)` con `HashMap`.
- Insertar actor: promedio `O(1)`.
- Borrar actor: promedio `O(1)` por clave.
- Ordenar lista: depende del algoritmo aplicado al array (`O(n^2)` si burbuja, `O(n log n)` si mergesort).

## Cuando esta solucion es adecuada

- Muy buena para catálogos grandes con muchas consultas por nombre.
- Adecuada para flujos "cargar y consultar" frecuentes.
- Menos adecuada si se necesita mantener orden total en tiempo real tras cada inserción (ahí conviene estructura ordenada nativa).

## Entregables esperados (segun enunciado)

- Programa funcional.
- Pruebas de funcionamiento.
- Documentación de diseño, alternativas y análisis de eficiencia.
