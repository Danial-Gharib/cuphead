module sample.cuphead {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.base;
    requires java.xml;
    requires org.controlsfx.controls;
    requires javafx.media;
    requires com.google.gson;
    opens sample.cuphead to javafx.fxml;
    opens sample.cuphead.view to javafx.fxml, javafx.graphics;
    opens sample.cuphead.model to com.google.gson;
    exports sample.cuphead;
}