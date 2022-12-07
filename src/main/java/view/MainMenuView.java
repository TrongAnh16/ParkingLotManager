package view;

import java.util.Scanner;

public class MainMenuView {
    public static Scanner scan = new Scanner(System.in);
    public  static int launch() {
        System.out.println("----------MENU----------");
        System.out.println("Size 1: You want to parked your vehicle : ");
        System.out.println("Size 2: You want to show vehicle in parking lot: ");
        System.out.println("Size 3: You want to search parking ticket your vehicle : ");
        String userinput = scan.nextLine();
       return userinput.length();
    }
}
