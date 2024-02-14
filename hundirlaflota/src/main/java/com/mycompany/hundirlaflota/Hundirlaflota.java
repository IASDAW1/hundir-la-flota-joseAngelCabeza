/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hundirlaflota;


public class Hundirlaflota {

public static void main(String[] args) {
        Barco[] barcos = new Barco[4];
        barcos[0] = new Barco(4, "Portaaviones");
        barcos[1] = new Barco(3, "Destructor");
        barcos[2] = new Barco(3, "Submarino");
        barcos[3] = new Barco(2, "Patrullera");

        // Crea el tablero
        Tablero tablero = new Tablero(10, 10, barcos);

        // Colocar barcos aleatoriamente en el tablero
        tablero.colocarBarcos();

        // Comenzar el juego
        tablero.jugar();
    }
}