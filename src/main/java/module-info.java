module MeteoMateo {

    requires javafx.fxml;
    requires javafx.controls;
    requires owm.japis;
    requires java.sql;
    requires gson;
    requires controlsfx;
    exports weather;
    opens weather.controller to javafx.fxml;
    opens weather to javafx.fxml;

}