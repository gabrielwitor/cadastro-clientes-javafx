package com.example.cadastroclientesjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class TelaClientesController {
    @FXML
    ListView<String> clientesListView;

    public void mostrarClientes(ArrayList<Cliente> clientes){
        for(Cliente cliente : clientes){
            clientesListView.getItems().addAll(String.format("%d | Nome: %s | Telefone: %s | CEP: %s | Número: %s",cliente.getCodigo(), cliente.getNome(),
                    cliente.getTelefone(), cliente.getEndereco().getCep(),cliente.getEndereco().getNumero()));
        }
    }
}
