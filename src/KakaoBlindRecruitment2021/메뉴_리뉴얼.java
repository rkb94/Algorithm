package KakaoBlindRecruitment2021;

import java.util.*;
import java.util.stream.Collectors;

public class 메뉴_리뉴얼 {
    public static String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        Set<String> alphabetSet = new HashSet<>();
        Arrays.stream(orders).forEach(order -> alphabetSet.addAll(Arrays.asList(order.split(""))));

        List<List<Course>> combinationList = Arrays.stream(course)
                .mapToObj(i -> makeCombination(orders, i))
                .collect(Collectors.toList());

        for (List<Course> courseList : combinationList) {
            for (String order : orders) {
                for (Course courseObject : courseList) {
                    long count = Arrays.stream(courseObject.menu.split(""))
                            .filter(order::contains).count();
                    if (courseObject.menu.length() == count) {
                        courseObject.plusCount();
                    }
                }
            }

            int maxCourseCount = courseList.stream()
                    .sorted(Comparator.comparingInt(a -> a.count))
                    .max(Comparator.comparingInt(o -> o.count))
                    .get().count;

            for (Course courseObject : courseList) {
                if (courseObject.count == maxCourseCount && courseObject.count > 0) {
                    answer.add(courseObject.menu);
                }
            }
            System.out.println(courseList);
        }

        Collections.sort(answer);

        return answer.toArray(new String[0]);
    }

    protected static List<Course> makeCombination(String[] orders, int target) {
        List<String> orderList = Arrays.asList(orders.clone());
        List<Course> courseList = new ArrayList<>();

        for (String order : orderList) {
            List<String> alphabetList = Arrays.asList(order.split(""));
            courseList.addAll(makeCombination(alphabetList, target));
        }

        return courseList;
    }

    protected static List<Course> makeCombination(List<String> alphabetList, int target) {
        List<Course> result = new ArrayList<>();
        boolean[] visit = new boolean[alphabetList.size()];

        makeCombination(alphabetList, result, visit, 0, 0, target);

        return result;
    }

    private static void makeCombination(List<String> alphabetList, List<Course> result, boolean[] visit, int index, int visitCount, int stopCount) {
        if (visitCount == stopCount) {
            List<String> combination = new ArrayList<>();
            for (int i = 0; i < visit.length; i++) {
                if (visit[i]) {
                    combination.add(alphabetList.get(i));
                }
            }
            result.add(new Course(String.join("", combination), 0));
        } else {
            if (visit.length > index) {
                visit[index] = true;
                makeCombination(alphabetList, result, visit, index + 1, visitCount + 1, stopCount);
                visit[index] = false;
                makeCombination(alphabetList, result, visit, index + 1, visitCount, stopCount);
            }
        }
    }

    static class Course {
        String menu;
        int count;

        public Course(String menu, int count) {
            this.menu = menu;
            this.count = count;
        }

        public void plusCount() {
            count = count + 1;
        }

        @Override
        public String toString() {
            return "Course{" +
                    "menu='" + menu + '\'' +
                    ", count=" + count +
                    '}';
        }
    }
}
