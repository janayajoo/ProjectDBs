/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GESTION;

import MODELO.Estudiante;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author SERGIO PC
 */
public class gestionEstudiante {
    Estudiante Estudiante;
    private String rutaEstudiante;
    
    public gestionEstudiante(){
        this.rutaEstudiante = "./ARCHIVOS/estudiante.txt";
        this.verificarArchivoEstudiante();
    }
    
     public void guardarEstudiante(Estudiante pro){
 
        try{
            File file = new File(this.rutaEstudiante);
            FileWriter fr = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fr);
            pw.println(pro.toString());
            pw.close();
//            JOptionPane.showMessageDialog(null, "El programa a sido guardado exitosamente...");
        }

        catch(IOException ex){
            System.out.println("No se pudo guardar el programa...");
        }
    }

    public boolean verificarArchivoEstudiante(){
        boolean verify = false;
        try{
            File filex = new File(this.rutaEstudiante); //si no existe la ruta
            if(!filex.exists()){
                filex.createNewFile(); // lo creo
                verify = true;
            }
        }

        catch (IOException ex){
            System.out.println("Problema con la ruta creando archivo...");
        }

        return verify;
    }
    
    public ArrayList<Estudiante> getTodos(){
        ArrayList<Estudiante> libroEst = new ArrayList();
        FileReader file;
        BufferedReader br;
        String registro;

        try{
            file = new FileReader(this.rutaEstudiante);
            br = new BufferedReader(file);
            while((registro = br.readLine()) != null){
                String[] campos = registro.split(";");
                Estudiante lib = new Estudiante(campos[0], campos[1], campos[2],campos[3], campos[4]);
                libroEst.add(lib);
            }
        }

        catch(IOException ex){
            System.out.println("Fallo buscando libro...");
        }
        return libroEst;
    }
  
    
    public Estudiante getEstudiante (String id){
        FileReader file;
        BufferedReader br;
        String registro;
        Estudiante carre = null;
        
        try{
            file = new FileReader(this.rutaEstudiante);
            br = new BufferedReader(file);
            while((registro = br.readLine()) != null){
                String[] campos = registro.split(";");
                
                if(campos[0].equals(id)){
                    carre = new Estudiante(campos[0], campos[1], campos[2],campos[3], campos[4]);
                    break;
                }
            }
        }

        catch(IOException ex){
            System.out.println("Fallo buscando libro...");
        }
        return carre;
    }
    
    public void modificarEstudiante(String oldid, Estudiante laNueva){
        ArrayList<Estudiante> carres = this.getTodos();
        int i=0;
        for (Estudiante carre: carres){
            if (carre.getId().equals(oldid)){
                carres.set(i, laNueva);
                this.reemplazarArchivo(carres);
                break;
            }
            i++;
        }
    }
    
    public boolean eliminarEstudianteId(String id){
        boolean existe = false;
        
        if(this.verificaCodigo(id)){
            ArrayList<Estudiante> estu = this.getTodos();
            for(Estudiante carre:estu){
                if(carre.getId().equals(id)){
                    estu.remove(carre);
                    this.reemplazarArchivo(estu);
                    existe = true;
                    break;
                }
            }
        }
        return existe;
    }
    
    public boolean eliminarEstudianteNombre(String id){
        boolean existe = false;
        
        if(this.verificaCodigo(id)){
            ArrayList<Estudiante> carres = this.getTodos();
            for(Estudiante carre:carres){
                if(carre.getName().equals(id)){
                    carres.remove(carre);
                    this.reemplazarArchivo(carres);
                    existe = true;
                    break;
                }
            }
        }
        return existe;
    }
    
    public boolean verificaNombre (String name){
        boolean esta=false;
        
        ArrayList<Estudiante> estu=this.getTodos();
        for (Estudiante carre:estu){
            if (carre.getName().equals(name)){
                esta=true;
            }
        }
        return esta;
    }
    
    public boolean verificaCodigo (String code){
        boolean existe=false;
        ArrayList<Estudiante> carres = this.getTodos();
        for (Estudiante carre:carres){
            if (carre.getId().equals (code)){
                existe=true;
            }
        }
        return existe;
    }

    private void reemplazarArchivo(ArrayList<Estudiante> carres) {
        try{
            File file = new File(this.rutaEstudiante);
            FileWriter fw = new FileWriter(file, false);
            PrintWriter pw = new PrintWriter(fw);
            for(Estudiante carre: carres){
                pw.println(carre.toString());
            }
            pw.close();
        }

        catch(IOException ex) {
            System.out.println("No se puede reemplazar el archivo...");
        }
    }
    
    
}
