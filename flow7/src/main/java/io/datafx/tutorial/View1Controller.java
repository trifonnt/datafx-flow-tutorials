package io.datafx.tutorial;

import io.datafx.controller.ViewController;
import io.datafx.controller.ViewNode;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

/**
 * Created by hendrikebbers on 28.01.15.
 */
@ViewController("view1.fxml")
public class View1Controller extends AbstractController {

    @ViewNode
    private TextField nameField;

    @ViewNode
    private Label professionLabel;

    @Inject
    Model myModel;

    @PostConstruct
    public void init() {
        super.init();
        nameField.textProperty().bindBidirectional(myModel.nameProperty());
        professionLabel.textProperty().bindBidirectional(myModel.professionProperty());
    }

    @PreDestroy
    public void onClose() {
        nameField.textProperty().unbind();
        professionLabel.textProperty().unbind();
    }
}
