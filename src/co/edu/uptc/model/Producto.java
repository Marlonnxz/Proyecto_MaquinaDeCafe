/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uptc.model;

/**
 *
 * @author MARLON
 */
public abstract class Producto {

    protected String nombre;
    protected int cantidadOnzasActuales;
    protected MaquinaDispensadora maquina = new MaquinaDispensadora();

    public Producto() {

    }

    public Producto(String nombre, int cantidadOnzasActuales) {
        this.nombre = nombre;
        this.cantidadOnzasActuales = cantidadOnzasActuales;
    }

    public abstract double calcularPrecioOnzasIngresadas(int onzas);

    public abstract double calcularCambio(double dineroIngresado, int onzas, double dineroBaseMaquina, MaquinaDispensadora maquinaDispensadora);
}
