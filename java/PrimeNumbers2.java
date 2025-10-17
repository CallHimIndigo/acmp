import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

//  Task938 (Простые числа - 2)
public class PrimeNumbers2 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("input.txt"));
             PrintWriter out = new PrintWriter("output.txt")) {

            int n = in.nextInt();
            int maxCount = 0;
            int res = 0;
            for(int i = 0; i < n; i++) {
                int num = in.nextInt();
                int count = calcPrimeFactors(num);
                if(count > maxCount){
                    maxCount = count;
                    res = num;
                }
            }

            out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int calcPrimeFactors(int num){
        int count = 0;

        if(num % 2 == 0) {
            count++;
            while(num % 2 == 0) //  Убираем все степени
                num /= 2;
        }

        for(int i = 3; i*i <= num; i += 2){ //  Перебираем только нечетные
            if(num % i == 0 ){
                count++;
                while (num % i == 0)    //  Убираем все степени
                    num /= i;
            }
        }

        if(num > 1) //  Если осталось число, то оно простое
            count++;

        return count;
    }
}
