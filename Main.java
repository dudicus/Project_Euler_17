import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> numWords;

        String[] numWordsSingleDigit = {
                "zero",
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine"
        };

        String[] numWordsTeens = {
                "ten",
                "eleven",
                "twelve",
                "thirteen",
                "fourteen",
                "fifteen",
                "sixteen",
                "seventeen",
                "eighteen",
                "nineteen"
        };

        String[] numWordsTens = {
                "zero",
                "ten",
                "twenty ",
                "thirty ",
                "forty ",
                "fifty ",
                "sixty ",
                "seventy ",
                "eighty ",
                "ninety "
        };

        final String HUNDRED = "hundred";
        final String THOUSAND = "thousand";

        {
            numWords = new ArrayList<>();
        }

        for(int i = 1; i <= 1000; i++) {
            int num = i;
            String numString = "";
            while(num > 0) {
                if(num < 10) {
                    numString += numWordsSingleDigit[num];
                    num = 0;
                }
                else if(num < 20) {
                    numString += numWordsTeens[num - 10];
                    num = 0;
                }
                else if(num < 100) {
                    numString += numWordsTens[num / 10];
                    num %= 10;
                }
                else if(num < 1000) {
                    if(num % 100 != 0) {
                        numString += numWordsSingleDigit[num / 100] + " " + HUNDRED + " and ";
                    }
                    else {
                        numString += numWordsSingleDigit[num / 100] + " " + HUNDRED;
                    }
                    num %= 100;
                }
                else {
                    numString = "one " + THOUSAND;
                    num %= 1000;
                }
            }

            numWords.add(numString);
        }

        numWords.forEach(System.out::println);

        String combinedNumWords = String.join("", numWords).replaceAll("\\s+", "");

        System.out.println();

        System.out.println("The total number of letters in the numbers one to one thousand is " + combinedNumWords.length());
    }
}
