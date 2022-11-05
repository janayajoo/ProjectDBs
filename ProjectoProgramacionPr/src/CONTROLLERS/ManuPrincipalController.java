package CONTROLLERS;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import MODELO.City;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableRow;

public class ManuPrincipalController {

    @FXML
    private TextField Capital_Country;

    @FXML
    private TextField Code2_Country;

    @FXML
    private TextField Code_City;

    @FXML
    private TextField Code_Country;

    @FXML
    private TextField Code_Country1;

    @FXML
    private TextField Continent_Country;

    @FXML
    private TextField CountryCode_CL;

    @FXML
    private Button CreateCountry;

    @FXML
    private Button CreateCountry1;

    @FXML
    private Button Create_CL;

    @FXML
    private Button Create_City;

    @FXML
    private Button DeleteCountry;

    @FXML
    private Button DeleteCountry1;

    @FXML
    private Button Delete_CL;

    @FXML
    private TextField District_City;

    @FXML
    private TextField GNP_Country;

    @FXML
    private TextField GNP_Old_Country;

    @FXML
    private TextField Gov_Country;

    @FXML
    private TextField Head_Country;

    @FXML
    private TextField ID_City;

    @FXML
    private TextField Language_CL;

    @FXML
    private TextField Life_Country;

    @FXML
    private TextField Local_Country;

    @FXML
    private MenuItem MoveCL;

    @FXML
    private MenuItem MoveCity;

    @FXML
    private MenuItem MoveCountry;

    @FXML
    private MenuItem MoveOperaciones;

    @FXML
    private TextField Name_City;

    @FXML
    private TextField Name_Country;

    @FXML
    private TextField Official_CL;

    @FXML
    private TextField Perc_CL;

    @FXML
    private TextField Pop_City;

    @FXML
    private TextField Pop_Country;

    @FXML
    private TextField Region_Country;

    @FXML
    private TextField SA_Country;

    @FXML
    private MenuItem Salir;

    @FXML
    private Button UpdateCountry;

    @FXML
    private Button UpdateCountry1;

    @FXML
    private Button Update_CL;

    @FXML
    private Button Update_City;

    @FXML
    private TableColumn<City, String> code_col;

    @FXML
    private TableColumn<City, String> district_col;

    @FXML
    private Label doM;

    @FXML
    private Pane doMenu;

    @FXML
    private Button eliminarPrograma;

    @FXML
    private Pane gestionCL;

    @FXML
    private Pane gestionCity;

    @FXML
    private Pane gestionCountry;

    @FXML
    private Pane gestionOperaciones;

    @FXML
    private TableColumn<City, String> id_col;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu menuConsulta;

    @FXML
    private MenuItem menuPrincipal;

    @FXML
    private TableColumn<City, String> name_col;

    @FXML
    private TableColumn<City, String> pop_col;

    @FXML
    private TableView<City> table_city;

    Connection con;
    PreparedStatement pst;
    int myIndex;
    int id;

    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/World", "root", "");
        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {

        }
    }

    @FXML
    void doCL(ActionEvent event) {
        this.gestionCL.setVisible(true);
        this.gestionCity.setVisible(false);
        this.gestionCountry.setVisible(false);
        this.gestionCL.toFront();
    }

    @FXML
    void doCity(ActionEvent event) {
        this.gestionCL.setVisible(false);
        this.gestionCity.setVisible(true);
        this.gestionCountry.setVisible(false);
        this.gestionCity.toFront();
    }

    @FXML
    void doCountry(ActionEvent event) {
        this.gestionCL.setVisible(false);
        this.gestionCity.setVisible(false);
        this.gestionCountry.setVisible(true);
        this.gestionCountry.toFront();
    }

    @FXML
    void doCreateCity(ActionEvent event) {
        String id_city, name_city, code_city, district_city, pop_city;
        id_city = ID_City.getText();
        name_city = Name_City.getText();
        code_city = Code_City.getText();
        district_city = District_City.getText();
        pop_city = Pop_City.getText();

        try {
            pst = con.prepareStatement("insert into city(ID,Name,CountryCode,District,Population) values(?,?,?,?,?)");
            pst.setString(1, id_city);
            pst.setString(2, name_city);
            pst.setString(3, code_city);
            pst.setString(4, district_city);
            pst.setString(5, pop_city);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("City Registation");

            alert.setHeaderText("City Registation");
            alert.setContentText("Record Added!");

            alert.showAndWait();

            table_city();

            ID_City.setText("");
            Name_City.setText("");
            Code_City.setText("");
            District_City.setText("");
            Pop_City.setText("");
            ID_City.requestFocus();
        } catch (SQLException ex) {
            Logger.getLogger(ManuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void table_city() {
        Connect();
        ObservableList<City> city = FXCollections.observableArrayList();
        try {
            pst = con.prepareStatement("select ID,Name,CountryCode,District,Population from city");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {
                    City st = new City();
                    st.setId(rs.getString("ID"));
                    st.setName(rs.getString("Name"));
                    st.setDistrict(rs.getString("District"));
                    st.setCountry_code(rs.getString("Country Code"));
                    st.setPopulation(rs.getString("Population"));
                    city.add(st);
                }
            }

            table_city.setItems(city);
            id_col.setCellValueFactory(f -> f.getValue().idProperty());
            name_col.setCellValueFactory(f -> f.getValue().namProperty());
            district_col.setCellValueFactory(f -> f.getValue().dStringProperty());
            code_col.setCellValueFactory(f -> f.getValue().codeProperty());
            pop_col.setCellValueFactory(f -> f.getValue().pStringProperty());

        }

        catch (SQLException ex) {
            Logger.getLogger(ManuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }

        table_city.setRowFactory(tv -> {
            TableRow<City> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    myIndex = table_city.getSelectionModel().getSelectedIndex();
                    id = Integer.parseInt(String.valueOf(table_city.getItems().get(myIndex).getId()));
                    ID_City.setText(table_city.getItems().get(myIndex).getId());
                    Name_City.setText(table_city.getItems().get(myIndex).getName());
                    Code_City.setText(table_city.getItems().get(myIndex).getCountry_code());
                    Pop_City.setText(table_city.getItems().get(myIndex).getPopulation());
                    district_col.setText(table_city.getItems().get(myIndex).getDistrict());

                }
            });
            return myRow;
        });

    }

    @FXML
    void doCreateCountry(ActionEvent event) {

    }

    @FXML
    void doCreate_CL(ActionEvent event) {

    }

    @FXML
    void doDeleteCity(ActionEvent event) {
        myIndex = table_city.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(table_city.getItems().get(myIndex).getId()));

        try {
            pst = con.prepareStatement("delete from city where id = ? ");
            pst.setInt(1, id);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("City Registation");

            alert.setHeaderText("City Registation");
            alert.setContentText("Deleted!");

            alert.showAndWait();
            table_city();
        } catch (SQLException ex) {
            Logger.getLogger(ManuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void doDeleteCountry(ActionEvent event) {

    }

    @FXML
    void doDelete_CL(ActionEvent event) {

    }

    @FXML
    void doMenu(ActionEvent event) {
        this.gestionCL.setVisible(false);
        this.gestionCity.setVisible(false);
        this.gestionCountry.setVisible(false);
        this.gestionOperaciones.setVisible(false);
    }

    @FXML
    void doOperations(ActionEvent event) {
        this.gestionCL.setVisible(false);
        this.gestionCity.setVisible(false);
        this.gestionCountry.setVisible(false);
        this.gestionOperaciones.setVisible(true);
        this.gestionOperaciones.toFront();
    }

    @FXML
    void doSalir(ActionEvent event) {
        var stage = (Stage) this.gestionCountry.getScene().getWindow();
        stage.close();
        System.exit(0);
    }

    @FXML
    void doUpdateCity(ActionEvent event) {

        myIndex = table_city.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(table_city.getItems().get(myIndex).getId()));

        String id_city, name_city, code_city, district_city, pop_city;

        id_city = ID_City.getText();
        name_city = Name_City.getText();
        code_city = Code_City.getText();
        district_city = District_City.getText();
        pop_city = Pop_City.getText();

        try {
            pst = con.prepareStatement(
                    "update City set Name = ?,CountryCode = ? ,District = ?, Population = ? where ID = ? ");
            pst.setString(1, name_city);
            pst.setString(2, code_city);
            pst.setString(3, district_city);
            pst.setString(4, pop_city);
            pst.setString(5, id_city);
            pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("City Registation");

            alert.setHeaderText("City Registation");
            alert.setContentText("Updated!");

            alert.showAndWait();
            table_city();
        } catch (SQLException ex) {
            Logger.getLogger(ManuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void doUpdateCountry(ActionEvent event) {

    }

    @FXML
    void doUpdate_CL(ActionEvent event) {

    }

}
