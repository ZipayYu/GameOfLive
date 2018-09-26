package lifegame;

import java.util.Random;

/**
 * 细胞阵列类.
 * @author Administrator
 */
public class CellMap {
	/**
	 * 行数.
	 */
	private int row;
	/**
	 * 列数.
	 */
	private int col;
	/**
	 * 初代细胞.
	 */
	private int[][] cells1;

	/**
	 * 二代细胞.
	 */
	private int[][] cells2;
	/**
	 * 获取cells1.
	 * @return cells1
	 */
	public int[][] getCells1() {
		return cells1;
	}

	/**
	 * 获取cells2.
	 * @return cells2
	 */
	public int[][] getCells2() {
		return cells2;
	}

	/**
	 * 构造函数.
	 * @param x   行
	 * @param y   列
	 */
	public CellMap(final int x, final int y) {
		super();
		this.row = x;
		this.col = y;
		cells1 = new int[row + 2][col + 2];
		cells2 = new int[row + 2][col + 2];
		for (int i = 0; i < row + 2; i++) {
			for (int j = 0; j < col + 2; j++) {
				cells1[i][j] = 0;
				cells2[i][j] = 0;
			}
		}
	}

	/**
	 * 生成ui信息.
	 * @param cells 细胞数组
	 * @return str 前端ui代码
	 */
	public String showGraph(final int[][] cells) {
		String str = "<table class='table-bordered'>";
		int id = 1;
		for (int i = 1; i < row + 1; i++) {
			str = str + "<tr>";
			for (int j = 1; j < col + 1; j++) {
				str += "<td id='" + id;
				if (cells[i][j] == 1) {
					str += "' style='background-color:black'></td>";
				} else {
					str += "' style='background-color:white'></td>";
				}
			}
			str += "</tr>";
		}
		return str;
	}

	/**
	 * 计算下一代细胞阵列状态.
	 * @param cells1 一代细胞
	 * @param cells2 二代细胞
	 */
	public void judgeStatu(int[][] cells1, int[][] cells2) {
		for (int i = 1; i <= row; i++) {

			for (int j = 1; j <= col; j++) {

				// 计算周围活细胞个数
				int count = cells1[i - 1][j - 1]
						+ cells1[i - 1][j]
						+ cells1[i - 1][j + 1]
						+ cells1[i][j - 1]
						+ cells1[i][j + 1]
						+ cells1[i + 1][j - 1]
						+ cells1[i + 1][j]
						+ cells1[i + 1][j + 1];
				// 判断细胞下一代状态
				if (count == 2) {
					cells2[i][j] = cells1[i][j];
				} else if (count == 3) {
					cells2[i][j] = 1;
				} else {
					cells2[i][j] = 0;
				}
			}
		}

	}



	/**
	 * 随机生成初始活细胞.
	 */
	public void setLivingCells(int[][] cells) {
		int max = row * col;
		int min = 1;
		Random random = new Random();
		int num = random.nextInt(max) % (max - min + 1) + min;
		for (int index = 1; index <= num; index++) {
			int i = random.nextInt(row) % (row - 1 + 1) + 1;
			int j = random.nextInt(col) % (col - 1 + 1) + 1;
			cells[i][j] = 1;
		}

	}

	/**
	 * 将二代细胞作为一代细胞.
	 * @param cells1 一代细胞
	 * @param cells2 二代细胞
	 */
	public void exchangeData(int[][] cells1, int[][] cells2) {
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				cells1[i][j] = cells2[i][j];
			}
		}
	}
}
