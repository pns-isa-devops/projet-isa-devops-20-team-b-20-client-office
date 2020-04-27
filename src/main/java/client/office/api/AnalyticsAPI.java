package client.office.api;
import javax.xml.ws.BindingProvider;

import client.utils.api.ServiceAPI;
import stubs.analytics.AnalyticsService;
import stubs.analytics.AnalyticsServiceImplService;

import java.net.URL;

public class AnalyticsAPI extends ServiceAPI {

    private AnalyticsService analyticsService;

    public AnalyticsAPI(String host, String port) {
        super(host, port);
    }

    public AnalyticsService getAnalyticsService() {
        return this.analyticsService;
    }


    @Override
    protected void initializeService(String host, String port) {
        URL wsdlLocation = AnalyticsAPI.class.getResource("/AnalyticsWS.wsdl");
        AnalyticsServiceImplService factory = new AnalyticsServiceImplService(wsdlLocation);
        this.analyticsService = factory.getAnalyticsServiceImplPort();
        String address = "http://" + host + ":" + port + "/drone-delivery-backend/webservices/AnalyticsWS?wsdl";
        ((BindingProvider) analyticsService).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                address);

    }
}
