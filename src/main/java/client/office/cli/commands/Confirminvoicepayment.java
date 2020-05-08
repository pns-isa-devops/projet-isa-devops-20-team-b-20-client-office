package client.office.cli.commands;

import java.util.List;

import client.office.framework.ShellOffice;
import client.office.officetools.InvoiceDisplay;
import client.utils.cli.commands.Command;
import stubs.invoice.Invoice;

public class Confirminvoicepayment extends Command {
    @Override
    public void execute(List<String> args) {
        Invoice invoice;
        if (args.size() != 1) {
            System.err.println("wrong number of arguments");
            System.err.println("ConfirmInvoicePayment <invoiceID>");
            return;
        }
        try {
            invoice = ((ShellOffice) this.shell).getInvoiceAPI().getInvoiceService().confirmInvoicePayment(args.get(0));
            System.out.println(InvoiceDisplay.invoiceToString(invoice));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected String help() {
        return "confirminvoicepayment <invoiceID> : tag an invoice as paid";
    }
}
