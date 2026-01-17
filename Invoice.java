import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private Customer customer;
    private List<Service>serviceList;
    private double totalamount;

    public Invoice(Customer customer) {
        this.customer = customer;
        this.serviceList = new ArrayList<>();
        this.totalamount = 0;
    }
    public void addService(Service service){
        serviceList.add(service);
        totalamount += service.getPrice();
    }
    public void printInvoice(){
        System.out.println("________________ Invoice ________________ ");
        System.out.println();
        System.out.println("customer: "+customer.getName() + " | Phone :" +customer.getPhone() + " | Car :" +customer.getCar().getCarNumber() +" Number : " +customer.getCar().getCarNumber());
        for(int i = 0; i<serviceList.size(); i++){
            System.out.println((i+1)+ " "+ serviceList.get(i).getName() + " : rupee = " +serviceList.get(i).getPrice());
        }
        System.out.println("Total amount : " +totalamount);
        System.out.println();
        System.out.println("---------------thank you---------------");
    }

}
