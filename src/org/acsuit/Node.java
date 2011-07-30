package org.acsuit;

public abstract class Node {
	protected Node parent;
	protected Node yes;
	protected Node no;

	public void setYes(Node yesNode) {
		this.yes = yesNode;
		yesNode.parent = this;
	}


	public void setNo(Node newno) {
		this.no = newno;
		newno.parent = this;
	}

	public Node getYes() {
		return this.yes;
	}

		
	public Node getNo() {
		return this.no;
	}

		
	public boolean hasYes() {
		if(this.yes == null){
			return false;
		}
		return true;
	}

		
	public boolean hasNo() {
		if(this.no == null){
			return false;
		}
		return true;
	}

	public Node getParent() {
		return this.parent;
	}
		
	public String getQuestion(){
		return "Are you thinking of something?";
	}
}
