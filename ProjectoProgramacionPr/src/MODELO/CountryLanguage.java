package MODELO;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CountryLanguage {
    private final StringProperty country_code;
    private final StringProperty language;
    private final StringProperty percentage;
    private final StringProperty is_official;

    public CountryLanguage() {
        country_code = new SimpleStringProperty(this, "country_code");
        language = new SimpleStringProperty(this, "language");
        percentage = new SimpleStringProperty(this, "percentage");
        is_official = new SimpleStringProperty(this, "is_official");
    }

    public String getCountry_code() {
        return country_code.get();
    }

    public void setCountry_code(String newcountry_code) {
        country_code.set(newcountry_code);
    }

    public String getLanguage() {
        return language.get();
    }

    public void setLenguage(String newlanguage) {
        language.set(newlanguage);
    }

    public String getPercentage() {
        return percentage.get();
    }

    public void setPercentage(String newpercentage) {
        percentage.set(newpercentage);
    }

    public String getIs_official() {
        return is_official.get();
    }

    public void setIs_official(String newis_official) {
        is_official.set(newis_official);
    }

    public StringProperty cProperty() {
        return country_code;
    }

    public StringProperty languageProperty() {
        return language;
    }

    public StringProperty percentageProperty() {
        return percentage;
    }

    public StringProperty is_officialProperty() {
        return is_official;
    }
}
