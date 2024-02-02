package JavaTask2;

public class Xbox implements GameController{
    private boolean isOpen = false;
    @Override
    public void addController(String controller){
        System.out.println("XBOX Controller added as " + controller );
    }

    @Override
    public void playGame(){
        if(!isOpen){
            throw new IllegalStateException("XBOX is closed, you can not run the game!");
        }
        System.out.println("Game Started : XBOX");
    }

    public void open(){
        if (isOpen) {
            throw new IllegalStateException("XBOX is already opened!");
        }
        System.out.println("XBOX is opened.");
        isOpen = true;
    }

    public void shutdown() {
        if (!isOpen) {
            throw new IllegalStateException("XBOX is already closed!");
        }
        System.out.println("XBOX is closed.");
        isOpen = false;
    }
}
