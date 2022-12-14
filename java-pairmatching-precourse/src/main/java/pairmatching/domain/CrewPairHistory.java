package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CrewPairHistory {
    private final Crew crew;
    private final List<Crew> history;

    public CrewPairHistory(Crew crew) {
        this.crew = crew;
        this.history = new ArrayList<>();
    }

    public void putMatchedPair(List<Crew> pairs) {
        history.addAll(getPair(pairs));
    }

    private List<Crew> getPair(List<Crew> pairs) {
        return pairs.stream()
             .filter(crew -> !crew.equals(this.crew))
             .collect(Collectors.toList());
    }

    public boolean isMatched(List<Crew> crews) {
        return crews.stream()
                .filter(crew -> !this.crew.equals(crew))
                .anyMatch(this::isMatchedPair);
    }

    private boolean isMatchedPair(Crew pair) {
        return (crew.getCourse() == pair.getCourse()) && history.contains(pair);
    }

    public void reset() {
        history.clear();
    }

    public Crew getCrew() {
        return crew;
    }
}
