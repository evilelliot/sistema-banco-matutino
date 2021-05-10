import java.util.ArrayList;

import com.CuentaBancaria;
import com.CuentaInversion;
import com.CuentaNomina;
import com.Cliente;
import java.util.Scanner;


class Main{
    static private Scanner input = new Scanner(System.in);
    // Objeto de clientes
    static Cliente cliente = null;
    // Objeto de cuenta bancaria
    static CuentaBancaria cuentasBancarias = null;
    // Arraylist para guardar todas las cuentas
    static ArrayList<CuentaNomina> cuentas = new ArrayList<>();
    static ArrayList<CuentaInversion> cuentasIn = new ArrayList<>();
    // Opcion input
    public static void main(String[] args){
        
        int opt = 0;
        // Cuentahabiente
        String nombres, apellidos, domicilio, ciudad, telefono;
        cliente = new Cliente("Alberto", "Ocaranza", "Bosque satanico", "Zapopan", "3315038570");
        CuentaNomina nominas = null;
        CuentaInversion inversion = null;

        nominas = new CuentaNomina(cliente, "nomina");
        nominas.depositar(3000);
        nominas.depositar(4000);
        cuentas.add(nominas);

        // Loop de ejecución
        do{ 
            Menu();
            System.out.print("Tu opcion: ");
            opt = Integer.parseInt(input.nextLine());
            switch(opt){
                case 1:
                    System.out.println("Crear una cuenta de nomina");
                    System.out.println("Ingrese los datos del cuentahabiente");
                    // Comenzamos a pedir los datos del cuentahabiente
                    System.out.println("Nombre(s): ");
                    nombres = input.nextLine();
                    System.out.println("Apellido(s): ");
                    apellidos = input.nextLine();
                    System.out.println("Direccion: ");
                    domicilio = input.nextLine();
                    System.out.println("Ciudad: ");
                    ciudad = input.nextLine();
                    System.out.println("Numero de telefono: ");
                    telefono = input.nextLine();

                    // Crear un cliente
                    cliente = new Cliente(nombres, apellidos, domicilio, ciudad, telefono);
                    // Crear cuenta
                    nominas = new CuentaNomina(cliente, "nomina");
                    // Añadir al storage
                    cuentas.add(nominas);

                break;
                case 2:
                    System.out.println("Crear una cuenta de inversion");
                    System.out.println("Crear una cuenta de nomina");
                    System.out.println("Ingrese los datos del cuentahabiente");
                    // Comenzamos a pedir los datos del cuentahabiente
                    System.out.println("Nombre(s): ");
                    nombres = input.nextLine();
                    System.out.println("Apellido(s): ");
                    apellidos = input.nextLine();
                    System.out.println("Direccion: ");
                    domicilio = input.nextLine();
                    System.out.println("Ciudad: ");
                    ciudad = input.nextLine();
                    System.out.println("Numero de telefono: ");
                    telefono = input.nextLine();

                    // Crear un cliente
                    cliente = new Cliente(nombres, apellidos, domicilio, ciudad, telefono);
                    // Crear cuenta
                    inversion = new CuentaInversion(cliente, "inversion");
                    // Añadir al storage
                    cuentasIn.add(inversion);
                break;
                case 3:
                    // Depositar, retirar, consultar saldo, mostrar movimientos
                    String tipo;
                    String no;
                    System.out.println("Buscar una cuenta");
                    System.out.println("Elige el tipo de cuenta: ");
                    tipo = input.nextLine();
                    if(tipo.toLowerCase().equals("nomina")){
                        System.out.println("Buscando cuenta de nomina.");
                        System.out.println("Introduce el nombre del cuentahabiente: ");
                        no = input.nextLine();
                        Double cantidad;
                        if(getIndexCuenta(no, "nomina") != 0000){
                            System.out.println("Retirar - Depositar - Mostrar saldo - Mostrar movimientos");
                            String o = input.nextLine();
                            switch(o){
                                case "retirar":
                                    System.out.println("Cantdad:");
                                    cantidad = input.nextDouble();
                                    cuentas.get(getIndexCuenta(no, "nomina")).retirar(cantidad);
                                break;
                                case "depositar":
                                    System.out.println("Cantdad:");
                                    cantidad = input.nextDouble();
                                    cuentas.get(getIndexCuenta(no, "nomina")).depositar(cantidad);
                                break;
                                case "mostrar saldo":
                                    cuentas.get(getIndexCuenta(no, "nomina")).consultaSaldo();;
                                break;
                                case "mostrar movimientos":
                                    cuentas.get(getIndexCuenta(no, "nomina")).mostrarMovimientos();
                                break;
                            }
                        }else{
                            System.out.println("No se encontró la cuenta solicitada.");
                        }
                    }else if(tipo.toLowerCase().equals("inversion")){
                        System.out.println("Buscando cuenta de inversion.");
                        System.out.println("Introduce el nombre del cuentahabiente: ");
                        no = input.nextLine();
                        if(getIndexCuenta(no, "inversion") != 0000){
                            cuentasIn.get(getIndexCuenta(no, "inversion")).proyectarInversion();
                        }else{
                            System.out.println("No se encontró la cuenta solicitada.");
                        }
                    }else{
                        System.out.println("Tipo de cuenta invalido.");
                    }
                break;
                case 4:
                    System.out.println("Lista de cuentas nomina");
                    for(int i = 0; i <= cuentas.size() - 1; i++){
                        if(cuentas.get(i).tipo == "nomina"){
                            System.out.println(cuentas.get(i).numeroCuenta + ": " + cuentas.get(i).cliente.nombre);
                        }
                    }
                break;
                case 5:
                    System.out.println("Lista de cuentas de inversion");
                    for(int i = 0; i <= cuentas.size() - 1; i++){
                        if(cuentas.get(i).tipo == "inversion"){
                            System.out.println(cuentas.get(i).numeroCuenta + ": " + cuentas.get(i).cliente.nombre);
                        }
                    }
                break;
                case 6: 
                    System.out.println("Saliendo del sisteam bancario.");
                break;
                default:
                    System.out.println("Opcion invalida, revisa las opciones designadas.");
                break;
            }
        }while(opt != 6);


        
    }
    // Hagan ustedes el menu, tuve que rehacer todo este puto cagadero en 1 hora porqué el otro no funciona lol
    // No mas pongan mensajes con las opciones que necesitan y ya.
    static void Menu(){
        System.out.println("Menu");

    }
    static private int getIndexCuenta(String nombre, String tipo){
        if(tipo.equals("nomina")){
            for(int i = 0; i <= cuentas.size() - 1; i ++){
                if(cuentas.get(i).cliente.nombre.toLowerCase() == nombre.toLowerCase()){
                    return i;
                }else{
                    return 0000;
                }
            }
            return 0;
        }else{
            for(int i = 0; i <= cuentasIn.size() - 1; i ++){
                if(cuentasIn.get(i).cliente.nombre.toLowerCase() == nombre.toLowerCase()){
                    return i;
                }else{
                    return 0000;
                }
            }
            return 0;
        }
    }
}