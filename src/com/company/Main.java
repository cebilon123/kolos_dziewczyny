package com.company;
//Najprościej można to zrobić w ten sposób,
//że losuje się pewną liczbę konfiguracji
// monet, które pozwalają na wydanie ustalonej reszty i
//jako wynik zwracana jest ta konfiguracja, która ma najmniejszą liczbę monet

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        final int[] nominaly = {500, 200, 100, 50, 20, 10, 5, 2, 1}; //w groszacxh
        //final int[] liczbaMonet = {14, 13, 12, 0, 11, 14, 3, 13, 1}; // liczba nominalow
        int zl = 1, gr = 30, r, i = 0;

        Random generator = new Random();
        int numerNajkorzstniejszegoLosowania = 0;
        int liczbaLosowan = 10;
        int liczbaMaxWydanychMonet = 100;
        int najmniejWydanychMonet = liczbaMaxWydanychMonet;

        int[] wydaneMonety = new int[liczbaMaxWydanychMonet]; //tablica wydanych monet
        int[] korzysteRozw = new int[liczbaMaxWydanychMonet];


        for (i = 0; i < liczbaLosowan; i++) {
            r = zl * 100 + gr;
            System.out.print("losowanie " + i + "  ");
            int lWM = 0; //liczba wydanych monet

            while (r > 0 && lWM < liczbaMaxWydanychMonet) {
                //generator.nextInt(nominaly.length);
                int moneta = nominaly[generator.nextInt(nominaly.length)]; //losowa moneta z nominalów


                if (r >= moneta) {
                    wydaneMonety[lWM] = moneta; // za kazdym razem jak wylosujesz dobra moneta +1
                    r = r - moneta;
                    lWM++;
                }
            }
            if (lWM < najmniejWydanychMonet) {
                numerNajkorzstniejszegoLosowania = i;
                najmniejWydanychMonet = lWM;
                for (int j = 0; j < lWM; j++)
                    korzysteRozw[j] = wydaneMonety[j];
            }
            System.out.println(Arrays.toString(wydaneMonety));
        }

        if (najmniejWydanychMonet < liczbaMaxWydanychMonet)
        {
            float suma = 0;
            System.out.print("Reszta: ");
            for (int j = 0; j < najmniejWydanychMonet; j++)
            {
                System.out.print(korzysteRozw[j]/100.0 + " ");
                suma += korzysteRozw[j]/100.0;
            }

            System.out.println("Suma: "+suma);
        System.out.println("Najkorzystniejsze losowanie to: " + numerNajkorzstniejszegoLosowania);
        }
        else System.out.print("Nie znaleziono rozwiazania.");

    }

    //bo nadpisujemy tablice i bierzemy pierwsze liczby które spełniają warunek

}
