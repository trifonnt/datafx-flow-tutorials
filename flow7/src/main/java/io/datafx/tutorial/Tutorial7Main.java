package io.datafx.tutorial;

import io.datafx.controller.flow.Flow;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by hendrikebbers on 28.01.15.
 */
public class Tutorial7Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		new Flow(View1Controller.class)
			.withLink(View1Controller.class, "changeView", View2Controller.class)
			.withLink(View2Controller.class, "changeView", View1Controller.class)
			.startInStage(primaryStage);
	}

	public static void main(String... args) {
		launch(args);
	}
}