package client.office.officetools;

import stubs.invoice.Delivery;
import stubs.invoice.Invoice;

public class InvoiceDisplay {

    public static String invoiceToString(Invoice invoice)
    {
        StringBuilder msg = new StringBuilder();
        msg.append("[ Invoice N°");
        msg.append(invoice.getInvoiceId());
        msg.append("\n");
        msg.append("Status : ");
        msg.append(invoice.getStatus());
        msg.append("\n");
        msg.append("Price HT : ");
        msg.append(invoice.getPrice());
        msg.append("\n");
        msg.append("Price TTC : ");
        msg.append(invoice.getPrice()*1.2);
        msg.append("\n");

        msg.append("Number of deliveries : ");
        msg.append(invoice.getDeliveries().size());
        msg.append("\n");
        msg.append("List of deliveries : \n");

        for(Delivery delivery : invoice.getDeliveries())
        {
            msg.append(delivery.getDeliveryId());
            msg.append("\n");
        }

        msg.append("]");

        return msg.toString();
    }
}
