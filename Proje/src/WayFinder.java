public class WayFinder {

    public void wayfinder(CountryMap map) {

        City[] cities = map.getCities();
        Route[] routes = map.getRoutes();
        City ilk = map.getFirstLastCity()[0];
        City son = map.getFirstLastCity()[1];

        int cityCount = map.getCityCount();


        int[] mesafeler = new int[cityCount];
        boolean[] visited = new boolean[cityCount];
        int[] prev = new int[cityCount];


        String[] cityLabels = new String[cityCount];
        for (int i = 0; i < cityCount; i++) {
            cityLabels[i] = cities[i].getCityLabel();
            prev[i] = -1;
        }


        int startInx = findCity(ilk.getCityLabel(), cityLabels);
        int endInx = findCity(son.getCityLabel(), cityLabels);


        for (int i = 0; i < cityCount; i++) {
            mesafeler[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        mesafeler[startInx] = 0;


        for (int i = 0; i < cityCount; i++) {

            int currentCityInx = foundedMinDistanceInx(mesafeler, visited);
            if (currentCityInx == -1) break;

            visited[currentCityInx] = true;


            for (Route route : routes) {
                int neighborInx = -1;
                if (route.getFirstCity().equals(cityLabels[currentCityInx])) {
                    neighborInx = findCity(route.getSecondCity(), cityLabels);
                } else if (route.getSecondCity().equals(cityLabels[currentCityInx])) {
                    neighborInx = findCity(route.getFirstCity(), cityLabels);
                }

                if (neighborInx != -1 && !visited[neighborInx]) {
                    int newDist = mesafeler[currentCityInx] + route.getTime();
                    if (newDist < mesafeler[neighborInx]) {
                        mesafeler[neighborInx] = newDist;
                        prev[neighborInx] = currentCityInx;
                    }
                }
            }
        }


        if (mesafeler[endInx] == Integer.MAX_VALUE) {
            System.out.println("No path found from " + ilk.getCityLabel() + " to " + son.getCityLabel());
        } else {
            System.out.print("Fastest Way: ");
            path(prev, endInx, cityLabels);
            System.out.println("\nTotal Time: " + mesafeler[endInx] + " min");
        }
    }

    private int findCity(String cityLabel, String[] cityLabels) {
        for (int i = 0; i < cityLabels.length; i++) {
            if (cityLabels[i].equals(cityLabel)) {
                return i;
            }
        }
        return -1;
    }

    private int foundedMinDistanceInx(int[] distances, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int minInx = -1;

        for (int i = 0; i < distances.length; i++) {
            if (!visited[i] && distances[i] < minDistance) {
                minDistance = distances[i];
                minInx = i;
            }
        }

        return minInx;
    }

    private void path(int[] previous, int currentInx, String[] cityLabels) {

        String[] path = new String[cityLabels.length];
        int pathInx = 0;

        while (currentInx != -1) {
            path[pathInx++] = cityLabels[currentInx];
            currentInx = previous[currentInx];
        }

        for (int i = pathInx - 1; i >= 0; i--) {
            System.out.print(path[i]);
            if (i > 0) {
                System.out.print(" -> ");
            }
        }
    }

}
