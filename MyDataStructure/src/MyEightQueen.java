
public class MyEightQueen {

	public static void main(String[] args) {
		set(0);
	}

	static boolean[] flag_a = new boolean[8];
	static boolean[] flag_b = new boolean[15];
	static boolean[] flag_c = new boolean[15];
	static int[] pos = new int[8];

	static void print() {
		for (int i = 0; i < 8; i++)
			System.out.printf("%2d", pos[i]);
		System.out.println();
		
	}

	static void set(int i) {
		for (int j = 0; j < 8; j++) {
			if (flag_a[j] == false && flag_b[i + j] == false && flag_c[i - j + 7] == false) {
				pos[i] = j;
				if (i == 7)
					print();
				else {
					flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
					set(i + 1);
					flag_a[j] = flag_b[i + j] = flag_c[1 - j + 7] = false;
				}

			}
		}

	}
	
}

//	public void eightQueen() {
//
//		int queen = 8;
//		int attempt = 0;
//		int start = 0;
//		while (queen > 0) {
//			int row = -1;
//			int col = -1;
//			attempt++;
//
//			if (attempt <= 9) {
//				start++;
//				chessBoard = new int[size][size];
//			}
//
//			for (int i = start; i < chessBoard.length; i++) {
//				for (int j = 0; j < chessBoard.length; j++) {
//					if (chessBoard[i][j] == 0) {
//						chessBoard[i][j] = queen;
//						queen--;
//						row = i;
//						col = j;
//						break;
//					}
//				}
//			}
//
//			for (int i = 0; i < chessBoard.length; i++) {
//				int a = Integer.parseInt(String.valueOf(queen) + String.valueOf(queen));
//
//				if (chessBoard[row][i] == 0) {
//					chessBoard[row][i] = a;
//				}
//
//				if (chessBoard[i][col] == 0) {
//					chessBoard[i][col] = a;
//				}
//			}
//		}
//
//	}
//
//	public void eightQueen2() {
//
//		int queen = 8;
//		int attempt = 0;
//		int start = 0;
//		int[] row = { 0, 1, 2, 3, 4, 5, 6, 7 };
//		int[] col = { 0, 1, 2, 3, 4, 5, 6, 7 };
//		while (queen > 0) {
//			attempt++;
//
//			if (attempt <= 9) {
//				start++;
//				chessBoard = new int[size][size];
//			}
//
//			for (int i : row) {
//				for (int j : col) {
//					if (chessBoard[i][j] == 0) {
//						chessBoard[i][j] = queen;
//						queen--;
//					}
//				}
//			}
//		}
//
//	}
