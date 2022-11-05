package MODELO;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class City {
    // private String name, country_code, district;
    // private int id, population;

    private final StringProperty name;
    private final StringProperty country_code;
    private final StringProperty district;
    private final StringProperty id;
    private final StringProperty population;

    public City() {

        id = new SimpleStringProperty(this, "id");
        name = new SimpleStringProperty(this, "name");
        country_code = new SimpleStringProperty(this, "country_code");
        district = new SimpleStringProperty(this, "district");
        population = new SimpleStringProperty(this, "population");
    }

    // this.name = "";
    // this.country_code = "";
    // this.district = "";
    // this.id = 0;
    // this.population = 0;
    // }

    // public City(String name, String country_code, String district, int id, int
    // population) {
    // this.name = name;
    // this.country_code = country_code;
    // this.district = district;
    // this.id = id;
    // this.population = population;
    // }

    public String getName() {
        return name.get();
    }

    public void setName(String newname) {
        name.set(newname);
    }

    public String getCountry_code() {
        return country_code.get();
    }

    public void setCountry_code(String newcountry_code) {
        country_code.set(newcountry_code);
    }

    public String getDistrict() {
        return district.get();
    }

    public void setDistrict(String newdistrict) {
        district.set(newdistrict);
    }

    public String getId() {
        return id.get();
    }

    public void setId(String newid) {
        id.set(newid);
    }

    public String getPopulation() {
        return population.get();
    }

    public void setPopulation(String newpopulation) {
        population.set(newpopulation);
        ;
    }

    public StringProperty idProperty() {
        return id;
    }

    public StringProperty namProperty() {
        return name;
    }

    public StringProperty dStringProperty() {
        return district;
    }

    public StringProperty codeProperty() {
        return country_code;
    }

    public StringProperty pStringProperty() {
        return population;
    }
}
