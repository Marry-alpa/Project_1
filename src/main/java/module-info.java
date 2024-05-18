module com.example.project_1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.project_1 to javafx.fxml;
    //exports com.example.project_1;
    exports com.example.project_1.project1_1;
    exports com.example.project_1.project1_2;
    exports com.example.project_1.project1_3;
    opens com.example.project_1.project1_1 to javafx.fxml;
}