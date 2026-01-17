import java.io.FileNotFoundException;
import java.util.Scanner;

public class GarageBillingApp {
    public static void main(String[] args) throws FileNotFoundException {
        GarageService garageService = new GarageService();
        Scanner sc = new Scanner(System.in);

        System.out.println("--------------------- Bharti Car Service Center--------------------- ");

        while (true){
            System.out.println("1. Add Cutomer");
            System.out.println("2. Display Service");
            System.out.println("3. Exit");
            System.out.println("Enter Your Choise");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter the customer Name : ");
                    String name = sc.next();
                    System.out.println("Enter the phone number: ");
                    String phone = sc.next();
                    System.out.println("Enter the car number : ");
                    String carNum = sc.next();
                    System.out.println("Enter the car model : ");
                    String model = sc.next();
                    garageService.addCustomer(name,phone,carNum,model);
                    break;
                case (2):
                    System.out.println("Enter the car number : ");
                    String carN = sc.next();
                    garageService.createInvoice(carN);
                    break;
                case (3):
                    System.out.println("Exiting ...... Thank You");
                    sc.close();
                    return;
                default:
                    System.out.println("invalid choice. Try again");
            }
        }
    }
//piyush kuar
}
