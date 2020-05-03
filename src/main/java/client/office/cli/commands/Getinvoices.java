package client.office.cli.commands;

import java.util.List;

import client.utils.cli.commands.Command;
import stubs.invoice.Delivery;
import stubs.invoice.Invoice;
import client.office.framework.ShellOffice;

public class Getinvoices extends Command {

    @Override
    public void execute(List<String> args) {
        List<Invoice> invoices = ((ShellOffice) this.shell).getInvoiceAPI().getInvoiceService().getInvoices();
        System.out.println("List of invoices :");
        for(Invoice invoice : invoices)
        {
            System.out.println(invoiceToString(invoice));
        }
    }

    @Override
    protected String help() {
        return "getInvoice : Get invoices";
    }

    public String invoiceToString(Invoice invoice) 
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