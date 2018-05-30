package dice;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import core.Utils;

public class Dice {
	/**
	 * Print the all combination sequences
	 * @param remainingSteps
	 * @param diceSequence
	 */
	public static void combinationSequence(int remainingSteps, Deque<Integer> diceSequence) {
		if(diceSequence == null) diceSequence = new ArrayDeque<Integer>();
		
		if(remainingSteps == 0) {
			Utils.printIterableInLine(diceSequence);
			return;
		}
		
		final int validMaxDiceNumber = Math.min(remainingSteps, 6);
		for(int i = 1 ; i <= validMaxDiceNumber ; ++i) {
			diceSequence.addLast(i);
			combinationSequence(remainingSteps-i, diceSequence);
			diceSequence.removeLast();
		}
	}

	/**
	 * Calculate the total count of combination
	 * @param remainingSteps
	 * @return
	 */
	public static BigInteger combinationCount(int remainingSteps) {
		if(remainingSteps == 0) {
			return BigInteger.ONE;
		}
		
		final int validMaxDiceNumber = Math.min(remainingSteps, 6);
		BigInteger count = BigInteger.ZERO;
		for(int i = 1 ; i <= validMaxDiceNumber ; ++i) {
			count = count.add(combinationCount(remainingSteps - i));
		}
		
		return count;
	}

	/**
	 * Calculate the total count of combination using Dynamic Programming
	 * @param remainingSteps
	 * @param countMap
	 * @return
	 */
	public static BigInteger combinationCountDP(int remainingSteps, Map<Integer, BigInteger> countMap) {
		if(countMap == null) {
			countMap = new HashMap<Integer, BigInteger>();
		}
		
		if(remainingSteps == 0) {
			return BigInteger.ONE;
		}
		
		if( countMap.containsKey(remainingSteps) ) {
			return countMap.get(remainingSteps);
		}
		
		final int validMaxDiceNumber = Math.min(remainingSteps, 6);
		BigInteger count = BigInteger.ZERO;
		for(int i = 1 ; i <= validMaxDiceNumber ; ++i) {
			count = count.add(combinationCountDP(remainingSteps - i, countMap));
		}
		countMap.put(remainingSteps, count);
		Utils.printKeyValue(remainingSteps, count);
		return count;
	}
	
	/**
	 * Calculate the total count of combination using Dynamic Programming without recursive. Using Map<Integer, BigInteger>
	 * @param remainingSteps
	 * @param countMap
	 * @return
	 */
	public static BigInteger combinationCountDPNoRecursive(int remainingSteps, Map<Integer, BigInteger> countMap) {
		if(countMap == null) {
			countMap = new HashMap<Integer, BigInteger>();
		}
		
		countMap.put(0, BigInteger.ONE);
		countMap.put(1, BigInteger.ONE);
		Utils.printKeyValue(1, BigInteger.ONE);
		
		int curRemainingSteps = 2;
		while(curRemainingSteps <= remainingSteps) {
			BigInteger count = BigInteger.ZERO;
			int maxDiceNumber = Math.min(curRemainingSteps, 6);
			for(int i = 1 ; i <= maxDiceNumber ; ++i) {
				count = count.add(countMap.get(curRemainingSteps - i));
			}
			
			countMap.put(curRemainingSteps, count);
			Utils.printKeyValue(curRemainingSteps, count);
			
			++curRemainingSteps;
		}
		
		return countMap.get(remainingSteps);
	}
	
	/**
	 * Calculate the total count of combination using Dynamic Programming without recursive. Using List<BigInteger>.
	 * @param remainingSteps
	 * @return
	 */
	public static BigInteger combinationCountDPNoRecursive_ListVersion(int remainingSteps) {
		List<BigInteger> countList = new ArrayList<BigInteger>();
		countList.add(BigInteger.ONE);	// countList[0] = 1;
		countList.add(BigInteger.ONE);  // countList[1] = 1;
		Utils.printKeyValue(1, BigInteger.ONE);
		
		int curRemainingSteps = 2;
		while(curRemainingSteps <= remainingSteps) {
			BigInteger count = BigInteger.ZERO;
			int maxDiceNumber = Math.min(curRemainingSteps, 6);
			for(int i = 1 ; i <= maxDiceNumber ; ++i) {
				count = count.add(countList.get(curRemainingSteps - i));
			}
			
			countList.add(count);
			Utils.printKeyValue(curRemainingSteps, count);
			
			++curRemainingSteps;
		}
		
		return countList.get(remainingSteps);
	}
}
