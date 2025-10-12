import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

//  Task001 (A+B)
public class SumAB {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("input.txt"));
             PrintWriter out = new PrintWriter("output.txt")) {

            int a = in.nextInt();
            int b = in.nextInt();
            out.println(a + b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
