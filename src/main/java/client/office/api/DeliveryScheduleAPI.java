package client.office.api;

import java.net.URL;

import javax.xml.ws.BindingProvider;

import client.utils.api.ServiceAPI;
import stubs.delivery.DeliveryScheduleService;
import stubs.delivery.DeliveryScheduleServiceImplService;

public class DeliveryScheduleAPI extends ServiceAPI {

    private DeliveryScheduleService deliveryScheduleService;

    public DeliveryScheduleAPI(String host, String port) {
        super(host, port);
    }

    public DeliveryScheduleService getDeliveryScheduleService() {
        return this.deliveryScheduleService;
    }

    @Override
    protected void initializeService(String host, String port) {
        URL wsdlLocation = DeliveryScheduleAPI.class.getResource("/DeliveryScheduleWS.wsdl");
        DeliveryScheduleServiceImplService factory = new DeliveryScheduleServiceImplService(wsdlLocation);
        this.deliveryScheduleService = factory.getDeliveryScheduleServiceImplPort();
        String address = "http://" + host + ":" + port + "/drone-delivery-backend/webservices/DeliveryScheduleWS?wsdl";
        ((BindingProvider) deliveryScheduleService).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                address);
    }
}
