import ex2305.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LaboratoriosTest {
    public static void main(String[] args) {
        // Creo objeto Laboratorio
        Laboratorios laboratorios = new Laboratorios(3);

        // Añade algunas solicitudes para testeo
        laboratorios.addSolicitud("POO-A;1;3");
        laboratorios.addSolicitud("POO-B;1;3");
        laboratorios.addSolicitud("POO-A;2;1");
        laboratorios.addSolicitud("TEC-A;1;3");
        // Añade mas solicitudes, las que veas necesarias

        // Añade un error, para testear
        laboratorios.addSolicitud("Web-B;1;3");
        // Añade mas errores si lo ves necesario

        // Imprime el output a un fichero y a la propia consola
        laboratorios.asignarLabs();
        System.out.println(laboratorios);

        // Imprime a un nuevo fichero, llamado output.
        try (PrintWriter writer = new PrintWriter(new FileWriter("output.txt"))) {
            writer.println(laboratorios);
            System.out.println("Output written to 'output.txt'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}