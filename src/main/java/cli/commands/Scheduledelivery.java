package cli.commands;

import stubs.delivery.Exception_Exception;

import java.util.List;

public class Scheduledelivery extends Command {
    @Override
    public void execute(List<String> args) {
        if(args.size()<2) {
            System.err.println("No delivery number selected");
            return;
        }
        System.out.println(String.format("Scheduling delivery : %s for %s", args.get(1), args.get(0)));
        try {
            ((DroneDeliveryAPI)this.shell.getDroneDeliveryAPI()).deliveries.scheduleDelivery(args.get(0), args.get(1));
        } catch (Exception_Exception e) {
            e.printStackTrace();
        }
        System.out.println("Delivery scheduled");
    }

    @Override
    String help() {
        return "Scheduling delivery";
    }
}
