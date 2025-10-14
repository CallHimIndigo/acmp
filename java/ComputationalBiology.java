import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

//  Task278 (Вычислительная биология)
public class ComputationalBiology {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("input.txt"));
             PrintWriter out = new PrintWriter("output.txt")) {

            String s = in.nextLine();
            String t = in.nextLine();

            if(s.isEmpty()){        //  Если строка s пустая
                out.println("YES");
                return;
            }

            int j = 0;
            for(int i = 0; i < t.length(); i++){
                if(t.charAt(i) == s.charAt(j)){
                    j++;
                    if(j == s.length()){
                        out.println("YES");
                        return;
                    }
                }
            }
            out.println("NO");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
