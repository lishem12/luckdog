package basic_class_03;

import java.util.HashMap;
import java.util.Map;

// 设计RandomPool结构
//【题目】
// 设计一种结构，在该结构中有如下三个功能：
// insert(key)：将某个key加入到该结构，做到不重复加入。
// delete(key)：将原本在结构中的某个key移除。
// getRandom()：等概率随机返回结构中的任何一个key。
// Insert、delete和getRandom 方法的时间复杂度都是O(1)。
public class Code_06_RandomPool {

	public static class RandomPool<K> {
		Map<K, Integer> keyIndexMap;
		Map<Integer, K> indexKeyMap;
		int size;

		public RandomPool() {
			keyIndexMap = new HashMap<>();
			indexKeyMap = new HashMap<>();
			this.size = 0;
		}

		public void delete(K key) {
			if (!keyIndexMap.containsKey(key)) {
				return;
			}
			int index = keyIndexMap.get(key);
			keyIndexMap.remove(key);
			K lastKey = indexKeyMap.get(--this.size);
			keyIndexMap.put(lastKey, index);
			indexKeyMap.put(index, lastKey);
			indexKeyMap.remove(this.size);
		}

		public void insert(K key) {
			keyIndexMap.put(key, this.size);
			indexKeyMap.put(this.size++, key);
		}

		public K getRandom() {
			if(this.size==0) {
				return null;
			}
			int index = (int) (Math.random() * this.size);
			return indexKeyMap.get(index);
		}
	}

	public static void main(String[] args) {
		RandomPool<String> pool = new RandomPool<String>();
		pool.insert("zuo");
		pool.insert("cheng");
		pool.insert("yun");
		pool.insert("ma");
		pool.insert("shi");
		pool.insert("bing");

		pool.delete("ma");
		pool.delete("cheng");
		pool.delete("yun");
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
	}
}
