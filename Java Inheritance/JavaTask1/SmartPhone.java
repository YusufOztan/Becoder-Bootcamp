package JavaTask1;

public class SmartPhone extends Phone{
    int storage;
    int ram;
    double camera;

    //No Args Constructor
    SmartPhone() {
        this(0, "", 0.0, "", 0, 0, 0.0);
    }
    //All Args Constructor
    SmartPhone(int id,String name, double price,String phoneNumber,int storage,int ram,double camera){
        super(id,name,price,phoneNumber);
        this.storage = storage;
        this.ram = ram;
        this.camera = camera;
    }
}
