package com.dominictracey.actions;

import com.dominictracey.State;
import com.dominictracey.model.IAction;
import com.dominictracey.model.IState;

public class RemoveAction extends BaseAction implements IAction {

	// use the constructor to set params
	protected RemoveAction() {
		super(-1,-1); //default values
	}
	
	public RemoveAction(int p1, int p2) {
		super(p1,p2);
	}

	@Override
	public IState execute(IState state) {
		// validate in case controller doesn't?
		if (validate(state, p1, p2)) {
			// we just mutate the state here. We could be all clojure/redux etc. and create a deep copy to modify and return
			state.getSlot(p1).remove();
		}	
		
		return state;
	}

	@Override
	public boolean validate(IState state, int slot1, int slot2) {
		// slot has to be there and have at least one item
		return state.getSlot(slot1) != null && state.getSlot(slot1).count() > 0;
	}

	@Override
	public IState undo(IState state) {
		// we may have already lost the queue through intervening actions...
		if (state.getSize() >= p1) {
			state.getSlot(p1).remove();
		}
		return null;
	}

	@Override
	public IState redo(IState state) {
		return execute(state);
	}


}
