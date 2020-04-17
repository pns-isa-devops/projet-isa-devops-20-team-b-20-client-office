package framework;

import api.DeliveryScheduleAPI;
import cli.framework.Shell;

public class ShellOffice extends Shell {
    
    private DeliveryScheduleAPI deliveryScheduleAPI;

    public ShellOffice(DeliveryScheduleAPI deliveryScheduleAPI) {
        this.deliveryScheduleAPI = deliveryScheduleAPI;
    }

    public DeliveryScheduleAPI getDeliveryServiceAPI() {
        return deliveryScheduleAPI;
    }

}