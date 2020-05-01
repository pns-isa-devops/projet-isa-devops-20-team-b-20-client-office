package client.office.cli.commands;

import java.util.List;

import client.office.framework.ShellOffice;
import client.utils.cli.commands.Command;

public class Scheduledelivery extends Command {
    @Override
    public void execute(List<String> args) {
        if (args.size() < 2) {
            System.err.println("Not enough arguments");
            System.err.println("scheduledelivery <HH:mm> <deliveryID>");
            return;
        }
        try {
            System.out.println(String.format("Scheduling delivery : %s for %s", args.get(1), args.get(0)));
            ((ShellOffice) this.shell).getDeliveryServiceAPI().getDeliveryScheduleService()
                    .scheduleDelivery(args.get(0), args.get(1));
            System.out.println("Delivery scheduled!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected String help() {
        return "scheduledelivery <HH:mm> <deliveryID> : Schedules the specified delivery at the specified hour.";
    }
}
