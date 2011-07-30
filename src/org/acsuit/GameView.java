package org.acsuit;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;

public class GameView extends Activity implements OnClickListener{
	TextView infoText;
	EditText editText;
	String input;
	boolean again=true;
	//Node head;
	Node newBeast;
	Node newQuestion;
	Node base;
	Node start;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		infoText = (TextView) this.findViewById(R.id.gameText);

		start=new Question("Does it live in the ground?");
		start.setYes(new Answer("Niffler"));
		start.setNo(new Answer("Dementor"));
		base=start;
		infoText.setText(start.getQuestion());
		View yesButton = findViewById(R.id.yesButton);
		yesButton.setOnClickListener(this);
		
		View noButton = findViewById(R.id.noButton);
		noButton.setOnClickListener(this);

		editText= (EditText) findViewById(R.id.editText);
		editText.setOnKeyListener(new OnKeyListener() {
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// If the event is a key-down event on the "enter" button
				if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
						(keyCode == KeyEvent.KEYCODE_ENTER)) {
					input = editText.getText().toString().toLowerCase();
					editText.setText("");
					infoText.setText(getNextInput());
					return true;
				}
				return false;
			}
		});


	}
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.yesButton:
			if (start.hasYes()) {
				start = start.getYes();
				infoText.setText(start.getQuestion());
			}
			else{
				infoText.setText("I win! Muhaha! Enter 'q' to exit");
			}
			break;
		case R.id.noButton:

			if(start.hasNo()){
				start = start.getNo();
				infoText.setText(start.getQuestion());
			}
			else{
				if(start instanceof Answer){
					Answer animal = (Answer) start;
					infoText.setText("What is a question that the answer would be yes for your beast, but no for a " 
							+ animal.getAnswer().toLowerCase() + "?");
				}
			}
			break;
			
		}

	}

	public String getNextInput(){
	

		if(input.equalsIgnoreCase("q")){
			finish();
			return null;
		}
		else if (input.contains("?")){
			newQuestion = new Question(input);
			return ("Let's keep playing!");
		}
		else{
			newBeast= new Answer(input);
			rebranch();
			return("Type 'q' to stop playing");
		}
	}
	public void rebranch(){
		Node parent = start.getParent();
		newQuestion.setNo(start);
		newQuestion.setYes(newBeast);

	}



}
