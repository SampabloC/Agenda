/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.Scanner;

/**
 *
 * @author Javier Ismael Sampablo Cuevas
 */
public class Agenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Operaciones operaciones = new Operaciones();
        int opc = 0;
        do {
            System.out.println("\nAgenda");
            System.out.println("1.-Crear contacto");
            System.out.println("2.-Buscar, actualizar y eliminar.");
            System.out.println("3.-Mostrar contactos");
            System.out.println("0.-Salir");
            try{
            opc = leer.nextInt();
            } catch(Exception e) {
                System.out.println("dato no numerico\n\n");
                leer.next();
            }
           switch(opc) {
                case 1:
                    operaciones.addC();
                    System.out.println();
                    break;
                case 2:
                    operaciones.researchC();
                    System.out.println();
                    break;
                case 3:
                    operaciones.showC();
                    System.out.println();
                    break;
            }
        } while (opc != 0);
        
    }
    
}
