package org.ispirer.systems.desktop.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.ispirer.systems.desktop.constant.LocaleManager;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.ispirer.systems.desktop.constant.PathConst.PATH_TO_BUNDLE;
import static org.ispirer.systems.desktop.constant.PathConst.PATH_TO_MESSAGE_FXML;

public class MessageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClose;

    @FXML
    private Label labelInformation;

    @FXML
    private Label labelMessage;

    private Stage stage;

    public MessageController() {
        stage = new Stage();
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(PATH_TO_MESSAGE_FXML));
        fxmlLoader.setResources(ResourceBundle.getBundle(PATH_TO_BUNDLE, new Locale(LocaleManager.getCurrentLang())));
        fxmlLoader.setController(this);
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.initModality(Modality.APPLICATION_MODAL);
    }

    @FXML
    void initialize() throws IOException {
        initLabelInformation();
        initText();
        initButton();
        btnClose.setOnAction(actionEvent -> {
            stage.close();
        });
    }

    public void show() {
        stage.show();
    }

    private void initLabelInformation() {
        labelInformation.setText(resources.getString("label.information"));
    }

    private void initText() {
        labelMessage.setText(resources.getString("pop.up.window.message"));
    }

    private void initButton() {
        btnClose.setText(resources.getString("btn.close"));
    }

}
