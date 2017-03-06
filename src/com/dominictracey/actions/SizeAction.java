package com.dominictracey.actions;

import com.dominictracey.model.IAction;
import com.dominictracey.model.IState;

public class SizeAction extends BaseAction implements IAction {

	public SizeAction(int p1, int p2) {
		super(p1,p2);
	}
	

	// use the constructor to set params
	protected SizeAction() {
		super(-1,-1); //never used
	}
	
	
	protected int priorSize; // save off the prior size for redo
		
	@Override
	public IState execute(IState state) {
		// validate in case controller doesn't?
		if (validate(state, p1, p2)) {
			priorSize = state.getSize();
			// we just mutate the state here. We could be all clojure/redux etc. and create a deep copy to modify and return
			state.resize(p1);
		}	
		
		return state;
	}

	@Override
	public boolean validate(IState state, int slot1, int slot2) {
		return slot1 > -1;
	}


	@Override
	public IState redo(IState state) {
		return execute(state);
	}
	
	@Override
	public IState undo(IState state) {
		state.resize(priorSize);
		return state;
	}


}
