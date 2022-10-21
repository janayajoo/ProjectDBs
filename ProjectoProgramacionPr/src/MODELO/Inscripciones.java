/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

/**
 *
 * @author SERGIO PC
 */
public class Inscripciones {
    
    String codigoEst;   
    String nombre;
    String estudiante;
    String asignatura;
    String profesor;
    String creditos;
    
    
    public Inscripciones(){
        codigoEst="";
        estudiante = "";
        asignatura = "";
        profesor = "";
        creditos = "";
    }
    
    public Inscripciones(String codigoEst, String estudiante, String asignatura, String creditos, String profesor){
        
        this.codigoEst=codigoEst;         
        this.estudiante = estudiante;
        this.asignatura = asignatura;
        this.creditos = creditos;
        this.profesor = profesor;
    }

    public String getCodigoEst() {
        return codigoEst;
    }

    public void setCodigoEst(String codigoEst) {
        this.codigoEst = codigoEst;
    }
    
    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getCreditos() {
        return creditos;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }
    
    

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
    
    @Override
    public String toString() {
        return this.getCodigoEst() + ";"+ this.getEstudiante() +";"+this.getAsignatura()+ ";" + this.getCreditos() + ";" +this.getProfesor();
    }
    
    
    
    
    
}
