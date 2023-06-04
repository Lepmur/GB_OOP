package ru.geekbrains.task1;

public interface Runner {

    /**
     * Прыжок
     * @param height высота прыжка
     * @return результат прыжка (удалось перепрыгнуть препятствие или нет)
     */
    default boolean jump(int height) {
        if (height <= getMaxJump()){
            System.out.printf("%s перепрыгнул через стену %d м.\n", getName(), height);
            return true;
        }
        else{
            System.out.printf("%s не смог перепрыгнуть через стену %d м.\n", getName(), height);
            return false;
        }
    }

    /**
     * Бег
     * @param length дистанция
     * @return результат забега (удалось пробежать дистанцию или нет)
     */
    default boolean run(int length) {
        if (length <= getMaxRun()){
            System.out.printf("%s пробежал по дорожке %d м.\n", getName(), length);
            return true;
        }
        else{
            System.out.printf("%s не смог пробежать по дорожке %d м.\n", getName(), length);
            return false;
        }
    }

    /**
     * Получить имя бегуна
     * @return Имя
     */
    String getName();

    /**
     * Получить максимальную дистанцию
     * @return
     */
    int getMaxRun();

    /**
     * Получить максимальную высоту прыжка
     * @return
     */
    int getMaxJump();

}
