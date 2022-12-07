package view;

import java.util.List;

public class ParkingSpot {
    private ParkingTicketService parkingTicketService;
    private List<ParkingTicket> tickets;
    public  ParkingSpot(){
        parkingTicketService = new ParkingTicketService();
        tickets = parkingTicketService.getAllTickets();
    }
    public final int MAX_PARKING_SPOT = 10;
    private int[] spots = new  int[MAX_PARKING_SPOT];
    public int SpotNum() {
        for (int i=0;i<tickets.size();i++) {
            spots[tickets.get(i).getSpotNumber()-1] = tickets.get(i).getSpotNumber();
        }
        int count= 0;
        while (spots[count]!=0){
            count++;
            if (count==MAX_PARKING_SPOT) return -1;
        }
        return count+1;
    }

    public int emptySpot() {
       return tickets.get(MAX_PARKING_SPOT-1).getSpotNumber();
    }

}
