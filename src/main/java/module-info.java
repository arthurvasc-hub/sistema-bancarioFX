module com.arthur.projetos.sistemabancariofx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.arthur.projetos.sistemabancariofx to javafx.fxml;
    exports com.arthur.projetos.sistemabancariofx;
}