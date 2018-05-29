# practice_java
Practice by Java.

```
src
    core
    dice
```


## dice package
Dice problems.

### Dice: combinaton sequence to achieve n'th step
```java
Dice.combinationSequence()
```
**Tip:**<br/>
Simulate the rolling to enumerate all.

### Dice: Remaining steps
Imagine you are playing a board game. You roll a 6-faced dice and move forward the same number of spaces that you rolled. If the finishing point is “n” spaces away from the starting point, please implement a program that calculates how many possible ways are there to arrive exactly at the finishing point.

```java
Dice.combinationCount()
Dice.combinationCountDP()
Dice.combinationCountDPNoRecursive()
```

**Tip:**<br/>
A gamer can only achieve n'th step only by one of below conditions
- already achieved n-1 step and then roll 1.
- already achieved n-2 step and then roll 2.
- already achieved n-3 step and then roll 3.
- already achieved n-4 step and then roll 4.
- already achieved n-5 step and then roll 5.
- already achieved n-6 step and then roll 6.
So all possible way to achieve n'th step is
```
f(n) = f(n-1) + f(n-2) + f(n-3) + f(n-4) + f(n-5) + f(n-6)
```


## core package
Some utilities.
