package com.dominictracey.actions;

import com.dominictracey.model.IAction;

public class ActionFactory {
	public IAction get(String name) {
		if (name.equals("add")) {
			return new AddAction();
		} else if (name.equals("size")) {
			return new SizeAction();
		} else {
			System.out.println("bad action requested: " + name);
			return null;
		}
	}
}
