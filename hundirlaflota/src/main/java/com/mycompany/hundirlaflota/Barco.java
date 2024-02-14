/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hundirlaflota;

/**
 *
 * @author titoa
 */
public class Barco 
{
//atributos
    int longitud=4;
    private String nombreBarco;
    private boolean[] parte = new boolean[longitud];


     //constructor

    public Barco(int longitud, String nombreBarco) {
        this.longitud = longitud;
        this.nombreBarco = nombreBarco;
    }

     void hundirParte(int parte)
    {
     if (parte > 0 && parte < longitud) 
     {
            this.parte[parte] = true;

            System.out.println("La parte " + parte + " ha sido hundida.");

        } else {
            System.out.println("Agua.");
        }

    }


    boolean haSidoHundido(int parte,char tablero,int y,int x)
    {
        if(this.parte[parte]=true)
        {
            return false;
        }
         return true;
    }


    //metodos

    public int getLongitud() {
        return longitud;
    }

    public String getNombreBarco() {
        return nombreBarco;
    }

    public boolean[] getParte() {
        return parte;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public void setNombreBarco(String nombreBarco) {
        this.nombreBarco = nombreBarco;
    }

    public void setParte(boolean[] parte) {
        this.parte = parte;
    }

    boolean haSidoHundido() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
