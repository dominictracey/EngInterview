package com.dominictracey.model;

public interface IState {

	void print();
	ISlot getSlot(int i);
	void resize(int i);
	  
}