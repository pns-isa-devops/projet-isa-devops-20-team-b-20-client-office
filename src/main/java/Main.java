import api.DeliveryScheduleAPI;
import cli.commands.ScheduleDelivery;
import cli.framework.Shell;

import cli.commands.Bye;
import cli.commands.Help;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        String host = (args.length == 0 ? "localhost" : args[0]);
        String port = (args.length < 2 ? "8080" : args[1]);
        System.out.println("Starting Drone Delivery OFFICE");
        System.out.println("  - Remote server: " + host);
        System.out.println("  - Port number:   " + port);
        Shell s = new Shell(new DeliveryScheduleAPI(host, port));
        s.register(ScheduleDelivery.class, Bye.class, Help.class);
        s.run();
    }

}
