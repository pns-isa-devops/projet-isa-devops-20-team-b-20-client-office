package cli.commands;

import api.DroneDeliveryAPI;
import stubs.delivery.Exception_Exception;

import java.util.List;

public class Scheduledelivery extends Command {
    @Override
    public void execute(List<String> args) {
        if (args.size() < 2) {
            System.err.println("Not enough arguments");
            System.err.println("scheduledelivery <HH:mm> <deliveryID>");
            return;
        }
        System.out.println(String.format("Scheduling delivery : %s for %s", args.get(1), args.get(0)));
        try {
            boolean status = ((DroneDeliveryAPI) this.shell.getDroneDeliveryAPI()).deliveries.scheduleDelivery(args.get(0), args.get(1));
            if (status)  System.out.println("Delivery scheduled");
            else System.out.println("Time slot not available");
        } catch (Exception_Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    String help() {
        return "Scheduling delivery";
    }
}
