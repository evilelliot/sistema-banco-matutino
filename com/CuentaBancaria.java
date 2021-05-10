package com;

import java.util.Date;
import java.util.Random;

public class CuentaBancaria {
    public long numeroCuenta;
    public double saldo;
    public Date fechaAlta;
    public Cliente cliente;
    public String tipo;
    public CuentaBancaria(Cliente c, String t){
        this.numeroCuenta = this.generarNumeroCuenta();
        this.saldo = 1;
        this.fechaAlta = new Date();
        this.cliente = c;    
        this.tipo = t;
    }
    private int generarNumeroCuenta(){
        Random rnd = new Random();
        int n = 100000 + rnd.nextInt(900000);

        return n;
    }

}
