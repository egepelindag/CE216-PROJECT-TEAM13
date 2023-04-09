module sample.offlinedictionary {
    requires javafx.controls;
    requires javafx.fxml;


    opens sample.offlinedictionary to javafx.fxml;
    exports sample.offlinedictionary;
}