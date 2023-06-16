import java.util.*;

public class Prompt {
    public void runPrompt() {
        Scanner s = new Scanner(System.in);
        Calender cal = new Calender();

        while(true) {
            System.out.println("연도를 입력하세요.(exit: -1)");
            System.out.print("YEAR> ");
            int year = s.nextInt();
            if(year == -1) break;

            System.out.println("달을 입력하세요.");
            System.out.print("MONTH> ");
            int month = s.nextInt();
            s.nextLine();

            System.out.println("첫번째 요일을 입력하세요. (SU, MO, TU, WE, TH, FR, SA)");
            System.out.print("WEEKDAY> ");
            String weekDay = s.nextLine();

            if(month > 12 || month < 1) {
                System.out.println("잘못된 입력입니다.");
                continue;
            }

            cal.printCalender(year, month, weekDay);
        }

        System.out.println("Have a nice day!");
        s.close();
    }

    public static void main(String[] args) {
        Prompt p = new Prompt();
        p.runPrompt();
    }
}
