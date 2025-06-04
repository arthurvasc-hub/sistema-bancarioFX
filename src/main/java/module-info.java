module com.arthur.projetos.sistemabancariofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jbcrypt;


    opens com.arthur.projetos.sistemabancariofx to javafx.fxml;
    exports com.arthur.projetos.sistemabancariofx;
    exports com.arthur.projetos.sistemabancariofx.Controller;
    opens com.arthur.projetos.sistemabancariofx.Controller to javafx.fxml;
}