package startup;

import org.apache.ignite.Ignition;

public class ClientNodeSpringStartup {
    /**
     * Start up node with specified configuration.
     * 
     * @param args Command line arguments, none required.
     * @throws Exception If failed.
     **/
    public static void main(String[] args) throws Exception {
        Ignition.start("ImportedCluster-client.xml");
    }
}