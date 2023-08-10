/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uptc.model;

/**
 *
 * @author MARLON
 */
public class Administrador implements AdminAcciones {


    @Override
    public void surtirProducto(int opcion, int numeroDeOnzas, Cappuccino cappuccino, Express express, Latte latte, MaquinaDispensadora maquinaDispensadora) {

        if (opcion == 1) {
            cappuccino.setCantidadOnzasActualesCap((numeroDeOnzas + cappuccino.getCantidadOnzasActualesCap()));
        } else if (opcion == 2) {
            express.setCantidadOnzasActualesExp((numeroDeOnzas + express.getCantidadOnzasActualesExp()));
        } else if (opcion == 3) {
            latte.setCantidadOnzasActualesLat((numeroDeOnzas + latte.getCantidadOnzasActualesLat()));
        } else {
            cappuccino.setCantidadOnzasActualesCap(cappuccino.getCantidadOnzasActualesCap());
            express.setCantidadOnzasActualesExp(express.getCantidadOnzasActualesExp());
            latte.setCantidadOnzasActualesLat(latte.getCantidadOnzasActualesLat());
        }

    }

    @Override
    public void ingresarDineroBase(double dinero, MaquinaDispensadora maquinaDispensadora) {
        double resultado;
        resultado = maquinaDispensadora.getDineroBase() + dinero;
        maquinaDispensadora.setDineroBase(resultado);
    }
    
    
    
    

}
