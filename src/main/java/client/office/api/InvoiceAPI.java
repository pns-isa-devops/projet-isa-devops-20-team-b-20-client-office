package client.office.api;

import java.net.URL;

import javax.xml.ws.BindingProvider;

import client.utils.api.ServiceAPI;
import stubs.invoice.InvoiceService;
import stubs.invoice.InvoiceServiceImplService;

public class InvoiceAPI extends ServiceAPI {

    private InvoiceService invoiceService;

    public InvoiceAPI(String host, String port) {
        super(host, port);
    }

    public InvoiceService getInvoiceService() {
        return this.invoiceService;
    }

    @Override
    protected void initializeService(String host, String port) {
        URL wsdlLocation = DeliveryScheduleAPI.class.getResource("/InvoiceWS.wsdl");
        InvoiceServiceImplService factory = new InvoiceServiceImplService(wsdlLocation);
        this.invoiceService = factory.getInvoiceServiceImplPort();
        String address = "http://" + host + ":" + port + "/drone-delivery-backend/webservices/InvoiceWS?wsdl";
        ((BindingProvider) invoiceService).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                address);
    }
}
