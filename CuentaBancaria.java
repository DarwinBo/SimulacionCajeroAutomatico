// CuentaBancaria.java
public class CuentaBancaria {
    private String titular;
    private TipoDeCuenta tipoDeCuenta;
    private double saldo;
    private final double COMISION = 1.2;

    public CuentaBancaria(String titular, TipoDeCuenta tipoDeCuenta, double saldo){
        this.titular = titular;
        this.tipoDeCuenta = tipoDeCuenta;
        this.saldo = saldo;
    }

    public CuentaBancaria(String titular, double saldo){
        this(titular, TipoDeCuenta.AHORRO, saldo);
    }

    public CuentaBancaria(){
        this("", TipoDeCuenta.AHORRO, 0);
    }

    public void sacarDinero(double cantidad){
        if(cantidad <= 0 || cantidad > saldo){
            System.out.println("Cantidad inválida o saldo insuficiente.");
            return;
        }
        double comision = calcularComision();
        saldo -= (cantidad + comision);
        System.out.println("Se ha retirado: " + cantidad + ", comisión aplicada: " + comision);
    }

    public void ingresarDinero(double cantidad){
        if(cantidad <= 0){
            System.out.println("Cantidad inválida.");
            return;
        }
        saldo += cantidad;
        System.out.println("Se ha ingresado: " + cantidad);
    }

    public double calcularComision(){
        if(tipoDeCuenta == TipoDeCuenta.AHORRO){
            return COMISION;
        }
        return 0.0;
    }

    public void cambiarTipoDeCuenta(TipoDeCuenta nuevoTipo){
        tipoDeCuenta = nuevoTipo;
        System.out.println("Tipo de cuenta cambiado a: " + tipoDeCuenta);
    }

    public double obtenerSaldo(){
        return saldo;
    }

    public String getTitular(){
        return titular;
    }

    public TipoDeCuenta getTipoDeCuenta(){
        return tipoDeCuenta;
    }
}
