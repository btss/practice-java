# dice package
Dice related problems.

## Dice: combinaton sequence to achieve N'th step

```java
// code
Dice.combinationSequence(4, null);

/* output
1,1,1,1
1,1,2
1,2,1
1,3
2,1,1
2,2
3,1
4
*/
```

**Tip:**  
Simulate the rolling to enumerate all.  
Assume now remains N steps to finish, after rolling the dice, there will be possible results.

- rolls 1, then remains N-1 steps to go.
- rolls 2, then remains N-2 steps to go.
- rolls 3, then remains N-3 steps to go.
- rolls 3, then remains N-4 steps to go.
- rolls 4, then remains N-5 steps to go.
- rolls 6, then remains N-6 steps to go.

Repeats above process until remains 0 step so that can enumerate all combination sequences.

## Dice: Remaining steps
Imagine you are playing a board game. You roll a 6-faced dice and move forward the same number of spaces that you rolled. If the finishing point is “n” spaces away from the starting point, please implement a program that calculates how many possible ways are there to arrive exactly at the finishing point.

```java
// code
Dice.combinationCount(10);
Dice.combinationCountDP(10, null);
Dice.combinationCountDPNoRecursive(10);

/* output
1: 1
2: 2
3: 4
4: 8
5: 16
6: 32
7: 63
8: 125
9: 248
10: 492
*/
```

**Tip:**  

A gamer can only achieve N'th step only by one of below conditions
- already achieved N-1 step and then roll 1.
- already achieved N-2 step and then roll 2.
- already achieved N-3 step and then roll 3.
- already achieved N-4 step and then roll 4.
- already achieved N-5 step and then roll 5.
- already achieved N-6 step and then roll 6.

So all possible way to achieve n'th step is
```
f(N) = f(N-1) + f(N-2) + f(N-3) + f(N-4) + f(N-5) + f(N-6)
```
