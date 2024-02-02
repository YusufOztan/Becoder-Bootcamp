package JavaTask2;

public class Main {
    public static void main(String[] args) {
        //turn on the computer to start the games
        Computer computer = new Computer();
        computer.open();

        //create the XBOX and Playstation object
        Xbox xbox = new Xbox();
        Playstation playstation = new Playstation();

        //add controller to XBOX and play games
        xbox.addController("XBOX Controller");
        xbox.open();
        xbox.playGame();
        xbox.shutdown();

        //add a controller to Playstation and play games
        playstation.addController("Playstation Controller");
        playstation.open();
        playstation.playGame();
        playstation.shutdown();

        //turn off the computer
        computer.shutdown();
    }
}
