package client.office.cli.commands;

import java.util.List;

import client.office.officetools.InvoiceDisplay;
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
            System.out.println(InvoiceDisplay.invoiceToString(invoice));
        }
    }

    @Override
    protected String help() {
        return "getInvoice : Get invoices";
    }

}