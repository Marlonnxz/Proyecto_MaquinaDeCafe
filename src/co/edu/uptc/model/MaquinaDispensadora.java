/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package co.edu.uptc.model;

import java.util.ArrayList;

/**
 *
 * @author MARLON
 */
public class MaquinaDispensadora implements MaquinaAcciones {

    private double dineroBase;
    private final int NIVEL_MAXIMO_ONZAS_MAQUINA = 60;
    private int cantidadOnzasMaquina;
    private final String CONTRASENA_MAQUINA = "12345";

    public MaquinaDispensadora() {

    }

    public MaquinaDispensadora(double dineroBase, int cantidadOnzasMaquina) {
        this.dineroBase = dineroBase;
        this.cantidadOnzasMaquina = cantidadOnzasMaquina;
    }

    public <T> String mostrarRecibo(T producto) {
        return producto.toString();
    }

    @Override
    public String prendido() {
        return "La maquina esta encendida";
    }

    @Override
    public String apagado() {

        return "La maquina esta apagada";
    }

    public String getCONTRASENA_MAQUINA() {
        return CONTRASENA_MAQUINA;
    }

    public int getNIVEL_MAXIMO_ONZAS_MAQUINA() {
        return NIVEL_MAXIMO_ONZAS_MAQUINA;
    }

    public double getDineroBase() {
        return dineroBase;
    }

    public void setDineroBase(double dineroBase) {
        this.dineroBase = dineroBase;
    }

    @Override
    public String iniciaLlenado() {
        return "¡Inicio de llenado!";
    }

    @Override
    public String finalizaLlenado() {
        return "Finalizo el llenado\n"
                + "       ( (\n"
                + "       ) )\n"
                + "     ........\n"
                + "     |      |\n"
                + "     \\      /\n"
                + "      `----'";
    }

}
