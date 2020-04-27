package client.office.framework;

import client.office.api.DeliveryScheduleAPI;
import client.office.api.InvoiceAPI;
import client.utils.cli.framework.Shell;

public class ShellOffice extends Shell {

    private DeliveryScheduleAPI deliveryScheduleAPI;
    private InvoiceAPI invoiceAPI;

    public ShellOffice(DeliveryScheduleAPI deliveryScheduleAPI, InvoiceAPI invoiceAPI) {
        super("client.office.cli.commands");
        this.deliveryScheduleAPI = deliveryScheduleAPI;
        this.invoiceAPI = invoiceAPI;
    }

    public DeliveryScheduleAPI getDeliveryServiceAPI() {
        return deliveryScheduleAPI;
    }

    public InvoiceAPI getInvoiceAPI() {
        return invoiceAPI;
    }

}
