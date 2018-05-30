package dice;

import java.math.BigInteger;

public class DiceMain {
	public static void main(String[] args) {
		int remainingSteps = 0;
		BigInteger count;
		
		// diceCombinationPath
		remainingSteps = 13;
//		Dice.combinationSequence(remainingSteps, null);
		
		// diceCombinationCount
		remainingSteps = 30;	// needs few seconds to calculate 30
//		count = Dice.combinationCount(remainingSteps); System.out.println(count);

		// diceCombinationCount using Dynamic Programming
		remainingSteps = 610;
//		count = Dice.combinationCountDP(remainingSteps, null); System.out.println(count);
		
		// diceCombinationCount using Dynamic Programming with out recursive
		remainingSteps = 610;
//		count = Dice.combinationCountDPNoRecursive(remainingSteps, null); System.out.println(count);
	}
}
