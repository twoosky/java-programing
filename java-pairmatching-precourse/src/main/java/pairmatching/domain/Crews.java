package pairmatching.domain;

import pairmatching.domain.enums.Course;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static pairmatching.utils.ErrorMessages.NOT_EXIST_CREW;
import static pairmatching.utils.FileReader.*;

public class Crews {
    private final Map<Course, List<Crew>> crews;

    public Crews() {
        this.crews = initCrews();
    }

    private Map<Course, List<Crew>> initCrews() {
        return Arrays.stream(Course.values())
                .collect(Collectors.toMap(course -> course, this::addCrew));
    }

    private List<Crew> addCrew(Course course) {
        return read(course).stream()
                .map(name -> new Crew(course, name))
                .collect(Collectors.toList());
    }

    public List<String> getCrewsName(Course course) {
        return getCrewsByCourse(course).stream()
                .map(Crew::getName)
                .collect(Collectors.toList());
    }

    public List<Crew> getCrewsByCourse(Course course) {
        return crews.get(course);
    }

    public Crew getCrewByName(Course course, String name) {
        return getCrewsByCourse(course).stream()
                .filter(crew -> crew.isEqualName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_CREW));
    }
}
