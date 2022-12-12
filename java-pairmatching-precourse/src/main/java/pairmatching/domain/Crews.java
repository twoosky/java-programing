package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static pairmatching.utils.ErrorMessages.NOT_EXIST_CREW;
import static pairmatching.utils.FileReader.*;

public class Crews {
    private final List<Crew> crews;
    private final List<CrewPairHistory> crewPairHistories;

    public Crews() {
        this.crews = new ArrayList<>();
        this.crewPairHistories = initCrewPairHistories();
        initCrews();
    }

    private void initCrews() {
        addCrew(Course.FRONTEND, read(FRONT_CREWS_FILE_PATH));
        addCrew(Course.BACKEND, read(BACKEND_CREWS_FILE_PATH));
    }

    private List<CrewPairHistory> initCrewPairHistories() {
        return crews.stream()
                .map(CrewPairHistory::new)
                .collect(Collectors.toList());
    }

    private void addCrew(Course course, List<String> names) {
        names.forEach(name -> crews.add(new Crew(course, name)));
    }

    public boolean isMatchedPair(Crew crew) {
        CrewPairHistory crewPairHistory = getCrewPairHistory(crew);
        return crewPairHistory.isMatchedPair(crew);
    }

    private CrewPairHistory getCrewPairHistory(Crew crew) {
        return crewPairHistories.stream()
                .filter(history-> history.getCrew().equals(crew))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_CREW));
    }

    public List<Crew> getCrews() {
        return crews;
    }
}
