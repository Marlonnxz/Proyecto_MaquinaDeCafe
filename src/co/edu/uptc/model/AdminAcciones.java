/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.uptc.model;

/**
 *
 * @author MARLON
 */
public interface AdminAcciones {

    abstract void surtirProducto(int opcion ,int numeroDeOnzas, Cappuccino cappuccino,Express express,Latte latte,MaquinaDispensadora maquinaDispensadora);
    abstract void ingresarDineroBase(double dinero,MaquinaDispensadora maquinaDispensadora);
}
