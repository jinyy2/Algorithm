import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* input-data
7
0 1 1 0 1 0 0
0 1 1 0 1 0 1
1 1 1 0 1 0 1
0 0 0 0 1 1 1
0 1 0 0 0 0 0
0 1 1 1 1 1 0
0 1 1 1 0 0 0
*/
public class FloodFill_BFS {

	static int N;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // input-end

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					cnt++;
					bfs(i, j, cnt + 1);
				}
			}
		}

		// 크기 구하기
		int[] count = new int[2 + cnt];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
						count[map[i][j]]++;
				}
			}
			
		System.out.println(cnt);
		for (int k = 2; k < cnt + 2; k++) {
			System.out.println(count[k]);
		}
	}

	public static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	private static void bfs(int r, int c, int group) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(r, c));
		map[r][c] = group;
		while (!queue.isEmpty()) {
			Point temp = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = temp.r + dr[d];
				int nc = temp.c + dc[d];

				if (!safe(nr, nc))
					continue;

				if (map[nr][nc] == 1) {
					map[nr][nc] = group;
					queue.offer(new Point(nr, nc));
				}
			}
		}
	}

	private static boolean safe(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < N;
	}

}
