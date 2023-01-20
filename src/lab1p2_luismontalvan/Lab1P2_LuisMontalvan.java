/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_luismontalvan;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author luism
 */
public class Lab1P2_LuisMontalvan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        Scanner pochita = new Scanner(System.in);
        boolean salir = false;
        do {
            System.out.print("------- Menu -------\n1)Ejercicio 1\n2)Ejercicio 2\n3)Ejercicio 3\n4)Salir\nElija una opcion: ");
            int opc = pochita.nextInt();
            switch (opc) {
                case 1:
                    hanoi1();
                    break;
                case 2:
                    Fechas();
                    break;
                case 3:
                    Pi1();
                    break;
                case 4:
                    salir = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida\n");
                    break;
            }
        } while (salir == false);
    }

    public static void hanoi1() {
        Scanner pochita = new Scanner(System.in);
        System.out.print("Numero de discos: ");
        int discos = pochita.nextInt();
        int origen = 1;
        int auxiliar = 2;
        int destino = 3;
        int pasos = 1;
        hanoi2(discos, origen, auxiliar, destino, pasos);
    }

    public static void hanoi2(int n, int origen, int auxiliar, int destino, int pasos) {
        if (n == 1) {
            System.out.println(pasos + " Mover disco " + n + " de " + origen + " a " + destino);

        } else {
            hanoi2(n - 1, origen, destino, auxiliar, pasos);

            System.out.println(pasos + " Mover disco " + n + " de " + origen + " a " + destino);

            hanoi2(n - 1, auxiliar, origen, destino, pasos);
        }
    }

    public static void Fechas() throws ParseException {
        Scanner pochita = new Scanner(System.in);
        System.out.println("Escriba una cadena en el siguiente formato: diego,01/06/2000, animales123, carro, 22/16/200...");
        String cadena = pochita.nextLine();
        String[] data = cadena.split(",");
        identify(data);
    }

    public static void Pi1() {
        Scanner pochita = new Scanner(System.in);
        System.out.print("Escriba el limite de la sumatoria: ");
        int k = pochita.nextInt();
        System.out.println(Pi2(k, 0));

    }

    public static double Pi2(int k, double res) {

        if (k == 0) {
            double top = Math.pow(-1, k);
            double bot = 2 * k + 1;
            res = 4 * ((top / bot) + res);
        } else {
            double top = Math.pow(-1, k);
            double bot = 2 * k + 1;
            res = 4 * ((top / bot) + res);
            Pi2(k - 1, res);
        }
        return res;
    }

    public static void identify(String[] data) throws ParseException {
        Date Fecha;
        Fecha = new Date();
        for (int i = 0; i < data[0].length(); i++) {
            String cadena = data[i];
            int cont = 0;
           for (int j = 0; j < cadena.length(); j++) {
                char letra = cadena.charAt(j);
                int numeroChar = (int) letra;
                if (numeroChar == 47) {
                    cont++;
                }
                if (cont == 2) {
                   DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
                   Fecha = df.parse(data[i]);
                   System.out.println(Fecha);
                }
            } 
        }
            
    }
}

