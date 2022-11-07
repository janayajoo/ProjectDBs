package CONTROLLERS;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
    private TextField ID_City;

    @FXML
    private TextField Indep_year;

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
    private Button Filter_CL;

    @FXML
    private Button Filter_City;

    @FXML
    private Button Filter_Country;

    @FXML
    private Button reset_Country;

    @FXML
    private Button reset_CL;

    @FXML
    private Button reset_City;

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
    private TableColumn<CountryLanguage, String> country_code_col;

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

    @FXML
    private TableView<CountryLanguage> table_country_language;

    @FXML
    private TextField where_CL;

    @FXML
    private TextField where_City;

    @FXML
    private TextField where_Country;

    @FXML
    private RadioButton regexp_country_button;

    @FXML
    private RadioButton sql_country_button;

    @FXML
    private RadioButton regexp_city_button;

    @FXML
    private RadioButton sql_city_button;

    @FXML
    private RadioButton regexp_CL_button;

    @FXML
    private RadioButton sql_CL_button;

    @FXML
    private ChoiceBox<String> combo_city;

    @FXML
    private ChoiceBox<String> combo_CL;

    @FXML
    private ChoiceBox<String> combo_country;

    Connection con;
    PreparedStatement pst;
    int myIndex;
    int id;
    String id_s, id_lang;
    String code_CLnew, language_CLnew, official_CLnew, perc_CLnew;

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
        String code_CL, language_CL, official_CL, perc_CL;
        code_CL = CountryCode_CL.getText();
        language_CL = Language_CL.getText();
        official_CL = Official_CL.getText();
        perc_CL = Perc_CL.getText();

        try {
            pst = con.prepareStatement(
                    "insert into countrylanguage (CountryCode,Language,IsOfficial,Percentage) values(?,?,?,?)");
            pst.setString(1, code_CL);
            pst.setString(2, language_CL);
            pst.setString(3, official_CL);
            pst.setString(4, perc_CL);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Country Language Registation");

            alert.setHeaderText("Country Language Registation");
            alert.setContentText("Record Added!");

            alert.showAndWait();

            table_country_language();

            CountryCode_CL.setText("");
            Language_CL.setText("");
            Official_CL.setText("");
            Perc_CL.setText("");
            CountryCode_CL.requestFocus();

        } catch (SQLException ex) {
            Logger.getLogger(ManuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void table_country_language() {
        Connect();
        ObservableList<CountryLanguage> CL = FXCollections.observableArrayList();

        try {
            pst = con.prepareStatement("select CountryCode,Language,IsOfficial,Percentage from countrylanguage;");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next()) {
                    CountryLanguage st = new CountryLanguage();
                    st.setCountry_code(rs.getString("CountryCode"));
                    st.setLenguage(rs.getString("Language"));
                    st.setIs_official(rs.getString("IsOfficial"));
                    st.setPercentage(rs.getString("Percentage"));
                    CL.add(st);
                }
            }

            table_country_language.setItems(CL);
            country_code_col.setCellValueFactory(f -> f.getValue().country_codeProperty());
            language_col.setCellValueFactory(f -> f.getValue().languageProperty());
            official_col.setCellValueFactory(f -> f.getValue().is_officialProperty());
            perc_col.setCellValueFactory(f -> f.getValue().percentageProperty());

        }

        catch (SQLException ex) {
            Logger.getLogger(ManuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }

        table_country_language.setRowFactory(tv -> {
            TableRow<CountryLanguage> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    myIndex = table_country_language.getSelectionModel().getSelectedIndex();
                    id_s = (String.valueOf(table_country_language.getItems().get(myIndex).getCountry_code()));
                    CountryCode_CL.setText(table_country_language.getItems().get(myIndex).getCountry_code());
                    Language_CL.setText(table_country_language.getItems().get(myIndex).getLanguage());
                    Official_CL.setText(table_country_language.getItems().get(myIndex).getIs_official());
                    Perc_CL.setText(table_country_language.getItems().get(myIndex).getPercentage());

                    code_CLnew = table_country_language.getItems().get(myIndex).getCountry_code();

                    language_CLnew = (table_country_language.getItems().get(myIndex).getLanguage());
                }
            });
            return myRow;
        });

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
        myIndex = table_country_language.getSelectionModel().getSelectedIndex();
        id_s = (String.valueOf(table_country_language.getItems().get(myIndex).getCountry_code()));
        id_lang = (String.valueOf(table_country_language.getItems().get(myIndex).getLanguage()));

        try {
            pst = con.prepareStatement("delete from countrylanguage where CountryCode = ? and Language= ?");
            pst.setString(1, id_s);
            pst.setString(2, id_lang);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Country Language Registation");

            alert.setHeaderText("Country Language Registation");
            alert.setContentText("Deleted!");

            alert.showAndWait();
            table_country_language();
        } catch (SQLException ex) {
            Logger.getLogger(ManuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void doMenu(ActionEvent event) {
        this.gestionCL.setVisible(false);
        this.gestionCity.setVisible(false);
        this.gestionCountry.setVisible(false);
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
    void CL_Click(MouseEvent event) {
        myIndex = table_country_language.getSelectionModel().getSelectedIndex();

        id_s = (String.valueOf(table_country_language.getItems().get(myIndex).getCountry_code()));

        code_CLnew = CountryCode_CL.getText();
        language_CLnew = Language_CL.getText();
        official_CLnew = Official_CL.getText();
        perc_CLnew = Perc_CL.getText();
        System.out.println(code_CLnew);
    }

    // -----------------------------------UPDATECL-----------------------------------//

    @FXML
    void doUpdate_CL(ActionEvent event) {
        myIndex = table_country_language.getSelectionModel().getSelectedIndex();

        id_s = (String.valueOf(table_country_language.getItems().get(myIndex).getCountry_code()));

        String code_CL, language_CL, official_CL, perc_CL;

        code_CL = CountryCode_CL.getText();
        language_CL = Language_CL.getText();
        official_CL = Official_CL.getText();
        perc_CL = Perc_CL.getText();

        try {
            pst = con.prepareStatement(
                    "update countrylanguage set CountryCode = ?, Language = ? ,IsOfficial = ?, Percentage = ? where CountryCode = ? and Language = ?");
            pst.setString(1, code_CL);
            pst.setString(2, language_CL);
            pst.setString(3, official_CL);
            pst.setString(4, perc_CL);
            pst.setString(5, code_CLnew);
            pst.setString(6, language_CLnew);

            pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Country Language Registation");

            alert.setHeaderText("Country Language Registation");
            alert.setContentText("Updated!");

            alert.showAndWait();
            table_country_language();
        } catch (SQLException ex) {
            Logger.getLogger(ManuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // -----------------------------------FIILTROCOUNTRYLANGUAGE-----------------------------------//

    @FXML
    void doFilter_CL(ActionEvent event) {

        int opcion = (combo_CL.getSelectionModel().getSelectedIndex());

        String where;
        where = where_CL.getText();

        Connect();
        ObservableList<CountryLanguage> CL = FXCollections.observableArrayList();

        if (opcion == (0)) {
            if (sql_CL_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from countrylanguage where CountryCode like ? or Language like ? or isOfficial like ? or Percentage like ?;");
                    pst.setString(1, where);
                    pst.setString(2, where);
                    pst.setString(3, where);
                    pst.setString(4, where);
                    ResultSet rs = pst.executeQuery();
                    {
                        while (rs.next()) {
                            CountryLanguage st = new CountryLanguage();
                            st.setCountry_code(rs.getString("CountryCode"));
                            st.setLenguage(rs.getString("Language"));
                            st.setIs_official(rs.getString("IsOfficial"));
                            st.setPercentage(rs.getString("Percentage"));
                            CL.add(st);
                        }
                    }

                    table_country_language.setItems(CL);
                    country_code_col.setCellValueFactory(f -> f.getValue().country_codeProperty());
                    language_col.setCellValueFactory(f -> f.getValue().languageProperty());
                    official_col.setCellValueFactory(f -> f.getValue().is_officialProperty());
                    perc_col.setCellValueFactory(f -> f.getValue().percentageProperty());

                }

                catch (SQLException ex) {
                    Logger.getLogger(ManuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (regexp_CL_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from countrylanguage where CountryCode REGEXP ? or Language REGEXP ? or isOfficial REGEXP ? or Percentage REGEXP ?;");
                    pst.setString(1, where);
                    pst.setString(2, where);
                    pst.setString(3, where);
                    pst.setString(4, where);
                    ResultSet rs = pst.executeQuery();
                    {
                        while (rs.next()) {
                            CountryLanguage st = new CountryLanguage();
                            st.setCountry_code(rs.getString("CountryCode"));
                            st.setLenguage(rs.getString("Language"));
                            st.setIs_official(rs.getString("IsOfficial"));
                            st.setPercentage(rs.getString("Percentage"));
                            CL.add(st);
                        }
                    }

                    table_country_language.setItems(CL);
                    country_code_col.setCellValueFactory(f -> f.getValue().country_codeProperty());
                    language_col.setCellValueFactory(f -> f.getValue().languageProperty());
                    official_col.setCellValueFactory(f -> f.getValue().is_officialProperty());
                    perc_col.setCellValueFactory(f -> f.getValue().percentageProperty());

                }

                catch (SQLException ex) {
                    Logger.getLogger(ManuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        if (opcion == (1)) {
            if (sql_CL_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from countrylanguage where CountryCode like ? ;");
                    pst.setString(1, where);
                    ResultSet rs = pst.executeQuery();
                    {
                        while (rs.next()) {
                            CountryLanguage st = new CountryLanguage();
                            st.setCountry_code(rs.getString("CountryCode"));
                            st.setLenguage(rs.getString("Language"));
                            st.setIs_official(rs.getString("IsOfficial"));
                            st.setPercentage(rs.getString("Percentage"));
                            CL.add(st);
                        }
                    }

                    table_country_language.setItems(CL);
                    country_code_col.setCellValueFactory(f -> f.getValue().country_codeProperty());
                    language_col.setCellValueFactory(f -> f.getValue().languageProperty());
                    official_col.setCellValueFactory(f -> f.getValue().is_officialProperty());
                    perc_col.setCellValueFactory(f -> f.getValue().percentageProperty());

                }

                catch (SQLException ex) {
                    Logger.getLogger(ManuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (regexp_CL_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from countrylanguage where CountryCode REGEXP ?;");
                    pst.setString(1, where);
                    ResultSet rs = pst.executeQuery();
                    {
                        while (rs.next()) {
                            CountryLanguage st = new CountryLanguage();
                            st.setCountry_code(rs.getString("CountryCode"));
                            st.setLenguage(rs.getString("Language"));
                            st.setIs_official(rs.getString("IsOfficial"));
                            st.setPercentage(rs.getString("Percentage"));
                            CL.add(st);
                        }
                    }

                    table_country_language.setItems(CL);
                    country_code_col.setCellValueFactory(f -> f.getValue().country_codeProperty());
                    language_col.setCellValueFactory(f -> f.getValue().languageProperty());
                    official_col.setCellValueFactory(f -> f.getValue().is_officialProperty());
                    perc_col.setCellValueFactory(f -> f.getValue().percentageProperty());

                }

                catch (SQLException ex) {
                    Logger.getLogger(ManuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        if (opcion == (2)) {
            if (sql_CL_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from countrylanguage where Language like ? ;");
                    pst.setString(1, where);
                    ResultSet rs = pst.executeQuery();
                    {
                        while (rs.next()) {
                            CountryLanguage st = new CountryLanguage();
                            st.setCountry_code(rs.getString("CountryCode"));
                            st.setLenguage(rs.getString("Language"));
                            st.setIs_official(rs.getString("IsOfficial"));
                            st.setPercentage(rs.getString("Percentage"));
                            CL.add(st);
                        }
                    }

                    table_country_language.setItems(CL);
                    country_code_col.setCellValueFactory(f -> f.getValue().country_codeProperty());
                    language_col.setCellValueFactory(f -> f.getValue().languageProperty());
                    official_col.setCellValueFactory(f -> f.getValue().is_officialProperty());
                    perc_col.setCellValueFactory(f -> f.getValue().percentageProperty());

                }

                catch (SQLException ex) {
                    Logger.getLogger(ManuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (regexp_CL_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from countrylanguage where Language REGEXP ?;");
                    pst.setString(1, where);
                    ResultSet rs = pst.executeQuery();
                    {
                        while (rs.next()) {
                            CountryLanguage st = new CountryLanguage();
                            st.setCountry_code(rs.getString("CountryCode"));
                            st.setLenguage(rs.getString("Language"));
                            st.setIs_official(rs.getString("IsOfficial"));
                            st.setPercentage(rs.getString("Percentage"));
                            CL.add(st);
                        }
                    }

                    table_country_language.setItems(CL);
                    country_code_col.setCellValueFactory(f -> f.getValue().country_codeProperty());
                    language_col.setCellValueFactory(f -> f.getValue().languageProperty());
                    official_col.setCellValueFactory(f -> f.getValue().is_officialProperty());
                    perc_col.setCellValueFactory(f -> f.getValue().percentageProperty());

                }

                catch (SQLException ex) {
                    Logger.getLogger(ManuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        if (opcion == (3)) {
            if (sql_CL_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from countrylanguage where IsOfficial like ? ;");
                    pst.setString(1, where);
                    ResultSet rs = pst.executeQuery();
                    {
                        while (rs.next()) {
                            CountryLanguage st = new CountryLanguage();
                            st.setCountry_code(rs.getString("CountryCode"));
                            st.setLenguage(rs.getString("Language"));
                            st.setIs_official(rs.getString("IsOfficial"));
                            st.setPercentage(rs.getString("Percentage"));
                            CL.add(st);
                        }
                    }

                    table_country_language.setItems(CL);
                    country_code_col.setCellValueFactory(f -> f.getValue().country_codeProperty());
                    language_col.setCellValueFactory(f -> f.getValue().languageProperty());
                    official_col.setCellValueFactory(f -> f.getValue().is_officialProperty());
                    perc_col.setCellValueFactory(f -> f.getValue().percentageProperty());

                }

                catch (SQLException ex) {
                    Logger.getLogger(ManuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (regexp_CL_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from countrylanguage where IsOfficial REGEXP ?;");
                    pst.setString(1, where);
                    ResultSet rs = pst.executeQuery();
                    {
                        while (rs.next()) {
                            CountryLanguage st = new CountryLanguage();
                            st.setCountry_code(rs.getString("CountryCode"));
                            st.setLenguage(rs.getString("Language"));
                            st.setIs_official(rs.getString("IsOfficial"));
                            st.setPercentage(rs.getString("Percentage"));
                            CL.add(st);
                        }
                    }

                    table_country_language.setItems(CL);
                    country_code_col.setCellValueFactory(f -> f.getValue().country_codeProperty());
                    language_col.setCellValueFactory(f -> f.getValue().languageProperty());
                    official_col.setCellValueFactory(f -> f.getValue().is_officialProperty());
                    perc_col.setCellValueFactory(f -> f.getValue().percentageProperty());

                }

                catch (SQLException ex) {
                    Logger.getLogger(ManuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        if (opcion == (4)) {
            if (sql_CL_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from countrylanguage where Percentage like ? ;");
                    pst.setString(1, where);
                    ResultSet rs = pst.executeQuery();
                    {
                        while (rs.next()) {
                            CountryLanguage st = new CountryLanguage();
                            st.setCountry_code(rs.getString("CountryCode"));
                            st.setLenguage(rs.getString("Language"));
                            st.setIs_official(rs.getString("IsOfficial"));
                            st.setPercentage(rs.getString("Percentage"));
                            CL.add(st);
                        }
                    }

                    table_country_language.setItems(CL);
                    country_code_col.setCellValueFactory(f -> f.getValue().country_codeProperty());
                    language_col.setCellValueFactory(f -> f.getValue().languageProperty());
                    official_col.setCellValueFactory(f -> f.getValue().is_officialProperty());
                    perc_col.setCellValueFactory(f -> f.getValue().percentageProperty());

                }

                catch (SQLException ex) {
                    Logger.getLogger(ManuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (regexp_CL_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from countrylanguage where Percentage REGEXP ?;");
                    pst.setString(1, where);
                    ResultSet rs = pst.executeQuery();
                    {
                        while (rs.next()) {
                            CountryLanguage st = new CountryLanguage();
                            st.setCountry_code(rs.getString("CountryCode"));
                            st.setLenguage(rs.getString("Language"));
                            st.setIs_official(rs.getString("IsOfficial"));
                            st.setPercentage(rs.getString("Percentage"));
                            CL.add(st);
                        }
                    }

                    table_country_language.setItems(CL);
                    country_code_col.setCellValueFactory(f -> f.getValue().country_codeProperty());
                    language_col.setCellValueFactory(f -> f.getValue().languageProperty());
                    official_col.setCellValueFactory(f -> f.getValue().is_officialProperty());
                    perc_col.setCellValueFactory(f -> f.getValue().percentageProperty());

                }

                catch (SQLException ex) {
                    Logger.getLogger(ManuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    // -----------------------------------FIILTRO
    // COUNTRY-----------------------------------//

    @FXML
    void doFilter_Country(ActionEvent event) {

        int opcion = (combo_country.getSelectionModel().getSelectedIndex());

        String where;
        where = where_Country.getText();

        Connect();
        ObservableList<Country> country = FXCollections.observableArrayList();

        if (opcion == 0) {
            if (sql_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where Code like ? or Name like ? or Continent like ? or Region like ? or SurfaceArea like ? or IndepYear like ? or Population like ? or LifeExpectancy like ? or GNP like ? or GNPOld like ? or LocalName like ? or GovernmentForm like ? or HeadOfState like ? or Capital like ? or Code2 like ?;");
                    pst.setString(1, where);
                    pst.setString(2, where);
                    pst.setString(3, where);
                    pst.setString(4, where);
                    pst.setString(5, where);
                    pst.setString(6, where);
                    pst.setString(7, where);
                    pst.setString(8, where);
                    pst.setString(9, where);
                    pst.setString(10, where);
                    pst.setString(11, where);
                    pst.setString(12, where);
                    pst.setString(13, where);
                    pst.setString(14, where);
                    pst.setString(15, where);
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
            }
            if (regexp_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where Code REGEXP ? or Name REGEXP ? or Continent REGEXP ? or Region REGEXP ? or SurfaceArea REGEXP ? or IndepYear REGEXP ? or Population REGEXP ? or LifeExpectancy REGEXP ? or GNP REGEXP ? or GNPOld REGEXP ? or LocalName REGEXP ? or GovernmentForm REGEXP ? or HeadOfState REGEXP ? or Capital REGEXP ? or Code2 REGEXP ?;");
                    pst.setString(1, where);
                    pst.setString(2, where);
                    pst.setString(3, where);
                    pst.setString(4, where);
                    pst.setString(5, where);
                    pst.setString(6, where);
                    pst.setString(7, where);
                    pst.setString(8, where);
                    pst.setString(9, where);
                    pst.setString(10, where);
                    pst.setString(11, where);
                    pst.setString(12, where);
                    pst.setString(13, where);
                    pst.setString(14, where);
                    pst.setString(15, where);
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
            }
        }

        if (opcion == 1) {
            if (sql_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where Code like ? ;");
                    pst.setString(1, where);
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
            }
            if (regexp_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where Code REGEXP ? ;");
                    pst.setString(1, where);
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
            }
        }

        if (opcion == 2) {
            if (sql_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where Name like ? ;");
                    pst.setString(1, where);
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
            }
            if (regexp_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where Name REGEXP ? ;");
                    pst.setString(1, where);
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
            }
        }

        if (opcion == 3) {
            if (sql_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where Continent like ? ;");
                    pst.setString(1, where);
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
            }
            if (regexp_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where Continent REGEXP ? ;");
                    pst.setString(1, where);
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
            }
        }

        if (opcion == 4) {
            if (sql_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where Region like ? ;");
                    pst.setString(1, where);
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
            }
            if (regexp_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where Region REGEXP ? ;");
                    pst.setString(1, where);
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
            }
        }

        if (opcion == 5) {
            if (sql_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where SurfaceArea like ? ;");
                    pst.setString(1, where);
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
            }
            if (regexp_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where SurfaceArea REGEXP ? ;");
                    pst.setString(1, where);
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
            }
        }

        if (opcion == 6) {
            if (sql_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where IndepYear like ? ;");
                    pst.setString(1, where);
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
            }
            if (regexp_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where IndepYear REGEXP ? ;");
                    pst.setString(1, where);
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
            }
        }

        if (opcion == 7) {
            if (sql_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where Population like ? ;");
                    pst.setString(1, where);
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
            }
            if (regexp_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where Population REGEXP ? ;");
                    pst.setString(1, where);
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
            }
        }

        if (opcion == 8) {
            if (sql_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where LifeExpectancy like ? ;");
                    pst.setString(1, where);
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
            }
            if (regexp_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where LifeExpectancy REGEXP ? ;");
                    pst.setString(1, where);
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
            }
        }

        if (opcion == 9) {
            if (sql_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where GNP like ? ;");
                    pst.setString(1, where);
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
            }
            if (regexp_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where GNP REGEXP ? ;");
                    pst.setString(1, where);
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
            }
        }

        if (opcion == 10) {
            if (sql_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where GNPOld like ? ;");
                    pst.setString(1, where);
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
            }
            if (regexp_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where GNPOld REGEXP ? ;");
                    pst.setString(1, where);
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
            }
        }

        if (opcion == 11) {
            if (sql_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where LocalName like ? ;");
                    pst.setString(1, where);
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
            }
            if (regexp_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where LocalName REGEXP ? ;");
                    pst.setString(1, where);
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
            }
        }

        if (opcion == 12) {
            if (sql_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where GovernmentForm like ? ;");
                    pst.setString(1, where);
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
            }
            if (regexp_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where GovernmentForm REGEXP ? ;");
                    pst.setString(1, where);
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
            }
        }

        if (opcion == 13) {
            if (sql_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where HeadOfState like ? ;");
                    pst.setString(1, where);
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
            }
            if (regexp_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where HeadOfState REGEXP ? ;");
                    pst.setString(1, where);
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
            }
        }

        if (opcion == 14) {
            if (sql_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where Capital like ? ;");
                    pst.setString(1, where);
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
            }
            if (regexp_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where Capital REGEXP ? ;");
                    pst.setString(1, where);
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
            }

        }

        if (opcion == 15) {
            if (sql_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where Code2 like ? ;");
                    pst.setString(1, where);
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
            }
            if (regexp_country_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            "select * from country where Code2 REGEXP ? ;");
                    pst.setString(1, where);
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
            }
        }
    }

    // -----------------------------------FIILTRO
    // CITY-----------------------------------//

    @FXML
    void doFilter_City(ActionEvent event) {

        int opcion = (combo_city.getSelectionModel().getSelectedIndex());

        String where;
        where = where_City.getText();

        Connect();
        ObservableList<City> city = FXCollections.observableArrayList();

        if (opcion == (0)) {
            if (sql_city_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            // "select * from city where " + where + ";");
                            "select * from city where ID like ? or Name like ? or District like ? or CountryCode like ? or Population like ?");
                    pst.setString(1, where);
                    pst.setString(2, where);
                    pst.setString(3, where);
                    pst.setString(4, where);
                    pst.setString(5, where);

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
            } else if (regexp_city_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            // "select * from city where " + where + ";");
                            "select * from city where ID REGEXP ? or Name REGEXP ? or District REGEXP ? or CountryCode REGEXP ? or Population REGEXP ?");
                    pst.setString(1, where);
                    pst.setString(2, where);
                    pst.setString(3, where);
                    pst.setString(4, where);
                    pst.setString(5, where);

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
            }
        }

        if (opcion == 1) {
            if (sql_city_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            // "select * from city where " + where + ";");
                            "select * from city where ID like ?;");
                    pst.setString(1, where);

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
            } else if (regexp_city_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            // "select * from city where " + where + ";");
                            "select * from city where ID REGEXP ? ;");
                    pst.setString(1, where);

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
            }
        }

        if (opcion == (2)) {
            if (sql_city_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            // "select * from city where " + where + ";");
                            "select * from city where Name like ? ;");
                    pst.setString(1, where);

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
            } else if (regexp_city_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            // "select * from city where " + where + ";");
                            "select * from city where Name REGEXP ? ;");
                    pst.setString(1, where);

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
            }
        }

        if (opcion == (3)) {
            if (sql_city_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            // "select * from city where " + where + ";");
                            "select * from city where District like ? ;");
                    pst.setString(1, where);

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
            } else if (regexp_city_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            // "select * from city where " + where + ";");
                            "select * from city where District REGEXP ? ;");
                    pst.setString(1, where);

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
            }
        }

        if (opcion == (4)) {
            if (sql_city_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            // "select * from city where " + where + ";");
                            "select * from city where CountryCode like ? ;");
                    pst.setString(1, where);

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
            } else if (regexp_city_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            // "select * from city where " + where + ";");
                            "select * from city where CountryCode REGEXP ? ;");
                    pst.setString(1, where);

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
            }
        }

        if (opcion == (5)) {
            if (sql_city_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            // "select * from city where " + where + ";");
                            "select * from city where Population like ?");
                    pst.setString(1, where);

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
            } else if (regexp_city_button.isSelected()) {
                try {
                    pst = con.prepareStatement(
                            // "select * from city where " + where + ";");
                            "select * from city where Population REGEXP ?");
                    pst.setString(1, where);

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
            }
        }
    }

    // -----------------------------------RESETS-----------------------------------//
    @FXML
    void doReset_Country(ActionEvent event) {
        table_country();
    }

    @FXML
    void doReset_City(ActionEvent event) {
        table_city();
    }

    @FXML
    void doReset_CL(ActionEvent event) {
        table_country_language();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ToggleGroup tg = new ToggleGroup();
        sql_CL_button.setToggleGroup(tg);
        regexp_CL_button.setToggleGroup(tg);

        ToggleGroup tgc = new ToggleGroup();
        sql_city_button.setToggleGroup(tgc);
        regexp_city_button.setToggleGroup(tgc);

        ToggleGroup tga = new ToggleGroup();
        sql_country_button.setToggleGroup(tga);
        regexp_country_button.setToggleGroup(tga);

        combo_CL.getItems().addAll("All", "CountryCode", "Language", "IsOfficial", "Percentage");
        combo_CL.setValue("All");

        combo_city.getItems().addAll("All", "ID", "Name", "District", "CountryCode", "Population");
        combo_city.setValue("All");

        combo_country.getItems().addAll("All", "Code", "Name", "Continent", "Region", "SurfaceArea", "IndepYear",
                "Population",
                "LifeExpectancy", "GNP", "GNPOld", "LocalName", "GovernmentForm", "HeadOfState", "Capital", "Code2");
        combo_country.setValue("All");

        Connect();
        table_city();
        table_country();
        table_country_language();
    }
}
