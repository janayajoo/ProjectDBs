/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GESTION;

import MODELO.Asignatura;
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
public class gestionAsignatura {
    Asignatura Asignatura;
    private String rutaAsignatura;
    
    public gestionAsignatura(){
         this.rutaAsignatura = "./ARCHIVOS/asignatura.txt";
        this.verificarArchivoAsignatura();
    }
    
    public void guardarAsignatura(Asignatura pro){
       
        try{
            File file = new File(this.rutaAsignatura);
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
    
   public boolean verificarArchivoAsignatura(){
        boolean verify = false;
        try{
            File filex = new File(this.rutaAsignatura); //si no existe la ruta
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
   
   public ArrayList<Asignatura> getTodos(){
        ArrayList<Asignatura> libroDoc = new ArrayList();
        FileReader file;
        BufferedReader br;
        String registro;

        try{
            file = new FileReader(this.rutaAsignatura);
            br = new BufferedReader(file);
            while((registro = br.readLine()) != null){
                String[] campos = registro.split(";");
                Asignatura lib = new Asignatura(campos[0], campos[1], campos[2] , campos[3], campos [4]);
                libroDoc.add(lib);
            }
        }

        catch(IOException ex){
            System.out.println("Fallo buscando libro...");
        }
        return libroDoc;
    }
   
   public Asignatura getAsignatura (String id){
        FileReader file;
        BufferedReader br;
        String registro;
        Asignatura carre = null;
        
        try{
            file = new FileReader(this.rutaAsignatura);
            br = new BufferedReader(file);
            while((registro = br.readLine()) != null){
                String[] campos = registro.split(";");
                
                if(campos[0].equals(id)){
                    carre = new Asignatura(campos[0], campos[1], campos[2] , campos[3], campos [4]);
                    break;
                }
            }
        }

        catch(IOException ex){
            System.out.println("Fallo buscando libro...");
        }
        return carre;
   }
   
   public void modificarAsignatura(String oldid, Asignatura laNueva){
        ArrayList<Asignatura> carres = this.getTodos();
        int i=0;
        for (Asignatura carre: carres){
            if (carre.getId().equals(oldid)){
                carres.set(i, laNueva);
                this.reemplazarArchivo(carres);
                break;
            }
            i++;
        }
    }
   
   public boolean eliminarAsignaturaId(String id){
        boolean existe = false;
        
        if(this.verificaCodigo(id)){
            ArrayList<Asignatura> estu = this.getTodos();
            for(Asignatura carre:estu){
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
   
   
   public boolean eliminarAsignaturaNombre(String id){
        boolean existe = false;
        
        if(this.verificaCodigo(id)){
            ArrayList<Asignatura> carres = this.getTodos();
            for(Asignatura carre:carres){
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
        
        ArrayList<Asignatura> estu=this.getTodos();
        for (Asignatura carre:estu){
            if (carre.getName().equals(name)){
                esta=true;
            }
        }
        return esta;
    }
   
   
   public boolean verificaCodigo (String code){
        boolean existe=false;
        ArrayList<Asignatura> carres = this.getTodos();
        for (Asignatura carre:carres){
            if (carre.getId().equals (code)){
                existe=true;
            }
        }
        return existe;
   }
   
    private void reemplazarArchivo(ArrayList<Asignatura> carres) {
        try{
            File file = new File(this.rutaAsignatura);
            FileWriter fw = new FileWriter(file, false);
            PrintWriter pw = new PrintWriter(fw);
            for(Asignatura carre: carres){
                pw.println(carre.toString());
            }
            pw.close();
        }

        catch(IOException ex) {
            System.out.println("No se puede reemplazar el archivo...");
        }
    }
   
   
   
   
    
    
}
