import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Calender {
    private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] LEAF_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String SAVE_FILE = "calender.dat";

    private HashMap<Date, PlanItem> planMap;

    public Calender() {
        planMap = new HashMap<Date, PlanItem>();
        File f = new File(SAVE_FILE);
        if(!f.exists())
            return;
        try {
            Scanner s = new Scanner(f);
            while(s.hasNext()) {
                String line = s.nextLine();
                String[] words = line.split(",");
                String date = words[0];
                String detail = words[1].replaceAll("\"", "");
                PlanItem p = new PlanItem(date, detail);
                planMap.put(p.getDate(), p);
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @param strDate ex: "2023-06-18"
     * @param plan
     */
    public void registerPlan(String strDate, String plan) {
        PlanItem p = new PlanItem(strDate, plan);
        planMap.put(p.getDate(), p);

        File f = new File(SAVE_FILE);
        String item = p.saveString();

        try {
            FileWriter fw = new FileWriter(f, true);
            fw.write(item);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PlanItem searchPlan(String strDate) {
        Date date = PlanItem.getDatefromString(strDate);
        return planMap.get(date);
    }

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

    public int getTotalDays(int year, int month) {
        int yearDays = (year-1) * 365 + (int)((year-1)/4) - (int)((year-1)/100) + (int)((year-1)/400);
        int monthDays = 0;
        for(int i = 1; i < month; i++) {
            monthDays += getMaxDaysOfMonth(year, i);
        }

        return yearDays + monthDays;
    }

    public void printCalender(int year, int month) {
        System.out.printf("    <<%4d년%3d월>>\n", year, month);
        System.out.println("  SU MO TU WE TH FR SA");
        System.out.println("------------------------");

        int maxDay = getMaxDaysOfMonth(year, month);
        int idx = getTotalDays(year, month) % 7;
        int i = 0;

        while(i <= maxDay + idx) {
            if(i <= idx) {
                System.out.printf("   ");
            }else {
                System.out.printf("%3d", i - idx);
            }
            if((i+1) % 7 == 0) {
                System.out.println();
            }
            i++;
        }
        System.out.println();
    }

}
