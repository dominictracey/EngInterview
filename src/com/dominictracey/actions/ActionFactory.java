package com.dominictracey.actions;

import com.dominictracey.model.IAction;

public class ActionFactory {
	public IAction get(String name, int p1, int p2) {
		if (name.equals("add")) {
			return new AddAction(p1, p2);
		} else if (name.equals("size")) {
			return new SizeAction(p1, p2);
		} else if (name.equals("replay")) {
			return new ReplayAction(p1, p2);
		} else if (name.equals("undo")) {
			return new UndoAction(p1, p2);
		} else if (name.equals("mv")) {
			return new MoveAction(p1, p2);
		} else if (name.equals("rm")) {
			return new RemoveAction(p1, p2);
		} else {
			System.out.println("bad action requested: " + name);
			return null;
		}
	}
}
