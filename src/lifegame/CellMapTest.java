package lifegame;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class CellMapTest {

	private static CellMap aMap;

	/**
	 * 测试数据，一代细胞.
	 */
	private int[][] a = {
			{0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 1, 0, 0, 0, 1, 1, 0 },
			{0, 1, 0, 1, 1, 1, 0, 0 },
			{0, 0, 0, 0, 1, 1, 1, 0 },
			{0, 0, 0, 1, 1, 0, 0, 0 },
			{0, 0, 1, 1, 0, 0, 0, 0 },
			{0, 0, 1, 0, 0, 0, 1, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0 }
			};
	/**
	 * 测试数据，二代细胞.
	 */
	private int[][] b = {
			{0, 0, 0, 0, 0, 0, 0, 0 },
			{0, 0, 1, 0, 0, 1, 1, 0 },
			{0, 0, 1, 1, 0, 0, 0, 0 },
			{0, 0, 1, 0, 0, 0, 1, 0 },
			{0, 0, 1, 0, 0, 0, 0, 0 },
			{0, 0, 1, 0, 1, 0, 0, 0 },
			{0, 0, 1, 1, 0, 0, 0, 0 },
			{0, 0, 0, 0, 0, 0, 0, 0 }
			};
	/**
	 * 测试数据，前端代码.
	 */
	private String str = "<table class='table-bordered'><tr><td id='1' style='background-color:black'></td><td id='1' style='background-color:white'></td><td id='1' style='background-color:white'></td><td id='1' style='background-color:white'></td><td id='1' style='background-color:black'></td><td id='1' style='background-color:black'></td></tr><tr><td id='1' style='background-color:black'></td><td id='1' style='background-color:white'></td><td id='1' style='background-color:black'></td><td id='1' style='background-color:black'></td><td id='1' style='background-color:black'></td><td id='1' style='background-color:white'></td></tr><tr><td id='1' style='background-color:white'></td><td id='1' style='background-color:white'></td><td id='1' style='background-color:white'></td><td id='1' style='background-color:black'></td><td id='1' style='background-color:black'></td><td id='1' style='background-color:black'></td></tr><tr><td id='1' style='background-color:white'></td><td id='1' style='background-color:white'></td><td id='1' style='background-color:black'></td><td id='1' style='background-color:black'></td><td id='1' style='background-color:white'></td><td id='1' style='background-color:white'></td></tr><tr><td id='1' style='background-color:white'></td><td id='1' style='background-color:black'></td><td id='1' style='background-color:black'></td><td id='1' style='background-color:white'></td><td id='1' style='background-color:white'></td><td id='1' style='background-color:white'></td></tr><tr><td id='1' style='background-color:white'></td><td id='1' style='background-color:black'></td><td id='1' style='background-color:white'></td><td id='1' style='background-color:white'></td><td id='1' style='background-color:white'></td><td id='1' style='background-color:black'></td></tr>";

	@Before
	public void setUp() throws Exception {
		aMap = new CellMap(6, 6);

	}
	
	/**
	 * 测试随机生成函数.
	 */
	@Test 
	public void testSetLivingCells() {
		aMap.setLivingCells(aMap.getCells1());
		System.out.println(Arrays.deepToString(aMap.getCells1()));

	}
	/**
	 * 测试生成前端代码函数.
	 */
	@Test
	public void testShowGraph() {
		// System.out.println(aMap.showGraph(a));
		assertEquals(str, aMap.showGraph(a));
	}
	/**
	 * 测试演化函数.
	 */
	@Test
	public void testJudgeStatu() {
		
		aMap.judgeStatu(a, aMap.getCells2());
		Arrays.deepEquals(b, aMap.getCells2());
		assertEquals(Arrays.deepToString(b), Arrays.deepToString(aMap.getCells2()));
	}
	/**
	 * 测试数据交换函数。
	 */
	@Test
	public void testExchangeData() {
		aMap.exchangeData(aMap.getCells1(), b);
		assertEquals(Arrays.deepToString(aMap.getCells1()), Arrays.deepToString(b));
	}

}
