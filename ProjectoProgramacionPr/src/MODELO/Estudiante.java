/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.util.Objects;

/**
 *
 * @author SERGIO PC
 */
public class Estudiante extends Persona {
    private String programa, genero, foto;
    
    
    public Estudiante(){
        super();
        this.programa = "";
        this.genero = "";
        this.foto = "";
        
    }
    
    public Estudiante(String id, String nombres, String programa, String genero, String foto){
        super(id,nombres);
        this.programa = programa;
        this.genero = genero;
        this.foto = foto;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    

  

    @Override
    public String toString() {
        return super.getId() + ";"+ super.getName()+ ";"+this.programa + ";" +this.genero + ";" + this.foto;
    }

    
    @Override
    public int hashCode(){
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(super.getId());
        return hash;
    }
    
//    @Override
//    public boolean equals(Object obj){
//        if (this == obj){
//            return true;
//        }
//        if (this == null){
//            return false;
//        }
//        if (getClass() != obj.getClass()){
//            return false;
//        }
//        final Programa other = (Programa) obj;
//        if(!Objects.equals(super.getId(), other)){
//            return false;
//        }
//        return true;
//         
//    }
}
