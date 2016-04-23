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
@ViewController("view2.fxml")
public class View2Controller extends AbstractController {

    @ViewNode
    private Label nameLabel;

    @ViewNode
    private TextField professionField;

    @Inject
    Model myModel;

    @PostConstruct
    public void init() {
        super.init();
        nameLabel.textProperty().bindBidirectional(myModel.nameProperty());
        professionField.textProperty().bindBidirectional(myModel.professionProperty());
    }

    @PreDestroy
    public void onClose() {
        nameLabel.textProperty().unbind();
        professionField.textProperty().unbind();
    }
}
