package agenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Javier Ismael Sampablo Cuevas
 */
public class Operaciones {

    Scanner leer = new Scanner(System.in);
    List<String> agendaNom = new ArrayList<>();
    List<Integer> agendaTel = new ArrayList<>();

    public void addC() {
        boolean pas = true;
        int num = 0;
        System.out.print("Registre nombre: ");
        String name = leer.next();
        System.out.print("Registre telefono: ");
        num = leer.nextInt();
        agendaNom.add(name.toUpperCase());
        agendaTel.add(num);
    }
    
    public void add_telC(String name) {
        System.out.println("Register telefono: ");
        agendaNom.add(name.toUpperCase());
        agendaTel.add(leer.nextInt());
        System.out.println("\nContacto registrado.");
    }

    public void showC() {
        System.out.println("Nombre\tTelefono");
        for (int i = 0; i < agendaNom.size(); i++) {
            System.out.println(agendaNom.get(i) + "\t" + agendaTel.get(i));
        }
    }

    public void researchC() {
        if (!empty()) {
            System.out.println("Contacto a buscar(nombre): ");
            String search = leer.next();
            if (agendaNom.contains(search.toUpperCase())) {
                int op = 0;
                System.out.println("\tEl contacto que busca se encuentra registrado\n");
                System.out.println("¿Qué acción dese realizar?");
                System.out.println("1.-Modificar");
                System.out.println("2.-Eliminar");
                System.out.println("3.-Salir");
                do {
                    try {
                        op = leer.nextInt();
                    } catch (Exception e) {
                        System.out.println("dato invalido");
                    }
                    int index = agendaNom.indexOf(search.toUpperCase());
                    switch (op) {
                        case 1:
                            System.out.println("¿Modificar Nombre(N) o Telefono(T)?");
                            char option = leer.next().charAt(0);
                            if (option == 'n' || option == 'N') {
                                System.out.print("Nuevo nombre: ");
                                String newname = leer.next();
                                agendaNom.add(index, newname.toUpperCase());
                            } else {
                                System.out.print("Nuevo telefono: ");
                                agendaTel.add(index, leer.nextInt());
                            }
                            System.out.println("\nContacto Modificado");
                            op = 3;
                            break;
                        case 2:
                            System.out.print("¿Seguro que desea eliminar(s/n)?: ");
                            char validacion = leer.next().charAt(0);
                            if (validacion == 's' || validacion == 'S') {
                                agendaNom.remove(index);
                                agendaTel.remove(index);
                                System.out.println("Contacto eliminado con exito.");
                            } else {
                                System.out.println("Eliminación cancelada.");
                            }
                            op = 3;
                            break;
                        default:
                            break;
                    }
                } while (op != 3);
            } else {
                System.out.println("Contacto no existente.");
                System.out.println("¿Crear contacto?(S/N)");
                char validacion = leer.next().charAt(0);
                if (validacion == 's' || validacion == 'S') {
                    this.add_telC(search);
                }
            }
        } else {
            System.out.println("Agenda vacía.");
        }
    }

    public boolean empty() {
        if (agendaNom.isEmpty()) {
            agendaTel.clear();
            return true;
        } else {
            return false;
        }
    }

}
