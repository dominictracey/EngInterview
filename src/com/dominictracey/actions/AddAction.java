package com.dominictracey.actions;

import com.dominictracey.State;
import com.dominictracey.model.IAction;
import com.dominictracey.model.IState;

public class AddAction implements IAction {

	@Override
	public IState execute(IState state, int slot1, int slot2) {
		// validate in case controller doesn't?
		if (validate(state, slot1, slot2)) {
			// we just mutate the state here. We could be all clojure/redux etc. and create a deep copy to modify and return
			state.getSlot(slot1).add("X ");
		}
		
		
		return state;
	}

	@Override
	public boolean validate(IState state, int slot1, int slot2) {
		return state.getSlot(slot1) != null;
	}


}
