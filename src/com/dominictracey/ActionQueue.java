package com.dominictracey;

import java.util.ArrayList;
import java.util.List;

import com.dominictracey.model.IAction;
import com.dominictracey.model.IState;

public class ActionQueue {
	
	protected List<IAction> actionQueue = new ArrayList<IAction>();
	
	public void enqueue(IAction action) {
		actionQueue.add(action);
	}
	
	public void replay(int n, IState state) {
		for (int i = actionQueue.size(); i > actionQueue.size()-n; --i) {
			state = actionQueue.get(i-1).redo(state);
		}
	}
	
	public void undo(int n, IState state) {
		for (int i = actionQueue.size(); i > actionQueue.size()-n; --i) {
			state = actionQueue.get(i-1).undo(state);
		}
	}
	
	public int getSize() { return actionQueue.size(); }
}
