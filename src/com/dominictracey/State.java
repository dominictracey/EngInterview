package com.dominictracey;

import java.util.ArrayList;
import java.util.List;

import com.dominictracey.model.ISlot;
import com.dominictracey.model.IState;

public class State implements IState {

	protected List<ISlot> state = new ArrayList<ISlot>();
	
	@Override
	public void print() {
		
		int count = 1;
		for (ISlot slot : state) {
			System.out.print(count + ": ");
			slot.print();
			++count;
		}	
	}

	@Override
	public ISlot getSlot(int i) {
		// pass in zero-based index (input is 1-based)
		if (i <= state.size()) {
			return state.get(i-1);
		} else {
			System.out.println("Invalid slot requested: " + i);
			return null;
		}
	}
	
	@Override
	public void resize(int i) {
		if (i >= 0) {
			if (state.size() < i) {
				// tack on new ones
				int numToAdd = i-state.size();
				for (int c = 0; c < numToAdd; ++c) {
					state.add(new Slot());
				}
			} else {
				// trim from end
				//int numToRemove  
				for (int c = state.size()-1; c >= i; --c) {
					state.remove(c);
				}
			}
		} else {
			System.out.println("Invalid resize attempt");
		}
	}

	@Override
	public int getSize() {
		return state.size();
	}
	
	

}
