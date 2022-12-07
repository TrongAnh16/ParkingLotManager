package view;

public class ParkingTicket {
    public String enterDate;
    public String enterTime;
    private long CardNumber;
    public String CardType;
    public int SpotNumber;
    public Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getDate() {
        return enterDate;
    }

    public void setDate(String enterDate) {
        this.enterDate = enterDate;
    }

    public String getTime() {
        return enterTime.toString();
    }

    public void setTime(String enterTime) {
        this.enterTime = enterTime;
    }

    public long getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.CardNumber = cardNumber;
    }

    public String getCardType() {
        return CardType;
    }

    public void setCardType(String carType) {
        this.CardType = carType;
    }

    public int getSpotNumber() {
        return SpotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.SpotNumber = spotNumber;
    }

    public Car getAssignedCar() {
        return car;
    }

    public void setAssignedCar(Car car) {
        this.car = car;
    }

    public String toData(){
        return String.format("%s,%s,%s,%s,%s,%s", car.getNumberPlate(), car.getCarColor(), car.getCarType(), this.getTime(), this.getDate(),this.getSpotNumber());
    }
}
