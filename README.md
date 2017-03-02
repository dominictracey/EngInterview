## Coding Exercise

Design a command-line controller program for a robotic arm that takes commands that move blocks stacked in a series of slots. After each command, output the state of the slots, which each line of output corresponding to a slot and each X corresponding to a block.

**Commands:**

  * size [n] - Adjusts the number of slots, resizing if necessary. Program must start with this to be valid.
  * add [slot] - Adds a block to the specified slot.
  * mv [slot1] [slot2] - Moves a block from slot1 to slot2.
  * rm [slot] - Removes a block from the slot.
  * replay [n] - Replays the last n commands.
  * undo [n] - Undo the last n commands.

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

### Notes
1. We should be able to run your program from the command line.
2. Use whatever language you'd like, but don't use any libraries or frameworks aside from whatever is standard in the language you choose.
3. Please comment your code as necessary, including explaining any assumptions you're making. No assumptions are wrong as long as we're aware of what they are.
4. We're mostly interested in how you choose to structure and organize your code, since the problem itself is relatively straightforward.
5. Feel free to add comments about tradeoffs you're making or optimizations you'd make if you had more time, but plase don't spend more than a few hours on the code you submit.
6. Send us a link to a github repo with your solution.


