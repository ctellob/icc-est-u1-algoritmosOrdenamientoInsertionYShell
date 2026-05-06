public class Insertion {

    public int[] sort(int[] arrayOriginal, boolean asc) {
        // Clonamos el arreglo original de forma sencilla
        int[] arr = arrayOriginal.clone();

        int comparaciones = 0;
        int iteraciones = 0;
        int cambios = 0;

        System.out.println("==== METODO INSERCIÓN ====\n");
        System.out.println("Arreglo original:");
        imprimirArreglo(arr);
        System.out.println();

        for (int i = 1; i < arr.length; i++) {
            iteraciones++;
            boolean primeraLinea = true;
            int j = i;

            while (j > 0) {
                comparaciones++;
                int a = j - 1;
                int b = j;

                boolean condicion = false;
                if (asc == true) {
                    if (arr[a] > arr[b]) {
                        condicion = true;
                    }
                } else {
                    if (arr[a] < arr[b]) {
                        condicion = true;
                    }
                }

                String cambioTexto = "no";
                if (condicion == true) {
                    cambioTexto = "si";
                }

                String estadoTexto = obtenerArregloEstado(arr);
                String variables = "a=" + a + "   b=" + b + "   [a]=" + arr[a] + "   [b]=" + arr[b] + "   cambio="
                        + cambioTexto;

                if (primeraLinea == true) {
                    System.out.println("I" + i + "   " + estadoTexto + variables);
                    primeraLinea = false;
                } else {
                    System.out.println("     " + estadoTexto + variables);
                }

                if (condicion == true) {
                    cambios++;
                    int temp = arr[a];
                    arr[a] = arr[b];
                    arr[b] = temp;
                    j--;
                } else {
                    break;
                }
            }
            System.out.println();
        }

        System.out.println("end  " + obtenerArregloEstado(arr) + "\n");

        System.out.println("COMPARACIONES = " + comparaciones);
        System.out.println("ITERACIONES   = " + iteraciones);
        System.out.println("CAMBIOS       = " + cambios);

        int[] resultados = { comparaciones, cambios, iteraciones };
        return resultados;
    }

    private void imprimirArreglo(int[] arr) {
        for (int num : arr) {
            System.out.print(num + "  ");
        }
        System.out.println();
    }

    private String obtenerArregloEstado(int[] arr) {
        String texto = "";
        for (int num : arr) {
            texto = texto + num + " ";
        }
        while (texto.length() < 45) {
            texto = texto + " ";
        }
        return texto;
    }
}