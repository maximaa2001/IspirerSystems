package org.ispirer.systems.desktop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.ispirer.systems.desktop.constant.LocaleManager;
import org.ispirer.systems.desktop.controller.MainController;
import org.ispirer.systems.desktop.observer.Subscriber;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.ispirer.systems.desktop.constant.PathConst.PATH_TO_BUNDLE;
import static org.ispirer.systems.desktop.constant.PathConst.PATH_TO_MAIN_FXML;

public class App extends Application implements Subscriber {
    private Stage stage;

    private AnchorPane anchorPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        create();
    }

    @Override
    public void update() throws IOException {
        AnchorPane newAnchorPane = loadFxml();
        anchorPane.getChildren().setAll(newAnchorPane.getChildren());
    }

    private void create() throws IOException {
        anchorPane = loadFxml();
        stage.setResizable(false);
        Scene scene = new Scene(anchorPane, 700, 150);
        stage.setScene(scene);
        stage.show();
    }

    private AnchorPane loadFxml() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(PATH_TO_MAIN_FXML));
        fxmlLoader.setResources(ResourceBundle.getBundle(PATH_TO_BUNDLE, new Locale(LocaleManager.getCurrentLang())));

        AnchorPane load = fxmlLoader.load();
        MainController controller = fxmlLoader.getController();
        controller.addSubscriber(this);
        stage.setTitle(fxmlLoader.getResources().getString("test.project"));

        return load;
    }

}
