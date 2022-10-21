package MODELO;

public class City {
    private String name, country_code, district;
    private int id, population;

    public City() {
        this.name = "";
        this.country_code = "";
        this.district = "";
        this.id = 0;
        this.population = 0;
    }

    public City(String name, String country_code, String district, int id, int population) {
        this.name = name;
        this.country_code = country_code;
        this.district = district;
        this.id = id;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
