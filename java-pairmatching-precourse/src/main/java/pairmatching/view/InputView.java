package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

import static pairmatching.utils.ViewMessages.*;

public class InputView {
    public String readMenu() {
        System.out.println(MENU);
        return Console.readLine();
    }

    public String readCourse() {
        System.out.println(COURSE);
        return Console.readLine();
    }

    public String readReMatching() {
        System.out.println(REMATCHING);
        return Console.readLine();
    }
}
