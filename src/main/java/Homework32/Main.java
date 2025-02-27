package Homework32;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard board = new CoffeeOrderBoard();

        board.add("Ivan");
        board.add("Katya");
        board.add("Andriy");

        board.draw();

        board.deliver();
        board.deliver(2);

        board.draw();
    }
}
