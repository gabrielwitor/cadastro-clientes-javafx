package com.example.cadastroclientesjavafx;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaClientesController {

    @FXML
    private void initialize() {
        // Colunas relacionadas a 'Cliente'
        idColumn.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("codigo"));
        nomeColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        telefoneColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefone"));

        // Colunas relacionadas ao 'Endereco' através do objeto 'Cliente'
        cepColumn.setCellValueFactory(cellData -> cellData.getValue().getEndereco().cepProperty());
        cidadeColumn.setCellValueFactory(cellData -> cellData.getValue().getEndereco().cidadeProperty());
        estadoColumn.setCellValueFactory(cellData -> cellData.getValue().getEndereco().estadoProperty());
        ruaColumn.setCellValueFactory(cellData -> cellData.getValue().getEndereco().ruaProperty());
        numeroColumn.setCellValueFactory(cellData -> cellData.getValue().getEndereco().numeroProperty());
    }

    @FXML
    private TableView<Cliente> clientesTableView;

    @FXML
    private TableColumn<Cliente, Integer> idColumn;

    @FXML
    private TableColumn<Cliente, String> nomeColumn;

    @FXML
    private TableColumn<Cliente, String> telefoneColumn;

    @FXML
    private TableColumn<Cliente, String> cepColumn;

    @FXML
    private TableColumn<Cliente, String> cidadeColumn;

    @FXML
    private TableColumn<Cliente, String> estadoColumn;

    @FXML
    private TableColumn<Cliente, String> numeroColumn;

    @FXML
    private TableColumn<Cliente, String> ruaColumn;

    public void mostrarClientes(ObservableList<Cliente> clientes) {
        clientesTableView.setItems(clientes);
    }
}
