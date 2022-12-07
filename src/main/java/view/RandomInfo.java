package view;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class RandomInfo {
    Random random = new Random();

    String[] dist = {"75", "43", "29", "37", "74", "51", "96", "92"};
    String[] alpha = {"A", "B", "C", "D", "E", "F", "G", "H"};
    String[] color = {"Red", "Yellow", "Green", "White", "Brown", "Violet", "Pink"};
    String[] type = {"Sedan", "Van", "Minivan", "Bus", "Pickup-truck", "Hatchback"};

    public String NumberPlate() {
        int di = random.nextInt(dist.length);
        int al = random.nextInt(alpha.length);

        return dist[di] +"-"+ alpha[al] +"-"+ random.nextInt((999 - 100)+1) + 10;
    }

    public String CarColor() {
        int res = random.nextInt(color.length);
        return color[res];
    }

    public String CarType() {
        int typ = random.nextInt(type.length);
        return type[typ];
    }

    public String Time() {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        String enterTime = localTime.format(dateTimeFormatter);
        return enterTime;
    }

    public String ExitTime() {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        String exitTime = localTime.format(dateTimeFormatter);
        return exitTime;
    }

    public String Date() {
        LocalDate mydate = LocalDate.now();
        return mydate.toString();
    }

    public String ExitDate() {
        LocalDate exitdate = LocalDate.now();
        return  exitdate.toString();
    }

    String[] cardtype = {"Debit", "Credit"};

    public String CardType() {
        int caty = random.nextInt(cardtype.length);
        return cardtype[caty];
    }

    public long CardNumber() {
        return ((random.nextLong()% 100000000000000L) + 5200000000000000L);
    }
}
