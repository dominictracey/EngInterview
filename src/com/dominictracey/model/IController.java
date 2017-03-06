package com.dominictracey.model;

import com.dominictracey.ActionQueue;

public interface IController {
	  void run();
	  ActionQueue getActionQueue();
}
