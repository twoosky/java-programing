package racingcar.domain;

import racingcar.dto.MovingResultDto;
import racingcar.dto.WinnerDto;
import racingcar.utils.MovingRuleGenerator;

public class RaceGame {
    private final Cars cars;
    private final Moving moving;

    public RaceGame(String names, MovingRuleGenerator<Integer> movingRuleGenerator) {
        this.cars = new Cars(names);
        this.moving = new Moving(movingRuleGenerator);
    }

    public GameCount generateGameCount(String gameCount) {
        return new GameCount(gameCount);
    }

    public MovingResultDto move() {
        moving.move(cars);
        return new MovingResultDto(cars);
    }

    public WinnerDto getWinner() {
        Winner winner = new Winner(cars);
        return new WinnerDto(winner);
    }
}
