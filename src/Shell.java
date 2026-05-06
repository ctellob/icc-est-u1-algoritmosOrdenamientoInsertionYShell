public class Shell {

    public int[] sort(int[] arrayOriginal, boolean asc) {
        int[] arr = arrayOriginal.clone();

        int comparaciones = 0;
        int iteraciones = 0;
        int cambios = 0;

        System.out.println("==== METODO SHELL ====\n");
        System.out.println("Arreglo original:");
        imprimirArreglo(arr);
        System.out.println();

        int iterCount = 1;

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                iteraciones++;
                int j = i;
                boolean primeraLinea = true;

                while (j >= gap) {
                    comparaciones++;
                    int a = j - gap;
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
                    String variables = "gap=" + gap + "   a=" + a + "   b=" + b + "   [a]=" + arr[a] + "   [b]="
                            + arr[b] + "   cambio=" + cambioTexto;

                    if (primeraLinea == true) {
                        System.out.println("I" + iterCount + "   " + estadoTexto + variables);
                        primeraLinea = false;
                    } else {
                        System.out.println("     " + estadoTexto + variables);
                    }

                    if (condicion == true) {
                        cambios++;
                        int temp = arr[a];
                        arr[a] = arr[b];
                        arr[b] = temp;
                        j = j - gap;
                    } else {
                        break;
                    }
                }
                iterCount++;
                System.out.println();
            }
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