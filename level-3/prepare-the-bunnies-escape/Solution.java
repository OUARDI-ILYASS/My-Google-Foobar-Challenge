import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Position {
    public final int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position move(int offsetX, int offsetY){
        return new Position(x+offsetX, y+offsetY);
    }

}

public class Solution {

    public static int[] X = {0, 0, 1, -1};
    public static int[] Y = {1, -1, 0, 0};

    public static int solution(int[][] map) {
        int row = map.length;
        int col = map[0].length;
        int fastestPath = Integer.MAX_VALUE;
        int[][] distFromStart = bfs(map, row, col, new Position(0,0));
        int[][] distFromFinish = bfs(map, row, col, new Position(row - 1, col - 1));


        fastestPath = reconstructFastestPath(row, col, fastestPath, distFromStart, distFromFinish);
        return fastestPath;

    }

    private static int reconstructFastestPath(int row, int col, int fastestPath, int[][] distFromStart, int[][] distFromFinish) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (distFromStart[i][j] > 0 && distFromFinish[i][j] > 0) {
                    fastestPath = Math.min(fastestPath, distFromStart[i][j] + distFromFinish[i][j] - 1);
                }
            }
        }
        return fastestPath;
    }

    private static int[][] bfs(int[][] map, int row, int col, Position start) {
        int[][] dis = new int[row][col];
        Queue<Position> Q = new LinkedList<>();
        Q.add(start);
        for (int i = 0; i < row; i++)
            Arrays.fill(dis[i], 0);

        dis[start.x][start.y] = 1;

        while (!Q.isEmpty()) {
            Position currPosition = Q.poll();

            for (int i = 0; i < 4; i++) {
                Position adjacent = currPosition.move(X[i], Y[i]);
                if (validMove(row, col, dis, adjacent)) {
                    dis[adjacent.x][adjacent.y] = dis[currPosition.x][currPosition.y] + 1;
                    if (map[adjacent.x][adjacent.y] == 1)
                        continue;
                    Q.add(adjacent);
                }
            }
        }
        return dis;
    }

    private static boolean validMove(int row, int col, int[][] dis, Position adjacent) {
        return adjacent.x >= 0 && adjacent.y >= 0 && adjacent.x < row && adjacent.y < col && dis[adjacent.x][adjacent.y] == 0;
    }
}
