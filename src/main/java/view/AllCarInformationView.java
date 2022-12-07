package view;

import de.vandermeer.asciitable.AT_Row;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.ArrayList;

public class AllCarInformationView {
    public static void showInformation(Car car, ParkingTicket parkingticket, ArrayList<ParkingTicket> assignedspotlist) {
        ParkingTicketService parkingTicketService = new ParkingTicketService();
        AsciiTable table = new AsciiTable();
        table.addRule();
        AT_Row titleRow = table.addRow(null, null, null, null, "All Car Information");
        titleRow.getCells().get(4).getContext().setTextAlignment(TextAlignment.CENTER);
        table.addRule();
        table.addRow("Car Number", "Car Color", "Car Type", "Parking Time", "Parking Date");
        table.addRule();
        for (ParkingTicket pt : parkingTicketService.getAllTickets()) {
            table.addRow(pt.getAssignedCar().getNumberPlate(), pt.getAssignedCar().getCarColor(),
                    pt.getAssignedCar().getCarType(), pt.getTime(), pt.getDate());
            table.addRule();
        }
        System.out.println(table.render());
    }
}
