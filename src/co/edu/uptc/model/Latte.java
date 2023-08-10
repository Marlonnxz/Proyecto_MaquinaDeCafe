/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uptc.model;

/**
 *
 * @author MARLON
 */
public class Latte extends Producto {

    private double dineroIntroducido;
    private int cantidadOnzasActualesLat;
    public static final double PRECIO_ONZA = 530;

    public Latte() {
    }

    public Latte(int cantidadOnzasActuales) {
        super("Latte", cantidadOnzasActuales);
        this.cantidadOnzasActualesLat = cantidadOnzasActuales;
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
        Latte latte = new Latte();
        double cambio;
        cambio = Math.abs(latte.calcularPrecioOnzasIngresadas(onzas) - dineroIngresado);
        Math.abs(latte.calcularPrecioOnzasIngresadas(onzas));
        double dineroEnMaquina = (dineroBaseMaquina + dineroIngresado) - cambio;
        if (dineroBaseMaquina < cambio) {
            maquinaDispensadora.setDineroBase(dineroBaseMaquina);
        } else if (dineroBaseMaquina >= cambio) {
            maquinaDispensadora.setDineroBase(dineroEnMaquina);
        }
        return cambio;
    }

    public int getCantidadOnzasActualesLat() {
        return cantidadOnzasActualesLat;
    }

    public void setCantidadOnzasActualesLat(int cantidadOnzasActualesLat) {
        this.cantidadOnzasActualesLat = cantidadOnzasActualesLat;

    }

    @Override
    public String toString() {
        return "Recibo Cafe Latte: \n"
                + "Precio por onza =" + PRECIO_ONZA
                + "\nOnzas Digitadas = " + cantidadOnzasActuales
                + "\nDinero Introducido =" + dineroIntroducido
                + "\nValor Final = " + calcularPrecioOnzasIngresadas(cantidadOnzasActuales)
                + "\nCambio = " + calcularCambio(dineroIntroducido, cantidadOnzasActuales, dineroIntroducido, maquina);
    }

}
