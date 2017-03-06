package com.dominictracey.actions;

import com.dominictracey.model.IAction;
import com.dominictracey.model.IState;

public class MoveAction extends BaseAction implements IAction {

	// use the constructor to set params
	protected MoveAction() {
		super(-1,-1); //default values
	}
	
	public MoveAction(int p1, int p2) {
		super(p1,p2);
	}

	@Override
	public IState execute(IState state) {
		// validate in case controller doesn't?
		if (validate(state, p1, p2)) {
			// we just mutate the state here. We could be all clojure/redux etc. and create a deep copy to modify and return
			state.getSlot(p1).remove();
			state.getSlot(p2).add("X ");
		}
		
		
		return state;
	}

	@Override
	public boolean validate(IState state, int slot1, int slot2) {
		if (state.getSlot(slot1) != null && state.getSlot(slot2) != null && state.getSlot(slot1).count() > 0) {
			return true; 
		} else {
			System.out.println("Attempt at invalid move from " + slot1 + " to " + slot2);
			return false;
		}
	}

	@Override
	public IState undo(IState state) {
		// we may have already lost the queue through intervening actions...
		if (state.getSize() >= p1 && state.getSize() >= p2 & state.getSlot(p2).count() > 0) {
			state.getSlot(p2).remove();
			state.getSlot(p1).add("X ");
		} else {
			System.out.println("Attempt at invalid move from " + p2 + " to " + p1 + ". In undo.");
		}
		return state;
	}

	@Override
	public IState redo(IState state) {
		return execute(state);
	}


}
