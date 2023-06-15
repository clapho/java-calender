import java.util.*;

public class Sum {
    public static void main(String[] args) {
        System.out.println("두 수를 입력하세요.");
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

        String[] splitedInput = input.split(" ");
        int first = Integer.parseInt(splitedInput[0]);
        int second = Integer.parseInt(splitedInput[1]);

        System.out.printf("두 수의 합은 %d 입니다.", first + second);
        s.close();
    }
}
