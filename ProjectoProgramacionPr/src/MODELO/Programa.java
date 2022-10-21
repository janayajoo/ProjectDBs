/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.util.Objects;

/**
 *
 */
public class Programa {
    
    private String id;
    private String nombrePrograma;
    private boolean veryPresencial;
    private boolean veryOnline;
    private boolean veryAcreditada;
    
    
    public  Programa(){
        this.id = "";
        this.nombrePrograma = "";
        this.veryAcreditada = false;
        this.veryOnline = false;
        this.veryPresencial =false;
        
        
    }
    
    public Programa(String id, String nombrePrograma, boolean Acreditada, boolean Online, boolean Presencial){
        this.id = id;
        this.nombrePrograma = nombrePrograma;
        this.veryAcreditada = Acreditada;
        this.veryOnline = Online;
        this.veryPresencial = Presencial;
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

    public boolean isVeryPresencial() {
        return veryPresencial;
    }

    public void setVeryPresencial(boolean veryPresencial) {
        this.veryPresencial = veryPresencial;
    }

    public boolean isVeryOnline() {
        return veryOnline;
    }

    public void setVeryOnline(boolean veryOnline) {
        this.veryOnline = veryOnline;
    }

    public boolean isVeryAcreditada() {
        return veryAcreditada;
    }

    public void setVeryAcreditada(boolean veryAcreditada) {
        this.veryAcreditada = veryAcreditada;
    }
    
    

    @Override
    public String toString() {
        return  this.id + ";" + this.nombrePrograma + ";" + this.veryAcreditada + ";" + this.veryPresencial + ";" + this.veryOnline;
    }
    
    
    
    @Override
    public int hashCode(){
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final Programa other = (Programa) obj;
        if(!Objects.equals(this.id, other.id)){
            return false;
        }
        return true;
         
    }
    
    
    
}
