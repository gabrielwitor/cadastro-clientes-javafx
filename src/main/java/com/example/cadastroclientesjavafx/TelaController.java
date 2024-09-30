package com.example.cadastroclientesjavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class TelaController {

    Endereco endereco;
    Buscador buscador;

    ObservableList<Cliente> clientes;

    Alert alert;

    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField telefoneTextField;

    @FXML
    private TextField cepTextField;

    @FXML
    private TextField ruaTextField;

    @FXML
    private TextField numeroTextField;

    @FXML
    private TextField cidadeTextField;

    @FXML
    private ChoiceBox<String> estadoChoiceBox;

    @FXML
    private void initialize(){
        buscador = new Buscador();

        estadoChoiceBox.getItems().addAll(buscador.estados);

        clientes = FXCollections.observableArrayList(); // Inicializando a lista de clientes
    }

    @FXML
    private void buscarCep() {
        String cep = cepTextField.getText();
        try {
            endereco = buscador.buscar(cep);

            ruaTextField.setText(endereco.getRua());
            cidadeTextField.setText(endereco.getCidade());
            estadoChoiceBox.setValue(endereco.getEstado());

        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, String.format("O formato do CEP \"%s\" não é válido",cepTextField.getText()), ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.setTitle("Erro!");
            alert.setHeaderText("");
            alert.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Erro ao conectar com o serviço ViaCep. Verifique sua conexão.", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.setTitle("Erro!");
            alert.setHeaderText("");
            alert.show();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, String.format("Houve um erro! %s",e.getCause()), ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.setTitle("Erro!");
            alert.setHeaderText("");
            alert.show();
        }
    }

    @FXML
    private void limparCampos(){
        nomeTextField.clear();
        telefoneTextField.clear();
        cepTextField.clear();
        ruaTextField.clear();
        numeroTextField.clear();
        cidadeTextField.clear();
        estadoChoiceBox.setValue(null);
    }

    @FXML
    private void adicionarCliente(){

        try {
            endereco = new Endereco(cepTextField.getText(), ruaTextField.getText(), numeroTextField.getText(), cidadeTextField.getText(), estadoChoiceBox.getValue());
            Cliente cliente = new Cliente(nomeTextField.getText(), endereco, telefoneTextField.getText());

            cliente.validarTelefone();

            clientes.add(cliente);
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR, String.format("Erro na inserção do cliente: %s", e.getMessage()), ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.setTitle("Erro!");
            alert.setHeaderText("");
            alert.show();
        }
        limparCampos();
    }

    @FXML
    private void listarCadastros(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("telaClientes.fxml"));
            Parent root = fxmlLoader.load();

            // Create a new Stage
            Stage stage = new Stage();
            stage.setTitle("Listar cadastros");

            // Create a Scene with the loaded FXML file
            Scene scene = new Scene(root);

            // Set the Scene to the Stage
            stage.setScene(scene);

            // Show the Stage (window)
            stage.show();

            // Used for listing the customers
            TelaClientesController telaClientesController = fxmlLoader.getController();
            telaClientesController.mostrarClientes(clientes);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}