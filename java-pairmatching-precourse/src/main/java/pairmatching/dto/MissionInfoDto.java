package pairmatching.dto;

public class MissionInfoDto {
    private final String course;
    private final String level;
    private final String mission;

    public MissionInfoDto(String course, String level, String mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public String getCourse() {
        return course;
    }

    public String getLevel() {
        return level;
    }

    public String getMission() {
        return mission;
    }
}
