package graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Prim {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\graph\\Bai 27"));
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] input = new int[7][7];
		int[] g = new int[20];
		int[] distance = new int[20];
		int[] res = new int[20];

		for (int i = 1; i <= m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			input[x][y] = d;
			input[y][x] = d;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i != j && input[i][j] == 0) {
					input[i][j] = 100;
				}
			}
		}

		int index_Res = 1;
		int u = 0, v = 0;
		// dua dinh 1 vao T
		g[1] = -1;
		distance[1] = -1;
		// gan gia tri cho distance[]
		for (int i = 2; i <= n; i++) {
			g[i] = 1;
			distance[i] = input[1][i];
		}
		// dua dan n-1 canh vao T
		for (int i = 2; i <= n; i++) {
			int minD = 100;
			// tim canh (u,v) ngan nhat co u thuoc U, v ngoai U
			for (int j = 2; j <= n; j++) {
				if (distance[j] != -1 && distance[j] < minD) {
					minD = distance[j];
					v = j;
					u = g[v];
				}
			}
			// cho canh (u,v) vao T, cho v vao U
			res[index_Res] = u;
			res[index_Res + 1] = v;
			g[v] = distance[v] = -1;
			index_Res += 2;
			// cap nhat lai g[] distance[] khi dua v vao U
			for (int j = 2; j <= n; j++) {
				if (distance[j] != -1 && input[v][j] < distance[j]) {
					distance[j] = input[v][j];
					g[j] = v;
				}
			}
		}
		for (int i = 1; i <= 2 * (n - 1); i++) {
			System.out.print(res[i] + " ");
		}
	}

}
