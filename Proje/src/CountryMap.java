public class CountryMap {
    private int cityCount;
    private String[] cities;
    private String[][] cityDistances;
    private String lastLine;

    public CountryMap(int cityCount, String[] cities, String[][] cityDistances, String lastLine) {
        this.cityCount = cityCount;
        this.cities = cities;
        this.cityDistances = cityDistances;
        this.lastLine = lastLine;
    }

    public int getCityCount() {
        return cityCount;
    }

    public void setCityCount(int cityCount) {
        this.cityCount = cityCount;
    }

    public String[] getCities() {
        return cities;
    }

    public void setCities(String[] cities) {
        this.cities = cities;
    }

    public String[][] getCityDistances() {
        return cityDistances;
    }

    public void setCityDistances(String[][] cityDistances) {
        this.cityDistances = cityDistances;
    }

    public String getLastLine() {
        return lastLine;
    }

    public void setLastLine(String lastLine) {
        this.lastLine = lastLine;
    }
}
