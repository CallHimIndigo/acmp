import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

//  Task159 (Обратная перестановка)
public class InversePermutation {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("input.txt"));
             PrintWriter out = new PrintWriter("output.txt")) {

            int n = in.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = in.nextInt();
            int[] p = new int[n];

            for(int i = 0; i < n; i++){
                p[arr[i] - 1] = i + 1;
            }

            StringBuilder sb = new StringBuilder();
            for(int value : p){
                sb.append(value).append(" ");
            }

            out.println(sb.toString().trim());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
