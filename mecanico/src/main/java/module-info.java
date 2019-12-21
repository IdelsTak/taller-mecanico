module com.github.idelstak.mecanico {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.github.idelstak.mecanico to javafx.fxml;
    exports com.github.idelstak.mecanico;
}