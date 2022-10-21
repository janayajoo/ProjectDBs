package MODELO;

public class Country {
    private String code, name, continent, region, local_name, government_form, head_state, code2;
    private float surface_area, life_expectancy, gnp, gnp_old;
    private int indep_year, population, capital;

    public Country() {
        this.code = "";
        this.name = "";
        this.continent = "";
        this.region = "";
        this.local_name = "";
        this.government_form = "";
        this.head_state = "";
        this.code2 = "";
        this.surface_area = 0;
        this.life_expectancy = 0;
        this.gnp = 0;
        this.gnp_old = 0;
        this.indep_year = 0;
        this.population = 0;
        this.capital = 0;
    }

    public Country(String code, String name, String continent, String region, String local_name, String government_form, String head_state, String code2, float surface_area, float life_expectancy, float gnp, float gnp_old, int indep_year, int population, int capital) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.local_name = local_name;
        this.government_form = government_form;
        this.head_state = head_state;
        this.code2 = code2;
        this.surface_area = surface_area;
        this.life_expectancy = life_expectancy;
        this.gnp = gnp;
        this.gnp_old = gnp_old;
        this.indep_year = indep_year;
        this.population = population;
        this.capital = capital;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLocal_name() {
        return local_name;
    }

    public void setLocal_name(String local_name) {
        this.local_name = local_name;
    }

    public String getGovernment_form() {
        return government_form;
    }

    public void setGovernment_form(String government_form) {
        this.government_form = government_form;
    }

    public String getHead_state() {
        return head_state;
    }

    public void setHead_state(String head_state) {
        this.head_state = head_state;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public float getSurface_area() {
        return surface_area;
    }

    public void setSurface_area(float surface_area) {
        this.surface_area = surface_area;
    }

    public float getLife_expectancy() {
        return life_expectancy;
    }

    public void setLife_expectancy(float life_expectancy) {
        this.life_expectancy = life_expectancy;
    }

    public float getGnp() {
        return gnp;
    }

    public void setGnp(float gnp) {
        this.gnp = gnp;
    }

    public float getGnp_old() {
        return gnp_old;
    }

    public void setGnp_old(float gnp_old) {
        this.gnp_old = gnp_old;
    }

    public int getIndep_year() {
        return indep_year;
    }

    public void setIndep_year(int indep_year) {
        this.indep_year = indep_year;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }
}
