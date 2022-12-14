package pairmatching.view;


import pairmatching.domain.enums.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.enums.Level;
import pairmatching.domain.enums.Mission;
import pairmatching.dto.PairMatchingDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.text.MessageFormat.*;
import static pairmatching.utils.ViewMessages.*;

public class OutputView {
    public static final String SEPARATOR = " | ";
    public static final String MATCHING_RESULT_SEPARATOR = " : ";

    public void printMenu() {
        System.out.println(SELECT_MENU);
    }

    public void printMissionMenu() {
        System.out.println(MISSION_MENU_START);
        System.out.println(format(MISSION_MENU_COURSE, toStringCourse()));
        System.out.println(MISSION_MENU);
        printMissionByLevel();
        System.out.println(MISSION_MENU_END);
    }

    private String toStringCourse() {
        return Arrays.stream(Course.values())
                .map(Course::getName)
                .collect(Collectors.joining(SEPARATOR));
    }

    private void printMissionByLevel() {
        Arrays.stream(Level.values())
                .map(this::toStringMissionByLevel)
                .forEach(System.out::println);
    }

    private String toStringMissionByLevel(Level level) {
        return format(MISSION_MENU_LEVEL_MISSION,
                level.getName(), toStringMission(level.getMissions()));
    }

    private String toStringMission(List<Mission> missions) {
        return missions.stream()
                .map(Mission::getName)
                .collect(Collectors.joining(SEPARATOR));
    }

    public void printPairMatchingResult(PairMatchingDto dto) {
        System.out.println(PAIR_MATCHING_RESULT);
        dto.getPairs().stream()
                .map(this::toStringPair)
                .forEach(System.out::println);
    }

    private String toStringPair(List<Crew> pair) {
        return pair.stream()
                .map(Crew::getName)
                .collect(Collectors.joining(MATCHING_RESULT_SEPARATOR));
    }

    public void printReset() {
        System.out.println(PAIR_MATCHING_RESULT_RESET);
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
