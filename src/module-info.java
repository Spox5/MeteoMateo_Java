module TravelWeather {

    requires javafx.fxml;
    requires javafx.controls;
    requires owm.japis;
    requires java.sql;
    requires gson;
    requires controlsfx;
    exports Weather;
    opens Weather to javafx.fxml;

}