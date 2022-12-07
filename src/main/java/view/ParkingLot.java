package view;

import de.vandermeer.asciitable.AT_Row;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.ArrayList;
import java.util.*;

public class ParkingLot {
    public static RandomInfo randominfo = new RandomInfo();
    public static void main(String[] args) {
        ParkingTicketService parkingTicketService = new ParkingTicketService();
        ArrayList<ParkingTicket> assignedspotlist = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        while (true) {
            ParkingSpot parkingspot = new ParkingSpot();
            int size=MainMenuView.launch();
            if (size == 1) {
                Car car = randomCarIn();
                int spotnum = checkIfSpotAvalable(parkingspot);
                if (spotnum==-1) continue;
                ParkingTicket parkingticket = randomTicketForNewCar(car);
                parkingticket.setSpotNumber(spotnum);
                parkingTicketService.addNewTicket(parkingticket);
                ParkingTicketView.showTicket(car, parkingticket,assignedspotlist);

            } else if (size == 3) {
                int checkspot = parkingspot.emptySpot();
                if (checkspot == 10) {
                    System.out.println("There is no car.");
                    continue;
                } else {
                    System.out.print("Enter your car number : ");
                    String number = scan.nextLine();
                    ScanTicket scanticket = new ScanTicket();
                    TotalTime totaltime = new TotalTime();
                    Payment payment = new Payment();
                    for (ParkingTicket cp : assignedspotlist) {
                        String carnumber = cp.getAssignedCar().getNumberPlate();
                        int item = scanticket.checknumber(number, carnumber);
                        if (item == 0) {
                            continue;
                        } else if (item == 1) {
                            int spot = assignedspotlist.indexOf(cp);
                            String exitdate = randominfo.ExitDate();
                            String exittime = randominfo.ExitTime();
                            String enterdate = assignedspotlist.get(spot).getDate();
                            String entertime = assignedspotlist.get(spot).getTime();

                            int time[] = totaltime.CalculateTime(enterdate, exitdate, entertime, exittime);
                            float amount = payment.TotalAmount(time[0], time[1]);

                            AsciiTable tb = new AsciiTable();
                            tb.addRule();
                            AT_Row titleRow = tb.addRow(null, null, null, null, null, null, null, null, null, "Your Parking Information");
                            titleRow.getCells().get(9).getContext().setTextAlignment(TextAlignment.CENTER);
                            tb.addRule();
                            tb.addRow("Car Number", "Car Color", "Car Type", "Parking Time ", "Exit Time", "Parking Date", "Exit Date", "Spot Number", "Total Time", "Total Amount");
                            tb.addRule();
                            tb.addRow(assignedspotlist.get(spot).getAssignedCar().getNumberPlate(),
                                    assignedspotlist.get(spot).getAssignedCar().getCarColor(),
                                    assignedspotlist.get(spot).getAssignedCar().getCarType(),
                                    assignedspotlist.get(spot).getTime(),
                                    exittime, assignedspotlist.get(spot).getDate(), exitdate, assignedspotlist.get(spot).getSpotNumber(),
                                    time[0] + " h " + time[1] + " min ", amount + " VND");
                            tb.addRule();
                            System.out.println(tb.render(150));

                            int luachon = 0;
                            do {
                                System.out.println("Do you want to paid payment?");
                                System.out.println("1. Yes and delete payment");
                                System.out.println("2. Change information: ");
                                luachon = Integer.parseInt(scan.nextLine());
                                switch (luachon) {
                                    case 1:
                                        assignedspotlist.remove(spot);
                                        break;
                                    case 2:
                                        int select = 0;
                                        do {
                                            System.out.println("1. Change car number: ");
                                            System.out.println("2. Change car color: ");
                                            System.out.println("3. Change car Type: ");
                                            select = Integer.parseInt(scan.nextLine());
                                            switch (select) {
                                                case 1:
                                                    boolean checkEditMenu = false;
                                                    do {
                                                        System.out.println("Enter a new car number: ");
                                                        String id = scan.nextLine();
                                                        for (int i = 0; i < assignedspotlist.size(); i++) {
                                                            if (assignedspotlist.get(i).getAssignedCar().getNumberPlate().equals(number)) {
                                                                assignedspotlist.get(i).getAssignedCar().setNumberPlate(id);
                                                                break;
                                                            }
                                                        }
                                                    } while (checkEditMenu);
                                                    break;
                                                case 2:
                                                    boolean checkEditMenu2 = false;
                                                    do {
                                                        System.out.println("Enter a new car color: ");
                                                        String newcolor = scan.nextLine();
                                                        for (int i = 0; i < assignedspotlist.size(); i++) {
                                                            if (assignedspotlist.get(i).getAssignedCar().getNumberPlate().equals(number)) {
                                                                assignedspotlist.get(i).getAssignedCar().setCarColor(newcolor);
                                                                break;
                                                            }
                                                        }
                                                    } while (checkEditMenu2);
                                                    break;
                                                case 3:
                                                    boolean checkEditMenu3 = false;
                                                    do {
                                                        System.out.println("Enter a new car type: ");
                                                        String newtype = scan.nextLine();
                                                        for (int i = 0; i < assignedspotlist.size(); i++) {
                                                            if (assignedspotlist.get(i).getAssignedCar().getNumberPlate().equals(number)) {
                                                                assignedspotlist.get(i).getAssignedCar().setCarType(newtype);
                                                                break;
                                                            }
                                                        }
                                                    } while (checkEditMenu3);
                                                    break;
                                            }
                                        } while (select == 0);
                                        break;
                                }
                            } while (luachon != 1 && luachon != 2);
                            break;
                        }
                    }
                }
            } else if (size == 2) {
                AllCarInformationView.showInformation(randomCarIn(), randomTicketForNewCar(randomCarIn()), assignedspotlist);
            }
        }
    }

    private static int checkIfSpotAvalable(ParkingSpot parkingspot) {
        int spotnum = parkingspot.SpotNum();
        if (spotnum == -1) {
            System.out.println("Sorry, spot is not available.");
        }
        return spotnum;
    }

    private static ParkingTicket randomTicketForNewCar(Car car) {
        ParkingTicket parkingticket = new ParkingTicket();
        parkingticket.setAssignedCar(car);
        String cardtype = randominfo.CardType();
        String time = randominfo.Time();
        String date = randominfo.Date();
        long cardnumber = randominfo.CardNumber();

        parkingticket.setCardType(cardtype);
        parkingticket.setTime(time);
        parkingticket.setDate(date);
        parkingticket.setCardNumber(cardnumber);
        return parkingticket;
    }

    private static Car randomCarIn() {
        Car car = new Car();
        String carcolor = randominfo.CarColor();
        String numberplate = randominfo.NumberPlate();
        String cartype = randominfo.CarType();
        car.setNumberPlate(numberplate);
        car.setCarColor(carcolor);
        car.setCarType(cartype);
        return car;
    }
}

