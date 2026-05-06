import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int[] arreglo = { 12, -7, 25, 0, -15, 33, 19, -22, 5, 48, -3 };
        Scanner teclado = new Scanner(System.in);
        Insertion insertion = new Insertion();
        Shell shell = new Shell();
        String op = "";

        do {
            System.out.println("\n|-------------PROGRAMA DE ORDENAMIENTO ---------|");
            System.out.println("|\t1.- Ejecutar Ordenamientos\t\t|");
            System.out.println("|\t2.- Salir\t\t\t\t|");
            System.out.println("|-----------------------------------------------|");
            System.out.print("Elija una opcion entre 1 o 2 = ");
            op = teclado.nextLine().trim();

            switch (op) {
                case "1":
                    System.out.println("¿ Insercion ascendete (true/false)");
                    String opInsercion = teclado.nextLine().trim();

                    System.out.println("¿ Shell ascendente (true/false)");
                    String opShell = teclado.nextLine();

                    if ((opInsercion.equalsIgnoreCase("true") || opInsercion.equalsIgnoreCase("false")) &&
                            (opShell.equalsIgnoreCase("true") || opShell.equalsIgnoreCase("false"))) {

                        System.out.println();

                        insertion.sort(arreglo, Boolean.parseBoolean(opInsercion));
                        System.out.println("\n------------------------------------------------------\n");
                        shell.sort(arreglo, Boolean.parseBoolean(opShell));
                    } else {
                        System.out.println("Error: Entrada inválida. Debe escribir 'true' o 'false'.");
                    }

                    break;
                case "2":
                    System.out.println("Saliendo del programa.....");
                    break;

                default:
                    System.out.println("Error al ingresar una opcion, Ingrese únicamente 1 o 2.");
                    break;
            }

        } while (!op.equals("2"));
        System.out.println("Fuera del programa");
        teclado.close();
    }
}