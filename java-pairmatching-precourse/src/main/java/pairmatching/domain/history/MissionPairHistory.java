package pairmatching.domain.history;

import pairmatching.domain.Course;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;

public class MissionPairHistory {
    private final Course course;
    private final Mission mission;
    private final Pair pair;

    public MissionPairHistory(Course course, Mission mission, Pair pair) {
        this.course = course;
        this.mission = mission;
        this.pair = pair;
    }

    public boolean isEqualCourseAndMission(Course course, Mission mission) {
        return (this.course == course) && (this.mission == mission);
    }

    public Pair getPair() {
        return pair;
    }
}
