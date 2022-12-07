package view;

public class Payment {
    float hourAmount = 3000;
    float totalAmountForHour = 0;
    float totalAmountForMinute = 0;

    public float TotalAmount(int hour, int minute) {
        totalAmountForHour = hour * hourAmount;
        if (minute < 60 && minute >= 30) {
            totalAmountForMinute = 2000;
        } else if (minute < 30 && minute >= 15) {
            totalAmountForMinute = 15;
        } else if (minute < 15 && minute >= 1) {
            totalAmountForMinute = 1000;
        }
        return (totalAmountForHour + totalAmountForMinute);
    }
}
