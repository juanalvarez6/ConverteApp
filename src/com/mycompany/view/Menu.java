package com.mycompany.view;

import com.mycompany.controller.QueryConverter;
import com.mycompany.model.ConverterData;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void viewMenu(){
        Scanner inOption = new Scanner(System.in);
        int option = 0;

        while (option != 7){

            System.out.println("====== Menú Principal ======");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.print("Elija una opción válida: ");
            System.out.println("************************************************");

            try {
                option = inOption.nextInt();

                switch (option) {
                    case 1 -> Menu.ask("USD", "ARS");
                    case 2 -> Menu.ask("ARS", "USD");
                    case 3 -> Menu.ask("USD", "BRL");
                    case 4 -> Menu.ask("BRL", "USD");
                    case 5 -> Menu.ask("USD", "COP");
                    case 6 -> Menu.ask("COP", "USD");
                    case 7 -> System.out.println("Saliendo del menú...");
                    default -> System.out.println("Opción no válida.");
                }
            }catch (InputMismatchException e){
                System.out.println("Error: Debe ingresar un número válido.");
                inOption.next();
            }
            System.out.println();

        }
        System.out.println("Programa Terminado");
    }

    private static void ask(String base_code, String target_code ){
        Scanner inValue = new Scanner(System.in);
        double value = 0;
        double result = 0;
        DecimalFormat df = new DecimalFormat("0.00");

        try {
            System.out.println("Ingrese el valor que desea convertir:");
            value = inValue.nextDouble();
            if(value < 0){
                System.out.println("Valor invalido.");
            }else{
                ConverterData currencyValue = QueryConverter.getConverter(base_code, target_code);
                result = currencyValue.conversion_rate()*value;
                System.out.println("El valor "+value+" ["+base_code+"]"+" corresponde al valor final =>>> "+df.format(result)+" ["+target_code+"]");
            }
        }catch (InputMismatchException e){
            System.out.println("Error: Debe ingresar un número válido.");
            inValue.next();
        }

    }
}
