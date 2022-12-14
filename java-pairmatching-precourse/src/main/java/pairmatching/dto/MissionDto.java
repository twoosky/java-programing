package pairmatching.dto;

import pairmatching.domain.enums.Course;
import pairmatching.domain.enums.Mission;

public class MissionDto {
    private final Course course;
    private final Mission mission;

    public MissionDto(Course course, Mission mission) {
        this.course = course;
        this.mission = mission;
    }

    public Course getCourse() {
        return course;
    }

    public Mission getMission() {
        return mission;
    }
}
