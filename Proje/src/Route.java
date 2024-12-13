public class Route {
    String firstCity;
    String secondCity;
    int time;



    public Route(String city1, String city2, int time) {
        this.firstCity = city1;
        this.secondCity = city2;
        this.time = time;
    }

    public Route() {

    }

    public String getFirstCity() {
        return firstCity;
    }

    public String getSecondCity() {
        return secondCity;
    }

    public int getTime() {
        return time;
    }

    public void setFirstCity(String firstCity) {
        this.firstCity = firstCity;
    }

    public void setSecondCity(String secondCity) {
        this.secondCity = secondCity;
    }

    public void setTime(int time) {
        this.time = time;
    }

}