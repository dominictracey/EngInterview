package com.dominictracey.actions;

import com.dominictracey.model.IAction;
import com.dominictracey.model.IState;

public class SizeAction implements IAction {

	@Override
	public IState execute(IState state, int p1, int p2) {
		// validate in case controller doesn't?
		if (validate(state, p1, p2)) {
			// we just mutate the state here. We could be all clojure/redux etc. and create a deep copy to modify and return
			state.resize(p1);
		}
		
		
		return state;
	}

	@Override
	public boolean validate(IState state, int slot1, int slot2) {
		return slot1 > -1;
	}


}
