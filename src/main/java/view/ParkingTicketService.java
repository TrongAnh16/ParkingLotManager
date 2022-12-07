package view;

import java.util.ArrayList;
import java.util.List;

public class ParkingTicketService {
    private final String PATH = "./data/tickets.txt";
    private static FileUtils fileUtils = FileUtils.getInstance();

    public void addNewTicket(ParkingTicket ticket) {
        List<ParkingTicket> tickets = getAllTickets();
        tickets.add(ticket);
        List<String> rawData = convertParkingTicketsToRawData(tickets);
        fileUtils.writeData(PATH, rawData);
    }

    private List<String> convertParkingTicketsToRawData(List<ParkingTicket> tickets) {
        List<String> rawData = new ArrayList<>();
        for (ParkingTicket ticket : tickets) {
            rawData.add(ticket.toData());
        }
        return rawData;
    }

    public List<ParkingTicket> getAllTickets() {
        List<String> rawData = fileUtils.readData(PATH);
        return convertRawDataToParkingTicket(rawData);
    }

    private List<ParkingTicket> convertRawDataToParkingTicket(List<String> rawData) {
        List<ParkingTicket> tickets = new ArrayList<>();
        for (String item : rawData) {
            String[] line = item.split(",");
            Car car = new Car();
            car.setNumberPlate(line[0]);
            car.setCarColor(line[1]);
            car.setCarType(line[2]);

            ParkingTicket ticket = new ParkingTicket();
            ticket.setAssignedCar(car);
            ticket.setTime(line[3]);
            ticket.setDate(line[4]);
            ticket.setSpotNumber(Integer.parseInt(line[5]));

            tickets.add(ticket);
        }
        return tickets;
    }

}
