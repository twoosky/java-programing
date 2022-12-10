package racingcar.view;

import racingcar.domain.Car;
import racingcar.dto.MovingResultDto;
import racingcar.dto.WinnerDto;
import java.util.Collections;

import static java.text.MessageFormat.*;
import static racingcar.utils.ViewMessage.*;

public class OutputView {

    public void printExecuteResultMessage() {
        System.out.println(EXECUTE_RESULT_MESSAGE);
    }

    public void printMovingResult(MovingResultDto movingResultDto) {
        for (Car car : movingResultDto.getCars()) {
            System.out.println(generateMovingResultMessage(car));
        }
        System.out.println();
    }

    private String generateMovingResultMessage(Car car) {
        return format(MOVING_RESULT_FORMAT, car.getName(),
                String.join("", Collections.nCopies(car.getPosition(), MOVING_POSITION_FORMAT)));
    }

    public void printWinner(WinnerDto winnerDto) {
        System.out.println(generateWinnerMessage(winnerDto));
    }

    private String generateWinnerMessage(WinnerDto winnerDto) {
        return format(WINNER_RESULT_FORMAT, String.join(", ", winnerDto.getNames()));
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
