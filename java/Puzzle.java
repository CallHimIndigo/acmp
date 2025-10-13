import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

//  Task237 (Головоломка)
public class Puzzle {
    static int n, m;
    static char[][] grid;
    static String[] words;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("input.txt"));
             PrintWriter out = new PrintWriter("output.txt")) {

            n = in.nextInt();
            m = in.nextInt();
            grid = new char[n][n];
            words = new String[m];
            in.nextLine(); //  Далее данные - с новой строки (по условию задачи)

            for(int i = 0; i < n; i++){
                String str = in.nextLine();
                for (int j = 0; j < n; j++) {
                    grid[i][j] = str.charAt(j);
                }
            }

            for(int i = 0; i < m; i++){
                words[i] = in.nextLine();
            }

            //  Ищем и обрабатываем слова
            for (String word : words) {
                boolean found = false;
                for (int i = 0; i < n && !found; i++) {
                    for (int j = 0; j < n && !found; j++) {
                        if (grid[i][j] == word.charAt(0)) {
                            if (dfs(i, j, word, 0)) {
                                found = true;
                            }
                        }
                    }
                }
            }

            //  Собираем что осталось
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != '.')
                        sb.append(grid[i][j]);
                }
            }

            char[] res = sb.toString().toCharArray();
            Arrays.sort(res);
            out.println(new String(res));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static boolean dfs(int x, int y, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        if (x < 0 || y < 0 || x >= n || y >= n || grid[x][y] == '.' || grid[x][y] != word.charAt(index)) {
            return false;
        }

        char temp = grid[x][y];
        grid[x][y] = '.';

        for (int dir = 0; dir < 4; dir++) {
            int newX = x + dx[dir];
            int newY = y + dy[dir];
            if (dfs(newX, newY, word, index + 1)) {
                return true;
            }
        }

        grid[x][y] = temp;
        return false;
    }
}
