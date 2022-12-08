package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(boolean isMove) {
        if (isMove) {
            position += 1;
        }
    }
}
