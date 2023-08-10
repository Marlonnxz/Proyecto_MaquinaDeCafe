/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uptc.view;

import co.edu.uptc.model.Administrador;
import co.edu.uptc.model.Cappuccino;
import co.edu.uptc.model.Express;
import co.edu.uptc.model.Latte;
import co.edu.uptc.model.MaquinaDispensadora;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author MARLON
 */
public class Main {

    public static void main(String[] args) {
        //CONTRASEÑA ADMIN :12345

        Cappuccino capAux = new Cappuccino();
        int opcion1 = 0;
        int opcion2 = 0;
        boolean bandera1 = false;
        boolean bandera2 = false;
        Scanner sc = new Scanner(System.in);
        MaquinaDispensadora maquina = new MaquinaDispensadora();
        Administrador admin = new Administrador();
        int contadorCantidadOnzasVendidasCappucino = 0;
        int contadorCantidadOnzasVendidasExpress = 0;
        int contadorCantidadOnzasVendidasLatte = 0;
        double contadorDineroOnzasCappuccino = 0;
        double contadorDineroOnzasExpress = 0;
        double contadorDineroOnzasLatte = 0;
        System.out.println("1. Encender \n"
                + "2. Apagar \n");

        while (bandera1 != true) {
            try {
                opcion1 = sc.nextInt();
                switch (opcion1) {
                    case 1:
                        System.out.println("---------------------");
                        System.out.println(maquina.prendido());
                        System.out.println("---------------------\n"
                                + "**Modo administrador** \n");

                        boolean accesoPermido = false;
                        while (!accesoPermido) {
                            System.out.println("Digite la contraseña:");
                            String contraseña = sc.next();
                            try {
                                if (contraseña.equals(maquina.getCONTRASENA_MAQUINA())) {
                                    System.out.println("Contraseña correcta. Acceso Permitido");
                                    System.out.println("Ingrese el dinero a la maquina:");
                                    double dinero = sc.nextDouble();
                                    maquina.setDineroBase(dinero);

                                    System.out.println("Digite (1) para llenar todos los productos a su tope maximo \n");
                                    int productoOnzas = sc.nextInt();

                                    if (productoOnzas == 1) {
                                        Cappuccino cappuccino = new Cappuccino(20);
                                        Express express = new Express(20);
                                        Latte latte = new Latte(20);
                                        MaquinaDispensadora maquina1 = new MaquinaDispensadora(dinero, productoOnzas);
                                        boolean bandera3 = false;
                                        while (!bandera3) {
                                            try {
                                                System.out.println("-----Bienvenido a la maquina dispensadora----- \n"
                                                        + "Digite el producto que desea: \n"
                                                        + "1. Cappuccino \n"
                                                        + "2. Express \n"
                                                        + "3. Latte \n"
                                                        + "4. Administrador");

                                                opcion2 = sc.nextInt();
                                                switch (opcion2) {
                                                    case 1:
                                                      
                                                        System.out.println("Cafe Cappuccino: \n"
                                                                + "Digite la cantidad de onzas que desea: \n"
                                                                + "1. 5 onzas \n"
                                                                + "2. 10 onzas");
                                                        int cantOnzas = sc.nextInt();
                                                        if (cappuccino.getCantidadOnzasActualesCap() <= 0 || cappuccino.getCantidadOnzasActualesCap() < 5 || cappuccino.getCantidadOnzasActualesCap() == 5 && cantOnzas == 2
                                                                || cappuccino.getCantidadOnzasActualesCap() > 5 && cappuccino.getCantidadOnzasActualesCap() < 10 && cantOnzas == 2) {
                                                            System.out.println("No hay onzas de cafe cappucino suficientes, contactarse con el admininistrador");

                                                        } else {
                                                            switch (cantOnzas) {
                                                                case 1:
                                                                    System.out.println("Ingrese a la maquina $" + cappuccino.calcularPrecioOnzasIngresadas(5));
                                                                    double dineroCappucino = sc.nextDouble();
                                                                    double dineroFaltante = cappuccino.calcularPrecioOnzasIngresadas(5) - dineroCappucino;
                                                                    if (dineroCappucino < cappuccino.calcularPrecioOnzasIngresadas(5)) {
                                                                        System.out.println("¡Dinero insuficiente! \n"
                                                                                + "Retire el dinero ingresado $" + dineroCappucino + " e ingrese el valor solicitado: $" + cappuccino.calcularPrecioOnzasIngresadas(5)
                                                                                + "\nDinero faltante: $" + dineroFaltante);

                                                                    } else if (dineroCappucino == cappuccino.calcularPrecioOnzasIngresadas(5)) {
                                                                        System.out.println("¡Gracias por su compra! \n"
                                                                                + "Su cambio es: $" + cappuccino.calcularCambio(dineroCappucino, 5, maquina1.getDineroBase(), maquina1));
                                                                        System.out.println(maquina1.iniciaLlenado());
                                                                        System.out.println("Llenando...");
                                                                        System.out.println(maquina1.finalizaLlenado());
                                                                        cappuccino.setCantidadOnzasActualesCap(cappuccino.getCantidadOnzasActualesCap() - 5);
                                                                        System.out.println("--------------------------");
                                                                        System.out.println(maquina1.mostrarRecibo(cappuccino));
                                                                        contadorCantidadOnzasVendidasCappucino += 5;
                                                                        contadorDineroOnzasCappuccino += cappuccino.calcularPrecioOnzasIngresadas(5);
                                                                        System.out.println("--------------------------");

                                                                    } else if (dineroCappucino > cappuccino.calcularPrecioOnzasIngresadas(5)) {
                                                                        //Aca esta el fallo
                                                                        double aux = cappuccino.calcularCambio(dineroCappucino, 5, maquina1.getDineroBase(), maquina1);
                                                                        if (maquina1.getDineroBase() > aux) {
                                                                            System.out.println("¡Gracias por su compra!\n"
                                                                                    + "Su cambio es: $" + aux);
                                                                            System.out.println(maquina1.iniciaLlenado());
                                                                            System.out.println("Llenando...");
                                                                            System.out.println(maquina1.finalizaLlenado());
                                                                            cappuccino.setCantidadOnzasActualesCap(cappuccino.getCantidadOnzasActualesCap() - 5);
                                                                            System.out.println("--------------------------");
                                                                            System.out.println(maquina1.mostrarRecibo(cappuccino));
                                                                            contadorCantidadOnzasVendidasCappucino += 5;
                                                                            contadorDineroOnzasCappuccino += cappuccino.calcularPrecioOnzasIngresadas(5);
                                                                            System.out.println("--------------------------");
                                                                            System.out.println(cappuccino.getCantidadOnzasActualesCap());
                                                                        } else {
                                                                            System.out.println("La maquina no cuenta con el dinero suficiente para darle el cambio.\n"
                                                                                    + "Contactese con el administrador.");
                                                                        }

                                                                    } else {
                                                                        System.out.println("La maquina no cuenta con dinero suficiente, por favor contacte al administrador");
                                                                    }

                                                                    break;
                                                                case 2:
                                                                    System.out.println("Ingrese a la maquina $" + cappuccino.calcularPrecioOnzasIngresadas(10));
                                                                    double dineroCappucino2 = sc.nextDouble();
                                                                    double dineroFaltante2 = cappuccino.calcularPrecioOnzasIngresadas(10) - dineroCappucino2;

                                                                    if (dineroCappucino2 < cappuccino.calcularPrecioOnzasIngresadas(10)) {
                                                                        System.out.println("¡Dinero insuficiente! \n"
                                                                                + "Retire el dinero ingresado $" + dineroCappucino2 + " e ingrese el valor solicitado: $" + cappuccino.calcularPrecioOnzasIngresadas(10)
                                                                                + "\nDinero faltante: $" + dineroFaltante2);

                                                                    } else if (dineroCappucino2 == cappuccino.calcularPrecioOnzasIngresadas(10)) {
                                                                        System.out.println("¡Gracias por su compra! \n"
                                                                                + "Su cambio es: $" + cappuccino.calcularCambio(dineroCappucino2, 10, maquina1.getDineroBase(), maquina1));

                                                                        System.out.println(maquina1.iniciaLlenado());
                                                                        System.out.println("Llenando...");
                                                                        System.out.println(maquina1.finalizaLlenado());
                                                                        cappuccino.setCantidadOnzasActualesCap(cappuccino.getCantidadOnzasActualesCap() - 10);
                                                                        System.out.println("--------------------------");
                                                                        System.out.println(maquina1.mostrarRecibo(cappuccino));
                                                                        contadorCantidadOnzasVendidasCappucino += 10;
                                                                        contadorDineroOnzasCappuccino += cappuccino.calcularPrecioOnzasIngresadas(10);
                                                                        System.out.println("--------------------------");

                                                                    } else if (dineroCappucino2 > cappuccino.calcularPrecioOnzasIngresadas(10)) {
                                                                        double aux = cappuccino.calcularCambio(dineroCappucino2, 10, maquina1.getDineroBase(), maquina1);
                                                                        if (maquina1.getDineroBase() > aux) {
                                                                            System.out.println("¡Gracias por su compra!\n"
                                                                                    + "Su cambio es: $" + aux);

                                                                            System.out.println(maquina1.iniciaLlenado());
                                                                            System.out.println("Llenando...");
                                                                            System.out.println(maquina1.finalizaLlenado());
                                                                            cappuccino.setCantidadOnzasActualesCap(cappuccino.getCantidadOnzasActualesCap() - 10);
                                                                            System.out.println("--------------------------");
                                                                            System.out.println(maquina1.mostrarRecibo(cappuccino));
                                                                            contadorCantidadOnzasVendidasCappucino += 10;
                                                                            contadorDineroOnzasCappuccino += cappuccino.calcularPrecioOnzasIngresadas(10);
                                                                            System.out.println("--------------------------");

                                                                        } else {
                                                                            System.out.println("La maquina no cuenta con el dinero suficiente para darle el cambio.\n"
                                                                                    + "Contactese con el administrador.");
                                                                        }

                                                                    } else {
                                                                        System.out.println("La maquina no cuenta con dinero suficiente, por favor contacte al administrador");
                                                                    }

                                                                    break;

                                                            }

                                                        }
                                                      break;

                                                    case 2:
                                                        System.out.println("Cafe Express: \n"
                                                                + "Digite la cantidad de onzas que desea: \n"
                                                                + "1. 5 onzas \n"
                                                                + "2. 10 onzas");
                                                        int cantOnzas2 = sc.nextInt();
                                                        //hacer otro while con una bandera para controlar este menu
                                                        if (express.getCantidadOnzasActualesExp() <= 0 || express.getCantidadOnzasActualesExp() < 5 || express.getCantidadOnzasActualesExp() == 5 && cantOnzas2 == 2
                                                                || express.getCantidadOnzasActualesExp() > 5 && express.getCantidadOnzasActualesExp() < 10 && cantOnzas2 == 2) {
                                                            System.out.println("No hay onzas de cafe Express  suficientes, contactarse con el admininistrador");

                                                        } else {
                                                            switch (cantOnzas2) {
                                                                case 1:
                                                                    System.out.println("Ingrese a la maquina $" + express.calcularPrecioOnzasIngresadas(5));
                                                                    double dineroExpress = sc.nextDouble();
                                                                    double dineroFaltante = express.calcularPrecioOnzasIngresadas(5) - dineroExpress;
                                                                    if (dineroExpress < express.calcularPrecioOnzasIngresadas(5)) {
                                                                        System.out.println("¡Dinero insuficiente! \n"
                                                                                + "Retire el dinero ingresado $" + dineroExpress + " e ingrese el valor solicitado: $" + express.calcularPrecioOnzasIngresadas(5)
                                                                                + "\nDinero faltante: $" + dineroFaltante);

                                                                    } else if (dineroExpress == express.calcularPrecioOnzasIngresadas(5)) {
                                                                        System.out.println("¡Gracias por su compra! \n"
                                                                                + "Su cambio es: $" + express.calcularCambio(dineroExpress, 5, maquina1.getDineroBase(), maquina1));

                                                                        System.out.println(maquina1.iniciaLlenado());
                                                                        System.out.println("Llenando...");
                                                                        System.out.println(maquina1.finalizaLlenado());
                                                                        express.setCantidadOnzasActualesExp(express.getCantidadOnzasActualesExp() - 5);
                                                                        System.out.println("--------------------------");
                                                                        System.out.println(maquina1.mostrarRecibo(express));
                                                                        contadorCantidadOnzasVendidasExpress += 5;
                                                                        contadorDineroOnzasExpress += express.calcularPrecioOnzasIngresadas(5);
                                                                        System.out.println("--------------------------");

                                                                    } else if (dineroExpress > express.calcularPrecioOnzasIngresadas(5)) {
                                                                        double aux = express.calcularCambio(dineroExpress, 5, maquina1.getDineroBase(), maquina1);
                                                                        if (maquina1.getDineroBase() > aux) {
                                                                            System.out.println("¡Gracias por su compra!\n"
                                                                                    + "Su cambio es: $" + aux);

                                                                            System.out.println(maquina1.iniciaLlenado());
                                                                            System.out.println("Llenando...");
                                                                            System.out.println(maquina1.finalizaLlenado());
                                                                            express.setCantidadOnzasActualesExp(express.getCantidadOnzasActualesExp() - 5);
                                                                            System.out.println("--------------------------");
                                                                            System.out.println(maquina1.mostrarRecibo(express));
                                                                            contadorCantidadOnzasVendidasExpress += 5;
                                                                            contadorDineroOnzasExpress += express.calcularPrecioOnzasIngresadas(5);
                                                                            System.out.println("--------------------------");

                                                                        } else {
                                                                            System.out.println("La maquina no cuenta con el dinero suficiente para darle el cambio.\n"
                                                                                    + "Contactese con el administrador.");
                                                                        }

                                                                    } else {
                                                                        System.out.println("La maquina no cuenta con dinero suficiente, por favor contacte al administrador");
                                                                    }

                                                                    break;
                                                                case 2:
                                                                    System.out.println("Ingrese a la maquina $" + express.calcularPrecioOnzasIngresadas(10));
                                                                    double dineroExpress2 = sc.nextDouble();
                                                                    double dineroFaltante2 = express.calcularPrecioOnzasIngresadas(10) - dineroExpress2;
                                                                    if (dineroExpress2 < express.calcularPrecioOnzasIngresadas(10)) {
                                                                        System.out.println("¡Dinero insuficiente! \n"
                                                                                + "Retire el dinero ingresado $" + dineroExpress2 + " e ingrese el valor solicitado: $" + express.calcularPrecioOnzasIngresadas(10)
                                                                                + "\nDinero faltante: $" + dineroFaltante2);

                                                                    } else if (dineroExpress2 == express.calcularPrecioOnzasIngresadas(10)) {
                                                                        System.out.println("¡Gracias por su compra! \n"
                                                                                + "Su cambio es: $" + express.calcularCambio(dineroExpress2, 10, maquina1.getDineroBase(), maquina1));

                                                                        System.out.println(maquina1.iniciaLlenado());
                                                                        System.out.println("Llenando...");
                                                                        System.out.println(maquina1.finalizaLlenado());
                                                                        express.setCantidadOnzasActualesExp(express.getCantidadOnzasActualesExp() - 10);
                                                                        System.out.println("--------------------------");
                                                                        System.out.println(maquina1.mostrarRecibo(express));
                                                                        contadorCantidadOnzasVendidasExpress += 10;
                                                                        contadorDineroOnzasExpress += express.calcularPrecioOnzasIngresadas(10);
                                                                        System.out.println("--------------------------");

                                                                    } else if (dineroExpress2 > express.calcularPrecioOnzasIngresadas(10)) {
                                                                        double aux = express.calcularCambio(dineroExpress2, 10, maquina1.getDineroBase(), maquina1);
                                                                        if (maquina1.getDineroBase() > aux) {
                                                                            System.out.println("¡Gracias por su compra!\n"
                                                                                    + "Su cambio es: $" + aux);

                                                                            System.out.println(maquina1.iniciaLlenado());
                                                                            System.out.println("Llenando...");
                                                                            System.out.println(maquina1.finalizaLlenado());
                                                                            express.setCantidadOnzasActualesExp(express.getCantidadOnzasActualesExp() - 10);
                                                                            System.out.println("--------------------------");
                                                                            System.out.println(maquina1.mostrarRecibo(express));
                                                                            contadorCantidadOnzasVendidasExpress += 10;
                                                                            contadorDineroOnzasExpress += express.calcularPrecioOnzasIngresadas(10);
                                                                            System.out.println("--------------------------");

                                                                        } else {
                                                                            System.out.println("La maquina no cuenta con el dinero suficiente para darle el cambio.\n"
                                                                                    + "Contactese con el administrador.");
                                                                        }

                                                                    } else {
                                                                        System.out.println("La maquina no cuenta con dinero suficiente, por favor contacte al administrador");
                                                                    }

                                                                    break;
                                                            }

                                                        }

                                                        break;
                                                    case 3:

                                                        System.out.println("Cafe Latte: \n"
                                                                + "Digite la cantidad de onzas que desea: \n"
                                                                + "1. 5 onzas \n"
                                                                + "2. 10 onzas");
                                                        int cantOnzas3 = sc.nextInt();
                                                        //hacer otro while con una bandera para controlar este menu
                                                        if (latte.getCantidadOnzasActualesLat() <= 0 || latte.getCantidadOnzasActualesLat() < 5 || latte.getCantidadOnzasActualesLat() == 5 && cantOnzas3 == 2
                                                                || latte.getCantidadOnzasActualesLat() > 5 && latte.getCantidadOnzasActualesLat() < 10 && cantOnzas3 == 2) {
                                                            System.out.println("No hay onzas de cafe Latte  suficientes, contactarse con el admininistrador");

                                                        } else {
                                                            switch (cantOnzas3) {
                                                                case 1:
                                                                    System.out.println("Ingrese a la maquina $" + latte.calcularPrecioOnzasIngresadas(5));
                                                                    double dineroLatte = sc.nextDouble();
                                                                    double dineroFaltante = latte.calcularPrecioOnzasIngresadas(5) - dineroLatte;
                                                                    if (dineroLatte < latte.calcularPrecioOnzasIngresadas(5)) {
                                                                        System.out.println("¡Dinero insuficiente! \n"
                                                                                + "Retire el dinero ingresado $" + dineroLatte + " e ingrese el valor solicitado: $" + latte.calcularPrecioOnzasIngresadas(5)
                                                                                + "\nDinero faltante: $" + dineroFaltante);

                                                                    } else if (dineroLatte == latte.calcularPrecioOnzasIngresadas(5)) {
                                                                        System.out.println("¡Gracias por su compra! \n"
                                                                                + "Su cambio es: $" + latte.calcularCambio(dineroLatte, 5, maquina1.getDineroBase(), maquina1));

                                                                        System.out.println(maquina1.iniciaLlenado());
                                                                        System.out.println("Llenando...");
                                                                        System.out.println(maquina1.finalizaLlenado());
                                                                        latte.setCantidadOnzasActualesLat(latte.getCantidadOnzasActualesLat() - 5);
                                                                        System.out.println("--------------------------");
                                                                        System.out.println(maquina1.mostrarRecibo(latte));
                                                                        contadorCantidadOnzasVendidasLatte += 5;
                                                                        contadorDineroOnzasLatte += latte.calcularPrecioOnzasIngresadas(5);
                                                                        System.out.println("--------------------------");

                                                                    } else if (dineroLatte > latte.calcularPrecioOnzasIngresadas(5)) {
                                                                        double aux = latte.calcularCambio(dineroLatte, 5, maquina1.getDineroBase(), maquina1);
                                                                        if (maquina1.getDineroBase() > aux) {
                                                                            System.out.println("¡Gracias por su compra!\n"
                                                                                    + "Su cambio es: $" + aux);
                                                                            System.out.println(maquina1.iniciaLlenado());
                                                                            System.out.println("Llenando...");
                                                                            System.out.println(maquina1.finalizaLlenado());
                                                                            latte.setCantidadOnzasActualesLat(latte.getCantidadOnzasActualesLat() - 5);
                                                                            System.out.println("--------------------------");
                                                                            System.out.println(maquina1.mostrarRecibo(latte));
                                                                            contadorCantidadOnzasVendidasLatte += 5;
                                                                            contadorDineroOnzasLatte += latte.calcularPrecioOnzasIngresadas(5);
                                                                            System.out.println("--------------------------");

                                                                        } else {
                                                                            System.out.println("La maquina no cuenta con el dinero suficiente para darle el cambio.\n"
                                                                                    + "Contactese con el administrador.");
                                                                        }

                                                                    } else {
                                                                        System.out.println("La maquina no cuenta con dinero suficiente, por favor contacte al administrador");
                                                                    }

                                                                    break;
                                                                case 2:
                                                                    System.out.println("Ingrese a la maquina $" + latte.calcularPrecioOnzasIngresadas(10));
                                                                    double dineroLatte2 = sc.nextDouble();
                                                                    double dineroFaltante2 = latte.calcularPrecioOnzasIngresadas(10) - dineroLatte2;
                                                                    if (dineroLatte2 < latte.calcularPrecioOnzasIngresadas(10)) {
                                                                        System.out.println("¡Dinero insuficiente! \n"
                                                                                + "Retire el dinero ingresado $" + dineroLatte2 + " e ingrese el valor solicitado: $" + latte.calcularPrecioOnzasIngresadas(10)
                                                                                + "\nDinero faltante: $" + dineroFaltante2);

                                                                    } else if (dineroLatte2 == latte.calcularPrecioOnzasIngresadas(10)) {
                                                                        System.out.println("¡Gracias por su compra! \n"
                                                                                + "Su cambio es: $" + latte.calcularCambio(dineroLatte2, 10, maquina1.getDineroBase(), maquina1));

                                                                        System.out.println(maquina1.iniciaLlenado());
                                                                        System.out.println("Llenando...");
                                                                        System.out.println(maquina1.finalizaLlenado());
                                                                        latte.setCantidadOnzasActualesLat(latte.getCantidadOnzasActualesLat() - 10);
                                                                        System.out.println("--------------------------");
                                                                        System.out.println(maquina1.mostrarRecibo(latte));
                                                                        contadorCantidadOnzasVendidasLatte += 10;
                                                                        contadorDineroOnzasLatte += latte.calcularPrecioOnzasIngresadas(10);
                                                                        System.out.println("--------------------------");

                                                                    } else if (dineroLatte2 > latte.calcularPrecioOnzasIngresadas(10)) {
                                                                        double aux = latte.calcularCambio(dineroLatte2, 10, maquina1.getDineroBase(), maquina1);
                                                                        if (maquina1.getDineroBase() > aux) {
                                                                            System.out.println("¡Gracias por su compra!\n"
                                                                                    + "Su cambio es: $" + aux);

                                                                            System.out.println(maquina1.iniciaLlenado());
                                                                            System.out.println("Llenando...");
                                                                            System.out.println(maquina1.finalizaLlenado());
                                                                            latte.setCantidadOnzasActualesLat(latte.getCantidadOnzasActualesLat() - 10);
                                                                            System.out.println("--------------------------");
                                                                            System.out.println(maquina1.mostrarRecibo(latte));
                                                                            contadorCantidadOnzasVendidasLatte += 10;
                                                                            contadorDineroOnzasLatte += latte.calcularPrecioOnzasIngresadas(10);
                                                                            System.out.println("--------------------------");

                                                                        } else {
                                                                            System.out.println("La maquina no cuenta con el dinero suficiente para darle el cambio.\n"
                                                                                    + "Contactese con el administrador.");
                                                                        }

                                                                    } else {
                                                                        System.out.println("La maquina no cuenta con dinero suficiente, por favor contacte al administrador");
                                                                    }

                                                                    break;
                                                            }

                                                        }

                                                        break;

                                                    case 4:
                                                        System.out.println("Digite la contraseña:");
                                                        String contraseña2 = sc.next();
                                                        if (contraseña2.equals(maquina.getCONTRASENA_MAQUINA())) {
                                                            System.out.println("Contraseña correcta. Acceso Permitido");
                                                            System.out.println("MODO ADMINISTRADOR \n"
                                                                    + "1. Surtir productos\n"
                                                                    + "2. Agregar dinero a la maquina dispensadora \n"
                                                                    + "3. Reporte del dia ");
                                                            int opcion3 = sc.nextInt();
                                                            switch (opcion3) {
                                                                case 1:
                                                                    System.out.println("Seleccione el producto que desea surtir: \n"
                                                                            + "Maximo por producto 20 onzas\n"
                                                                            + "Maximo de la maquina 60 onzas.\n"
                                                                            + "1. Nivel Cappuccino " + cappuccino.getCantidadOnzasActualesCap() + " onzas"
                                                                            + "\n2. Nivel Express " + express.getCantidadOnzasActualesExp() + " onzas"
                                                                            + "\n3. Nivel Latte " + latte.getCantidadOnzasActualesLat() + " onzas");
                                                                    int productoOnzas2 = sc.nextInt();
                                                                    sc.nextLine();

                                                                    System.out.println("\nDigite el valor en onzas que desea surtir a la maquina dispensadora:");
                                                                    int numeroOnzas = sc.nextInt();
                                                                    sc.nextLine();
                                                                    if (numeroOnzas > maquina1.getNIVEL_MAXIMO_ONZAS_MAQUINA()) {
                                                                        System.out.println("El numero de onzas ingresado, exede el limite de la maquina dispensadora");
                                                                    } else if (numeroOnzas <= maquina1.getNIVEL_MAXIMO_ONZAS_MAQUINA()) {
                                                                        switch (productoOnzas2) {
                                                                            case 1:
                                                                                if (numeroOnzas > 20) {
                                                                                    System.out.println("El numero de onzas ingresado exede el maximo por producto");
                                                                                    break;
                                                                                } else if (cappuccino.getCantidadOnzasActualesCap() + numeroOnzas > 20) {
                                                                                    System.out.println("El numero de onzas que ingresaste sumado al que ya tenia el cappuccino\n"
                                                                                            + "exeden el limite por producto en onzas de la maquina");
                                                                                    break;
                                                                                } else {
                                                                                    admin.surtirProducto(productoOnzas2, numeroOnzas, cappuccino, express, latte, maquina1);
                                                                                    System.out.println("Nivel de cafe Capuccino en onzas: " + cappuccino.getCantidadOnzasActualesCap());
                                                                                    break;
                                                                                }

                                                                            case 2:
                                                                                if (numeroOnzas > 20) {
                                                                                    System.out.println("El numero de onzas ingresado exede el maximo por producto");
                                                                                    break;
                                                                                } else if (express.getCantidadOnzasActualesExp() + numeroOnzas > 20) {
                                                                                    System.out.println("El numero de onzas que ingresaste sumado al que ya tenia el cappuccino\n"
                                                                                            + "exeden el limite por producto en onzas de la maquina");
                                                                                    break;
                                                                                } else {
                                                                                    admin.surtirProducto(productoOnzas2, numeroOnzas, cappuccino, express, latte, maquina1);
                                                                                    System.out.println("Nivel de cafe Express en onzas: " + express.getCantidadOnzasActualesExp());
                                                                                    break;
                                                                                }

                                                                            case 3:
                                                                                if (numeroOnzas > 20) {
                                                                                    System.out.println("El numero de onzas ingresado exede el maximo por producto");
                                                                                    break;
                                                                                } else if (latte.getCantidadOnzasActualesLat() + numeroOnzas > 20) {
                                                                                    System.out.println("El numero de onzas que ingresaste sumado al que ya tenia el cappuccino\n"
                                                                                            + "exeden el limite por producto en onzas de la maquina");
                                                                                    break;
                                                                                } else {
                                                                                    admin.surtirProducto(productoOnzas2, numeroOnzas, cappuccino, express, latte, maquina1);
                                                                                    System.out.println("Nivel de cafe Latte en onzas: " + latte.getCantidadOnzasActualesLat());
                                                                                    break;
                                                                                }

                                                                            default:
                                                                                System.out.println("Opcion invalida");
                                                                                break;
                                                                        }
                                                                    }

                                                                    break;
                                                                case 2:
                                                                    System.out.println("Digite el monto que desea ingresar a la maquina dispensadora");
                                                                    double dineroCappucino2 = sc.nextDouble();
                                                                    admin.ingresarDineroBase(dineroCappucino2, maquina1);
                                                                    System.out.println("Dinero en maquina: $" + maquina1.getDineroBase());

                                                                    break;

                                                                case 3:
                                                                    System.out.println("Reporte del dia: \n"
                                                                            + "1. Cappuccino \n"
                                                                            + "2. Express \n"
                                                                            + "3. Latte \n"
                                                                            + "4. Reporte general de las ventas del dia");

                                                                    int opcionReporte = sc.nextInt();

                                                                    switch (opcionReporte) {
                                                                        case 1:
                                                                            System.out.println("Cappuccino: \n"
                                                                                    + "Total onzas vendidas en el dia: " + contadorCantidadOnzasVendidasCappucino
                                                                                    + "\nTotal dinero obtenido por las onzas vendidas de Cappuccino: $" + contadorDineroOnzasCappuccino);
                                                                            break;
                                                                        case 2:
                                                                            System.out.println("Express: \n"
                                                                                    + "Total onzas vendidas en el dia: " + contadorCantidadOnzasVendidasExpress
                                                                                    + "\nTotal dinero obtenido por las onzas vendidas de Express: $" + contadorDineroOnzasExpress);
                                                                            break;
                                                                        case 3:
                                                                            System.out.println("Latte: \n"
                                                                                    + "Total onzas vendidas en el dia: " + contadorCantidadOnzasVendidasLatte
                                                                                    + "\nTotal dinero obtenido por las onzas vendidas de Latte: $" + contadorDineroOnzasLatte);
                                                                            break;
                                                                        case 4:
                                                                            double resultadoOnzasVendidas = (contadorCantidadOnzasVendidasCappucino + contadorCantidadOnzasVendidasExpress + contadorCantidadOnzasVendidasLatte);
                                                                            double resultadoDineroObtenidoDia = (contadorDineroOnzasCappuccino + contadorDineroOnzasExpress + contadorDineroOnzasLatte);

                                                                            System.out.println("Reporte General: \n"
                                                                                    + "Total onzas vendidas de todos los productos: " + resultadoOnzasVendidas
                                                                                    + "\nTotal dinero obtenido por todos los productos vendidos: $" + resultadoDineroObtenidoDia);
                                                                            break;

                                                                        
                                                                        default:
                                                                            System.out.println("Error, esta opcion no se encuentra en el menu.");
                                                                            break;
                                                                    }

                                                                    break;
                                                                default:
                                                                    System.out.println("Digite la opcion que desee.");
                                                                    break;

                                                            }
                                                        } else {
                                                            System.out.println("Contraseña incorrecta. Acceso Denegado");
                                                        }

                                                        break;
                                                    default:
                                                        System.out.println("Marque una de la opciones mostradas en pantalla.");
                                                        break;
                                                }

                                            } catch (InputMismatchException x) {
                                                System.out.println("Error, digite correctamente la opcion");
                                                sc.nextLine();

                                            }

                                        }
                                    } else {
                                        System.out.println("Por favor digite (1) para surtir al tope todos los productos");
                                    }

                                } else {
                                    System.out.println("Contraseña incorrecta. Acceso denegado");
                                    sc.nextLine();

                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Error, digite correctamente los datos");
                                sc.nextLine();
                            }
                        }
                        break;
                    case 2:
                        System.out.println(maquina.apagado());
                        bandera1 = true;
                        break;

                }

            } catch (InputMismatchException e) {
                System.out.println("Opcion invalida");
                sc.nextLine();
                
            }

        }
    }
}
