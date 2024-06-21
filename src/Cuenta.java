public class Cuenta {
    //Atributos de la clase
    private String cuenta;
    private double saldoCuenta;

    //Constructor de la clase
    public Cuenta(String cuenta, double saldoCuenta) {
        this.cuenta = cuenta;
        this.saldoCuenta = saldoCuenta;
    }

    public Cuenta(){}

    //Métodos Getter y Setter de la clase
    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public double getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(double saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }

    //Método para agregar saldo a la cuenta
    public void agregarSaldo(double saldo){
        this.saldoCuenta = saldoCuenta + saldo;
    }
    
    //Método para extraer saldo a la cuenta
    public void extraerSaldo(double saldo){
        this.saldoCuenta = saldoCuenta - saldo;
    }
}
