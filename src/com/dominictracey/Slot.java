package com.dominictracey;

import java.util.ArrayList;
import java.util.List;

import com.dominictracey.model.ISlot;

public class Slot implements ISlot {

	protected List<String>slot = new ArrayList<String>();
	
	@Override
	public void print() {
		System.out.println(slot.toString());	
	}

	@Override
	public boolean add(String s) {
		slot.add(s);
		return true;
	}

	@Override
	public boolean remove(String s) {
		if (slot.size() > 0) {
			slot.remove(0);
			return true;
		} else {
			return false;
		}
	}

}
