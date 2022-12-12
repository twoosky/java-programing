package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.dto.MissionDto;
import pairmatching.view.validator.InputMissionValidator;

import static pairmatching.utils.ViewMessages.*;

public class InputView {
    public static final String MISSION_INFO_SEPARATOR = ", ";
    public static final int COURSE_INDEX = 0;
    public static final int LEVEL_INDEX = 1;
    public static final int MISSION_INDEX = 2;


    public String readFunction() {
        System.out.println(MISSION);
        return Console.readLine();
    }

    public MissionDto readMission() {
        System.out.println(COURSE);
        String mission = Console.readLine();
        InputMissionValidator.validate(mission);
        return generateMissionDto(mission);
    }

    public String readReMatching() {
        System.out.println(REMATCHING);
        return Console.readLine();
    }

    private MissionDto generateMissionDto(String mission) {
        String[] missionInfo = mission.split(MISSION_INFO_SEPARATOR);
        return new MissionDto(
                missionInfo[COURSE_INDEX],
                missionInfo[LEVEL_INDEX],
                missionInfo[MISSION_INDEX]
        );
    }


}
