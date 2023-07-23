package MODEL;
public class Estudiante {
    public int idEstudiante;
    public String nombreEst, estado;
    public double nota1, nota2, promedio;
    public Estudiante(String nombreEst, double nota1, double nota2) {
        this.idEstudiante = idEstudiante;
        this.nombreEst = nombreEst;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }
    public Estudiante(int idEstudiante, String nombreEst, double nota1, double nota2, double promedio, String estado) {
        this.idEstudiante = idEstudiante;
        this.nombreEst = nombreEst;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.promedio = promedio;
        this.estado = estado;
    }
    public int getIdEstudiante() {
        return idEstudiante;
    }
    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
    public String getNombreEst() {
        return nombreEst;
    }
    public void setNombreEst(String nombreEst) {
        this.nombreEst = nombreEst;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public double getNota1() {
        return nota1;
    }
    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }
    public double getNota2() {
        return nota2;
    }
    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }
    public double getPromedio() {
        return promedio;
    }
    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    @Override
    public String toString() {
        return "Estudiante{" +
                "idEstudiante=" + idEstudiante +
                ", nombreEst='" + nombreEst + '\'' +
                ", estado='" + estado + '\'' +
                ", nota1=" + nota1 +
                ", nota2=" + nota2 +
                ", promedio=" + promedio +
                '}';
    }
}
