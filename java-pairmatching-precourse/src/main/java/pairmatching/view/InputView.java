package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.dto.MissionInfoDto;
import pairmatching.view.validator.InputMissionValidator;

import java.util.Arrays;

import static pairmatching.utils.ViewMessages.*;

public class InputView {
    public static final String MISSION_INFO_SEPARATOR = ", ";
    public static final int COURSE_INDEX = 0;
    public static final int LEVEL_INDEX = 1;
    public static final int MISSION_INDEX = 2;


    public String readMenu() {
        return Console.readLine();
    }

    public MissionInfoDto readMission() {
        System.out.println(SELECT_MISSION);
        System.out.println(MISSION_MENU_EX);
        String mission = Console.readLine();
        InputMissionValidator.validate(mission);
        return generateMissionDto(mission);
    }

    public String readReMatching() {
        System.out.println(REMATCHING);
        return Console.readLine();
    }

    private MissionInfoDto generateMissionDto(String mission) {
        String[] missionInfo = mission.split(MISSION_INFO_SEPARATOR);
        System.out.println("Arrays.asList(missionInfo = " + Arrays.asList(missionInfo));
        return new MissionInfoDto(
                missionInfo[COURSE_INDEX],
                missionInfo[LEVEL_INDEX],
                missionInfo[MISSION_INDEX]
        );
    }


}
