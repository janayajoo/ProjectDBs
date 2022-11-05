package CONTROLLERS;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import MODELO.City;
import MODELO.Country;
import MODELO.CountryLanguage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableRow;

public class ManuPrincipalController implements Initializable {

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
    private TableColumn<Country, String> GNPO_country_col;

    @FXML
    private TextField GNP_Country;

    @FXML
    private TextField GNP_Old_Country;

    @FXML
    private TableColumn<Country, String> GNP_country_col;

    @FXML
    private TextField Gov_Country;

    @FXML
    private TextField Head_Country;

    @FXML
    private TextField Indep_year;

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
    private TableColumn<Country, String> capital_country_col;

    @FXML
    private TableColumn<Country, String> code2_country_col;

    @FXML
    private TableColumn<City, String> code_col;

    @FXML
    private TableColumn<Country, String> code_country_col;

    @FXML
    private TableColumn<Country, String> cont_country_col;

    @FXML
    private TableColumn<Country, String> country_code_col;

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
    private TableColumn<Country, String> goverment_country_col;

    @FXML
    private TableColumn<Country, String> head_country_col;

    @FXML
    private TableColumn<City, String> id_col;

    @FXML
    private TableColumn<Country, String> indep_country_col;

    @FXML
    private TableColumn<CountryLanguage, String> language_col;

    @FXML
    private TableColumn<Country, String> life_country_col;

    @FXML
    private TableColumn<Country, String> local_country_col;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu menuConsulta;

    @FXML
    private MenuItem menuPrincipal;

    @FXML
    private TableColumn<City, String> name_col;

    @FXML
    private TableColumn<Country, String> name_country_col;

    @FXML
    private TableColumn<CountryLanguage, String> official_col;

    @FXML
    private TableColumn<CountryLanguage, String> perc_col;

    @FXML
    private TableColumn<City, String> pop_col;

    @FXML
    private TableColumn<Country, String> pop_country_col;

    @FXML
    private TableColumn<Country, String> reg_country_col;

    @FXML
    private TableColumn<Country, String> surface_country_col;

    @FXML
    private TableView<City> table_city;

    @FXML
    private TableView<Country> table_country;

    Connection con;
    PreparedStatement pst;
    int myIndex;
    int id;
    String id_s;

    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/world", "root", "terrans94");
        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {
            ex.printStackTrace();
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
            pst = con.prepareStatement("select ID,Name,CountryCode,District,Population from city;");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {
                    City st = new City();
                    st.setId(rs.getString("ID"));
                    st.setName(rs.getString("Name"));
                    st.setDistrict(rs.getString("District"));
                    st.setCountry_code(rs.getString("CountryCode"));
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
        String code_country, name_country, continent_country, region_country, surface_country, indep_country,
                pop_country, life_country, gnp_country, gnpold_country, local_country, goverment_country, head_country,
                capital_country, code2_country;
        code_country = Code_Country.getText();
        name_country = Name_Country.getText();
        continent_country = Continent_Country.getText();
        region_country = Region_Country.getText();
        surface_country = SA_Country.getText();
        indep_country = Indep_year.getText();
        pop_country = Pop_Country.getText();
        life_country = Life_Country.getText();
        gnp_country = GNP_Country.getText();
        gnpold_country = GNP_Old_Country.getText();
        local_country = Local_Country.getText();
        goverment_country = Gov_Country.getText();
        head_country = Head_Country.getText();
        capital_country = Capital_Country.getText();
        code2_country = Code2_Country.getText();

        try {
            pst = con.prepareStatement(
                    "insert into country(Code,Name,Continent,Region,SurfaceArea,IndepYear,Population,LifeExpectancy,GNP,GNPOld,LocalName,GovernmentForm,HeadOfState,Capital,Code2) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, code_country);
            pst.setString(2, name_country);
            pst.setString(3, continent_country);
            pst.setString(4, region_country);
            pst.setString(5, surface_country);
            pst.setString(6, indep_country);
            pst.setString(7, pop_country);
            pst.setString(8, life_country);
            pst.setString(9, gnp_country);
            pst.setString(10, gnpold_country);
            pst.setString(11, local_country);
            pst.setString(12, goverment_country);
            pst.setString(13, head_country);
            pst.setString(14, capital_country);
            pst.setString(15, code2_country);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("City Registation");

            alert.setHeaderText("City Registation");
            alert.setContentText("Record Added!");

            alert.showAndWait();

            table_country();

            Code_Country.setText("");
            Name_Country.setText("");
            Continent_Country.setText("");
            Region_Country.setText("");
            SA_Country.setText("");
            Indep_year.setText("");
            Pop_Country.setText("");
            Life_Country.setText("");
            GNP_Country.setText("");
            GNP_Old_Country.setText("");
            Local_Country.setText("");
            Gov_Country.setText("");
            Head_Country.setText("");
            Capital_Country.setText("");
            Code2_Country.setText("");
            Code_Country.requestFocus();

        } catch (SQLException ex) {
            Logger.getLogger(ManuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void table_country() {
        Connect();
        ObservableList<Country> country = FXCollections.observableArrayList();
        try {
            pst = con.prepareStatement(
                    "select Code,Name,Continent,Region,SurfaceArea,IndepYear,Population,LifeExpectancy,GNP,GNPOld,LocalName,GovernmentForm,HeadOfState,Capital,Code2 from country;");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {
                    Country st = new Country();
                    st.setCode(rs.getString("Code"));
                    st.setName(rs.getString("Name"));
                    st.setContinent(rs.getString("Continent"));
                    st.setRegion(rs.getString("Region"));
                    st.setSurface_area(rs.getString("SurfaceArea"));
                    st.setIndep_year(rs.getString("IndepYear"));
                    st.setPopulation(rs.getString("Population"));
                    st.setLife_expectancy(rs.getString("LifeExpectancy"));
                    st.setGnp(rs.getString("GNP"));
                    st.setGnp_old(rs.getString("GNPOld"));
                    st.setLocal_name(rs.getString("LocalName"));
                    st.setGovernment_form(rs.getString("GovernmentForm"));
                    st.setHead_state(rs.getString("HeadOfState"));
                    st.setCapital(rs.getString("Capital"));
                    st.setCode2(rs.getString("Code2"));
                    country.add(st);
                }
            }

            table_country.setItems(country);
            code_country_col.setCellValueFactory(f -> f.getValue().codeProperty());
            name_country_col.setCellValueFactory(f -> f.getValue().nameProperty());
            cont_country_col.setCellValueFactory(f -> f.getValue().continentPropoerty());
            reg_country_col.setCellValueFactory(f -> f.getValue().regionProperty());
            surface_country_col.setCellValueFactory(f -> f.getValue().surface_areaProperty());
            indep_country_col.setCellValueFactory(f -> f.getValue().indep_yearProperty());
            pop_country_col.setCellValueFactory(f -> f.getValue().populationProperty());
            life_country_col.setCellValueFactory(f -> f.getValue().life_expectancyProperty());
            GNP_country_col.setCellValueFactory(f -> f.getValue().gnpProperty());
            GNPO_country_col.setCellValueFactory(f -> f.getValue().gnp_oldProperty());
            local_country_col.setCellValueFactory(f -> f.getValue().local_nameProperty());
            goverment_country_col.setCellValueFactory(f -> f.getValue().government_formProperty());
            head_country_col.setCellValueFactory(f -> f.getValue().head_stateProperty());
            capital_country_col.setCellValueFactory(f -> f.getValue().capitalProperty());
            code2_country_col.setCellValueFactory(f -> f.getValue().code2Property());

        }

        catch (SQLException ex) {
            Logger.getLogger(ManuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }

        table_country.setRowFactory(tv -> {
            TableRow<Country> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    myIndex = table_country.getSelectionModel().getSelectedIndex();
                    id_s = (String.valueOf(table_country.getItems().get(myIndex).getCode()));
                    Code_Country.setText(table_country.getItems().get(myIndex).getCode());
                    Name_Country.setText(table_country.getItems().get(myIndex).getName());
                    Continent_Country.setText(table_country.getItems().get(myIndex).getContinent());
                    Region_Country.setText(table_country.getItems().get(myIndex).getPopulation());
                    Indep_year.setText(table_country.getItems().get(myIndex).getIndep_year());
                    Pop_Country.setText(table_country.getItems().get(myIndex).getPopulation());
                    Life_Country.setText(table_country.getItems().get(myIndex).getLife_expectancy());
                    GNP_Country.setText(table_country.getItems().get(myIndex).getGnp());
                    GNP_Old_Country.setText(table_country.getItems().get(myIndex).getGnp_old());
                    Local_Country.setText(table_country.getItems().get(myIndex).getLocal_name());
                    Gov_Country.setText(table_country.getItems().get(myIndex).getGovernment_form());
                    Head_Country.setText(table_country.getItems().get(myIndex).getHead_state());
                    Capital_Country.setText(table_country.getItems().get(myIndex).getCapital());
                    Code2_Country.setText(table_country.getItems().get(myIndex).getCode2());

                }
            });
            return myRow;
        });

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
        myIndex = table_country.getSelectionModel().getSelectedIndex();
        id_s = (String.valueOf(table_country.getItems().get(myIndex).getCode()));

        try {
            pst = con.prepareStatement("delete from country where id = ? ");
            pst.setString(1, id_s);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Country Registation");

            alert.setHeaderText("Country Registation");
            alert.setContentText("Deleted!");

            alert.showAndWait();
            table_country();
        } catch (SQLException ex) {
            Logger.getLogger(ManuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        myIndex = table_country.getSelectionModel().getSelectedIndex();
        id_s = (String.valueOf(table_country.getItems().get(myIndex).getCode()));

        String code_country, name_country, continent_country, region_country, surface_country, indep_country,
                pop_country, life_country, gnp_country, gnpold_country, local_country, goverment_country, head_country,
                capital_country, code2_country;
        code_country = Code_Country.getText();
        name_country = Name_Country.getText();
        continent_country = Continent_Country.getText();
        region_country = Region_Country.getText();
        surface_country = SA_Country.getText();
        indep_country = Indep_year.getText();
        pop_country = Pop_Country.getText();
        life_country = Life_Country.getText();
        gnp_country = GNP_Country.getText();
        gnpold_country = GNP_Old_Country.getText();
        local_country = Local_Country.getText();
        goverment_country = Gov_Country.getText();
        head_country = Head_Country.getText();
        capital_country = Capital_Country.getText();
        code2_country = Code2_Country.getText();

        try {
            pst = con.prepareStatement(
                    "update Country set Name=?,Continent=?,Region=?,SurfaceArea=?,IndepYear=?,Population=?,LifeExpectancy=?,GNP=?,GNPOld=?,LocalName=?,GovernmentForm=?,HeadOfState=?,Capital=?,Code2=? where Code = ? ");
            pst.setString(1, name_country);
            pst.setString(2, continent_country);
            pst.setString(3, region_country);
            pst.setString(4, surface_country);
            pst.setString(5, indep_country);
            pst.setString(6, pop_country);
            pst.setString(7, life_country);
            pst.setString(8, gnp_country);
            pst.setString(9, gnpold_country);
            pst.setString(10, local_country);
            pst.setString(11, goverment_country);
            pst.setString(12, head_country);
            pst.setString(13, capital_country);
            pst.setString(14, code2_country);
            pst.setString(15, code_country);
            pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Country Registation");

            alert.setHeaderText("Country Registation");
            alert.setContentText("Updated!");

            alert.showAndWait();
            table_country();
        } catch (SQLException ex) {
            Logger.getLogger(ManuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void doUpdate_CL(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connect();
        table_city();
        table_country();
    }

}
