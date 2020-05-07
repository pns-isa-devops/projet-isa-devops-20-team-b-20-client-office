package client.office.cli.commands;

import java.util.List;

import client.utils.cli.commands.Command;
import stubs.delivery.TimeState;
import client.office.framework.ShellOffice;

public class Getplanning extends Command {

    public static final int STARTING_HOUR = 8;

    @Override
    public void execute(List<String> args) {
        if (args.size() < 1) {
            System.err.println("Not enough arguments");
            System.err.println("getplanning : <droneID>");
            return;
        }
        try {
            List<TimeState> states = ((ShellOffice) this.shell).getDeliveryServiceAPI().getDeliveryScheduleService()
                    .getCurrentPlanning(args.get(0));
            for(int i=0; i<states.size(); i++)
            {
                System.out.printf("[%d:%d] %s |", getHour(i), getMinute(i), states.get(i).toString());
            }
        } catch (Exception e) {
            System.out.printf("Drone %s n'existe pas\n", args.get(0));
        }
    }

    private int getMinute(int i) {
        return i%4 * 15;
    }

    private int getHour(int i) {
        return i/4 + STARTING_HOUR;
    }

    @Override
    protected String help() {
        // TODO Auto-generated method stub
        return null;
    }
    
}