import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        RegexExercises regexExercises = new RegexExercises();

//        Lesson7(regexExercises);
//        Lesson12(regexExercises);
//        UpperCaseLetter(regexExercises);
//        NumberOfUpperCase("A vida E feita de Surpresas");
//        nonDuplicatedRandomNumbers(new LinkedList<>(),new Random());
//        System.out.println(twitterize("lano"));
//        compare();
        try {
            System.out.println(RegexExercises.class.getName());
            ReflectionEx reflectionEx = new ReflectionEx("RegexExercises");
//            reflectionEx.getFields();
            RegexExercises reg = reflectionEx.<RegexExercises>resolve("RegexExercises");
            reg.Lesson7();


        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    static void compare() {
        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println(str1.equals(str2));
    }

    /**
     * @param text
     * @return
     */
    static String twitterize(String text) {
        int stringSize = text.length();
        int betweenLetterSize = stringSize - 2;
        return String.valueOf(text.charAt(0)) + betweenLetterSize + String.valueOf(text.charAt(stringSize - 1));

    }

    /**
     *
     *
     * @param list
     */
    static void nonDuplicatedRandomNumbers(List<Integer> list, Random randomGenerator) {
        if (list.size() == 48) {
            return;
        }

        int nextInt = randomGenerator.nextInt(1, 49);
        if (!list.contains(nextInt)) {
            list.add(nextInt);
        }
        nonDuplicatedRandomNumbers(list, randomGenerator);

    }


}