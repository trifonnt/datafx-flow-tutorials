package io.datafx.tutorial;

import io.datafx.controller.injection.scopes.FlowScoped;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by hendrikebbers on 28.01.15.
 */
@FlowScoped
public class Model {

	private StringProperty name;

	private StringProperty profession;


	public Model() {
		name = new SimpleStringProperty();
		profession = new SimpleStringProperty();
	}

	public void loadVersionA() {
		name.set("Han Solo");
		profession.set("Smuggler");
	}

	public void loadVersionB() {
		name.set("Luke Skywalker");
		profession.set("Jedi");
	}

	public StringProperty nameProperty() {
		return name;
	}
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name.set(name);
	}

	public StringProperty professionProperty() {
		return profession;
	}
	public String getProfession() {
		return profession.get();
	}
	public void setProfession(String profession) {
		this.profession.set(profession);
	}
}