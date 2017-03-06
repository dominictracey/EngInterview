package com.dominictracey.model;

public interface IState {

	void print();
	ISlot getSlot(int i);
	int getSize();
	void resize(int i);
	  
}