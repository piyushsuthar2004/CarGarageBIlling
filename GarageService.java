import java.io.FileNotFoundException;
import java.util.*;
public class GarageService {
    private Map<String ,Customer>customerMap;
    private List<Service>availableService;

    public GarageService() throws FileNotFoundException {
        this.customerMap = new HashMap<>();
        this.availableService = new ArrayList<>();
        loadService();
    }



    public void loadService(){
        availableService.add(new Service("car wash" ,500));
        availableService.add(new Service("oil change" ,700));
        availableService.add(new Service("wheel alignment" ,300));
        availableService.add(new Service("Type Replacement" ,3000));
        availableService.add(new Service("puncture" ,50));

    }
    public void addCustomer(String name , String phone, String carNumber,String model){
        Car car = new Car(carNumber,model);
        Customer customer = new Customer(name , phone, car);
        customerMap.put(carNumber,customer);
        System.out.println("customer added successfully");
    }
    public void createInvoice(String carNumber){
        if(!customerMap.containsKey(carNumber)){
            System.out.println("no customer found whith car number :"+carNumber);
            return;
        }
        Scanner sc = new Scanner(System.in);
        Customer customer = customerMap.get(carNumber);
        Invoice invoice = new Invoice(customer);
        System.out.println("Available service:");
        for (int i = 0; i<availableService.size();i++){
            System.out.println((i+1) +" ."+availableService.get(i).getName() + " - rupee " + availableService.get(i).getPrice());
        }
        while(true){
            System.out.println("Enter Service number to add or 0 to finish");
            int choice = sc.nextInt();
            if(choice == 0) break;
            if(choice>0 && choice<=availableService.size()){
                invoice.addService(availableService.get(choice-1));
                System.out.println("Service Done");
            }
            else{
                System.out.println("Invalid Choice");
            }
        }
        invoice.printInvoice();
    }
}
