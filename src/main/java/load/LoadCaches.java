package load;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;

public class LoadCaches {

    public static void main(String[] args) throws Exception {
        try (Ignite ignite = Ignition.start("ImportedCluster-client.xml")) {
            System.out.println(">>> Loading caches...");

            System.out.println(">>> Loading cache: CityCache");
            ignite.cache("CityCache").loadCache(null);

            System.out.println(">>> Loading cache: CountryCache");
            ignite.cache("CountryCache").loadCache(null);

            System.out.println(">>> Loading cache: CountrylanguageCache");
            ignite.cache("CountrylanguageCache").loadCache(null);

            System.out.println(">>> All caches loaded!");
        }
    }
}