/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uptc.model;

/**
 *
 * @author MARLON
 */
public class Express extends Producto {

    private double dineroIntroducido;
    private int cantidadOnzasActualesExp;
    public static final double PRECIO_ONZA = 470;

    public Express() {

    }

    public Express(int cantidadOnzasActuales) {
        super("Express", cantidadOnzasActuales);
        this.cantidadOnzasActualesExp = cantidadOnzasActuales;
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
        Express express = new Express();
        double cambio;
        cambio = Math.abs(express.calcularPrecioOnzasIngresadas(onzas) - dineroIngresado);
        double dineroEnMaquina = (dineroBaseMaquina + dineroIngresado) - cambio;
        if (dineroBaseMaquina < cambio) {
            maquinaDispensadora.setDineroBase(dineroBaseMaquina);
        } else if (dineroBaseMaquina >= cambio) {
            maquinaDispensadora.setDineroBase(dineroEnMaquina);
        }
        return cambio;

    }

    public int getCantidadOnzasActualesExp() {
        return cantidadOnzasActualesExp;
    }

    public void setCantidadOnzasActualesExp(int cantidadOnzasActualesExp) {
        this.cantidadOnzasActualesExp = cantidadOnzasActualesExp;

    }

    @Override
    public String toString() {
        return "Recibo Cafe Express: \n"
                + "Precio por onza =" + PRECIO_ONZA
                + "\nOnzas Digitadas = " + cantidadOnzasActuales
                + "\nDinero Introducido =" + dineroIntroducido
                + "\nValor Final = " + calcularPrecioOnzasIngresadas(cantidadOnzasActuales)
                + "\nCambio = " + calcularCambio(dineroIntroducido, cantidadOnzasActuales, dineroIntroducido, maquina);
    }

}
