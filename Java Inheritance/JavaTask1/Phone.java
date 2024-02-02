package JavaTask1;

public class Phone extends Product{
    String phoneNumber;

    Phone(int id,String name,double price,String phoneNumber){
        super(id,name,price);
        this.phoneNumber = phoneNumber;
    }
}
