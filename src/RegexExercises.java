import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExercises {
    public String name = "Name Properties";
    private void match(String text, String regExRule) {
        if (text.matches(regExRule)) {
            System.out.println(text + " Matches");
        } else System.out.println(text + ": Does not Match REGEX => \" " + regExRule + " \"");
    }

    void match(List<String> texts, String regExRule) {
        for (String text : texts) {
            this.match(text, regExRule);
        }
    }

    /**
     * Write a method that returns the number of lower case characters in a string
     */
    static int NumberOfUpperCase(String text) {
        int count = 0;
        Pattern pattern = Pattern.compile("[a-z]");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            count++;
        }
        System.out.println("Found: " + count + " :Lower Cases letters ");
        return count;

    }

    /**
     * Ensure that a String contains 2 UpperCase letters
     */
    static void UpperCaseLetter(RegexExercises regexExercises) {
        regexExercises.match("2a", "\\d(?=[a-zA-Z])");
    }

    /**
     * Lesson 12: Nested groups
     * <p>
     * The Grouping concept applies also for Nesting Groups
     * The nested groups are read from left to right in the pattern, with the first capture group being the contents
     * of the first parentheses group, etc.
     * For the following strings, write an expression that matches and captures both the full date, and the year of the date.
     * <p>
     * Capture: Jan 1987
     * May 1969
     * Aug 2011
     */
    void Lesson12() {
        this.match(
                Arrays.asList("Jan 1987", "May 1969", "Aug 2011"),
                "^(\\w+\\s(\\d{4}))$");
    }

    /**
     * Lesson 11: Match groups
     * Defining groups of characters and capturing them is done by using the special parentheses ( and ) metacharacters.
     * Any subpattern inside a pair of parentheses will be captured as a group
     * <p>
     * Imagine for example that you had a command line tool to list all the image files you have in the cloud.
     * You could then use a pattern such as ^(IMG\d+\.png)$ to capture and extract the full filename, but if you only
     * wanted to capture the filename without the extension, you could use the pattern ^(IMG\d+)\.png$ which only
     * captures the part before the period.
     * <p>
     * Capture: file_record_transcript.pdf
     * file_07241999.pdf
     * testfile_fake.pdf.tmp (Should Skip/Failed)
     */
    void Lesson11() {
        this.match(
                Arrays.asList("file_record_transcript.pdf", "file_07241999.pdf", "testfile_fake.pdf.tmp"),
                "^(file_\\w+).pdf$");
    }

    /**
     * One way to tighten our patterns is to define a pattern that describes both the start and the end of
     * the line using the special ^ (hat) and $ (dollar sign) metacharacters.
     * <p>
     * we can use the pattern ^success to match only a line that begins with the word "success", but not the line
     * if we combine both the hat(^) and the dollar sign($), we create a pattern that matches the whole line completely at the beginning and end.
     * <p>
     * Note that this is different from the hat used inside a set of bracket [^...] for excluding characters, which can be confusing when reading regular expressions.
     * <p>
     * Try to match each of the strings below using these new special characters.
     * <p>
     * Text : Mission: successful
     * Last Mission: unsuccessful (Should Skip/Failed )
     * Next Mission: successful upon capture of target (Should Skip/Failed )
     */
    void Lesson10() {
        this.match(
                Arrays.asList("Mission: Successful", "Last Mission: unsuccessful", "Next Mission: successful upon capture of target"),
                "^Mission: Successful$");
    }

    /**
     * Lesson 9: All this whitespace
     * <p>
     * The most common forms of whitespace you will use with regular expressions are the space (␣), the tab (\t),
     * the new line (\n) and the carriage return (\r) (useful in Windows environments), and these special characters
     * match each of their respective whitespaces. In addition, a whitespace special character \s will match any of
     * the specific whitespaces above and is extremely useful when dealing with raw input text.
     * <p>
     * In the strings below, you'll find that the content of each line is indented by some whitespace from the index of
     * the line (the number is a part of the text to match). Try writing a pattern that can match each line containing
     * whitespace characters between the number and the content. Notice that the whitespace characters are just like
     * any other character and the special metacharacters like the star and the plus can be used as well.
     * <p>
     * Text : 1.   abc
     * 2.	abc
     * 3.           abc
     * 4.abc (Should Skip/Failed )
     */
    void Lesson9() {
        this.match(
                Arrays.asList("1.   abc", "2. abc", "3.           abc", "4.abc"),
                "\\d.\s+abc");
    }

    /**
     * In the strings below, notice how the plurality of the word "file" depends on the number of files found.
     * Try writing a pattern that uses the optionality metacharacter to match only the lines where one or
     * more files were found.
     * <p>
     * Texts: 1 file found?
     * 2 files found?
     * 24 files found?
     * No files found. (Should not Match)
     */
    public static void Lesson8(RegexExercises regexExercises) {
//        regexExercises.match(
//                Arrays.asList("1 file found?","2 files found?","24 files found?","No files found.")
//                ,"d+");
        regexExercises.match(
                Arrays.asList("1 file found?", "2 files found?", "24 files found?", "No files found.")
                , "\\d+ file[s]? found\\?");
    }

    /**
     * Below are a few simple strings that you can match using both the star and plus metacharacters.
     * There are at least two 'a's, zero or more 'b's, and at least one 'c' in each line to match,
     * so you can use the expression 'aa+b*c+' to represent this exactly.
     * Alternatively, an even more restrictive expression would be a{2,4}b{0,4}c{1,2}
     * which puts both an upper and lower bound on the number of each of the characters.
     * <p>
     * <p>
     * The Last one 'a' should not match the Rule
     */
    public void Lesson7() {
        this.match(Arrays.asList("aaaabcc", "aabbbbc", "aacc", "ab"), "aa+b*+c+");
    }


    public void Basic() {
        /**
         * Matches Integers
         * <p>
         * [0-9]*
         */
        this.match("12345", "[0-9]*");
        this.match("1ad2da34", "[0-9]*");
        /**
         * Match ([0-9]*+[.]?+[0-9]*+)*
         */
        this.match("1999.21994.2.2424.24256", "([0-9]*+[.]?+[0-9]*+)*");
        this.match("1999.21994.2,2424.24256", "([0-9]*+[.]?+[0-9]*+)*");

        /**
         * FIND EMAIL
         */
        this.match("j%oao@gm.com", "[^W]*@{1}[^W]*.[^W]");
    }

}

