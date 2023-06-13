package ru.geekbrains.lesson6.lsp;

public class Program {

    // Тип S будет подтипом Т тогда и только тогда,
    // когда каждому объекту oS типа S соответствует некий объект oT типа T таким образом,
    // что для всех программ P,
    // реализованных в терминах T, поведение P не будет меняться, если oT заменить на oS.
    public static void main(String[] args) {

        Bird oT1 = new Bird(); // T
        Bird oT2 = new Bird(); // T
        Bird oT3 = new Bird(); // T

        Duck oS1 = new Duck(); // S
        Duck oS2 = new Duck(); // S
        Penguin oS3 = new Penguin();

        fly(oT1);
        fly(oT2);
        fly(oT3);


        fly(oS1);
        fly(oS2);
        fly(oS3);
    }

    /**
     * P
     * @param bird
     */
    public static void fly(Bird bird){ // T
        try {
            bird.fly();
        }
        catch (Exception e){
            System.out.println("Не удалось запустить птичку в полет.");
        }
    }

}
