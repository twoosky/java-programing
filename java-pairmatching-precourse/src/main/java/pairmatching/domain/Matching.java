package pairmatching.domain;

import pairmatching.domain.enums.Course;
import pairmatching.utils.PairMatchingRule;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Matching {
    private final PairMatchingRule<String> pairMatchingRule;

    public Matching(PairMatchingRule<String> pairMatchingRule) {
        this.pairMatchingRule = pairMatchingRule;
    }

    public Pair match(Course course, Crews crews) {
        List<String> randomCrewNames = shufflesCrews(crews.getCrewsName(course));
        List<Crew> randomCrews = toCrews(randomCrewNames, crews, course);
        return new Pair(matchPair(randomCrews));
    }

    private List<String> shufflesCrews(List<String> crews) {
        return pairMatchingRule.match(crews);
    }

    private List<Crew> toCrews(List<String> randomCrews, Crews crews, Course course) {
        return randomCrews.stream()
                .map(name -> crews.getCrewByName(course, name))
                .collect(Collectors.toList());
    }

    private List<List<Crew>> matchPair(List<Crew> crews) {
        return IntStream.range(0, crews.size() - 1)
                .filter(i -> i % 2 == 0)
                .mapToObj(index -> generatePair(index, crews))
                .collect(Collectors.toList());
    }

    private List<Crew> generatePair(int index, List<Crew> crews) {
        if (isLastPair(index, crews)) {
            return Arrays.asList(crews.get(index++), crews.get(index++), crews.get(index));
        }
        return Arrays.asList(crews.get(index++), crews.get(index));
    }

    private boolean isLastPair(int index, List<Crew> crews) {
        return (crews.size() - index) == 3;
    }
}
