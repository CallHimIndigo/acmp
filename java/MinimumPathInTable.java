import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

//  Task120 (Минимальный путь в таблице)
public class MinimumPathInTable {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("input.txt"));
             PrintWriter out = new PrintWriter("output.txt")) {

            int n = in.nextInt();
            int m = in.nextInt();
            int arr[][] = new int[n][m];
            //  Т.к. только числа, нет смысла читать строки, достаточно отталкиваться от количества чисел в строке
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    arr[i][j] = in.nextInt();
                }
            }

            int[][] dp = new int[n][m];
            dp[0][0] = arr[0][0];
            for(int i = 1; i < n; i++)
                dp[i][0] = dp[i-1][0] + arr[i][0];
            for(int j = 1; j < m; j++)
                dp[0][j] = dp[0][j-1] + arr[0][j];
            for(int i = 1; i < n; i++){
                for(int j = 1; j < m; j++){
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + arr[i][j];
                }
            }

            out.println(dp[n-1][m-1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
