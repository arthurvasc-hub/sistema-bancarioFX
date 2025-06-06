
package com.arthur.projetos.sistemabancariofx.Controller;

import com.arthur.projetos.sistemabancariofx.Enums.Account;
import com.arthur.projetos.sistemabancariofx.Enums.Gender;
import com.arthur.projetos.sistemabancariofx.Model.Client;
import com.arthur.projetos.sistemabancariofx.Service.ClientService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.SQLException;
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

    Client client = new Client();
    ClientService clientService = new ClientService();

    @FXML
    public void save(ActionEvent event) throws SQLException {

        client.setName(tf_nome.getText().toString());
        client.setCpf(tf_cpf.getText().toString());
        client.setPassword(pf_senha.getText().toString());
        client.setAge(Integer.valueOf(tf_idade.getText().toString()));


        if (rb_masculino.isSelected()) {
            client.setGender(Gender.MASCULINO);
        }

        if(rb_femenino.isSelected()){
            client.setGender(Gender.FEMENINO);
        }

        if(rb_corrente.isSelected()) {
            client.setAccount(Account.CORRENTE);
        }

        if (rb_poupanca.isSelected()) {
            client.setAccount(Account.POUPANCA);
        }

        clientService.createClient(client);
    }
}
