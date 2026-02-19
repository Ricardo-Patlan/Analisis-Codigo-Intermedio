# Analisis-Codigo-Intermedio
Investigación sobre la generación y optimización de IR -  Sistemas 1.
Fecha : 18/02/2025

# 1. Generación de Código
El proceso de traducción se activa inmediatamente después del analizador semántico. En esta etapa, el compilador ya ha validado que el código es lógicamente coherente y que los tipos de datos coinciden.

# El proceso de traducción:
* Recorrido del Árbol: Se realiza un recorrido (usualmente post-orden) del Árbol Sintáctico 
* Aplanamiento de Estructuras: Las estructuras de alto nivel (como ciclos `while` o condicionales `if-else`) se transforman en secuencias lineales de instrucciones con saltos condicionales y etiquetas.
* Uso de Temporales: Se generan variables temporales para almacenar resultados intermedios de operaciones aritméticas complejas.

# 2. Beneficios de la Optimización
La mayor ventaja de utilizar una representación intermedia es que permite realizar mejoras en el programa antes de que este se adapte a un procesador específico (Intel, ARM, etc.).

# Técnicas de optimización aplicadas:
* Propagación de Constantes: Si una variable tiene un valor fijo conocido en tiempo de compilación, el optimizador reemplaza cada uso de esa variable por el valor real, ahorrando ciclos de lectura en memoria.
* Eliminación de Código Muerto: El compilador detecta secciones de código que nunca se ejecutan (por ejemplo, después de un `return`) o variables que se calculan pero nunca se usan, eliminándolas para reducir el tamaño del ejecutable.
* Reducción de Fuerza: Reemplaza operaciones costosas por otras más simples (ejemplo: cambiar `x * 2` por `x + x`).

