package api;

import stubs.delivery.DeliveryScheduleService;
import stubs.delivery.DeliveryScheduleServiceImplService;

import javax.xml.ws.BindingProvider;
import java.net.URL;

public class DeliveryScheduleAPI extends ServiceAPI {

    private DeliveryScheduleService deliveryScheduleService;

    public DeliveryScheduleAPI(String host, String port) {
        super(host, port);
    }

    public DeliveryScheduleService getDeliveryScheduleService(){
        return this.deliveryScheduleService;
    }

    @Override
    protected void initializeService(String host, String port) {
        URL wsdlLocation = DeliveryScheduleAPI.class.getResource("/DeliveryScheduleWS.wsdl");
        DeliveryScheduleServiceImplService factory = new DeliveryScheduleServiceImplService(wsdlLocation);
        this.deliveryScheduleService = factory.getDeliveryScheduleServiceImplPort();
        String address = "http://" + host + ":" + port + "/drone-delivery-backend/webservices/DeliveryScheduleWS?wsdl";
        ((BindingProvider) deliveryScheduleService).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
    }
}
