package com.arthur.projetos.sistemabancariofx.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button bt_deletar;

    @FXML
    private Button bt_editar;

    @FXML
    private Button bt_salvar;

    @FXML
    private ToggleGroup conta;

    @FXML
    private PasswordField pf_senha;

    @FXML
    private RadioButton rb_corrente;

    @FXML
    private RadioButton rb_femenino;

    @FXML
    private RadioButton rb_masculino;

    @FXML
    private RadioButton rb_poupanca;

    @FXML
    private ToggleGroup sexo;

    @FXML
    private TableColumn<?, ?> tc_cpf;

    @FXML
    private TableColumn<?, ?> tc_id;

    @FXML
    private TableColumn<?, ?> tc_idade;

    @FXML
    private TableColumn<?, ?> tc_nome;

    @FXML
    private TableColumn<?, ?> tc_sexo;

    @FXML
    private TextField tf_cpf;

    @FXML
    private TextField tf_idade;

    @FXML
    private TextField tf_nome;

    @FXML
    private TableView<?> tv_clientes;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void save(ActionEvent event) {
        String name = tf_nome.getText().toString();
        String cpf = tf_cpf.getText().toString();
        String idade = tf_idade.getText().toString();

        Object client = "Nome: " + name + " - CPF: " + cpf + " - Idade: " + idade + " anos";

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Alerta!");
        alert.setContentText("Parabéns, bem vindo ao nosso banco." + client);

        alert.show();

    }
}
