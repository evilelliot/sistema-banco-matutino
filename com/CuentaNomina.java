package com;
import java.util.ArrayList;
import com.Movimientos;
import com.CuentaBancaria;
import com.Cliente;

public class CuentaNomina extends CuentaBancaria{
    // Hacer una clase movimientos
    private ArrayList<Movimientos> movimientos = new ArrayList<>();
    public CuentaNomina(Cliente e, String t){
        super(e, t);
    }
    public double depositar(double cantidad){
        this.movimientos.add(new Movimientos("deposito", cantidad, this.saldo, this.saldo + cantidad));
        this.saldo = this.saldo +  cantidad;
        return this.saldo + cantidad;
    }
    public double retirar(double cantidad){
        if(cantidad >= this.saldo){
            System.out.println("No se puede efectuar la transacción por falta de recursos.");
            return 0;
        }else{
            this.movimientos.add(new Movimientos("retiro", cantidad, this.saldo, this.saldo - cantidad));
            this.saldo = this.saldo - cantidad;
            return this.saldo - cantidad;
        }
        
    }
    public void consultaSaldo(){
        System.out.println("Su saldo es: " +  this.saldo);
    }
    // Mostrar todos los movimientos de dicha cuenta
    public void mostrarMovimientos(){
        for(int i = 0; i <= this.movimientos.size() - 1; i++){
            System.out.println(this.movimientos.get(i).toString());
        }
    }
}
