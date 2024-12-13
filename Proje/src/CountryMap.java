import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class CountryMap {
    private City[] cities ;
    private Route[] routes ;
    private int cityCount;
    private int routeCount;
    private City[] firstLastCity;

    public CountryMap() {
        try{
            Scanner sc = new Scanner(new FileReader("map.txt"));
            this.cityCount = Integer.parseInt(sc.nextLine());
            String[] array = sc.nextLine().split(" ");

            this.cities = new City[cityCount];
            for(int i = 0;i < cityCount;i++){
                this.cities[i] = new City();
                this.cities[i].setCityLabel(array[i]);
            }
            this.routeCount = Integer.parseInt(sc.nextLine());
            this.routes = new Route[routeCount];

            for(int i = 0;i<routeCount;i++){
                String[] tempArray = new String[3];
                tempArray = sc.nextLine().split(" ");
                this.routes[i] = new Route();
                this.routes[i].setFirstCity(tempArray[0]);
                this.routes[i].setFirstCity(tempArray[1]);
                this.routes[i].setFirstCity(tempArray[2]);
            }
            this.firstLastCity = new City[2];
            String[] tempArray = sc.nextLine().split(" ");
            this.firstLastCity[0].setCityLabel(tempArray[0]);
            this.firstLastCity[1].setCityLabel(tempArray[1]);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public City[] getCities() {
        return cities;
    }

    public void setCities(City[] cities) {
        this.cities = cities;
    }

    public Route[] getRoutes() {
        return routes;
    }

    public void setRoutes(Route[] routes) {
        this.routes = routes;
    }

    public int getCityCount() {
        return cityCount;
    }

    public void setCityCount(int cityCount) {
        this.cityCount = cityCount;
    }

    public int getRouteCount() {
        return routeCount;
    }

    public void setRouteCount(int routeCount) {
        this.routeCount = routeCount;
    }

    public City[] getFirstLastCity() {
        return firstLastCity;
    }

    public void setFirstLastCity(City[] firstLastCity) {
        this.firstLastCity = firstLastCity;
    }


}

