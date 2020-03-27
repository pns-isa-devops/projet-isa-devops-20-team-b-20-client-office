package api;

import stubs.delivery.DeliveryScheduleService;
import stubs.delivery.DeliveryScheduleServiceImplService;

import javax.xml.ws.BindingProvider;
import java.net.URL;

public class DroneDeliveryAPI implements API {
    public DeliveryScheduleService deliveries;

    public DroneDeliveryAPI(String host, String port) {
        initDeliveries(host, port);
    }

    public void initDeliveries(String host, String port) {
        URL wsdlLocation = DroneDeliveryAPI.class.getResource("/DeliveryScheduleWS.wsdl");
        DeliveryScheduleServiceImplService factory = new DeliveryScheduleServiceImplService(wsdlLocation);
        this.deliveries = factory.getDeliveryScheduleServiceImplPort();
        String address = "http://" + host + ":" + port + "/drone-delivery-backend/webservices/DeliveryScheduleWS?wsdl";
        ((BindingProvider) deliveries).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
    }
}
