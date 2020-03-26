package api;

import stubs.delivery.DeliveryService;
import stubs.delivery.DeliveryServiceImplService;

import javax.xml.ws.BindingProvider;
import java.net.URL;

public class DroneDeliveryAPI implements API {
    public DeliveryService deliveries;

    public DroneDeliveryAPI(String host, String port) {
        initDeliveries(host, port);
    }

    public void initDeliveries(String host, String port)
    {
        URL wsdlLocation = DroneDeliveryAPI.class.getResource("/DeliveryWS.wsdl");
        DeliveryServiceImplService factory = new DeliveryServiceImplService(wsdlLocation);
        this.deliveries = factory.getDeliveryServiceImplPort();
        String address = "http://" + host + ":" + port + "/drone-delivery-backend/webservices/DeliveryWS?wsdl";
        ((BindingProvider) deliveries).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
    }
}
