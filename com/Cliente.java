package com;

public class Cliente {
    public String nombre;
    public String apellidos;
    public String domicilio;
    public String ciudad;
    public String telefono;

    public Cliente(String n, String a, String d, String c, String t){
        this.nombre    = n;
        this.apellidos = a;
        this.domicilio = d;
        this.ciudad    = c;
        this.telefono  = t;
    }
}
