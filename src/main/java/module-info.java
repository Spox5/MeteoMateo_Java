module MeteoMateo {

    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;
    requires owm.japis;
    requires gson;
    requires java.sql;
    requires org.controlsfx.controls;
    opens weather.controller to javafx.fxml;
    exports weather;

}