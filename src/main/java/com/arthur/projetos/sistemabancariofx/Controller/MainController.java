
package com.arthur.projetos.sistemabancariofx.Controller;

import com.arthur.projetos.sistemabancariofx.Enums.Account;
import com.arthur.projetos.sistemabancariofx.Enums.Gender;
import com.arthur.projetos.sistemabancariofx.Model.Client;
import com.arthur.projetos.sistemabancariofx.Service.ClientService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
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
    private RadioButton rb_feminino;

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
    private TableView<Client> tv_clientes;

    private ObservableList<Client> clientObservableList;

    private ClientService clientService;

    private Client client;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.clientService = new ClientService();
        this.client = new Client();
        showInfoTable();
    }




    @FXML
    public void save(ActionEvent event) throws SQLException {

        if(validator()) {
            client.setName(tf_nome.getText().toString());
            client.setCpf(tf_cpf.getText().toString());
            client.setPassword(pf_senha.getText().toString());
            client.setAge(Integer.valueOf(tf_idade.getText().toString()));


            if (rb_masculino.isSelected()) {
                client.setGender(Gender.MASCULINO);
            }

            if (rb_feminino.isSelected()) {
                client.setGender(Gender.FEMININO);
            }

            if (rb_corrente.isSelected()) {
                client.setAccount(Account.CORRENTE);
            }

            if (rb_poupanca.isSelected()) {
                client.setAccount(Account.POUPANCA);
            }
        }
        clientService.createClient(client);
        showInfoTable();
        clearText();
    }


    public boolean validator(){
        StringBuffer message = new StringBuffer();

        if(tf_nome.getText().equals("")){
            message.append("O campo nome é obrigatório. \n");
        }
        if(tf_cpf.getText().equals("")){
            message.append("O campo CPF é obrigatório. \n");
        }

        if(tf_idade.getText().equals("")) {
            message.append("O campo idade é obrigatório \n");
        }

        if(pf_senha.getText().equals("")) {
            message.append("O campo senha é obrigatório \n");
        }


        if(!message.isEmpty()) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("ERROR");
        alert.setContentText(message.toString());
        alert.show();

            return false;
        }
        else
            return true;

    }

    public void showInfoTable(){

        tc_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tc_nome.setCellValueFactory(new PropertyValueFactory<>("name"));
        tc_sexo.setCellValueFactory(new PropertyValueFactory<>("gender"));
        tc_idade.setCellValueFactory(new PropertyValueFactory<>("age"));
        tc_cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));

        List<Client> allClients = clientService.findAll();

        clientObservableList = FXCollections.observableList(allClients);

        tv_clientes.setItems(clientObservableList);


    }

    public void clearText(){
        tf_nome.setText("");
        tf_idade.setText("");
        tf_cpf.setText("");
        tf_cpf.setText("");
        pf_senha.setText("");
    }


}
