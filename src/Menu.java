import java.util.Scanner;

public class Menu {
  
    //Método para crear el menú
    public static void MenuInicio(){
        //Para instanciar los métodos de la clase Sala.
        Banco banco = new Banco();

        //Scanner para capturar la información de la consola
        @SuppressWarnings("resource")
        Scanner inputScanner = new Scanner(System.in);  
        boolean salir = true;

        while (salir) {
            System.out.println("*************************");
            System.out.println("       MENU INICIO");
            System.out.println("*************************");
            System.out.println("1. Alta Cliente");
            System.out.println("2. Baja Cliente");
            System.out.println("3. Alta Cuenta");
            System.out.println("4. Baja Cuenta");
            System.out.println("5. Dépositar saldo");
            System.out.println("6. Retirar saldo");
            System.out.println("7. Listar Clientes");
            System.out.println("8. Salir");   
    
            //Para que el usuario elija en la consola la opción.
            System.out.print("Elije una opción: ");
            int opcion = inputScanner.nextInt();
            inputScanner.nextLine();  //Para que no se pierda en la búsqueda        
            
            //Condicional Switch para hacer validaciones múltiples.
            //Usar el System.out.print SIN el el ln para que no haga salto de línea.
            switch (opcion) {
                case 1: //Alta Cliente.
                    System.out.print("Ingrese el dni: ");
                    String dni = inputScanner.nextLine(); //Para capturar el valor introducido y lo guarde en la variable nombre.
                    System.out.print("Ingrese el nombre: ");
                    String nombre = inputScanner.nextLine(); 
                    System.out.print("Ingrese el apellido: ");
                    String apellido = inputScanner.nextLine(); 
                    banco.AltaCliente(dni, nombre, apellido); 
                    break;
                case 2: //Baja Cliente.
                    System.out.print("Ingrese el dni del cliente: ");
                    String dni1 = inputScanner.nextLine();
                    banco.BajaCliente(dni1); 
                    break;
                case 3: //Alta Cuenta.
                    System.out.print("Ingrese el dni: ");
                    String dni2 = inputScanner.nextLine();
                    System.out.print("Ingrese el número de cuenta: ");
                    String cuenta = inputScanner.nextLine();
                    System.out.print("Ingrese el saldo de la cuenta: ");
                    double saldo = inputScanner.nextDouble();
                    banco.AltaCuenta(dni2, cuenta, saldo);
                    break;
                case 4: //Baja Cuenta.
                    System.out.print("Ingrese el número de cuenta: ");
                    String cuenta1 = inputScanner.nextLine();
                    banco.BajaCuenta(cuenta1);//Va al método BajaCliente, lo busca y lo elimina
                    break;  
                case 5: //Dépositar saldo.
                    System.out.print("Ingrese el dni: ");
                    String dni3 = inputScanner.nextLine();
                    System.out.print("Ingrese el número de cuenta: ");
                    String cuenta2 = inputScanner.nextLine();
                    System.out.print("Ingrese el saldo a depositar: ");
                    double saldo2 = inputScanner.nextDouble();
                    banco.Deposito(dni3, cuenta2, saldo2);
                    break; 
                case 6: //Retirar saldo.
                    System.out.print("Ingrese el dni: ");
                    String dni4 = inputScanner.nextLine();
                    System.out.print("Ingrese el número de cuenta: ");
                    String cuenta3 = inputScanner.nextLine();
                    System.out.print("Ingrese el saldo a retirar: ");
                    double saldo3 = inputScanner.nextDouble();
                    banco.Retiro(dni4, cuenta3, saldo3);
                    break; 
                case 7: //Lista de Clientes por saldo.
                    banco.ListadoClientes();
                    break;                      
                default:
                    salir = false;
                    break;
            }
        }
    }
}
