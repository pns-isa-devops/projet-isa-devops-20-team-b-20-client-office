
import client.office.api.DeliveryScheduleAPI;
import client.office.api.InvoiceAPI;
import client.office.cli.commands.Scheduledelivery;
import client.office.framework.ShellOffice;
import client.utils.cli.commands.Bye;
import client.utils.cli.commands.Help;
import client.utils.cli.framework.Shell;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        String host = (args.length == 0 ? "localhost" : args[0]);
        String port = (args.length < 2 ? "8080" : args[1]);
        System.out.println("Starting Drone Delivery OFFICE");
        System.out.println("  - Remote server: " + host);
        System.out.println("  - Port number:   " + port);
        Shell s = new ShellOffice(new DeliveryScheduleAPI(host, port), new InvoiceAPI(host, port));
        s.register(Scheduledelivery.class, Bye.class, Help.class);
        s.run();
    }

}
