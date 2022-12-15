package com.example.lab03;
import java.io.Serializable;
// permite que el objeto se enviado como parametro
public class Postulante  implements Serializable {
    private String DNI;
    private String nombres;
    private String apellidos;
    private String fechaNac;
    private String colegio;
    private String carrera;

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }

    private boolean expandable;



    public Postulante(String DNI, String nombres, String apellidos, String fechaNac, String colegio, String carrera) {
        this.DNI = DNI;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNac = fechaNac;
        this.colegio = colegio;
        this.carrera = carrera;
        this.expandable=false;
    }


    public String getDNI() {
        return DNI;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public String getColegio() {
        return colegio;
    }

    public String getCarrera() {
        return carrera;
    }



    @Override
    public String toString() {
        return "Postulante{" +
                "\nDNI=" + DNI +
                ", \nnombres='" + nombres + '\'' +
                ", \napellidos='" + apellidos + '\'' +
                ", \nfechaNac='" + fechaNac + '\'' +
                ", \ncolegio='" + colegio + '\'' +
                ", \ncarrera='" + carrera + '\'' +
                "\n}";
    }
}
