package racingcar.domain;

public class Moving {
    private final int number;

    public Moving(int number) {
        this.number = number;
    }

    public void move(Cars cars) {
        for (Car car : cars.getCars()) {
            car.move(isMove());
        }
    }

    private boolean isMove() {
        return number >= 4;
    }
}
