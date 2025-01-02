package programmers;

import java.util.*;

public class Lv2_1844 {
    int[] dx = new int[]{1,0,-1,0}; //
    int[] dy = new int[]{0,1,0,-1};

    public static void main(String[] args) {
        Lv2_1844 lv = new Lv2_1844();
        int[][] maps = new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        lv.solution(maps);
    }

    public int solution(int[][] maps) {
        int answer = 0;
        int[][] vis = new int[maps.length][maps[0].length];
        bfs(maps, vis);
        answer = vis[maps.length-1][maps[0].length-1];
        if (answer == 0) {
            answer = -1;
        }
        return answer;
    }

    public void bfs(int[][] maps, int[][] vis) {
        int x = 0;
        int y = 0;
        vis[x][y] = 1;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x,y});

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i=0; i<4; i++) {
                int nx = cx+dx[i];
                int ny = cy+dy[i];

                if (nx < 0 || nx > maps.length-1 || ny < 0 || ny > maps[0].length-1) {
                    continue;
                }
                if (vis[nx][ny] == 0 && maps[nx][ny] == 1) {
                    vis[nx][ny] = vis[cx][cy] + 1;
                    que.add(new int[]{nx,ny});
                }
            }
        }
        System.out.println(que);

    }

}
