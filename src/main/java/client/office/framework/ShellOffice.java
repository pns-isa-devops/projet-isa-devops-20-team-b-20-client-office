package client.office.framework;

import client.office.api.AnalyticsAPI;
import client.office.api.DeliveryScheduleAPI;
import client.utils.cli.framework.Shell;

public class ShellOffice extends Shell {

    private DeliveryScheduleAPI deliveryScheduleAPI;
    private AnalyticsAPI analyticsAPI;

    public ShellOffice(DeliveryScheduleAPI deliveryScheduleAPI,AnalyticsAPI analyticsAPI) {
        super("client.office.cli.commands");
        this.deliveryScheduleAPI = deliveryScheduleAPI;
        this.analyticsAPI = analyticsAPI;
    }

    public DeliveryScheduleAPI getDeliveryServiceAPI() {
        return deliveryScheduleAPI;
    }
    public AnalyticsAPI getAnalyticsAPI() { return analyticsAPI; }

}
