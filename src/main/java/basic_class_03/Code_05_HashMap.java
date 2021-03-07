package basic_class_03;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 讲解HashMap的 看看就行
 */
public class Code_05_HashMap {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("zuo", "31");

		System.out.println(map.containsKey("zuo")); // true
		System.out.println(map.containsKey("chengyun")); // false
		System.out.println("====================");

		System.out.println(map.get("zuo")); // 31
		System.out.println(map.size()); // 1
		System.out.println("====================");

		System.out.println(map.remove("zuo")); // 31
		System.out.println(map.containsKey("zuo")); // false
		System.out.println(map.get("zuo")); // null
		System.out.println(map.isEmpty()); // true
		System.out.println(map.size()); // 0

		System.out.println("====================");

		map.put("zuo", "31");
		System.out.println(map.get("zuo")); // 31
		map.put("zuo", "32");
		System.out.println(map.get("zuo")); // 32
		System.out.println("====================");

		map.put("zuo", "31");
		map.put("cheng", "32");
		map.put("yun", "33");

		for (String key : map.keySet()) {
			System.out.println(key); // 无序的 yun zuo cheng
		}
		System.out.println("====================");

		for (String value : map.values()) {
			System.out.println(value); // 33 31 32
		}
		System.out.println("=========================");

		map.clear();
		map.put("A", "1");
		map.put("B", "2");
		map.put("C", "3");
		map.put("D", "1");
		map.put("E", "2");
		map.put("F", "3");
		map.put("G", "1");
		map.put("H", "2");
		map.put("I", "3");

		for (Map.Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "," + value);
		}
		System.out.println("=========================");

		System.out.println("Map元素移除不可以用迭代器，只能用以下方式：");

		List<String> removeKeys = new ArrayList<>();
		
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (!entry.getValue().equals("1")) {
				removeKeys.add(entry.getKey());
			}
		}

		for (String key : removeKeys) {
			map.remove(key);
		}

		for (Map.Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "," + value);
		}
		System.out.println("======================");
	}

}
