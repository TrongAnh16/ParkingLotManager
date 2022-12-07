package view;

import de.vandermeer.asciitable.AT_Row;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.ArrayList;

public class ParkingTicketView {

    public static void showTicket(Car car, ParkingTicket parkingticket, ArrayList<ParkingTicket> assignedspotlist) {
        AsciiTable tb1 = new AsciiTable();
        tb1.addRule();
        AT_Row titleRow = tb1.addRow(null, null, null, null, null, "Parking Ticket");
        titleRow.getCells().get(5).getContext().setTextAlignment(TextAlignment.CENTER);
        tb1.addRule();
        tb1.addRow("Car Number", "Car Color", "Car Type", "Parking Time", "Parking Date", "Spot Number");
        tb1.addRule();
        tb1.addRow(car.getNumberPlate(), car.getCarColor(), car.getCarType(), parkingticket.getTime(), parkingticket.getDate(), parkingticket.getSpotNumber());
        tb1.addRule();
        assignedspotlist.add(parkingticket);
        AT_Row ttRow = tb1.addRow(null, null, null, null, null, "Size spot list: " + assignedspotlist.size());
        ttRow.getCells().get(5).getContext().setTextAlignment(TextAlignment.CENTER);
        tb1.addRule();
        System.out.println(tb1.render());
    }
}
