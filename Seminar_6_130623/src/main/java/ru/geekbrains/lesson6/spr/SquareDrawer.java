package ru.geekbrains.lesson6.spr;

public class SquareDrawer {

    private final Square square;


    public SquareDrawer(Square square) {
        this.square = square;
    }

    public void draw(int scale) {
        for (int i = 0; i < square.getSide() * scale *2; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < square.getSide() * scale -2; i++) {
            System.out.print("*");
            for (int j = 1; j < square.getSide() * scale * 2 - 1; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
        for (int i = 0; i < square.getSide() * scale * 2; i++) {
            System.out.print("*");
        }
    }

}
