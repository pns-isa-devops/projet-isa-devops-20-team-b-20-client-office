package client.office.cli.commands;

import java.util.List;

import client.utils.cli.commands.Command;
import stubs.invoice.Invoice;
import client.office.framework.ShellOffice;

public class Getinvoices extends Command {

    @Override
    public void execute(List<String> args) {
        List<Invoice> invoices = ((ShellOffice) this.shell).getInvoiceAPI().getInvoiceService().getInvoices();
        System.out.println("List of invoices :");
        for(Invoice invoice : invoices)
        {
            System.out.println(invoice.toString());
        }
    }

    @Override
    protected String help() {
        return "getInvoice : Get invoices";
    }

    

}