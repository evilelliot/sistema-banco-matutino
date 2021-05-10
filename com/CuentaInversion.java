package com;
public class CuentaInversion extends CuentaBancaria{
    public CuentaInversion(Cliente c, String t){
        super(c, t);
    }
    // Proyectar inversion
    public void proyectarInversion(){
        System.out.println("Proyectando inversión.");
    }
}
