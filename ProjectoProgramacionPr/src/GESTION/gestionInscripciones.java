/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GESTION;

import MODELO.Inscripciones;
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
public class gestionInscripciones {
    Inscripciones Inscripciones;
    
    private String rutaInscripciones;
    
    
    public  gestionInscripciones(){
        this.rutaInscripciones = "./ARCHIVOS/inscripciones.txt";
        this.verificarArchivoInscripcion();
    }
    
    public void guardarInscripcion (Inscripciones pro){
       
        try{
            File file = new File(this.rutaInscripciones);
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
    
   public boolean verificarArchivoInscripcion(){
        boolean verify = false;
        try{
            File filex = new File(this.rutaInscripciones); //si no existe la ruta
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
   
   public ArrayList<Inscripciones> getTodos(){
        ArrayList<Inscripciones> libroDoc = new ArrayList();
        FileReader file;
        BufferedReader br;
        String registro;

        try{
            file = new FileReader(this.rutaInscripciones);
            br = new BufferedReader(file);
            while((registro = br.readLine()) != null){
                String[] campos = registro.split(";");
                Inscripciones lib = new Inscripciones(campos[0], campos[1], campos[2] , campos[3], campos[4]);
                libroDoc.add(lib);
            }
        }

        catch(IOException ex){
            System.out.println("Fallo buscando libro...");
        }
        return libroDoc;
    }
   
   public Inscripciones getInscripcion (String id){
        FileReader file;
        BufferedReader br;
        String registro;
        Inscripciones carre = null;
        
        try{
            file = new FileReader(this.rutaInscripciones);
            br = new BufferedReader(file);
            while((registro = br.readLine()) != null){
                String[] campos = registro.split(";");
                
                if(campos[0].equals(id)){
                    carre = new Inscripciones(campos[0], campos[1], campos[2] , campos[3], campos[4]);
                    break;
                }
            }
        }

        catch(IOException ex){
            System.out.println("Fallo buscando libro...");
        }
        return carre;
   }
   
   public void modificarInscripcion(String oldid, Inscripciones laNueva){
        ArrayList<Inscripciones> carres = this.getTodos();
        int i=0;
        for (Inscripciones carre: carres){
            if (carre.getCodigoEst().equals(oldid)){
                carres.set(i, laNueva);
                this.reemplazarArchivo(carres);
                break;
            }
            i++;
        }
    }
   
   public boolean eliminarInscripcion(String id){
        boolean existe = false;
        
        if(this.verificaCodigo(id)){
            ArrayList<Inscripciones> estu = this.getTodos();
            for(Inscripciones carre:estu){
                if(carre.getCodigoEst().equals(id)){
                    estu.remove(carre);
                    this.reemplazarArchivo(estu);
                    existe = true;
                    break;
                }
            }
        }
        return existe;
    }
   
   
   public boolean eliminarInscripcionNombre(String id){
        boolean existe = false;
        
        if(this.verificaCodigo(id)){
            ArrayList<Inscripciones> carres = this.getTodos();
            for(Inscripciones carre:carres){
                if(carre.getCodigoEst().equals(id)){
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
        
        ArrayList<Inscripciones> estu=this.getTodos();
        for (Inscripciones carre:estu){
            if (carre.getCodigoEst().equals(name)){
                esta=true;
            }
        }
        return esta;
    }
   
   
   public boolean verificaCodigo (String code){
        boolean existe=false;
        ArrayList<Inscripciones> carres = this.getTodos();
        for (Inscripciones carre:carres){
            if (carre.getCodigoEst().equals (code)){
                existe=true;
            }
        }
        return existe;
   }
   
    private void reemplazarArchivo(ArrayList<Inscripciones> carres) {
        try{
            File file = new File(this.rutaInscripciones);
            FileWriter fw = new FileWriter(file, false);
            PrintWriter pw = new PrintWriter(fw);
            for(Inscripciones carre: carres){
                pw.println(carre.toString());
            }
            pw.close();
        }

        catch(IOException ex) {
            System.out.println("No se puede reemplazar el archivo...");
        }
    }
    
}
