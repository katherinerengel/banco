import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Banco {
    //Listas para alamacenar los registros ya que no es necesario la persistencia de la información.
    
    ArrayList<Cliente> clientes = new ArrayList<>();

    //Alta Cliente
    public void AltaCliente(String dni, String nombre, String apellido){
        Cliente nuevoCliente = new Cliente(dni, nombre, apellido);
        clientes.add(nuevoCliente);
        System.out.println("Cliente creado con éxito.");
    }

    //Buscar Cliente
    public Cliente BuscarCliente(String dni){
        Cliente clienteBuscado = new Cliente();
        //Bucle Foreache
        for (Cliente unCliente : clientes) {
           //Condicional if
           if(unCliente.getDni().equals(dni)) {
                clienteBuscado = unCliente;
           }
        }
        return clienteBuscado;
    }

    //Baja Cliente
    public void BajaCliente(String dni){
        Cliente clienteEncontrado = BuscarCliente(dni);
        clientes.remove(clienteEncontrado);
        System.out.println("Cliente eliminado con éxito.");
    }

    //Alta Cuenta
    public void AltaCuenta(String dni, String cuenta, double saldoCuenta){
        //Usando el método buscar cliente
        Cliente clienteBuscado = BuscarCliente(dni);
        if (clienteBuscado != null) { //Verificamos si cliente no es igual a null, entonces se guarda la cuenta
            Cuenta nuevaCuenta = new Cuenta(cuenta, saldoCuenta);
            clienteBuscado.agregarCuenta(nuevaCuenta);
            System.out.println("Cuenta registrada con éxito.");
        } else {
            System.out.println("El cliente no existe.");
        } 
    }

    //Baja Cuenta
    public void BajaCuenta(String cuenta){
        //Variable para saber si se elimino la cuenta
        boolean existe = false;
        //Recorre entre los clientes para buscar la cuenta
        for (Cliente unCliente : clientes) {
            //Se encontro el cliente y recorremos para buscar la cuenta
            for (Cuenta unaCuenta : unCliente.getCuentas()) {
                if (unaCuenta.getCuenta().equals(cuenta)) {
                    unCliente.eliminarCuenta(unaCuenta);
                    existe = true;
                }
            }
        }

        if (existe) {
            System.out.println("Cuenta eliminada con éxito.");
        } else {
            System.out.println("No se encontró la cuenta");
        }
    }

    //Depósito de saldo
    public void Deposito(String dni, String cuenta, double monto){
        //Primero se busca al cliente
        Cliente clienteBuscado = BuscarCliente(dni);
        if (clienteBuscado != null) { 
            for (Cuenta unaCuenta : clienteBuscado.getCuentas()) {
                if (unaCuenta.getCuenta().equals(cuenta)) {
                    unaCuenta.agregarSaldo(monto);
                    System.out.println("Depósito realizado con éxito");
                }
            }
        } else {
            System.out.println("El cliente no existe.");
        } 
    }

    //Extracción de saldo
    public void Retiro(String dni, String cuenta, double monto){
        //Primero buscamos el cliente
        Cliente clienteBuscado = BuscarCliente(dni);
        if (clienteBuscado != null) { 
            //Segundo buscamos la cuenta
            for (Cuenta unaCuenta : clienteBuscado.getCuentas()) {
                if (unaCuenta.getCuenta().equals(cuenta)) {
                    //Tercero verificamos el saldo de la cuenta
                    if (unaCuenta.getSaldoCuenta() >= monto) {
                        unaCuenta.extraerSaldo(monto);
                        System.out.println("Retiro realizado con éxito");
                    } else {
                        System.out.println("Saldo insuficiente.");
                    }
                }
            }
        } else {
            System.out.println("El cliente no existe.");
        } 
    }

    //Listado descendente de clientes por saldo de cuenta
    public void ListadoClientes(){
        //Para obtener a los clientes
        ArrayList<Cliente> clientesListados = new ArrayList<>(clientes);
        //Para ordenar a los clientes por saldo total
        Collections.sort(clientesListados,  Comparator.comparingDouble((Cliente g) -> g.getSaldoTotal()).reversed());

        //Para imprimir a los clientes ordenados
        for (Cliente unCliente : clientesListados) {
            System.out.println(unCliente.getNombre() + " " + unCliente.getApellido() + " - Saldo total = " + unCliente.getSaldoTotal());
        }        
    }
}
