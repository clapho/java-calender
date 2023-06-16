import java.util.*;

public class Calender {
    private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] LEAF_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] WEEK_DAYS = {"SU","MO", "TU", "WE", "TH", "FR", "SA"};

    public boolean isLeafYear(int year) {
        if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
            return true;

        return false;
    }

    public int getMaxDaysOfMonth(int year, int month) {
        if(isLeafYear(year)) {
            return LEAF_MAX_DAYS[month - 1];
        }else {
            return MAX_DAYS[month - 1];
        }
    }

    public void printCalender(int year, int month, String weekDay) {
        System.out.printf("    <<%4d년%3d월>>\n", year, month);
        System.out.println("  SU MO TU WE TH FR SA");
        System.out.println("------------------------");

        int maxDay = getMaxDaysOfMonth(year, month);
        int idx = Arrays.asList(WEEK_DAYS).indexOf(weekDay) + 1;

        int i = 1;

        while(i <= maxDay + idx - 1) {
            if(i < idx) {
                System.out.printf("   ");
            }else {
                System.out.printf("%3d", i - idx + 1);
            }
            if(i % 7 == 0) {
                System.out.println();
            }
            i++;
        }
        System.out.println();
    }

}
