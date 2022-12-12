package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.view.validator.InputMissionValidator;

import static pairmatching.utils.ViewMessages.*;

public class InputView {
    public String readMenu() {
        System.out.println(MISSION);
        return Console.readLine();
    }

    public String readMission() {
        System.out.println(COURSE);
        String mission = Console.readLine();
        InputMissionValidator.validate(mission);
        return mission;
    }

    public String readReMatching() {
        System.out.println(REMATCHING);
        return Console.readLine();
    }
}
