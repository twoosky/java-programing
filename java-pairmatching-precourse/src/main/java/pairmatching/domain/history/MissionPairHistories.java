package pairmatching.domain.history;

import pairmatching.domain.enums.Course;
import pairmatching.domain.enums.Mission;
import pairmatching.domain.Pair;

import java.util.ArrayList;
import java.util.List;

import static pairmatching.utils.ErrorMessages.NOT_EXIST_PAIR_BY_MISSION;

public class MissionPairHistories {
    private final List<MissionPairHistory> missionPairHistories;

    public MissionPairHistories() {
        this.missionPairHistories = new ArrayList<>();
    }

    public boolean isExistPair(Course course, Mission mission) {
        return missionPairHistories.stream()
                .anyMatch(history -> history.isEqualCourseAndMission(course, mission));
    }

    public void putMissionPair(Course course, Mission mission, Pair pair) {
        missionPairHistories.add(new MissionPairHistory(course, mission, pair));
    }

    public Pair getPair(Course course, Mission mission) {
        return getHistory(course, mission).getPair();
    }

    public void reset() {
        missionPairHistories.clear();
    }

    private MissionPairHistory getHistory(Course course, Mission mission) {
        return missionPairHistories.stream()
                .filter(history -> history.isEqualCourseAndMission(course, mission))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_PAIR_BY_MISSION));
    }

    public void resetByMission(Course course, Mission mission) {
        missionPairHistories.remove(getHistory(course, mission));
    }
}
