package org.ispirer.systems.desktop.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import org.ispirer.systems.desktop.constant.LocaleManager;
import org.ispirer.systems.desktop.observer.Publisher;
import org.ispirer.systems.desktop.observer.Subscriber;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static org.ispirer.systems.desktop.constant.LocaleConst.AVAILABLE_LANGUAGES;

public class MainController implements Publisher {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> boxLanguages;

    @FXML
    private Button btnShowWindow;

    @FXML
    private Label labelMain;

    private List<Subscriber> subscribers = new ArrayList<>();

    @FXML
    void initialize() {
        initBoxLanguages();
        initButton();
        initLabel();
        boxLanguages.setOnAction(actionEvent -> {
            String selectedItem = boxLanguages.getSelectionModel().getSelectedItem();
            LocaleManager.setCurrentLang(selectedItem);
            notifySubscribers();
        });

        btnShowWindow.setOnAction(actionEvent -> {
            MessageController messageController = new MessageController();
            messageController.show();
        });
    }

    private void initBoxLanguages() {
        AVAILABLE_LANGUAGES.forEach(lang -> boxLanguages.getItems().add(lang));
        boxLanguages.getSelectionModel().select(LocaleManager.getCurrentLang());
    }

    private void initButton() {
        btnShowWindow.setText(getBundle("show.window"));
    }

    private void initLabel() {
        labelMain.setText(getBundle("main.message"));
    }

    private String getBundle(String key) {
        return resources.getString(key);
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void notifySubscribers() {
        subscribers.forEach(subscriber -> {
            try {
                subscriber.update();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
