import java.util.*;
public class knighttest {

    static int[] dx = {2, -2, 2, -2, 1, -1, 1, -1};
    static int[] dy = {1, 1, -1, -2, 2, 2, -2, -2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[][] visited = new boolean[6][6];
        int[][] path = new int[36][2];
        
        for (int i = 0; i < 36; i++) {
            String pos = sc.next();
            int col = pos.charAt(0) - 'A';
            int row = pos.charAt(1) - '1';
            path[i][0] = col;
            path[i][1] = row;
        }
        sc.close();

        visited[path[0][0]][path[0][1]] = true;
        boolean isValid = true;

        for (int i = 0; i < 35; i++) {
            int x  = path[i][0],   y  = path[i][1];
            int nx = path[i+1][0], ny = path[i+1][1];

            // (1) 나이트 이동이 맞는지 바로 체크
            if (!knightMoveCheck(x, y, nx, ny)) {
                isValid = false;
                break;
            }
            // (2) 이미 방문인지 체크
            if (visited[nx][ny]) {
                isValid = false;
                break;
            }
            visited[nx][ny] = true;

            // (3) 마지막 이동 시 → 시작점 복귀 체크
            if (i == 34) {
                if (!knightMoveCheck(nx, ny, path[0][0], path[0][1])) {
                    isValid = false;
                }
            }
        }

        System.out.println(isValid ? "Valid" : "Invalid");
    }

    /** 단순 나이트 이동 여부 검사 */
    static boolean knightMoveCheck(int x, int y, int nx, int ny) {
        for (int i = 0; i < 8; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx == nx && yy == ny) {
                return true;
            }
        }
        return false;
    }
}
