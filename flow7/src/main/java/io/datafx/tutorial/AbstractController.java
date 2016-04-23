package io.datafx.tutorial;

import io.datafx.controller.ViewNode;
import io.datafx.controller.flow.action.ActionMethod;
import io.datafx.controller.flow.action.ActionTrigger;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * Created by hendrikebbers on 28.01.15.
 */
public abstract class AbstractController {

	@ViewNode
	@ActionTrigger("clear")
	private Button clearButton;

	@ViewNode
	@ActionTrigger("loadA")
	private Button loadAButton;

	@ViewNode
	@ActionTrigger("loadB")
	private Button loadBButton;

	@ViewNode
	@ActionTrigger("changeView")
	private Button changeView;

	@ViewNode
	private Label resultLabel;

	@Inject
	Model myModel;

	@PostConstruct
	public void init() {
		myModel.nameProperty()
				.addListener(e -> resultLabel.setText(myModel.getName() + " is a " + myModel.getProfession()));
		myModel.professionProperty()
				.addListener(e -> resultLabel.setText(myModel.getName() + " is a " + myModel.getProfession()));
		resultLabel.setText(myModel.getName() + " is a " + myModel.getProfession());
	}

	@ActionMethod("clear")
	private void clear() {
		myModel.setName(null);
		myModel.setProfession(null);
	}

	@ActionMethod("loadA")
	private void loadA() {
		myModel.loadVersionA();
	}

	@ActionMethod("loadB")
	private void loadB() {
		myModel.loadVersionB();
	}
}