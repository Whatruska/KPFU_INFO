package Lesson_16.Animals;

import Lesson_16.Interfaces.Animal;
import Lesson_16.Interfaces.Moveable;

public class Horse extends Animal implements Moveable {
    @Override
    public void eat(int weight) {

    }

    @Override
    public int getMeat() {
        return 0;
    }

    @Override
    public void move(int weight) {

    }
}
