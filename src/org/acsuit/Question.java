package org.acsuit;


public class Question extends Node{
	private String question;


public Question(String question){
	this.question = question;
	this.parent = null;
	this.yes = null;
	this.no = null;
}

public Question(String question, Node parent){
	this.question = question;
	this.parent = parent;
	this.yes = null;
	this.no = null;
}

@Override
public String getQuestion() {
	return question;
}

}