import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

//  Task065 (Расстояние Хэмминга)
public class HammingDistance {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("input.txt"));
             PrintWriter out = new PrintWriter("output.txt")) {

            String msg = in.nextLine();
            int n = in.nextInt();
            in.nextLine();  //  Далее данные - с новой строки (по условию задачи)
            String[] arr = new String[n];
            for(int i = 0; i < n; i++){
                arr[i] = in.nextLine();
            }

            int[] distances = new int[n];
            int min = Integer.MAX_VALUE;

            //  Считаем расстояния Хэмминга для каждого сообщения
            for(int i = 0; i < n; i++){
                distances[i] = calcHammingDistance(msg, arr[i]);
                if(distances[i] < min)
                    min = distances[i];
            }

            //  Считаем количество сообщений с минимальным расстоянием и формируем вывод
            int count = 0;  //  Количество сообщений с минимальным расстоянием
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n; i++){
                if(distances[i] == min){
                    count++;
                    sb.append((i + 1)).append(" ");
                }
            }
            out.println(count);
            out.println(sb.toString().trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int calcHammingDistance(String s1, String s2){
        int distance = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i))
                distance++;
        }
        return distance;
    }
}
