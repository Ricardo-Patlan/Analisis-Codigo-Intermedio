
//   EJEMPLOS DE CÓDIGO INTERMEDIO (IR)


public class EjemplosCodigoIntermedio {

    public static void main(String[] args) {

        ejemplo1_TAC();
        ejemplo2_Cuadruplas();
        ejemplo3_PropagacionConstantes();
        ejemplo4_CodigoMuerto();
    }


    // ─────────────────────────────────────────────────────
    // EJEMPLO 1: Código de Tres Direcciones (TAC)
    

    static void ejemplo1_TAC() {
        System.out.println("=============================================");
        System.out.println("EJEMPLO 1: Código de Tres Direcciones (TAC)");
        System.out.println("=============================================");

        // Expresión original:  resultado = (a + b) * c
        int a = 3, b = 4, c = 2;

        int t1 = a + b;        // Paso 1: suma primero
        int t2 = t1 * c;       // Paso 2: multiplica con el resultado anterior
        int resultado = t2;    // Paso 3: asigna el valor final

        System.out.println("Expresión original:  resultado = (a + b) * c");
        System.out.println("Con a=3, b=4, c=2");
        System.out.println();
        System.out.println("Instrucciones TAC generadas:");
        System.out.println("  t1 = a + b     -> " + t1);
        System.out.println("  t2 = t1 * c    -> " + t2);
        System.out.println("  resultado = t2 -> " + resultado);
    }


    // ─────────────────────────────────────────────────────
    // EJEMPLO 2: Cuádruplas
    

    static void ejemplo2_Cuadruplas() {
        System.out.println();
        System.out.println("=============================================");
        System.out.println("EJEMPLO 2: Cuadruplas");
        System.out.println("=============================================");

        // Cada fila es una instrucción: {operador, arg1, arg2, resultado}
        // Representa la misma expresión:  resultado = (a + b) * c
        String[][] cuadruplas = {
            {"+",  "a",  "b",  "t1"},
            {"*",  "t1", "c",  "t2"},
            {"=",  "t2", "-",  "resultado"}
        };

        System.out.println("Expresión original:  resultado = (a + b) * c");
        System.out.println();
        System.out.printf("  %-10s %-8s %-8s %s%n", "OPERADOR", "ARG1", "ARG2", "RESULTADO");
        System.out.println("  ------------------------------------");

        for (String[] fila : cuadruplas) {
            System.out.printf("  %-10s %-8s %-8s %s%n", fila[0], fila[1], fila[2], fila[3]);
        }
    }


    // ─────────────────────────────────────────────────────
    // EJEMPLO 3: Propagación de Constantes
   

    static void ejemplo3_PropagacionConstantes() {
        System.out.println();
        System.out.println("=============================================");
        System.out.println("EJEMPLO 3: Propagacion de Constantes");
        System.out.println("=============================================");

        System.out.println("Código fuente:");
        System.out.println("  x = 5");
        System.out.println("  y = x + 3");
        System.out.println("  z = y * 2");
        System.out.println();

        System.out.println("SIN optimización (se calcula al ejecutar):");
        System.out.println("  x = 5");
        System.out.println("  y = x + 3");
        System.out.println("  z = y * 2");
        System.out.println();

        // El compilador detecta que x=5, entonces calcula
        // y = 5+3 = 8, y luego z = 8*2 = 16,
        // todo esto antes de que el programa corra.

        System.out.println("CON propagación de constantes (se calcula en compilación):");
        System.out.println("  x = 5");
        System.out.println("  y = 8    <- el compilador calculó 5 + 3");
        System.out.println("  z = 16   <- el compilador calculó 8 * 2");
        System.out.println();
        System.out.println("Resultado: el programa ya no necesita hacer esas operaciones");
    }


    // ─────────────────────────────────────────────────────
    // EJEMPLO 4: Eliminación de Código Muerto
 

    static void ejemplo4_CodigoMuerto() {
        System.out.println();
        System.out.println("=============================================");
        System.out.println("EJEMPLO 4: Eliminacion de Codigo Muerto");
        System.out.println("=============================================");

        System.out.println("Código fuente:");
        System.out.println("  a = 10");
        System.out.println("  b = 99   <- b nunca se usa después");
        System.out.println("  c = a + 5");
        System.out.println("  System.out.println(c)");
        System.out.println();

        // Lista de instrucciones del programa
        String[] instrucciones = {
            "a = 10",
            "b = 99",         // b nunca se lee ni se usa en ninguna parte
            "c = a + 5",
            "println(c)"
        };

        System.out.println("El compilador revisa qué variables se usan...");
        System.out.println();

        for (String inst : instrucciones) {
            if (inst.contains("b = ")) {
                // b no aparece en ninguna otra instrucción
                System.out.println("  ELIMINADA  -> '" + inst + "'  (b nunca se usa)");
            } else {
                System.out.println("  CONSERVADA -> '" + inst + "'");
            }
        }

        System.out.println();
        System.out.println("Código final después de eliminar código muerto:");
        System.out.println("  a = 10");
        System.out.println("  c = a + 5");
        System.out.println("  println(c)");
        System.out.println();
        System.out.println("Resultado: el programa es más corto y eficiente");
    }
}