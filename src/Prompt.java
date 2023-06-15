import java.util.*;

public class Prompt {
    public void runPrompt() {
        Scanner s = new Scanner(System.in);
        Calender cal = new Calender();

        while(true) {
            System.out.println("연도를 입력하세요.");
            System.out.print("YEAR> ");
            int year = s.nextInt();
            System.out.println("달을 입력하세요.");
            System.out.print("MONTH> ");
            int month = s.nextInt();

            if(month == -1) {
                break;
            }

            if(month > 12 || month < 1) {
                continue;
            }

            cal.printCalender(year, month);
        }

        System.out.println("Have a nice day!");
        s.close();
    }

    public static void main(String[] args) {
        Prompt p = new Prompt();
        p.runPrompt();
    }
}
