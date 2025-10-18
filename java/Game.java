import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

//  Task004 (Игра)
public class Game {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("input.txt"));
             PrintWriter out = new PrintWriter("output.txt")) {

            int k = in.nextInt();
            out.println(k*100 + 90 + (9-k));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
