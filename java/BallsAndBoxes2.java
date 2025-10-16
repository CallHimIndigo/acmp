import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

//  Task864 (Шары и коробки - 2)
public class BallsAndBoxes2 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("input.txt"));
             PrintWriter out = new PrintWriter("output.txt")) {

            int n = in.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = in.nextInt();

            //  Считаем переносы
            int[] flows = new int[n];
            int sum = 0;
            for(int i = 0; i < n; i++){
                sum += arr[i] - 1;
                flows[i] = sum;
            }

            //  Сортируем и находим медиану для минимизации суммы абсолютных отклонений
            Arrays.sort(flows);
            int median = flows[n/2];
            int res = 0;
            for(int i : flows){
                res += Math.abs(i - median);
            }

            out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
