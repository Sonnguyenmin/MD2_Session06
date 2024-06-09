import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class checkMail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập địa chỉ email: ");
        String email = scanner.nextLine();

        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            System.out.println("Đây là một địa chỉ email hợp lệ.");
        } else {
            System.out.println("Đây không phải là một địa chỉ email hợp lệ.");
        }
    }
}
