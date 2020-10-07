package startup;

import cl.falabella.pnigam.model.Address;
import config.ServerConfigurationFactory;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.client.ClientCache;

import java.util.Timer;
import java.util.TimerTask;

public class ServerNodeCodeStartup {
    /**
     * Start up node with specified configuration.
     * 
     * @param args Command line arguments, none required.
     * @throws Exception If failed.
     **/

    public static  final String CACHE_NAME = "put-get-falabella-example";
    public static final int THRESHOLD = 10000;

    public static void main(String[] args) throws Exception {
        final Ignite ignite = Ignition.start(ServerConfigurationFactory.createConfiguration());

        //final IgniteCache cache = ignite.cache("test-cache");
        final IgniteCache<Object, Object> cache = ignite.getOrCreateCache(CACHE_NAME);
        new Timer().schedule(new TimerTask() {
            @Override public void run() {
                System.out.println("client average put time = " + cache.metrics().getAveragePutTime());
                System.out.println("client average get time = " + cache.metrics().getAverageGetTime());
            }
        }, 1000, 2000);

        //Generating dummy load.
        while (true) {
            for (int i = 0; i < 1000; i++) {
                cache.put(i, i);
            }

            for (int i = 0; i < 500; i++) {
                cache.get(i);
            }
        }
    }
}