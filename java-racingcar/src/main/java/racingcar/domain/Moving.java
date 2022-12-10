package racingcar.domain;

import racingcar.utils.MovingRuleGenerator;

public class Moving {
    private final MovingRuleGenerator<Integer> movingRuleGenerator;

    public Moving(MovingRuleGenerator<Integer> movingRuleGenerator) {
        this.movingRuleGenerator = movingRuleGenerator;
    }

    public void move(Cars cars) {
        for (Car car : cars.getCars()) {
            car.move(isMove());
        }
    }

    private boolean isMove() {
        return movingRuleGenerator.generate() >= 4;
    }
}
