package ex2305;

import java.util.Objects;

public class Solicitud implements Comparable<Solicitud> {
    private String asignatura;
    private int diaSem;
    private int franja;
    private int lab;

    public Solicitud(String n, int dia, int f){
        if(n.isEmpty()||dia<1||dia>7||f<1||f>3){
            throw new LabException("Argumentos erroneos");
        }else{
            this.asignatura=n;
            this.diaSem=dia;
            this.franja=f;
            this.lab=-1;
        }
    }

    public int getDiaSem() {
        return diaSem;
    }

    public int getFranja() {
        return franja;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public int getLab() {
        return lab;
    }

    public void setDiaSem(int diaSem) {
        if(diaSem<1||diaSem>7){
            throw new LabException("Argumentos erroneos");
        }else{
            this.diaSem=diaSem;
        }
    }

    public void setFranja(int franja) {
        if(franja<1||franja>3){
            throw new LabException("Argumentos erroneos");
        }else{
            this.franja=franja;
        }
    }

    public void setLab(int lab) {
        this.lab = lab;
    }

    @Override
    public String toString() {
        return "("+asignatura+", "+diaSem+", "+franja+", "+lab+")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solicitud solicitud = (Solicitud) o;
        return diaSem == solicitud.diaSem && franja == solicitud.franja && solicitud.asignatura.equalsIgnoreCase(this.asignatura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(asignatura, diaSem, franja, lab);
    }

    @Override
    public int compareTo(Solicitud otraSolicitud) {
        //Comparamos el dia de la semana
        int compareDia = Integer.compare(this.diaSem, otraSolicitud.diaSem);
        if (compareDia != 0) {
            return compareDia;
        }

        // Comparamos franja
        int compareFranja = Integer.compare(this.franja, otraSolicitud.franja);
        if(compareFranja!=0){
            return compareFranja;
        }
        // Comparamos por nombre asignatura, ignorando mayus y minus
        return this.asignatura.compareToIgnoreCase(otraSolicitud.asignatura);
    }
}
