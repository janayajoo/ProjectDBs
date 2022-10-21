package MODELO;

public class CountryLanguage {
    private String country_code, language;
    private float percentage;
    private boolean is_official;

    public CountryLanguage() {
        this.country_code = "";
        this.language = "";
        this.percentage = 0;
        this.is_official = false;
    }

    public CountryLanguage(String country_code, String language, float percentage, boolean is_official) {
        this.country_code = country_code;
        this.language = language;
        this.percentage = percentage;
        this.is_official = is_official;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public boolean isIs_official() {
        return is_official;
    }

    public void setIs_official(boolean is_official) {
        this.is_official = is_official;
    }
}
