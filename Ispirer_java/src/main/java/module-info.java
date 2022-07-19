module org.ispirer.systems.ispirersystemsproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.ispirer.systems.desktop.fxml to javafx.fxml;
    opens org.ispirer.systems.desktop.controller to javafx.fxml;

    exports org.ispirer.systems.desktop;
    exports org.ispirer.systems.desktop.controller;
    opens org.ispirer.systems.desktop to javafx.fxml;

}