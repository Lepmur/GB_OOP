package ru.geekbrains.task1;

public class Championship {

    public static void main(String[] args) {

        // Бегуны
        Runner[] runners = {
                new Cat("Барсик", 1500, 2),
                new Cat("Персик", 1700, 1),
                new Robot("R2D2", 99999, 0),
                new Robot("C3PO", 5000, 5),
                new Human("Петя", 2500, 2),
                new Human("Вася", 3500, 1)
        };

        // Препятствия
        Obstacle[] obstacles = {
          new Track(1200),
          new Wall(3),
          new Track(2000),
          new Wall(2),
          new Track(3000),
          new Wall(4)
        };

        for (Runner runner : runners){

            for (Obstacle obstacle: obstacles) {
                if (obstacle instanceof Track){
                    if (!runner.run(obstacle.getLength()))
                        break;
                }
                else if (obstacle instanceof  Wall){
                    if (!runner.jump(obstacle.getHeight()))
                        break;
                }
            }

        }


    }

}
