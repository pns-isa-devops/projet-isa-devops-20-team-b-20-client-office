package client.office.framework;

import client.office.api.AnalyticsAPI;
import client.office.api.DeliveryScheduleAPI;
import client.office.api.InvoiceAPI;
import client.utils.cli.framework.Shell;

public class ShellOffice extends Shell {

    private DeliveryScheduleAPI deliveryScheduleAPI;
    private AnalyticsAPI analyticsAPI;
    private InvoiceAPI invoiceAPI;

    public ShellOffice(DeliveryScheduleAPI deliveryScheduleAPI,AnalyticsAPI analyticsAPI, InvoiceAPI invoiceAPI) {
        super("client.office.cli.commands");
        this.deliveryScheduleAPI = deliveryScheduleAPI;
        this.analyticsAPI = analyticsAPI;
        this.invoiceAPI = invoiceAPI;
    }

    public DeliveryScheduleAPI getDeliveryServiceAPI() {
        return deliveryScheduleAPI;
    }
    public AnalyticsAPI getAnalyticsAPI() { return analyticsAPI; }

    public InvoiceAPI getInvoiceAPI() {
        return invoiceAPI;
    }

}
