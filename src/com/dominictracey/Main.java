package com.dominictracey;

import com.dominictracey.model.IController;

public class Main {
	
	public static void main(String[] args) {
		IController controller = new Controller();
		controller.run();
	}
	
}
