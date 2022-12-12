package pairmatching.domain;

import java.util.EnumMap;
import java.util.Map;

public class MissionPairHistory {
    private final Map<Mission, Pair> pairs;

    public MissionPairHistory() {
        this.pairs = new EnumMap<>(Mission.class);
    }

    public void putMissionPair(Mission mission, Pair pair) {
        pairs.put(mission, pair);
    }

    public boolean isExistPair(Mission mission) {
        return pairs.keySet().stream()
                .anyMatch(key -> key == mission);
    }

    public Map<Mission, Pair> getPairs() {
        return pairs;
    }
}
