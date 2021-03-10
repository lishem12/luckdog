package basic_class_04;

import java.util.Comparator;
import java.util.PriorityQueue;

//输入：
//参数1，正数数组costs
//参数2，正数数组profits
//参数3，正数k
//参数4，正数m
//costs[i]表示i号项目的花费
//profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
//k表示你不能并行、只能串行的最多做k个项目m表示你初始的资金
//说明：你每做完一个项目，马上获得的收益，可以支持你去做下一个项目。
//输出：
//你最后获得的最大钱数。
public class Code_03_IPO {

	public static class Node {
		public int p;
		public int c;

		public Node(int p, int c) {
			this.p = p;
			this.c = c;
		}
	}

	public static int findMaxizedCapital(int k, int m, int[] profits, int[] capital) {
		PriorityQueue<Node> profitsMaxHeap = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o2.p - o1.p;
			}
		});

		PriorityQueue<Node> costMinHeap = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.c - o2.c;
			}
		});
		for (int i = 0; i < profits.length; ++i) {
			costMinHeap.add(new Node(profits[i], capital[i]));
		}
		int sum = 0;
		for (int i = 0; i < k; ++i) {
			while (!costMinHeap.isEmpty() && costMinHeap.peek().c <= m) {
				profitsMaxHeap.add(costMinHeap.poll());
			}
			m += profitsMaxHeap.peek().p;
		}
		return m;
	}

	public static void main(String[] args) {
		int[] capital = { 1, 5, 6, 3, 8 };
		int[] profits = { 2, 7, 6, 2, 11 };
		System.out.println(findMaxizedCapital(1, 9, profits, capital));
	}
}
