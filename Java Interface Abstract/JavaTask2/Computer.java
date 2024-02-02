package JavaTask2;

public class Computer {
    private boolean isOpen = false;

    public void open() {
        if (isOpen) {
            throw new IllegalStateException("Computer is already opened!");
        }
        System.out.println("Computer is opening.");
        isOpen = true;
    }

    public void shutdown() {
        if (!isOpen) {
            throw new IllegalStateException("Computer is already closed!");
        }
        System.out.println("Computer is closed.");
        isOpen = false;
    }
}
