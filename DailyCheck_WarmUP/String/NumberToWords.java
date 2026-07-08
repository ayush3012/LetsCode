package DailyCheck_WarmUP.String;

public class NumberToWords {
    private static final String[] BELOW_20 = {"", "one", "two", "three", "four", "five", "six",
                                           "seven", "eight", "nine", "ten", "eleven", "twelve",
                                         "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                                          "eighteen", "nineteen"};

    private static final String[] below_100 = {"", "", "twenty", "thirty", "fourty", "fifty", "sixty",
                                        "seventy", "eighty", "ninty"};

    static String code(int a) {
        if (a == 0) return "zero";
        return helper(a).trim();
    }

    static String helper(int a) {
        if (a < 20)
            return BELOW_20[a] + " ";
        if (a < 100)
            return below_100[a / 10] + " " + helper(a % 10);
        if (a < 1000)
            return BELOW_20[a / 100] + " hundred " + helper(a % 100);
        if (a < 1000000)
            return helper(a / 1000) + " thousand " + helper(a % 1000);
        if (a < 1000000000)
            return helper(a / 1000000) + " million " + helper(a % 1000000);

        return helper(a / 1000000000) + " billion " + helper(a % 1000000000);
    }

    public static void main(String[] args) throws Exception {

        System.out.println(code(501));

    }
}

