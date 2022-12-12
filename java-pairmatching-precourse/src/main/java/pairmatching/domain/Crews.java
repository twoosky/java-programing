package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static pairmatching.utils.FileReader.*;

public class Crews {
    private final List<Crew> crews;

    public Crews() {
        this.crews = new ArrayList<>();
        initCrews();
    }

    private void initCrews() {
        addCrew(Course.FRONTEND, read(FRONT_CREWS_FILE_PATH));
        addCrew(Course.BACKEND, read(BACKEND_CREWS_FILE_PATH));
    }

    private void addCrew(Course course, List<String> names) {
        names.forEach(name -> crews.add(new Crew(course, name)));
    }

    public List<Crew> getCrews() {
        return crews;
    }

    public List<Crew> matchPair(int index) {
        if (isLastPair(index)) {
            return Arrays.asList(crews.get(index++), crews.get(index++), crews.get(index));
        }
        return Arrays.asList(crews.get(index++), crews.get(index));
    }

    private boolean isLastPair(int index) {
        return ((crews.size() - 1) - index) == 3;
    }
}
