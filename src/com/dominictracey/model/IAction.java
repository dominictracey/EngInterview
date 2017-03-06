package com.dominictracey.model;


public interface IAction {
  public enum ActionType { size, add, rm, mv, replay, undo }

  // should really do IAction1 and IAction2 to support different parameter list lengths...
  public abstract boolean validate(IState state, int slot1, int slot2);

  public abstract IState execute(IState state, int slot1, int slot2);


}
