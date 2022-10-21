/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.util.Objects;


public class Asignatura extends Persona {
    
    private String Profesor, Creditos, inscritos;
    
    
    public Asignatura(){
        super();
        this.Creditos = "";
        this.Profesor = "";
        this.inscritos = "";
    }
    
    public Asignatura(String id, String nombre, String creditos, String profesor, String inscritos){
        super(id,nombre);
        this.Creditos = creditos;
        this.Profesor = profesor;
    }

    public String getCreditos() {
        return Creditos;
    }

    public void setCreditos(String Creditos) {
        this.Creditos = Creditos;
    }

    public String getProfesor() {
        return Profesor;
    }

    public void setProfesor(String Profesor) {
        this.Profesor = Profesor;
    }

    public String getInscritos() {
        return inscritos;
    }

    public void setInscritos(String inscritos) {
        this.inscritos = inscritos;
    }

    
    @Override
    public String toString() {
        return super.getId()+ ";" + super.getName() +";"+ this.Creditos + ";" + this.Profesor + "; " + this.inscritos ;
    }
    
    
    
    @Override
    public int hashCode(){
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(super.getId());
        return hash;
    }
    
    
}
