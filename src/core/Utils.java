package core;

import static java.lang.System.out;

import java.util.Map;

public class Utils {
	private static boolean isOutputDebugInfo = false;
	private static String seperator = ",";
	
	//===== toStr()
	public static String toStr(Object obj) {
		debugln("obj is null");
		if(obj == null) return "null";
		
		debugln("class: " + obj.getClass().getName());
		return obj.toString();
	}
	
	public static <K, V> String toStrKeyValue(K k, V v) {
		return String.format("%s: %s", toStr(k), toStr(v));
	}

	//===== print Iterable
	public static <T> void printIterable(Iterable<T> iter) {
		for(T t : iter) {
			out.println(toStr(t));
		}
	}
	
	public static <T> void printIterableInLine(Iterable<T> iter) {
		boolean hasMore = false;
		for(T t : iter) {
			if(hasMore) out.print(seperator);
			out.print(toStr(t));
			hasMore = true;
		}
		out.println();
	}
	
	//===== print Key: Value
	public static <K, V> void printKeyValue(K k, V v) {
		out.println(toStrKeyValue(k, v));
	}
	
	//===== print Map
	public static <K, V> void printMap(Map<K, V> map) {
		for(Map.Entry<K, V> entry : map.entrySet()) {
			K k = entry.getKey();
			V v = entry.getValue();
			
			out.println(toStrKeyValue(k, v));
		}
	}
	
	public static <K, V> void printMapInLine(Map<K, V> map) {
		boolean hasMore = false;
		for(Map.Entry<K, V> entry : map.entrySet()) {
			K k = entry.getKey();
			V v = entry.getValue();
			
			if(hasMore) out.print(seperator);
			out.print(toStrKeyValue(k, v));
			hasMore = true;
		}
		out.println();
	}
	
	//===== debug
	private static void debug(String format, Object... args) {
		if(isOutputDebugInfo) out.format(format, args);
	}
	
	private static void debugln(String str) {
		if(isOutputDebugInfo) out.println(str);
	}

	//===== test main
		public static void main(String[] args) {
			out.println("Utils.main()");
	//		isOutputDebugInfo = true;
			
			// toStr()
			out.println(toStr(null));	// null
			out.println(toStr(10));		// 10
			out.println(toStr(100L));	// 100
			out.println(toStr(true));	// true
			out.println(toStr(false));	// false
		}
}
