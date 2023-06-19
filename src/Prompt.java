import java.text.ParseException;
import java.util.*;

public class Prompt {
    public void printMenu() {
        System.out.println("+-------------------+");
        System.out.println("| 1. 일정 등록");
        System.out.println("| 2. 일정 검색");
        System.out.println("| 3. 달력 보기");
        System.out.println("| h. 도움말 q. 종료");
        System.out.println("+-------------------+");
    }

    public void runPrompt() throws ParseException {
        printMenu();
        Scanner scanner = new Scanner(System.in);
        Calender cal = new Calender();

        while(true) {
            System.out.println("명령(1, 2, 3, h, q)");
            String cmd = scanner.nextLine();

            if(cmd.equals("1")) cmdRegister(scanner, cal);
            else if(cmd.equals("2")) cmdSearch(scanner, cal);
            else if(cmd.equals("3")) cmdCal(scanner, cal);
            else if(cmd.equals("h")) printMenu();
            else if(cmd.equals("q")) break;
        }

        System.out.println("Have a nice day!");
        scanner.close();
    }

    private void cmdRegister(Scanner s, Calender c) throws ParseException {
        System.out.println("[일정 등록] 날짜를 입력하세요.(yyyy-MM-dd)");
        String date = s.next();
        String plan = "";
        s.nextLine();
        System.out.println("일정을 입력하세요.");
        plan = s.nextLine();

        c.registerPlan(date, plan);
    }

    private void cmdSearch(Scanner s, Calender c) {
        System.out.println("[일정 검색] 날짜를 입력하세요.");
        String date = s.nextLine();
        PlanItem plan;
        plan = c.searchPlan(date);
        if(plan != null) {
            System.out.println(plan.detail);
        }else {
            System.out.println("일정이 없습니다.");
        }
    }

    public void cmdCal(Scanner s, Calender c) {
        System.out.println("연도를 입력하세요.");
        System.out.print("YEAR> ");
        int year = s.nextInt();

        System.out.println("달을 입력하세요.");
        System.out.print("MONTH> ");
        int month = s.nextInt();
        s.nextLine();

        if(month > 12 || month < 1) {
            System.out.println("잘못된 입력입니다.");
            return;
        }

        c.printCalender(year, month);
    }

    public static void main(String[] args) throws ParseException {
        Prompt p = new Prompt();
        p.runPrompt();
    }
}
