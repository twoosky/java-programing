package pairmatching.utils;

import java.util.List;

public interface PairMatchingRule<T> {
    List<T> match(List<T> crews);
}
