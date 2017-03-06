package com.dominictracey;
import java.util.Scanner;

import com.dominictracey.actions.ActionFactory;
import com.dominictracey.model.*;

public class Controller implements IController {

	// use as a singleton so we can access the ActionQueue from replay and undo commands
	protected static Controller _instance = null;
	public static IController getInstance() {
		if (_instance == null) {
			_instance = new Controller();
		}
		return _instance;
	}
	
	protected Controller() {
		//use the singleton
	}
	
	// where we support undo and replay
	protected ActionQueue actionQueue = new ActionQueue();
	
	@Override
	public void run() {
		try {
			// initialize state
			IState state = new State();
			ActionFactory actionFactory = new ActionFactory();
			
			printHelp();
			
			state.print();
			System.out.print("> ");
	
			Scanner scanner = new Scanner(System.in);
		    
			while(scanner.hasNext()) {

			    String input = scanner.nextLine();
			    if(input.contains("exit")) {
			        break;
			    }
		

			    
			    String[] tokens = input.split(" ");
			    
			    int p1 = -1;
			    if (tokens.length > 1) {
			    	p1 = Integer.parseInt(tokens[1]);
			    }
			    
			    int p2 = -1;
			    if (tokens.length > 2) {
			    	p2 = Integer.parseInt(tokens[2]);
			    }
			    
			    IAction action = actionFactory.get(tokens[0], p1, p2);
			    if (action != null) {
				    if (action.validate(state, p1, p2)) {
				    	action.execute(state);
				    	actionQueue.enqueue(action);
				    }
				    
				    state.print();
			    }
			    
			    System.out.print("> ");
			}
			scanner.close();
		} catch (Exception e) {
			// just let all the exceptions bubble up to here in the interest of brevity
			System.out.println("Something bad happened, exiting: " + e.getMessage());
		}
	}
	
	private void printHelp() {
		System.out.println("Valid actions are: size, add, mv, rm, replay, undo, exit");
	}

	@Override
	public ActionQueue getActionQueue() {
		return actionQueue;
	}
  
}
