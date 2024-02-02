package JavaTask2;

public class Playstation implements GameController{
    private boolean isOpen = false;

    @Override
    public void addController(String controller){
        System.out.println("Playstation Controller added as " + controller);
    }
    @Override
    public void playGame() {
        if (!isOpen) {
            throw new IllegalStateException("Playstation is closed, you can not run the game!");
        }
        System.out.println("Game Started : Playstation ");
    }

    public void open() {
        if (isOpen) {
            throw new IllegalStateException("Playstation is already opened!");
        }
        System.out.println("Playstation is opened.");
        isOpen = true;
    }

    public void shutdown() {
        if (!isOpen) {
            throw new IllegalStateException("Playstation is already closed!");
        }
        System.out.println("Playstation is closed.");
        isOpen = false;
    }
}
