import java.util.Scanner;

public class Calender {
    private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int getMaxDaysOfMonth(int month) {
        return MAX_DAYS[month-1];
    }

    public void printSampleCalender() {
        System.out.println("  일 월 화 수 목 금 토");
        System.out.println("-------------------");
        for(int i = 1; i <= 28; i++) {
            System.out.printf("%3d", i);
            if(i % 7 == 0) {
                System.out.println('\n');
            }
        }
    }

    public static void main(String[] args) {
        Calender cal = new Calender();
        System.out.println("달을 입력하세요.");
        Scanner s = new Scanner(System.in);
        int month = s.nextInt();

        System.out.printf("%d월은 %d일까지 있습니다.\n", month, cal.getMaxDaysOfMonth(month));
        s.close();
    }
}
