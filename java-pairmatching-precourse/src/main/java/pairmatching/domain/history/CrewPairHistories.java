package pairmatching.domain.history;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Crews;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static pairmatching.utils.ErrorMessages.NOT_EXIST_CREW;

public class CrewPairHistories {
    private final List<CrewPairHistory> crewPairHistories;

    public CrewPairHistories(Crews crews) {
        this.crewPairHistories = initCrewPairHistories(crews);
    }

    private List<CrewPairHistory> initCrewPairHistories(Crews crews) {
        return Arrays.stream(Course.values())
                .map(course -> generateHistoryByCourse(course, crews))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private List<CrewPairHistory> generateHistoryByCourse(Course course, Crews crews) {
        return crews.getCrewsByCourse(course).stream()
                .map(CrewPairHistory::new)
                .collect(Collectors.toList());
    }

    public boolean isMatchedPair(List<Crew> crews) {
        return crews.stream()
                .map(this::getCrewPairHistory)
                .anyMatch(history -> history.isMatched(crews));
    }

    private CrewPairHistory getCrewPairHistory(Crew crew) {
        return crewPairHistories.stream()
                .filter(history-> history.getCrew().equals(crew))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_CREW));
    }

    public void putCrewPairHistory(List<Crew> pair) {
        pair.stream()
                .map(this::getCrewPairHistory)
                .forEach(history -> history.putMatchedPair(pair));
    }

    public void resetCrewPairHistory() {
        crewPairHistories.forEach(CrewPairHistory::reset);
    }

}
