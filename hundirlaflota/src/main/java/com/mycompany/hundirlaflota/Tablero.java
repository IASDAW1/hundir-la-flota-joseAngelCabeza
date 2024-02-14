/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hundirlaflota;

import java.util.Random;
import java.util.Scanner;




/**
 *
 * @author titoa
 */
class Tablero {
    private char[][] tablero;
    private Barco[] barcos;
    private int filas;
    private int columnas;

    public Tablero(int filas, int columnas, Barco[] barcos) {
        this.filas = filas;
        this.columnas = columnas;
        this.tablero = new char[filas][columnas];
        this.barcos = barcos;
    }

    public void inicializarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = '~'; // Carácter que representa el agua
            }
        }
    }

    public void imprimirTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void colocarBarcos() {
        Random rand = new Random();
        for (Barco barco : barcos) {
            boolean colocado = false;
            while (!colocado) {
                int fila = rand.nextInt(filas);
                int columna = rand.nextInt(columnas);
                if (puedeColocarBarco(barco, fila, columna)) {
                    colocarBarcoEnTablero(barco, fila, columna);
                    colocado = true;
                }
            }
        }
    }

    public boolean puedeColocarBarco(Barco barco, int fila, int columna) {
        if (fila + barco.longitud <= filas && columna + 1 <= columnas) {
            for (int i = fila; i < fila + barco.longitud; i++) {
                if (tablero[i][columna] != '~') {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void colocarBarcoEnTablero(Barco barco, int fila, int columna) {
        for (int i = fila; i < fila + barco.longitud; i++) {
            tablero[i][columna] = 'B'; // Carácter que representa un barco
        }
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        while (!todosLosBarcosHundidos()) {
            imprimirTablero();
            System.out.println("Ingrese la fila y la columna para disparar (ejemplo: 2 3): ");
            int fila = scanner.nextInt();
            int columna = scanner.nextInt();
            if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
                if (tablero[fila][columna] == 'B') {
                    for (Barco barco : barcos) {
                        if (barco.haSidoHundido()) continue;
                        for (int i = 0; i < barco.longitud; i++) {
                            if (fila == i && columna == 0) {
                                barco.hundirParte(i);
                            }
                        }
                        if (barco.haSidoHundido()) {
                            System.out.println("¡Has hundido un barco!");
                        } else {
                            System.out.println("¡Has golpeado un barco!");
                        }
                    }
                } else {
                    System.out.println("Agua...");
                }
            } else {
                System.out.println("Coordenadas inválidas. Inténtalo de nuevo.");
            }
        }
        scanner.close();
        System.out.println("¡Has hundido todos los barcos! ¡Ganaste!");
    }

    private boolean todosLosBarcosHundidos() {
        for (Barco barco : barcos) {
            if (!barco.haSidoHundido()) {
                return false;
            }
        }
        return true;
    }
}
