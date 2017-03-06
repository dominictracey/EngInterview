package com.dominictracey.actions;

import com.dominictracey.Controller;
import com.dominictracey.State;
import com.dominictracey.model.IAction;
import com.dominictracey.model.IState;

public class UndoAction extends BaseAction implements IAction {
	
	public UndoAction(int p1, int p2) {
		super(p1,p2);
	}
	
	// use the constructor to set params
	protected UndoAction() {
		super(-1,-1); //never used
	}

	@Override
	public IState execute(IState state) {
		// validate in case controller doesn't?
		if (validate(state, p1, p2)) {
			// we just mutate the state here. We could be all clojure/redux etc. and create a deep copy to modify and return
			Controller.getInstance().getActionQueue().undo(p1, state);
		}
		
		
		return state;
	}

	@Override
	public boolean validate(IState state, int p1, int p2) {
		// need to have this many actions to undo
		return Controller.getInstance().getActionQueue().getSize() > p1;
	}
	
	// TODO recursion...
	// so replay and undo can't be replayed or undone in current version
	
	@Override
	public IState redo(IState state) {
		return state;
	}
	@Override
	public IState undo(IState state) {		
		return state;
	}


}
