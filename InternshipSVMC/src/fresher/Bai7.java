package fresher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai7 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("F:\\InternshipSVMC\\InternshipSVMC\\src\\fresher\\inputbai7"));
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 1; i <= tc; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] input = new int[n][m];
			int[][] res = new int[10][10];
			int[][] resfinal= new int[10][10];

			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					input[j][k] = sc.nextInt();
					res[j][k] = 0;
				}
			}

			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {

					res[j][k] = 0;
				}
			}

//max hang input
			int maxh = 0;
			int x = 0, y = 0;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (maxh < input[j][k]) {
						maxh = input[j][k];
					}

				}

				for (int k = 0; k < m; k++) {
					if (maxh == input[j][k]) {
						x = j;
						y = k;
					}
				}
				res[x][y] = maxh;
				maxh = 0;
			}

// max cot input
			int maxc = 0;
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < n; k++) {
					if (maxc < input[k][j]) {
						maxc = input[k][j];
					}
				}

				for (int k = 0; k < n; k++) {
					if (maxc == input[k][j]) {
						x = k;
						y = j;
					}
				}
				res[x][y] = maxc;
				maxc = 0;
			}

//max hang res
			int maxhres = 0;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (maxhres < res[j][k]) {
						maxhres = res[j][k];
					}
				}

				for (int k = 0; k < m; k++) {
					if (maxhres == res[j][k]) {
						x = j;
						y = k;
					}
				}

				for (int k = 0; k < y; k++) {
					res[j][k] = 0;
				}
				for (int k = y + 1; k < m; k++) {
					res[j][k] = 0;
				}
				maxhres = 0;
			}
			
			for(int j=0; j<10; j++) {
				for(int k=0; k<10; k++) {
					resfinal[j][k] = res[j][k];
				}
			}
			
// max cot resfinal
			int maxcres = 0;
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < n; k++) {
					if (maxcres < resfinal[k][j]) {
						maxcres = resfinal[k][j];
					}
				}

				for (int k = 0; k < n; k++) {
					if (maxcres == resfinal[k][j]) {
						x = k;
						y = j;
					}
				}
				
				for(int k=0;k<x;k++) {
					resfinal[k][j]=0;
				}
				for(int k=x+1;k<n;k++) {
					resfinal[k][j]=0;
				}
		//	System.out.println(maxcres);
				maxcres = 0;
			}
			
			int dem=0;
			for(int j=0; j<10; j++) {
				for(int k=0; k<10; k++) {
					if(resfinal[j][k]!=0) {
						dem++;
					}
				}
			}
			System.out.println(dem);
//			for (int j = 0; j < n; j++) {
//				for (int k = 0; k < m; k++) {
//					System.out.print(resfinal[j][k] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}

	}

}
