package com;

import java.util.Date;

public class Movimientos {
    private String tipo;
    private Date fecha;
    private double monto;
    private double saldoAnterior;
    private double saldoActual;

    public Movimientos(String t, double m, double san, double sac){
        // La fercha la vamos a generar aquí mismo a la hora de abrir el objeto
        this.tipo = t;
        this.fecha = new Date();
        this.monto = m;
        this.saldoAnterior = san;
        this.saldoActual   = sac;
    }
    // De prueba solamente
    @Override
    public String toString(){
        return this.tipo + "|" +  this.fecha.toString() + "|" + this.monto + "|" + this.saldoAnterior + "|" +  this.saldoActual;
    }
}
