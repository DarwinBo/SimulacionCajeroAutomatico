import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("Darwin Bello", TipoDeCuenta.AHORRO, 25000);
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== CAJERO AUTOMÁTICO ===");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Ingresar dinero");
            System.out.println("3. Sacar dinero");
            System.out.println("4. Cambiar tipo de cuenta");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch(opcion){
                case 1:
                    System.out.println("Saldo actual: " + cuenta.obtenerSaldo());
                    break;
                case 2:
                    System.out.print("Cantidad a ingresar: ");
                    double ingreso = sc.nextDouble();
                    cuenta.ingresarDinero(ingreso);
                    break;
                case 3:
                    System.out.print("Cantidad a retirar: ");
                    double retiro = sc.nextDouble();
                    cuenta.sacarDinero(retiro);
                    break;
                case 4:
                    System.out.println("Tipos de cuenta disponibles: AHORRO, NOMINA, HIPOTECA, INFANTIL");
                    System.out.print("Nuevo tipo de cuenta: ");
                    String tipoStr = sc.nextLine().toUpperCase();
                    try {
                        cuenta.cambiarTipoDeCuenta(TipoDeCuenta.valueOf(tipoStr));
                    } catch (IllegalArgumentException e){
                        System.out.println("Tipo inválido.");
                    }
                    break;
                case 5:
                    System.out.println("Gracias por usar el cajero.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while(opcion >=1 && opcion <=4);

        sc.close();
    }
}