module com.example.numeralconvertergui {
    requires javafx.controls;
    requires javafx.fxml;
    requires annotations;


    opens com.example.numeralconvertergui to javafx.fxml;
    exports com.example.numeralconvertergui;
}