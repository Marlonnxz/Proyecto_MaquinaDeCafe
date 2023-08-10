/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uptc.model;

/**
 *
 * @author MARLON
 */
public class Cappuccino extends Producto {

    private double dineroIntroducido;
    private int cantidadOnzasActualesCap;
    private static final double PRECIO_ONZA = 510;

    public Cappuccino() {

    }

    public Cappuccino(int cantidadOnzasActuales) {
        super("Cappuccino", cantidadOnzasActuales);
        this.cantidadOnzasActualesCap = cantidadOnzasActuales;
    }

    @Override
    public double calcularPrecioOnzasIngresadas(int onzas) {
        double resultado;
        resultado = onzas * PRECIO_ONZA;

        return resultado;
    }

    @Override
    public double calcularCambio(double dineroIngresado, int onzas, double dineroBaseMaquina, MaquinaDispensadora maquinaDispensadora) {
        this.dineroIntroducido = dineroIngresado;
        this.cantidadOnzasActuales = onzas;
        Cappuccino cappuccino = new Cappuccino();
        double cambio;
        cambio = Math.abs(cappuccino.calcularPrecioOnzasIngresadas(onzas) - dineroIngresado);
        double dineroEnMaquina = (dineroBaseMaquina + dineroIngresado) - cambio;
        if (dineroBaseMaquina < cambio) {
            maquinaDispensadora.setDineroBase(dineroBaseMaquina);
        } else if (dineroBaseMaquina >= cambio) {
            maquinaDispensadora.setDineroBase(dineroEnMaquina);
        }
        return cambio;

    }

    public int getCantidadOnzasActualesCap() {
        return cantidadOnzasActualesCap;
    }

    public void setCantidadOnzasActualesCap(int cantidadOnzasActualesCap) {
        this.cantidadOnzasActualesCap = cantidadOnzasActualesCap;

    }

    @Override
    public String toString() {
        return "Recibo Cafe Cappuccino: \n"
                + "Precio por onza =" + PRECIO_ONZA
                + "\nOnzas Digitadas = " + this.cantidadOnzasActuales
                + "\nDinero Introducido =" + this.dineroIntroducido
                + "\nValor Final = " + calcularPrecioOnzasIngresadas(cantidadOnzasActuales)
                + "\nCambio = " + calcularCambio(dineroIntroducido, cantidadOnzasActuales, dineroIntroducido, maquina);
    }

}
