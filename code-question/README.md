## Coding Exercise

Design a command-line controller program for a robotic arm that takes commands which moves blocks stacked in a series of slots. After each command, output the state of the slots, which each line of output corresponding to a slot and each X corresponding to a block.

### Notes
1. We should be able to run your program from the command line.
2. Use whatever language you'd like, but don't use any libraries or frameworks aside from whatever is starndard in the language you choose.
4. Don't spend more than an hour or two.
5. Commit the code for your solution in this folder in your repo.

**Commands:**

  * size [n] - Adjust the number of slots, resizing if necessary. Program must start with this to be valid.
  * add [slot] - Add a block to the top of the specified slot.
  * mv [slot1] [slot2] - Moves the top block from slot1 to slot2.
  * rm [slot] - Removes the top block from the slot.

Your program should validate that the commands are syntactically valid before executing them.

### Example

```
> size 3
1:
2:
3:

> add 2
1:
2: X
3:

> add 3
1:
2: X
3: X

> mv 3 2
1:
2: XX
3:

> rm 2
1:
2: X
3:
```
