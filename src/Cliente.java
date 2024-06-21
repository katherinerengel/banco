import java.util.ArrayList;

public class Cliente {
    //Atributos de la clase.
    private String dni;    
    private String nombre;
    private String apellido;
    //Relación de composición entre Cliente y Cuentas.
    private ArrayList<Cuenta> listaDeCuentas; 

    //Constructor de la clase
    public Cliente(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.listaDeCuentas = new ArrayList<>(); //Para inicializar el listado de cuent en vacio.
    }

    public Cliente(){}

    // Métodos Getter y Setter de la clase.
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    //Método para retornar las cuentas que tiene el cliente.
    public ArrayList<Cuenta> getCuentas(){
        return listaDeCuentas;
    }

    //Métodos para la lista de la relación que agrega y elimnar cuentas del cliente.
    public void agregarCuenta(Cuenta unaCuenta) {
        this.listaDeCuentas.add(unaCuenta);
    }
    
    public void eliminarCuenta(Cuenta unaCuenta) {
        this.listaDeCuentas.remove(unaCuenta);
    }

    //Método para retornar el saldo total de las cuentas
    public double getSaldoTotal(){
        double sumaSaldo = 0;
        for (Cuenta unaCuenta : listaDeCuentas) {
            //Para acumular el saldo que tiene el cliente en cada cuenta, en caso de que tenga más de una.
            sumaSaldo += unaCuenta.getSaldoCuenta();
        }

        return sumaSaldo;
    }
    
}
