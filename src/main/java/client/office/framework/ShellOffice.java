package client.office.framework;

import client.office.api.DeliveryScheduleAPI;
import client.utils.cli.framework.Shell;

public class ShellOffice extends Shell {

    private DeliveryScheduleAPI deliveryScheduleAPI;

    public ShellOffice(DeliveryScheduleAPI deliveryScheduleAPI) {
        super("client.office.cli.commands");
        this.deliveryScheduleAPI = deliveryScheduleAPI;
    }

    public DeliveryScheduleAPI getDeliveryServiceAPI() {
        return deliveryScheduleAPI;
    }

}
