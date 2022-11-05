package MODELO;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Country {
    // private String code, name, continent, region, local_name, government_form,
    // head_state, code2;
    // private float surface_area, life_expectancy, gnp, gnp_old;
    // private int indep_year, population, capital;

    // public Country() {
    // this.code = "";
    // this.name = "";
    // this.continent = "";
    // this.region = "";
    // this.local_name = "";
    // this.government_form = "";
    // this.head_state = "";
    // this.code2 = "";
    // this.surface_area = 0;
    // this.life_expectancy = 0;
    // this.gnp = 0;
    // this.gnp_old = 0;
    // this.indep_year = 0;
    // this.population = 0;
    // this.capital = 0;
    // }

    private final StringProperty code;
    private final StringProperty name;
    private final StringProperty continent;
    private final StringProperty region;
    private final StringProperty local_name;
    private final StringProperty government_form;
    private final StringProperty head_state;
    private final StringProperty code2;
    private final StringProperty surface_area;
    private final StringProperty life_expectancy;
    private final StringProperty gnp;
    private final StringProperty gnp_old;
    private final StringProperty indep_year;
    private final StringProperty population;
    private final StringProperty capital;

    public Country() {

        code = new SimpleStringProperty(this, "code");
        name = new SimpleStringProperty(this, "name");
        continent = new SimpleStringProperty(this, "continent");
        region = new SimpleStringProperty(this, "region");
        local_name = new SimpleStringProperty(this, "local_name");
        government_form = new SimpleStringProperty(this, "government_form");
        head_state = new SimpleStringProperty(this, "head_state");
        code2 = new SimpleStringProperty(this, "code2");
        surface_area = new SimpleStringProperty(this, "surface_area");
        life_expectancy = new SimpleStringProperty(this, "life_expectancy");
        gnp = new SimpleStringProperty(this, "gnp");
        gnp_old = new SimpleStringProperty(this, "gnp_old");
        indep_year = new SimpleStringProperty(this, "indep_year");
        population = new SimpleStringProperty(this, "population");
        capital = new SimpleStringProperty(this, "capital");
    }

    public String getCode() {
        return code.get();
    }

    public void setCode(String newcode) {
        code.set(newcode);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String newname) {
        name.set(newname);
    }

    public String getContinent() {
        return continent.get();
    }

    public void setContinent(String newcontinent) {
        continent.set(newcontinent);
    }

    public String getRegion() {
        return region.get();
    }

    public void setRegion(String newregion) {
        region.set(newregion);
    }

    public String getLocal_name() {
        return local_name.get();
    }

    public void setLocal_name(String newlocal_name) {
        local_name.set(newlocal_name);
    }

    public String getGovernment_form() {
        return government_form.get();
    }

    public void setGovernment_form(String newgovernment_form) {
        government_form.set(newgovernment_form);
    }

    public String getHead_state() {
        return head_state.get();
    }

    public void setHead_state(String newhead_state) {
        head_state.set(newhead_state);
    }

    public String getCode2() {
        return code2.get();
    }

    public void setCode2(String newcode2) {
        code2.set(newcode2);
    }

    public String getSurface_area() {
        return surface_area.get();
    }

    public void setSurface_area(String newsurface_area) {
        surface_area.set(newsurface_area);
    }

    public String getLife_expectancy() {
        return life_expectancy.get();
    }

    public void setLife_expectancy(String newlife_expectancy) {
        life_expectancy.set(newlife_expectancy);
    }

    public String getGnp() {
        return gnp.get();
    }

    public void setGnp(String newgnp) {
        gnp.set(newgnp);
    }

    public String getGnp_old() {
        return gnp_old.get();
    }

    public void setGnp_old(String newgnp_old) {
        gnp_old.set(newgnp_old);
    }

    public String getIndep_year() {
        return indep_year.get();
    }

    public void setIndep_year(String newindep_year) {
        indep_year.set(newindep_year);
    }

    public String getPopulation() {
        return population.get();
    }

    public void setPopulation(String newpopulation) {
        population.set(newpopulation);
    }

    public String getCapital() {
        return capital.get();
    }

    public void setCapital(String newcapital) {
        capital.set(newcapital);
    }

    public StringProperty codeProperty() {
        return code;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty continentPropoerty() {
        return continent;
    }

    public StringProperty regionProperty() {
        return region;
    }

    public StringProperty local_nameProperty() {
        return local_name;
    }

    public StringProperty government_formProperty() {
        return government_form;
    }

    public StringProperty head_stateProperty() {
        return head_state;
    }

    public StringProperty code2Property() {
        return code2;
    }

    public StringProperty surface_areaProperty() {
        return surface_area;
    }

    public StringProperty life_expectancyProperty() {
        return life_expectancy;
    }

    public StringProperty gnpProperty() {
        return gnp;
    }

    public StringProperty gnp_oldProperty() {
        return gnp_old;
    }

    public StringProperty indep_yearProperty() {
        return indep_year;
    }

    public StringProperty populationProperty() {
        return population;
    }

    public StringProperty capitalProperty() {
        return capital;
    }
}
