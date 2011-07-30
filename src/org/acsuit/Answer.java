package org.acsuit;

public class Answer extends Node{
	private String beast;

	public Answer(String beast){
		this.beast = beast;
		this.parent = null;
		this.yes = null;
		this.no = null;
	}

	public Answer(String beast, Node parent){
		this.beast = beast;
		this.parent = parent;
		this.yes = null;
		this.no = null;
	}
	
	@Override
	public String getQuestion() {
		return "Are you thinking of a " + beast + "?";
	}
	
	
	public String getAnswer() {
	return beast;
	}


}
