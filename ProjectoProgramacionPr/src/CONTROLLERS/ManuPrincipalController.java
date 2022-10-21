/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package CONTROLLERS;

import GESTION.gestionAsignatura;
import GESTION.gestionDocente;
import GESTION.gestionEstudiante;
import GESTION.gestionInscripciones;
import GESTION.gestionPrograma;
import MODELO.Asignatura;
import MODELO.Docente;
import MODELO.Estudiante;
import MODELO.Inscripciones;
import MODELO.Programa;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author sergi
 */
public class ManuPrincipalController implements Initializable {
    
    Programa Programa;
    Estudiante Estudiante;
    Docente Docente;
    Asignatura Asignatura;
    Inscripciones Inscripciones;
    
    gestionPrograma gestor;
    gestionEstudiante gestor2;
    gestionDocente gestor3;
    gestionAsignatura gestor4;
    gestionInscripciones gestor5;
    

    @FXML
    private Menu menuConsulta;
    @FXML
    private MenuItem menuGestion1;
    @FXML
    private MenuItem menuGestion2;
    @FXML
    private MenuItem menuGestion3;
    @FXML
    private Pane gestionPrograma;
    @FXML
    private Pane gestionEstudiante;
    @FXML
    private MenuItem Salir;
    @FXML
    private Button nuevoPrograma;
    @FXML
    private Button guardarPrograma;
    @FXML
    private Button buscarPrograma;
    @FXML
    private Button modificarPrograma;
    @FXML
    private CheckBox Acreditada;
    @FXML
    private CheckBox Presencial;
    @FXML
    private CheckBox Online;
    @FXML
    private MenuItem menuPrincipal;
    @FXML
    private MenuBar menuBar;
    @FXML
    private TextField codigoPro;
    @FXML
    private TextField codigoNamePro;
    @FXML
    private TableView<Programa> misProgramas;
    @FXML
    private TableColumn colCodigo;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colAcreditada;
    @FXML
    private TableColumn colPresencial;
    @FXML
    private TableColumn colOnline;
    
    private ObservableList<Programa> pror;
    private ObservableList<Programa> filtrados;
    private ArrayList<String> myStudents;
    
    private String cod, nombre, codEst, nombreEst, carreraEst, carrearaNuevaEst;
    private String CodAsig, oldAsig, oldCreditos, oldProfesor,nombAsig, prof, credito, asig, nomAsig,identDoce,catDocen ,nameDocente,fotoDocente;
    private boolean on, pre, acre;
    
  //_________________________ESTUDIANTES_________________________________________
    
    @FXML
    private Button eliminarPrograma;
    @FXML
    private ComboBox<String> comboAño;
    @FXML
    private ComboBox<String> comboPeriodo;
    @FXML
    private TextField codigoEstudiante;
    @FXML
    private TextField nombreEstudiante;
    @FXML
    private CheckBox estudianteFemenino;
    @FXML
    private CheckBox estuidianteMasculino;
    @FXML
    private Button nuevaFotoEst;
    @FXML
    private Button nuevoEst;
    @FXML
    private Button guardarEst;
    @FXML
    private Button buscarEst;
    @FXML
    private Button todosEst;
    @FXML
    private Button modificarEst;
    @FXML
    private Button eliminarEst;
    private TableColumn<?, ?> colAsignatura;
    private TableColumn<?, ?> colProfesor;
    private String nombrefoto;
    private String nombrefotoDoc;
    @FXML
    private ImageView imgFoto;
    @FXML
    private Pane todosEstudiante;
    
    private ObservableList<Estudiante> estud;
    
    private ObservableList<Estudiante> filtradosEst;
    private ObservableList<Estudiante> filtradosEstCarrera;
    private ObservableList<Estudiante> filtradosEstNombre;
    

    @FXML
    private TableColumn columCodigo;
    @FXML
    private TableColumn columNombre;
    @FXML
    private TableColumn columGenero;
    @FXML
    private Button regresarButtom;
    @FXML
    private Label programaEst;
    @FXML
    private TextField proEst;
    @FXML
    private ImageView fotoEst;
    @FXML
    private ComboBox<String> combGeneroEst;
    @FXML
    private TextField busquedaCarreraEst;
    @FXML
    private TextField busquedaNombreEst;
    @FXML
    private TableView<Estudiante> estTodosTable;
    @FXML
    private ComboBox<String> comboProgr;
    @FXML
    private Button nextEst;
    @FXML
    private Button backEst;
    
    private int EstCant = 0, cantidadDeEstudTotal =0;
    private int DocCant = 0, cantidaddeDocTotal = 0;
    private int contIns = 0;
    @FXML
    private Button nuevoDocente;
    @FXML
    private Button buscarDocente;
    @FXML
    private Button eliminarDocente;
    @FXML
    private Button guardarDocente;
    @FXML
    private Button modificarDocente;
    @FXML
    private Button todosDocente;
    @FXML
    private Button actualizarInscritos;
    @FXML
    private Button nuevoAsig;
    @FXML
    private Button guardarAsig;
    @FXML
    private Button buscarAsig;
    @FXML
    private Button modificarAsig;
    @FXML
    private Button eliminarAsig;
    @FXML
    private Button generarCodigoAsig;
    @FXML
    private ComboBox<String> comboCreditosAsig;
    @FXML
    private ComboBox<String> comboProfesorAsig;
    @FXML
    private TableColumn<?, ?> colCodigoAsig;
    @FXML
    private TableColumn<?, ?> colNombreAsig;
    @FXML
    private TableColumn<?, ?> colCreditosAsig;
    @FXML
    private Button buscarEstudianteInscripciones;
    @FXML
    private Button agregarInscripciones;
    @FXML
    private Button desagregarInscripciones;
    @FXML
    private TableView<Asignatura> tableInscritosDocente;
    private ObservableList<Asignatura> inscritosDoc;
    
    private String inscritos;
    @FXML
    private TableView<Asignatura> tableAsignaturas;
    @FXML
    private ComboBox<String> comboAsignaturaIns;
    @FXML
    private ComboBox<String> comboDocenteIns;
    @FXML
    private ComboBox<String> comboCategoriaDocente;
    @FXML
    private TextField filtroNombreDocente;
    @FXML
    private Button regresarDocentes;
    @FXML
    private TableColumn<?, ?> columnaId;
    @FXML
    private TableColumn<?, ?> columnaNombre;
    @FXML
    private TableColumn<?, ?> columnaCategoria;
    @FXML
    private TextField nombreDocente2;
    @FXML
    private TableView<Docente> tableTodosDocente;
    private ObservableList<Docente> doc;
    
    
    @FXML
    private Pane gestionDocente;
    @FXML
    private Pane todosDocentes;
    @FXML
    private Pane gestionAsignatura;
    @FXML
    private Pane gestionInscripciones;
    @FXML
    private TextField indetificacionDocente;
    @FXML
    private CheckBox catedraDocente;
    @FXML
    private CheckBox docenciaPlantaDocente;
    @FXML
    private CheckBox plantadocente;
    
    private ObservableList<Docente> filtradosDoc;
    @FXML
    private Label nombreDocente;
    @FXML
    private ImageView imgFotoDoc;
    @FXML
    private Button nuevaFotoDoc;
    @FXML
    private TextField codigoAsig;
    @FXML
    private TextField nombreAsig;
    @FXML
    private MenuItem menuGestion5;
    @FXML
    private MenuItem menuGestion6;
    @FXML
    private ImageView fotoDoce;
    
    private ObservableList<Asignatura> asignatura;
    private ObservableList<Asignatura> asignaturaFiltrados;
    @FXML
    private TableColumn<?, ?> colProfe;
    @FXML
    private TableColumn<?, ?> colAsignaturaIns;
    @FXML
    private TableColumn<?, ?> colCreditosIns;
    @FXML
    private TableColumn<?, ?> colProfesorAsigIns;
    @FXML
    private TableView<Inscripciones> tableInscripciones;
    private ObservableList<Inscripciones> inscripciones;
    @FXML
    private Button guardarInscripcion;
    @FXML
    private Button modificarInscripciones;
    @FXML
    private Label codigoStudIns;
    @FXML
    private Label nomStudIns;
    @FXML
    private Label carreaStudIns;
    @FXML
    private TableView<Inscripciones> tablaInscripcionesEst;
    private ObservableList<Inscripciones> inscripcionesEst;
    
    @FXML
    private TableColumn<?, ?> colAsig;
    @FXML
    private TableColumn<?, ?> colInscritos;
    @FXML
    private TableColumn<?, ?> colAsignaturaEst;
    @FXML
    private TableColumn<?, ?> colProfesorEst;
    @FXML
    private Button nextDoc1;
    @FXML
    private Button backDoc1;
    @FXML
    private ImageView imagePrincipal;
    @FXML
    private ImageView carrerasImg;
    @FXML
    private ImageView estudiantesImg;
    @FXML
    private ImageView docentesImg;
    @FXML
    private ImageView asignaturaImg;
    @FXML
    private ImageView inscripcionesImg;
    
     


    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //_______________________FOTOS____________________________
        this.nombrefoto = "sinFoto.jpg";
        this.nombrefotoDoc = "sinFoto.jpg";
        this.fotos();
        
        this.gestor = new gestionPrograma();
        this.gestor2 = new gestionEstudiante();
        this.gestor3 = new gestionDocente();
        this.gestor4 = new gestionAsignatura();
        this.gestor5= new gestionInscripciones();
        
        this.Estudiante = new Estudiante();
        this.Docente = new Docente();
        this.Asignatura = new Asignatura();
        this.Inscripciones = new Inscripciones();
        
        //_______________________observable list _________________________
        
        
        this.inscritosDoc = FXCollections.observableArrayList();
        this.asignaturaFiltrados = FXCollections.observableArrayList();
        this.inscripcionesEst = FXCollections.observableArrayList();
        this.asignatura = FXCollections.observableArrayList();
        this.pror = FXCollections.observableArrayList();
        this.filtrados=FXCollections.observableArrayList();
        this.estud = FXCollections.observableArrayList();
        this.filtradosEst =  FXCollections.observableArrayList();
        this.doc = FXCollections.observableArrayList();
        this.filtradosDoc = FXCollections.observableArrayList();
        this.asignaturaFiltrados = FXCollections.observableArrayList();
        this.inscripciones = FXCollections.observableArrayList();
        
        
       //____________________INICIALIZADORES________________________________
        
        //_______PROGRAMAS____________
        this.modelaTabla();
        this.traeProgramas();
        
        
        
        //_______ESTUDIANTES____________
        this.modelaTablaEst();
        this.traeEstudiantes();
        this.llenaComboEstPrograma();
        this.llenarCombos();
        
        
        //________DOCENTES_______________
        this.modelaTablaDoc();
        this.traeDocentes();
        this.llenarComboDocentes();
        
        
        //_________ASIGNATURAS_________________
        this.llenarCombosAsig();
        this.llenarComboAsignaturaCreditos();
        this.modelaTablaAsig();
        this.traeAsignaturas();
        this.traerAsignaturaDoc();
        this.modelaTablaDocIns();
        
        
        
        
        //_____________INSCRIPCIONES______________
        this.modelaTablaInscripciones();
        this.llenarCombosAsignaturaIns();
        this.llenarCombosDocenteIns();
        this.traerInscripciones();
        this.traerInscripcionesEst();
        this.modelaTablaInscritosEst();
        
        
        
        this.agregarInscripciones.setDisable(true);
        this.desagregarInscripciones.setDisable(true);
        this.comboAsignaturaIns.setDisable(true);
        this.comboDocenteIns.setDisable(true);
        this.tableInscripciones.setDisable(true);
        this.guardarInscripcion.setDisable(true);
        this.modificarInscripciones.setDisable(true);
        
        //___________________IMAGENES PRINCIPALES__________________________
        
        
        
        
    }
    
    
    public void fotos(){
        Image imageMenuPrincipal = new Image("file:"+"./GUI/menuPrincipal.png");
        this.imagePrincipal.setImage(imageMenuPrincipal);
        
        Image imageMenuEstudiante = new Image("file:"+"./GUI/carreras.png");
        this.carrerasImg.setImage(imageMenuEstudiante);
        
        Image imageMenuPrograma = new Image("file:"+"./GUI/estudiantes.png");
        this.estudiantesImg.setImage(imageMenuPrograma);
        
        Image imageMenuDocente = new Image("file:"+"./GUI/docente.png");
        this.docentesImg.setImage(imageMenuDocente);
        
        Image imageMenuAsignatura = new Image("file:"+"./GUI/asignaturas.png");
        this.asignaturaImg.setImage(imageMenuAsignatura);
        
        Image imageMenuInscripcion = new Image("file:"+"./GUI/inscripciones.png");
        this.inscripcionesImg.setImage(imageMenuInscripcion);
        
        
        
        
       
        
        
    }

    @FXML
    private void doOpcion1(ActionEvent event) {
       
        this.gestionPrograma.setVisible(true);
        this.gestionEstudiante.setVisible(false);
        this.gestionPrograma.toFront();
    }

    @FXML
    private void doAction2(ActionEvent event) {
       
        this.gestionPrograma.setVisible(false);
        this.gestionEstudiante.setVisible(true);
         this.gestionEstudiante.toFront();
    }
    
    @FXML
    private void doAction4(ActionEvent event) {
        this.gestionPrograma.setVisible(false);
        this.gestionEstudiante.setVisible(false);
        
        
        
    }

    @FXML
    private void doAction3(ActionEvent event) {
        this.gestionPrograma.setVisible(false);
        this.gestionEstudiante.setVisible(false);
        this.gestionAsignatura.setVisible(true);
        this.gestionDocente.setVisible(false);
        this.gestionInscripciones.setVisible(false);
        this.gestionAsignatura.toFront();
    }

    @FXML
    private void doSalir(ActionEvent event) {
        var stage = (Stage) this.gestionPrograma.getScene().getWindow();
        stage.close();
        System.exit(0);
    }
    
@FXML
    private void doNuevoPrograma(ActionEvent event) {
        this.codigoPro.setText("ING");
        this.codigoNamePro.setText("INGENIERIA");
        this.Online.setSelected(false);
        this.Presencial.setSelected(false);
        this.Acreditada.setSelected(false);
        this.guardarPrograma.setDisable(false);
        
    }

    @FXML
    private void doGuardarPrograma(ActionEvent event) {
        String codPro,Progr,msg;
        boolean acre,onli,presen;
        
        try{
            codPro = this.codigoPro.getText();
            Progr = this.codigoNamePro.getText();
            acre = this.Acreditada.isSelected();
            onli = this.Online.isSelected();
            presen = this.Presencial.isSelected();
            
            Programa pro = new Programa(codPro, Progr,acre,onli,presen);
            
            if(!this.pror.contains(pro)){
                this.pror.add(pro);
                this.misProgramas.setItems(pror);
                this.gestor.guardarPrograma(pro);
                JOptionPane.showMessageDialog(null, "El programa a sido guardado exitosamente...");
            } else {
                msg="Esa identificacion ya existe......";
                this.showMessages(msg, 1);
            }
        }catch(NumberFormatException nfe){
            msg= "Tipo de datos incorrecto";
            this.showMessages(msg,1);
        }
        this.codigoPro.setText("ING");
        this.codigoPro.requestFocus();
        this.codigoNamePro.setText("INGENIERIA");
        this.Online.setSelected(false);
        this.Presencial.setSelected(false);
        this.Acreditada.setSelected(false);
        this.guardarPrograma.setDisable(true);
    }


    @FXML
    private void doModificarPrograma(ActionEvent event) {
        String oldCodPro =this.cod;
        String oldProgr = this.nombre;
        boolean oldAcre = this.acre;
        boolean oldOnli = this.on;
        boolean oldPresen = this.pre;
      
        String codPro,Progr, msg;
        boolean acre,onli,presen;
        
        try{
            codPro = this.codigoPro.getText();
            Progr = this.codigoNamePro.getText();
            acre = this.Acreditada.isSelected();
            onli = this.Online.isSelected();
            presen = this.Presencial.isSelected();

            Programa laNueva = new Programa(codPro, Progr,acre,onli,presen);
            this.gestor.modificarPrograma(oldCodPro, laNueva);
            
            this.misProgramas.refresh();

        } catch (NumberFormatException nfe){
            msg= "Tipo de datos incorrecto";
            this.showMessages(msg,1);
        }
        this.misProgramas.getItems().clear();
        this.traeProgramas();
    }

    
    private void modelaTabla(){
        
        this.pror=FXCollections.observableArrayList();
        this.colCodigo.setCellValueFactory(new PropertyValueFactory("id"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombrePrograma"));
        this.colAcreditada.setCellValueFactory(new PropertyValueFactory("veryAcreditada"));
        this.colPresencial.setCellValueFactory(new PropertyValueFactory("veryPresencial"));
        this.colOnline.setCellValueFactory(new PropertyValueFactory("veryOnline"));
        
    }
    
    private boolean showMessages(String mesg, int caso){
        Alert msg;
        boolean ok = false;
        
        if (caso==1){//error
            msg = new Alert(Alert.AlertType.ERROR);
            msg.setTitle("ERROR");
            
            msg.setHeaderText(null);
            msg.setContentText(mesg);
            msg.showAndWait();
        }
        if (caso==2){//error
            msg = new Alert(Alert.AlertType.INFORMATION);
            msg.setTitle("LISTO");
            
            msg.setHeaderText(null);
            msg.setContentText(mesg);
            msg.showAndWait();
        }
        if (caso==3){//error
            msg = new Alert(Alert.AlertType.CONFIRMATION);
            msg.setTitle("ELIMINAR");
            
            msg.setHeaderText(null);
            msg.setContentText(mesg);
            msg.initStyle(StageStyle.UTILITY);
            Optional<ButtonType> result = msg.showAndWait();
            if(result.get()==ButtonType.OK){
                ok=true;
            }
        }
        return ok;
    }
    

//-------------------------------------------------------------------------

    private void traeProgramas() {
        ArrayList<Programa> prog=this.gestor.get_todos();

        for (Programa carre: prog){
            this.pror.add(carre);
        }
        this.misProgramas.setItems (this.pror);
    }

    @FXML
    private void doEliminarPrograma(ActionEvent event) {
        Programa laventa = this.misProgramas.getSelectionModel().getSelectedItem();
        String codigoPro = this.codigoPro.getText();
        
        if (laventa !=null) {
            this.pror.remove(laventa);
            this.misProgramas.refresh();
            if(codigoPro != null){
                this.gestor.eliminarProgramaID(codigoPro);
            } 
        }
        else{
            System.out.println("Debe seleccionar una rila");
        }
    }

    @FXML
    private void displaySelectedProgram(MouseEvent event) {
        Programa prog = this.misProgramas.getSelectionModel().getSelectedItem();
        
        if(prog==null){
            showMessages("Nothing selected", 1);
        } else{
            this.codigoPro.setText(prog.getId());
            this.codigoNamePro.setText(prog.getNombrePrograma());
            this.Online.setSelected(prog.isVeryOnline());
            this.Presencial.setSelected(prog.isVeryPresencial());
            this.Acreditada.setSelected(prog.isVeryAcreditada());
//            System.out.println(prog.getId() + ", " + prog.getNombrePrograma()  +", " + prog.isVeryAcreditada()+ ", " + prog.isVeryOnline() + ", " + prog.isVeryPresencial());  
        }
        this.cod = this.codigoPro.getText();
        this.nombre = this.codigoNamePro.getText();
        this.acre = this.Acreditada.isSelected();
        this.on = this.Online.isSelected();
        this.pre = this.Presencial.isSelected();
    }
    
    @FXML
    private void doBuscarPrograma(ActionEvent event) {
        String filtroName;
        
        filtroName=this.codigoPro.getText();
//        System.out.println(filtroName);
        
        if (filtroName.isEmpty()){
            this.misProgramas.setItems(this.pror);
        }
        else{
            this.filtrados.clear();
            for (Programa p:this.pror){
//                System.out.println(p);
                if((p.getId().toLowerCase()).contains(filtroName.toLowerCase()))
                    this.filtrados.add(p);
            }
            this.misProgramas.setItems(this.filtrados);
        }
    }
    
    //-----------------------------------------------------------------------------
    
    @FXML
    private void displaySelectedEst(MouseEvent event) {
        Estudiante est = this.estTodosTable.getSelectionModel().getSelectedItem();
        
        if(est==null){
            showMessages("Nothing selected", 1);
        } else{
//            this.busquedaCarreraEst.setText(est.getPrograma());
//            this.busquedaNombreEst.setText(est.getName());
              this.proEst.setText(est.getPrograma());
            Estudiante book=this.estTodosTable.getSelectionModel().getSelectedItem();
            Image image = new Image(getClass().getResourceAsStream("/IMAGENES/"+book.getFoto()));
            this.fotoEst.setImage(image);
        }
    }
    
    private void traeEstudiantes(){
        
        ArrayList<Estudiante> est=this.gestor2.getTodos();

        for (Estudiante elEstud: est){
            this.estud.add(elEstud); 
          this.cantidadDeEstudTotal++;
        }
        this.estTodosTable.setItems (this.estud);
    }
    
    @FXML
    private void buscarFoto(ActionEvent event) {
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Foto");
        fileChooser.setInitialDirectory(new File("./IMAGENES/"));
        
        File imgFile = fileChooser.showOpenDialog(new Stage());
        this.nombrefoto =imgFile.getName();
        
        if(this.nombrefoto != null){
            Image image = new Image("file:" + imgFile.getAbsolutePath());
            this.imgFoto.setImage(image);
        }
        String atributo = "Con foto";
    }

    private void modelaTablaEst(){
        
        this.estud=FXCollections.observableArrayList();
        this.columCodigo.setCellValueFactory(new PropertyValueFactory("id"));
        this.columNombre.setCellValueFactory(new PropertyValueFactory("name"));
        this.columGenero.setCellValueFactory(new PropertyValueFactory("genero"));  
    }
    
    private void llenaComboEstPrograma(){
        ArrayList<Programa> prog=this.gestor.get_todos();
        int i = 0;
//        this.comboProgr.getItems().add("PENDIENTE");
        
        for (Programa carre: prog){
          String carrera = carre.getNombrePrograma();
          this.comboProgr.getItems().add(carrera.toString());
//            System.out.println(carre);
        }
        
        cambiarEst();
        this.codEst = this.codigoEstudiante.getText();
        this.nombreEst = this.codigoNamePro.getText();
        this.carreraEst = this.nombreEstudiante.getText();
    }
    
    private void cambiarEst(){
        int i = 0;
        for(Estudiante stud: this.estud){
            
            this.codigoEstudiante.setText(stud.getId());
            this.nombreEstudiante.setText(stud.getName());

            Image image = new Image(getClass().getResourceAsStream("/IMAGENES/"+stud.getFoto()));
            this.imgFoto.setImage(image);

            this.comboProgr.getSelectionModel().select(stud.getPrograma());
            
            if(i == this.EstCant){
                break;
            }
            i++;
        }
    }
    
     private void cambiarDoc(){

        int i = 0;
        for(Docente stud: this.doc){
            
            this.indetificacionDocente.setText(stud.getId());
            this.nombreDocente2.setText(stud.getName());

            Image image = new Image(getClass().getResourceAsStream("/IMAGENES/"+stud.getFoto()));
            this.imgFotoDoc.setImage(image);

            if(i == this.DocCant){
                break;
            }
            i++;
        }
     }

    @FXML
    private void doNuevoEst(ActionEvent event) {
        this.comboProgr.getItems().clear();
        llenaComboEstPrograma();
        
        this.comboAño.setValue("");
        this.comboPeriodo.setValue("");        
        this.codigoEstudiante.setText("");
        this.nombreEstudiante.setText("");
        this.nombreEstudiante.requestFocus();
        this.estudianteFemenino.setSelected(false);
        this.estuidianteMasculino.setSelected(false);
        this.guardarEst.setDisable(false);
        this.comboPeriodo.setDisable(true);
    }

    @FXML
    private void doGuardarEst(ActionEvent event) {
         String codPro,name, progr, msg, foto;
         String genero = "";
         
        try{
            codPro = this.codigoEstudiante.getText();
            name = this.nombreEstudiante.getText();
            progr = this.comboProgr.getSelectionModel().getSelectedItem();
            
            if(this.estuidianteMasculino.isSelected() == true && this.estudianteFemenino.isSelected() == false){               
                genero = "Masculino";
            }else if (this.estuidianteMasculino.isSelected() == false && this.estudianteFemenino.isSelected() == true){                
                genero = "Femenino";
            }
            
            foto = this.nombrefoto;
            
            Estudiante est = new Estudiante(codPro, name,progr,genero, foto);
            
            
            if(!this.estud.contains(est)){
                this.estud.add(est);
                this.estTodosTable.setItems(estud);
                this.gestor2.guardarEstudiante(est);
                JOptionPane.showMessageDialog(null, "El programa a sido guardado exitosamente...");
            }
            
            else {
                msg="Esa identificacion ya existe......";
                this.showMessages(msg, 1);
            }
            
            this.comboAño.setValue("");
            this.comboPeriodo.setValue("");
            this.codigoEstudiante.setText("");
            this.nombreEstudiante.setText("");
            this.nombreEstudiante.requestFocus();
            this.estudianteFemenino.setSelected(false);
            this.estuidianteMasculino.setSelected(false);
            this.guardarEst.setDisable(true);
            this.comboPeriodo.setDisable(true);
            
        }catch(NumberFormatException nfe){
            msg= "Tipo de datos incorrecto";
            this.showMessages(msg,1);
        }
    }
    

    @FXML
    private void doBuscarEst(ActionEvent event) {
        String filtroName;
        
        filtroName=this.codigoEstudiante.getText();
//        System.out.println(filtroName);
        
        this.filtradosEst.clear();
        for (Estudiante p:this.estud){
//            System.out.println(p);
            if((p.getId().toLowerCase()).contains(filtroName.toLowerCase())){
                this.filtradosEst.add(p);
                this.nombreEstudiante.setText(p.getName());
                Image image = new Image(getClass().getResourceAsStream("/IMAGENES/"+p.getFoto()));
                this.imgFoto.setImage(image);
                this.comboProgr.getSelectionModel().select(p.getPrograma());
            }
        }
    }

    @FXML
    private void doModificarEst(ActionEvent event) {
        String oldCodEst =this.codEst;
        String oldProgr = this.carreraEst;
        String oldName = this.nombreEst;
                
        String codPro,Progr, foto, msg;
        String genero = "";
        
        
         //------------FALTA MODIFICAR AUN-------------//
        try{
            codPro = this.codigoEstudiante.getText();
            Progr = this.nombreEstudiante.getText();
            carrearaNuevaEst = this.comboProgr.getSelectionModel().getSelectedItem();
            if(this.estuidianteMasculino.isSelected() == true && this.estudianteFemenino.isSelected() == false){               
                genero = "Masculino";
            }else if (this.estuidianteMasculino.isSelected() == false && this.estudianteFemenino.isSelected() == true){                
                genero = "Femenino";
            }
            
            foto = this.nombrefoto;

            Estudiante laNueva = new Estudiante(codPro, Progr, carrearaNuevaEst,genero, foto);
            this.gestor2.modificarEstudiante(oldCodEst, laNueva);
            
        } catch (NumberFormatException nfe){
            msg= "Tipo de datos incorrecto";
            this.showMessages(msg,1);
        }
        this.estTodosTable.getItems().clear();
        this.traeEstudiantes();
    }

    @FXML
    private void doEliminarEst(ActionEvent event) {
        String msg;
        
        try{        
            String codigoEst = this.codigoEstudiante.getText();
            this.gestor2.eliminarEstudianteId(codigoEst);
         }
        
        catch (NumberFormatException nfe){
            msg= "Tipo de datos incorrecto";
            this.showMessages(msg,1);
        }
    }

    private void llenarCombos() {
        comboPeriodo.getItems().addAll(
            "1",
            "2");  
        
        comboAño.getItems().addAll(
            "2022",
            "2023",
            "2024",
            "2025"); 
        
        combGeneroEst.getItems().addAll(
                "Todos",
                "Masculino", 
                "Femenino"        
        );
        
        /*
        for(Estudiante li: libros){
            this.combGeneroEst.getItems().add(li.getGenero());
        }*/
    }

    @FXML
    private void doYear(ActionEvent event) { 

        this.comboPeriodo.setDisable(false);
    }

    @FXML
    private void doPeriodo(ActionEvent event) {
        Random random = new Random();   
        if(comboAño != null && comboPeriodo != null){
            String numRand = Integer.toString(random.nextInt(999));
            String anio = this.comboAño.getSelectionModel().getSelectedItem();
            String periodo = this.comboPeriodo.getSelectionModel().getSelectedItem();
            this.codigoEstudiante.setText(anio+periodo+numRand);
        }
    }

    @FXML
    private void doCargarTodos(ActionEvent event) {
        this.gestionPrograma.setVisible(false);
        this.gestionEstudiante.setVisible(false);
        this.todosEstudiante.setVisible(true);
        this.todosEstudiante.toFront();
        this.gestionDocente.setVisible(false);
        this.todosDocentes.setVisible(false);
        
    }

    @FXML
    private void doRegresarEst(ActionEvent event) {
        this.gestionPrograma.setVisible(false);
        this.gestionEstudiante.setVisible(true);
        this.todosEstudiante.setVisible(false);
        this.gestionEstudiante.toFront();
    }

    @FXML
    private void filtrarGenero(ActionEvent event) {
        this.filtradosEst.clear();
        int index;
        
        index=this.combGeneroEst.getSelectionModel().getSelectedIndex();
        //ArrayList<Estudiante> libros = this.gestor2.getTodos();
        if(index == 0){
            this.estTodosTable.setItems(this.estud);
        }
        else {
            if(index == 1){
                for(Estudiante stud: this.estud){
                    if("Masculino".equalsIgnoreCase(stud.getGenero())){
                        this.filtradosEst.add(stud);
                    }
                }
            }
            if(index == 2){
                
                for(Estudiante stud: this.estud){
                    if("Femenino".equalsIgnoreCase(stud.getGenero())){
                        this.filtradosEst.add(stud);
                    }
                }
            }
            this.estTodosTable.setItems(this.filtradosEst);
        }
        //Estudiante filtro =this.estud.get(0);
    }

    @FXML
    private void doFiltroCarrera(KeyEvent event) {
        String filtroName;
        
        filtroName=this.busquedaCarreraEst.getText();
        
        if (filtroName.isEmpty()){
            this.estTodosTable.setItems(this.estud);
        }
        else{
            this.filtradosEst.clear();
            for (Estudiante p:this.estud){
                if((p.getPrograma().toLowerCase()) .contains (filtroName.toLowerCase()))
                    this.filtradosEst.add(p);
            }
            this.estTodosTable.setItems (this.filtradosEst);
        }
    }

    @FXML
    private void foFiltroNombre(KeyEvent event) {
        String filtroName;
        
        filtroName=this.busquedaNombreEst.getText();
        
        if (filtroName.isEmpty()){
            this.estTodosTable.setItems(this.estud);
        }
        else{
            this.filtradosEst.clear();
            for (Estudiante p:this.estud){
                if((p.getName().toLowerCase()) .contains (filtroName.toLowerCase()))
                    this.filtradosEst.add(p);
            }
            this.estTodosTable.setItems (this.filtradosEst);
        }
    }


    @FXML
    private void doNextEst(ActionEvent event) {
        if (this.EstCant < (this.cantidadDeEstudTotal-1)){
            this.EstCant++;
        }
        cambiarEst();
        tablaInscripcionesEst.getItems().clear();
        traerInscripcionesEst();
        this.codEst = this.codigoEstudiante.getText();
        this.nombreEst = this.codigoNamePro.getText();
        this.carreraEst = this.nombreEstudiante.getText();
        
//        llenaComboEstPrograma();
    }

    @FXML
    private void doBackEst(ActionEvent event) {
        if (this.EstCant <= (this.cantidadDeEstudTotal-1)){
            this.EstCant--;
        }
        cambiarEst();
         tablaInscripcionesEst.getItems().clear();
        traerInscripcionesEst();
        this.codEst = this.codigoEstudiante.getText();
        this.nombreEst = this.codigoNamePro.getText();
        this.carreraEst = this.nombreEstudiante.getText();
    }
    
    
    private void modelaTablaInscritosEst(){
        
        this.colAsignaturaEst.setCellValueFactory(new PropertyValueFactory("asignatura"));
        this.colProfesorEst.setCellValueFactory(new PropertyValueFactory("profesor"));

    }
    
    //________________________________DOCENTE________________________________

    @FXML
    private void doNuevoDocente(ActionEvent event) {
        this.comboDocenteIns.getItems().clear();
        this.indetificacionDocente.setText("");
        this.nombreDocente2.setText("");
        this.indetificacionDocente.requestFocus();
        this.catedraDocente.setSelected(false);
        this.plantadocente.setSelected(false);
        this.docenciaPlantaDocente.setSelected(false);
        this.guardarDocente.setDisable(false);
        
    }

    @FXML
    private void doBuscarDocente(ActionEvent event) {
String filtroName;
        
        filtroName=this.indetificacionDocente.getText();
//        System.out.println(filtroName);X
        
        this.filtradosDoc.clear();
        for (Docente p:this.doc){
//            System.out.println(p);X
            if((p.getId().toLowerCase()).contains(filtroName.toLowerCase())){
                this.filtradosDoc.add(p);
                this.nombreDocente2.setText(p.getName());
                Image image = new Image(getClass().getResourceAsStream("/IMAGENES/"+p.getFoto()));
                this.imgFoto.setImage(image);
            }
        }
        this.identDoce = this.indetificacionDocente.getText();
    }

    @FXML
    private void doEliminarDocente(ActionEvent event) {
        String msg;
        
        try{        
            String codigoDoc = this.indetificacionDocente.getText();
            this.gestor3.eliminarDocenteId(codigoDoc);
         }
        
        catch (NumberFormatException nfe){
            msg= "Tipo de datos incorrecto";
            this.showMessages(msg,1);
        }
        
    }

    @FXML
    private void doGuardarDocente(ActionEvent event) {
        String codDoc,name,categoria, msg, foto;
        boolean cat,plan,docPlant;
        foto = this.nombrefotoDoc;
        categoria = "";
        ;
        
        try{
            codDoc = this.indetificacionDocente.getText();
            name = this.nombreDocente2.getText();
            cat = this.catedraDocente.isSelected();
            plan = this.plantadocente.isSelected();
            docPlant = this.docenciaPlantaDocente.isSelected();
            
            if(cat==true && plan ==false || cat==true && docPlant == false){
                categoria = "1";
            }else if (cat==false && plan ==true || plan==true && docPlant == false){
                categoria = "2";
            }else if (cat==false && docPlant ==true || plan==true && docPlant == false){
                categoria = "3";
            }
            
            Docente pro = new Docente(codDoc, name, categoria, foto);
            
            if(!this.doc.contains(pro)){
                this.doc.add(pro);
                this.tableTodosDocente.setItems(doc);
                this.gestor3.guardarDocente(pro);
                JOptionPane.showMessageDialog(null, "El programa a sido guardado exitosamente...");

            }
            
            else {
                msg="Esa identificacion ya existe......";
                this.showMessages(msg, 1);
            }
        }catch(NumberFormatException nfe){
            msg= "Tipo de datos incorrecto";
            this.showMessages(msg,1);
        }
        
        this.indetificacionDocente.setText("");
        this.nombreDocente2.setText("");
        this.catedraDocente.setSelected(false);
        this.plantadocente.setSelected(false);
        this.docenciaPlantaDocente.setSelected(false);
        this.guardarDocente.setDisable(true);
        
    }

    @FXML
    private void doModificarDocente(ActionEvent event) {
        String oldCodEst =this.identDoce;
        String oldCat = this.catDocen;
        String oldFoto = this.fotoDocente;
        String oldName = this.nameDocente;
                
        String codPro,Progr, foto, msg;
        String genero = "";
        
        
         //------------FALTA MODIFICAR AUN-------------//
        try{
            codPro = this.indetificacionDocente.getText();
            Progr = this.nombreDocente2.getText();
            
            if(this.catedraDocente.isSelected() == true && this.docenciaPlantaDocente.isSelected() == false && this.plantadocente.isSelected() == false){               
                genero = "1";
            }else if (this.catedraDocente.isSelected() == false && this.docenciaPlantaDocente.isSelected() == true && this.plantadocente.isSelected() == false){                
                genero = "2";
            } else if (this.catedraDocente.isSelected() == false && this.docenciaPlantaDocente.isSelected() == false && this.plantadocente.isSelected() == true){                
                genero = "3";
            }
            
            foto = this.nombrefoto;

            Docente laNueva = new Docente(codPro, Progr, genero, foto);
            this.gestor3.modificarDocente(oldCodEst, laNueva);
            
        } catch (NumberFormatException nfe){
            msg= "Tipo de datos incorrecto";
            this.showMessages(msg,1);
        }
        this.estTodosTable.getItems().clear();
        this.traeDocentes();
    }

    @FXML
    private void doTodosDocente(ActionEvent event) {
        this.gestionPrograma.setVisible(false);      
        this.gestionEstudiante.setVisible(false);
        this.todosEstudiante.setVisible(true);
        this.todosDocentes.toFront();
        this.gestionDocente.setVisible(false);
        this.todosDocentes.setVisible(true);
    }

    @FXML
    private void doActualizarInscritos(ActionEvent event) {
        
    }
    
    @FXML
    private void doRegresarDocentes(ActionEvent event) {
        this.gestionPrograma.setVisible(false);
        this.gestionEstudiante.setVisible(false);
        this.todosEstudiante.setVisible(true);
        this.gestionDocente.toFront();
        this.gestionDocente.setVisible(true);
        this.todosDocentes.setVisible(false);
    }
    
    private void modelaTablaDoc(){
        
        this.doc=FXCollections.observableArrayList();
        this.columnaId.setCellValueFactory(new PropertyValueFactory("Id"));
        this.columnaNombre.setCellValueFactory(new PropertyValueFactory("name"));
        this.columnaCategoria.setCellValueFactory(new PropertyValueFactory("categoria"));
        cambiarDoc();
    }
    
    private void traeDocentes() {
        
        ArrayList<Docente> prog=this.gestor3.getTodos();

        for (Docente carre: prog){
            this.doc.add(carre);
            
          this.cantidaddeDocTotal++;
        }
        this.tableTodosDocente.setItems(this.doc);
    }
    
    
    private void llenarComboDocentes(){
       comboCategoriaDocente.getItems().addAll(
            "Todos",
            "Catedra",
            "Docencia Planta",
            "Planta");  
    }
    
    @FXML
    private void buscarFotoDoc(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Foto");
        fileChooser.setInitialDirectory(new File("./IMAGENES/"));
        
        File imgFile = fileChooser.showOpenDialog(new Stage());
        this.nombrefoto =imgFile.getName();
        
        if(this.nombrefoto != null){
            Image image = new Image("file:" + imgFile.getAbsolutePath());
            this.imgFotoDoc.setImage(image);
        }
        
        String atributo = "Con foto";
    }
    
    @FXML
    private void displaySelectedDoc(MouseEvent event) {
        Docente est = this.tableTodosDocente.getSelectionModel().getSelectedItem();
        
        if(est==null){
            showMessages("Nothing selected", 1);
        } else{
//            this.busquedaCarreraEst.setText(est.getPrograma());
//            this.busquedaNombreEst.setText(est.getName());
              this.nombreDocente.setText(est.getCategoria());
            Docente book=this.tableTodosDocente.getSelectionModel().getSelectedItem();
            Image image = new Image(getClass().getResourceAsStream("/IMAGENES/"+book.getFoto()));
            this.fotoDoce.setImage(image);
        }
    }
    
     @FXML
    private void filtrarCategoria(ActionEvent event) {
        this.filtradosDoc.clear();
        int index;
        
        index=this.comboCategoriaDocente.getSelectionModel().getSelectedIndex();
        //ArrayList<Estudiante> libros = this.gestor2.getTodos();
        if(index == 0){
            this.tableTodosDocente.setItems(this.doc);
        }
        else {
            if(index == 1){
                for(Docente stud: this.doc){
                    if("1".equalsIgnoreCase(stud.getCategoria())){
                        this.filtradosDoc.add(stud);
                    }
                }
            }
            if(index == 2){
                
                for(Docente stud: this.doc){
                    if("2".equalsIgnoreCase(stud.getCategoria())){
                        this.filtradosDoc.add(stud);
                    }
                }
            }
            if(index == 3){
                
                for(Docente stud: this.doc){
                    if("3".equalsIgnoreCase(stud.getCategoria())){
                        this.filtradosDoc.add(stud);
                    }
                }
            }
            
            this.tableTodosDocente.setItems(this.filtradosDoc);
        }
    }
    
    @FXML
    private void doFiltroNombreDoc(KeyEvent event) {
        String filtroName;
        
        filtroName=this.filtroNombreDocente.getText();
        
        if (filtroName.isEmpty()){
            this.tableTodosDocente.setItems(this.doc);
        }
        else{
            this.filtradosDoc.clear();
            for (Docente p:this.doc){
                if((p.getName().toLowerCase()) .contains (filtroName.toLowerCase()))
                    this.filtradosDoc.add(p);
            }
            this.tableTodosDocente.setItems (this.filtradosDoc);
        }
    }

    
    //_____________________ASIGNATURAS______________________________________
    

    @FXML
    private void doNuevoAsig(ActionEvent event) {
        this.nombreAsig.setText("");
        this.codigoAsig.setText("");
        this.comboCreditosAsig.setValue("");
        this.comboProfesorAsig.setValue("");
        this.guardarAsig.setDisable(false);
        this.nombreAsig.requestFocus();
    }
    
    private void llenarComboAsignaturaCreditos(){
       comboCreditosAsig.getItems().addAll(
            "1",
            "2",
            "3",
            "4");  
    }
    
    private void modelaTablaAsig(){
        this.asignatura=FXCollections.observableArrayList();
        this.colCodigoAsig.setCellValueFactory(new PropertyValueFactory("id"));
        this.colNombreAsig.setCellValueFactory(new PropertyValueFactory("name"));
        this.colCreditosAsig.setCellValueFactory(new PropertyValueFactory("Creditos"));
        this.colProfe.setCellValueFactory(new PropertyValueFactory("Profesor"));
    }
    
    private void modelaTablaDocIns(){
        
        this.colAsig.setCellValueFactory(new PropertyValueFactory("name"));
        this.colInscritos.setCellValueFactory(new PropertyValueFactory("inscritos"));
    }
    
    private void llenarCombosAsig(){
        
        ArrayList<Docente> prog=this.gestor3.getTodos();
        int i = 0;
//        this.comboProgr.getItems().add("PENDIENTE");
        for (Docente carre: prog){
          String carrera = carre.getName();
          this.comboProfesorAsig.getItems().add(carrera.toString());
//            System.out.println(carre);
        }
        
        this.carreraEst = this.nombreEstudiante.getText();
        
    }


    @FXML
    private void doGuardarAsig(ActionEvent event) {
        String codDoc,name,creditos,profesor, inscritos, msg;
        inscritos = "";
        try{
            codDoc = this.codigoAsig.getText();
            name = this.nombreAsig.getText();
            creditos = this.comboCreditosAsig.getSelectionModel().getSelectedItem();
            profesor = this.comboProfesorAsig.getSelectionModel().getSelectedItem();
            
            Asignatura pror = new Asignatura(codDoc, name, creditos, profesor,inscritos);
            
            if(!this.asignatura.contains(pror)){
                this.asignatura.add(pror);
                this.tableAsignaturas.setItems(asignatura);
                this.gestor4.guardarAsignatura(pror);
                JOptionPane.showMessageDialog(null, "El programa a sido guardado exitosamente...");
            }
            
            if(!this.inscritosDoc.contains(pror)){
                this.inscritosDoc.add(pror);
                this.tableInscritosDocente.setItems(inscritosDoc);
                
                JOptionPane.showMessageDialog(null, "El programa a sido guardado exitosamente...");
            }
            
            else {
                msg="Esa identificacion ya existe......";
                this.showMessages(msg, 1);
            }
        }catch(NumberFormatException nfe){
            msg= "Tipo de datos incorrecto";
            this.showMessages(msg,1);
        }
        
        this.nombreAsig.setText("");
        this.codigoAsig.setText("");
        this.comboCreditosAsig.setValue("");
        this.guardarAsig.setDisable(true);

    }
    
    private void traeAsignaturas(){
        
        ArrayList<Asignatura> prog=this.gestor4.getTodos();

        for (Asignatura carre: prog){
            this.asignatura.add(carre);
        }
        this.tableAsignaturas.setItems(this.asignatura);
    }

    @FXML
    private void doBuscarAsig(ActionEvent event) {
//        String filtroName;
//        
//        filtroName=this.codigoAsig.getText();
//        System.out.println(filtroName);
//        
//        this.asignaturaFiltrados.clear();
//        for (Asignatura p:this.asignatura){
//            System.out.println(p);
//            if((p.getId().toLowerCase()).contains(filtroName.toLowerCase())){
//                this.asignaturaFiltrados.add(p);
//                this.nombreAsig.setText(p.getName());
//            }
//        }
//        
        String filtroName;
        
        filtroName=this.codigoAsig.getText();
//        System.out.println(filtroName);
        
        if (filtroName.isEmpty()){
            this.tableAsignaturas.setItems(this.asignatura);
        }
        this.asignaturaFiltrados.clear();
        for (Asignatura p:this.asignatura){
//            System.out.println(p);
            if((p.getId().toLowerCase()).contains(filtroName.toLowerCase())){
                this.asignaturaFiltrados.add(p);
                this.nombreAsig.setText(p.getName());
            }
            this.tableAsignaturas.setItems(this.asignaturaFiltrados);
        }
    }

    @FXML
    
    private void doModificarAsig(ActionEvent event) {
        String oldCodAsig = this.asig;
        String oldNombreAsig =this.nomAsig;
        String oldCreditos = this.credito;
        String oldProfe = this.prof;
                
        String codPro,name, creditos, profesor, inscritos, msg;
        inscritos= "";
       
         //------------FALTA MODIFICAR AUN-------------//
        try{
            codPro = this.codigoAsig.getText();
            name = this.nombreAsig.getText();
            creditos = this.comboCreditosAsig.getSelectionModel().getSelectedItem();
            profesor = this.comboProfesorAsig.getSelectionModel().getSelectedItem();
            
            Asignatura laNueva = new Asignatura(codPro, name, creditos, profesor,inscritos);
            this.gestor4.modificarAsignatura(oldCodAsig, laNueva);
            
        } catch (NumberFormatException nfe){
            msg= "Tipo de datos incorrecto";
            this.showMessages(msg,1);
        }
        this.tableAsignaturas.getItems().clear();
        this.traeAsignaturas();
        this.modificarAsig.setDisable(true);
    }

    @FXML
    private void doEliminarAsig(ActionEvent event) {
        
        Asignatura laventa = this.tableAsignaturas.getSelectionModel().getSelectedItem();
        String codigoPro = this.codigoAsig.getText();
        
        if (laventa !=null) {
            this.asignatura.remove(laventa);
            this.tableAsignaturas.refresh();
            if(codigoPro != null){
                this.gestor4.eliminarAsignaturaId(codigoPro);
            } 
        }
        else{
            System.out.println("Debe seleccionar una fila");
        }
        
        this.nombreAsig.setText("");
        this.codigoAsig.setText("");
        this.comboCreditosAsig.setValue("");
    }

    @FXML
    private void doGenerarCodigo(ActionEvent event) {
        String codAsignatura, asig;
        Random random = new Random();  
        String numRand = Integer.toString(random.nextInt(999));

        asig = this.nombreAsig.getText();
        if(asig.isEmpty()){
            showMessages("Agrege nombre de Asginatura", 1);
            this.nombreAsig.requestFocus();
        } else {
        
            codAsignatura = asig.substring(0,3) + numRand;

            this.codigoAsig.setText(codAsignatura);
        }
    }
    
    @FXML
    private void displaySelectedAsig(MouseEvent event) {
        Asignatura est = this.tableAsignaturas.getSelectionModel().getSelectedItem();
        
        if(est==null){
            showMessages("Nothing selected", 1);
        } else{

              this.nombreAsig.setText(est.getName());
              this.codigoAsig.setText(est.getId());
              this.comboCreditosAsig.setValue(est.getCreditos());
              this.comboProfesorAsig.setValue(est.getProfesor());
        }
        
        this.asig = this.codigoAsig.getText();
        this.nomAsig = this.codigoNamePro.getText();
        this.credito = this.comboCreditosAsig.getSelectionModel().getSelectedItem();
        this.prof = this.comboProfesorAsig.getSelectionModel().getSelectedItem();
        this.modificarAsig.setDisable(false);
    }
    
    //_____________________________INSCRIPCIONES_______________________________

    @FXML
    private void doBuscarEstudianteInscripciones(ActionEvent event) {
        
        this.agregarInscripciones.setDisable(false);
        this.desagregarInscripciones.setDisable(false);
        this.comboAsignaturaIns.setDisable(false);
        this.comboDocenteIns.setDisable(false);
        this.tableInscripciones.setDisable(false);
        this.guardarInscripcion.setDisable(false);
        this.modificarInscripciones.setDisable(false);
        
        String codEstBus = "";
        
        codEstBus = JOptionPane.showInputDialog("INGRESE EL CODIGO DEL ESTUDIANTE A BUSCAR");
        
//        System.out.println(codEstBus);
        
        this.filtradosEst.clear();
        for (Estudiante p:this.estud){
//            System.out.println(p);
            if((p.getId().toLowerCase()).contains(codEstBus.toLowerCase())){
                this.filtradosEst.add(p);
                this.codigoStudIns.setText(p.getId()); 
                this.nomStudIns.setText(p.getName()); 
                this.carreaStudIns.setText(p.getPrograma());
            }
        }
    }

    @FXML
    private void doAgregarInscripciones(ActionEvent event) {
        
        String codigoStud ="", stud="" ,asig="",creditos="",profesor="", msg;
        
        try{
            codigoStud = this.codigoStudIns.getText();
            stud = this.nomStudIns.getText();
            asig= this.comboAsignaturaIns.getSelectionModel().getSelectedItem();
            //_______________________HELP CREDITOS_________________________________

            ArrayList<Asignatura> prog=this.gestor4.getTodos();
            for (Asignatura carre: prog){
                if(carre.getName().equals(asig)){
                    creditos = carre.getCreditos();
                }
            }
            profesor = this.comboDocenteIns.getSelectionModel().getSelectedItem();

            Inscripciones pror = new Inscripciones(codigoStud, stud, asig, creditos, profesor);

            this.gestor5.guardarInscripcion(pror);

            if(!this.inscripciones.contains(pror)){
                this.inscripciones.add(pror);
                this.tableInscripciones.setItems(inscripciones);
                JOptionPane.showMessageDialog(null, "El programa a sido guardado exitosamente...");
            }
            else {
                msg="Esa identificacion ya existe......";
                this.showMessages(msg, 1);
            }
            
            
                if(!this.inscripcionesEst.contains(pror)){
                    this.inscripcionesEst.add(pror);
                    this.tablaInscripcionesEst.setItems(inscripcionesEst);
                    JOptionPane.showMessageDialog(null, "El programa a sido guardado exitosamente...");
                }
                else {
                     msg="Esa identificacion ya existe......";
                    this.showMessages(msg, 1);
                }
            
        } catch(NumberFormatException nfe){
            msg= "Tipo de datos incorrecto";
            this.showMessages(msg,1);
        }
        this.codigoStudIns.setText("");
        this.nomStudIns.setText("");
        this.carreaStudIns.setText("");
        this.comboAsignaturaIns.setValue("");
        this.comboProfesorAsig.setValue("");
    }

    @FXML
    private void doDesagregarInscripciones(ActionEvent event) {
        
        Inscripciones laventa = this.tableInscripciones.getSelectionModel().getSelectedItem();
        String codigoPro = this.comboAsignaturaIns.getValue();
        
        if (laventa !=null) {
            this.asignatura.remove(laventa);
            this.tableAsignaturas.refresh();
            if(codigoPro != null){
                this.gestor4.eliminarAsignaturaId(codigoPro);
            } 
        }
        else{
            System.out.println("Debe seleccionar una fila");
        }
        
        this.nombreAsig.setText("");
        this.codigoAsig.setText("");
        this.comboCreditosAsig.setValue("");
    }
    
    private void traerInscripciones(){
        
        ArrayList<Inscripciones> prog=this.gestor5.getTodos();

        for (Inscripciones carre: prog){
            this.inscripciones.add(carre);
        }
        this.tableInscripciones.setItems(this.inscripciones);
        
    }
    
    private void traerInscripcionesEst(){
        codEst = this.codigoEstudiante.getText();
        
        ArrayList<Inscripciones> proge=this.gestor5.getTodos();  
        
        for (Inscripciones carre: proge){
                if(codEst.equals(carre.getCodigoEst())){ 
                    System.out.println(codEst);
                    System.out.println(carre);
                    this.inscripcionesEst.add(carre);
                    this.tablaInscripcionesEst.setItems(this.inscripcionesEst);         
                } else {
                    this.tablaInscripcionesEst.refresh();
                }
        }  
    }
    
    private void traerAsignaturaDoc(){
        
        codEst = this.nombreDocente2.getText();
        
        ArrayList<Asignatura> proge=this.gestor4.getTodos();  
        
        for (Asignatura carre: proge){
                if(codEst.equals(carre.getProfesor())){ 
                    System.out.println(codEst);
                    System.out.println(carre);
                    this.inscritosDoc.add(carre);
                    this.tableInscritosDocente.setItems(this.inscritosDoc);         
                } else {
                    this.tableInscritosDocente.refresh();
                }
        }  
    }
    
    private void modelaTablaInscripciones(){
        
        this.colAsignaturaIns.setCellValueFactory(new PropertyValueFactory("asignatura"));
        this.colCreditosIns.setCellValueFactory(new PropertyValueFactory("creditos"));
        this.colProfesorAsigIns.setCellValueFactory(new PropertyValueFactory("profesor"));
        
    }
    
    private void llenarCombosDocenteIns(){
        
        ArrayList<Docente> prog=this.gestor3.getTodos();
        int i = 0;
//        this.comboProgr.getItems().add("PENDIENTE");
        for (Docente carre: prog){
          String carrera = carre.getName();
          this.comboDocenteIns.getItems().add(carrera.toString());
//            System.out.println(carre);
        }
        this.carreraEst = this.nombreEstudiante.getText();     
    }
    
    private void llenarCombosAsignaturaIns(){
        
        ArrayList <Asignatura> prog=this.gestor4.getTodos();
        int i = 0;
//        this.comboProgr.getItems().add("PENDIENTE");
        for (Asignatura carre: prog){
          String carrera = carre.getName();
          this.comboAsignaturaIns.getItems().add(carrera.toString());
//            System.out.println(carre);
        }
        
    }

    @FXML
    private void doAction5(ActionEvent event) {
        this.gestionPrograma.setVisible(false);
        this.gestionEstudiante.setVisible(false);
        this.gestionAsignatura.setVisible(false);
        this.gestionDocente.setVisible(true);
        this.gestionInscripciones.setVisible(false);
        this.gestionDocente.toFront();

    }

    @FXML
    private void doAction6(ActionEvent event) {
        this.gestionPrograma.setVisible(false);
        this.gestionEstudiante.setVisible(false);
        this.gestionAsignatura.setVisible(false);
        this.gestionDocente.setVisible(false);
        this.gestionInscripciones.setVisible(true);
        this.gestionInscripciones.toFront();

    }

    @FXML
    private void doNextDoc(ActionEvent event) {
         if (this.DocCant < (this.cantidaddeDocTotal-1)){
            this.DocCant++;
        }
         System.out.println(DocCant);
         System.out.println(cantidaddeDocTotal);
        cambiarDoc();
        tableInscritosDocente.getItems().clear();
        traerAsignaturaDoc();
        this.codEst = this.indetificacionDocente.getText();
        this.nombreEst = this.nombreDocente2.getText();
        
    }

    @FXML
    private void doBackDoc(ActionEvent event) {
         if (this.DocCant <= (this.cantidaddeDocTotal-1)){
            this.DocCant--;
        }
         
        cambiarDoc();
        tableInscritosDocente.getItems().clear();
        traerAsignaturaDoc();
        
        this.codEst = this.indetificacionDocente.getText();
        this.nombreEst = this.nombreDocente2.getText();
    }

    

   

    

    

    

    
    
    
    
  
}