## Hello!

The implementation is mostly complete. Didn't mess around with undo-ing or replaying the undo or replay actions in the interest of time. The model package contains the interfaces used and the actions are served up by an action factory.

I maintain the action queue for undo and replaying within the controller for ease of access (the controller is accessible to the action subclasses as a singleton).

State management is pretty rudimentary so this isn't thread safe. State object would be copied and a modified instance returned to make this more robust.

Exceptions are just trapped at the main run loop, though invalid inputs should be trapped and logged before they are attempted.

Also probably should have templated IAction to support variable length parameter lists.

Also never tied the action strings into the enum (create a constructor and member variable inside enum)

I stayed away from some Java 8 constructs like lamba expressions and so forth to maximize readibility

In general it works, took me a couple of hours and hopefully you like it!

Output example:
```
Valid actions are: size, add, mv, rm, replay, undo, exit
> size 2
1: []
2: []
> size 7
1: []
2: []
3: []
4: []
5: []
6: []
7: []
> undo 1
1: []
2: []
> add 2
1: []
2: [X ]
> mv 2 1
1: [X ]
2: []
> add 2
1: [X ]
2: [X ]
> replay 2
1: [X , X ]
2: [X ]
> rm 2
1: [X , X ]
2: []
> mv 2 1
Attempt at invalid move from 2 to 1
1: [X , X ]
2: []
> mv 1 2
1: [X ]
2: [X ]
> replay 1
1: []
2: [X , X ]
> size 1
1: []
> 
```

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
3. Don't persist anything to a database or file store. Keep everthing in memory, and start from a clean slate every time the program runs.
4. Please comment your code as necessary, including explaining any assumptions you're making. No assumptions are wrong as long as we're aware of what they are.
5. We're mostly interested in how you choose to structure and organize your code, since the problem itself is relatively straightforward.
6. Feel free to add comments about tradeoffs you're making or optimizations you'd make if you had more time.
7. Please don't spend more than 2 hours on the code you submit.
8. Send us a link to a github repo with your solution within a week.


