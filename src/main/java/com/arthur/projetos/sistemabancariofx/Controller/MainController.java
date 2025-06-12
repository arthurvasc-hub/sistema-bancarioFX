
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
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
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
        hideButtons();
    }

    void hideButtons(){
        this.bt_editar.setVisible(false);
        this.bt_deletar.setVisible(false);

    }




    @FXML
    public void save(ActionEvent event) throws SQLException {

        if(validator()) {
            client.setName(tf_nome.getText());
            client.setCpf(tf_cpf.getText());
            client.setPassword(pf_senha.getText());
            client.setAge(Integer.valueOf(tf_idade.getText()));
            rbSelected();
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


        List<Client> allClients = clientService.findAll();

        clientObservableList = FXCollections.observableList(allClients);

        tv_clientes.setItems(clientObservableList);


    }

    public void clearText(){
        tf_nome.setText("");
        tf_idade.setText("");
        tf_cpf.setText("");
        pf_senha.setText("");
    }

    @FXML
    void fillFields(MouseEvent event) {

        client = (Client) tv_clientes.getSelectionModel().getSelectedItem();

        if(client != null){

            bt_salvar.setVisible(false);
            bt_editar.setVisible(true);
            bt_deletar.setVisible(true);

            tf_nome.setText(client.getName());
            tf_idade.setText(String.valueOf(client.getAge()));

            if(client.getGender().equals(Gender.MASCULINO)){
                rb_masculino.setSelected(true);
            }

            else if(client.getGender().equals(Gender.FEMININO)){
                rb_feminino.setSelected(true);
            }

            if(client.getAccount().equals(Account.CORRENTE)){
                rb_corrente.setSelected(true);
            }

            else if(client.getAccount().equals(Account.POUPANCA)){
                rb_poupanca.setSelected(true);
            }

        }

    }

    @FXML
    void edit(ActionEvent event) {

        if(validator()){
        client.setName(tf_nome.getText());
        client.setCpf(tf_cpf.getText());
        client.setPassword(pf_senha.getText());
        client.setAge(Integer.valueOf(tf_idade.getText()));
        rbSelected();
        }

        clientService.update(client, client.getId());
        showInfoTable();
        clearText();

    }

    private void rbSelected() {
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

    public void delete(ActionEvent event){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmação deletar");
        alert.setHeaderText("Tem certeza que deseja eliminar?");

        Optional<ButtonType> result = alert.showAndWait();

        if(result.get() == ButtonType.OK) {
            clientService.deleteClientById(client.getId());
            showInfoTable();
            clearText();
        }

    }


}
