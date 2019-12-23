module com.github.idelstak.mecanico {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.commons.lang3;

    opens com.github.idelstak.mecanico to javafx.fxml;
    exports com.github.idelstak.mecanico;
}