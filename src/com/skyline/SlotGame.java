package com.skyline;

import java.util.ArrayDeque;
import java.util.Deque;

import core.Utils;

public class SlotGame {
	private static boolean[] flag = new boolean[5];
	
	public static void reset() {
		for(int i = 0 ; i < flag.length ; ++i) {
			flag[i] = false;
		}
	}
	
	public static void funcList_wrong(int n) {
		if(n == 0) {
			System.out.println();
			return;
		}
		
		for(int i = 0 ; i < 5 ; ++i) {
			if(flag[i] == true) continue;
			flag[i] = true;
			System.out.print(i);
			System.out.print(",");
			funcList_wrong(--n);
			flag[i] = false;
		}
	}
	
	public static void funcList_dp(Deque<Integer> path) {
		if(path == null) {
			path = new ArrayDeque<Integer>();
		}
		
		if(path.size() == 5) {
			Utils.printIterableInLine(path);
			return;
		}
		
		for(int i = 0 ; i < 5 ; ++i) {
			if(path.contains(i)) continue;
			
			path.addLast(i);
			funcList_dp(path);
			path.removeLast();
		}
	}
}
