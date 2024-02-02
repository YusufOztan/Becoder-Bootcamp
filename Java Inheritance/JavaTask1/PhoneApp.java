package JavaTask1;

public class PhoneApp{
    public static double calculateTotalPrice(SmartPhone[] smartPhoneArray){
        double totalPrice = 0;
        for (int i = 0; i < smartPhoneArray.length; i++) {
            totalPrice += smartPhoneArray[i].price;
        }
        return totalPrice;
    }

    public static void main(String[] args) {

        SmartPhone phone1 = new SmartPhone(1,"Phone 1",5000,"000111",16,2,8);
        SmartPhone phone2 = new SmartPhone(2,"Phone 2",6000,"111222",32, 4, 13);
        SmartPhone phone3 = new SmartPhone(3,"Phone 3",7000,"222333",64, 6, 20);
        SmartPhone phone4 = new SmartPhone(4,"Phone 4",8000,"333444",128, 8, 32);
        SmartPhone phone5 = new SmartPhone(5,"Phone 5",9000,"444555",128, 8, 50);

        SmartPhone[] smartPhoneArray = {phone1, phone2, phone3, phone4, phone5};

        System.out.println("Total price of identified phones: " + calculateTotalPrice(smartPhoneArray));
    }
}
