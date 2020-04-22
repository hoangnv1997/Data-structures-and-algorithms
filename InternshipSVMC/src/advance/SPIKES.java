package advance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SPIKES {
	static int[] xValues = { -1, 1, 0, 0 };
	static int[] yValues = { 0, 0, -1, 1 };
	static int[][] visited_go = new int[41][41];
	static int[][] visited_out = new int[41][41];
	static int flag = 0;
	static int nSpike = 0;
	static int n, m;
	private static Scanner sc;

	static void solution(int x, int y, int count, int direction, char[][] map) {

		if (count > nSpike) {
			return;
		}

		if (direction == 1) {
			visited_go[x][y] = 1;
		} else {
			visited_out[x][y] = 1;
		}

		if (map[x][y] == 'x' && direction == 1) {
			solution(x, y, count, 2, map);
			return;
		}

		if (map[x][y] == '@' && direction == 2) {
			flag = 1;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int xTemp = x + xValues[i];
			int yTemp = y + yValues[i];
			if (xTemp >= 0 && xTemp < n && yTemp >= 0 && yTemp < m) {
				if (direction == 1 && visited_go[xTemp][yTemp] == 0) {
					if (map[xTemp][yTemp] != '#') {
						if (map[xTemp][yTemp] == 's') {
							solution(xTemp, yTemp, count + 1, direction, map);
						} else {
							solution(xTemp, yTemp, count, direction, map);
						}
					}
					if (flag == 1) {
						return;
					}
				} else if (direction == 2 && visited_out[xTemp][yTemp] == 0) {
					if (map[xTemp][yTemp] != '#') {
						if (map[xTemp][yTemp] == 's') {
							solution(xTemp, yTemp, count + 1, direction, map);
						} else {
							solution(xTemp, yTemp, count, direction, map);
						}
					}
					if (flag == 1) {
						return;
					}
				}
			}
		}
		if (direction == 1) {
			visited_go[x][y] = 0;
		} else {
			visited_out[x][y] = 0;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\advance\\Bai SPIKES"));
		sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		nSpike = sc.nextInt();
		sc.nextLine();
		sc.nextLine();
		char[][] map = new char[n][m];
		int startX = 0;
		int startY = 0;


		for (int i = 0; i < n; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == '@') {
					startX = i;
					startY = j;
				}
			}
			if (i < n - 1) {
				sc.nextLine();
			}

		}
		flag = 0;
		solution(startX, startY, 0, 1, map);
		if (flag == 1) {
			System.out.println("SUCCESS");
		} else {
			System.out.println("IMPOSSIBLE");
		}

	}

}
