package pairmatching.utils;

import pairmatching.domain.enums.Course;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static pairmatching.utils.ErrorMessages.NOT_FOUND_FILE;

public class FileReader {
    public static final String FRONT_CREWS_FILE_PATH = "/home/haneul/workspace/java-programing/java-pairmatching-precourse/src/main/resources/frontend-crew.md";
    public static final String BACKEND_CREWS_FILE_PATH = "/home/haneul/workspace/java-programing/java-pairmatching-precourse/src/main/resources/backend-crew.md";

    private FileReader() {}

    public static List<String> read(Course course) {
        try {
            List<String> names = new ArrayList<>();
            Scanner scanner = new Scanner(new File(getPath(course)));
            while (scanner.hasNextLine()) {
                names.add(scanner.nextLine());
            }
            return names;
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(NOT_FOUND_FILE);
        }
    }

    private static String getPath(Course course) {
        if (course == Course.FRONTEND) {
            return FRONT_CREWS_FILE_PATH;
        }
        return BACKEND_CREWS_FILE_PATH;
    }
}
