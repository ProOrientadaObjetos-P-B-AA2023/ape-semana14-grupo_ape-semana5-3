package VIEW;
import MODEL.Estudiante;
import CONTROLER.ProcesarEstudiantes;
import java.util.ArrayList;
import java.util.List;
public class TestEstudiante {
    public static void main(String[] args) {
        ArrayList<Estudiante> lstEst = new ArrayList<Estudiante>(List.of(
                new Estudiante("Paul", Math.random() * 10, Math.random() * 10),
                new Estudiante("Estafania", Math.random() * 10, Math.random() * 10)));
        ProcesarEstudiantes procesarEstudiantes = new ProcesarEstudiantes(lstEst);
        procesarEstudiantes.calculoPromedios();
        procesarEstudiantes.calculoEstados();
        for (Estudiante est : lstEst)
            procesarEstudiantes.insertarEstudiante(est);
        ArrayList<Estudiante> lstEst2 = procesarEstudiantes.getLstEstudiantes();
        for (Estudiante est : lstEst2)
            System.out.println(est);
    }
}
