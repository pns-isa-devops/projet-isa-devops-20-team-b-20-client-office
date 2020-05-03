package client.office.cli.commands;

import client.office.framework.ShellOffice;
import client.utils.cli.commands.Command;
import stubs.analytics.Exception_Exception;

import java.util.List;

public class Occupancy extends Command {
    @Override
    public void execute(List<String> args) {
        if (args.size() < 1) {
            System.err.println("Not enough arguments");
            System.err.println("occupancy <droneID>");
            return;
        }
        try {
           System.out.println( ((ShellOffice) this.shell).getAnalyticsAPI().getAnalyticsService()
                    .getOccupancyRate(args.get(0))*100 +"%");

        } catch (Exception_Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    protected String help() {
        return "occupancy <drone> : returns the occupancy rate of this drone";
    }
}
