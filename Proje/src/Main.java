import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Usage: java Main <filename>");
            return;
        }

        String fileName = args[0];
        Scanner sc = null;

        try {
            sc = new Scanner(Paths.get(fileName));
            CountryMap countryMap = new CountryMap(sc);
            WayFinder wayFinder = new WayFinder();
            wayFinder.wayfinder(countryMap);
        } catch (IOException e) {
            System.out.println("dosya bulunamadi!");
        }finally {
            sc.close();
        }

    }
}
