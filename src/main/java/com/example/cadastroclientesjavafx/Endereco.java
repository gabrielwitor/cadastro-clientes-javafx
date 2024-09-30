package com.example.cadastroclientesjavafx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Endereco {
    private final StringProperty cep;
    private final StringProperty rua;
    private final StringProperty numero;
    private final StringProperty cidade;
    private final StringProperty estado;

    public Endereco() {
        this.cep = new SimpleStringProperty("");
        this.rua = new SimpleStringProperty("");
        this.numero = new SimpleStringProperty("");
        this.cidade = new SimpleStringProperty("");
        this.estado = new SimpleStringProperty("");
    }

    public Endereco(String cep, String rua, String numero, String cidade, String estado) {
        this.cep = new SimpleStringProperty(cep);
        this.rua = new SimpleStringProperty(rua);
        this.numero = new SimpleStringProperty(numero);
        this.cidade = new SimpleStringProperty(cidade);
        this.estado = new SimpleStringProperty(estado);
    }

    public String getCep() {
        return cep.get();
    }

    public void setCep(String cep) {
        this.cep.set(cep);
    }

    public StringProperty cepProperty() {
        return cep;
    }

    public String getRua() {
        return rua.get();
    }

    public void setRua(String rua) {
        this.rua.set(rua);
    }

    public StringProperty ruaProperty() {
        return rua;
    }

    public String getNumero() {
        return numero.get();
    }

    public void setNumero(String numero) {
        this.numero.set(numero);
    }

    public StringProperty numeroProperty() {
        return numero;
    }

    public String getCidade() {
        return cidade.get();
    }

    public void setCidade(String cidade) {
        this.cidade.set(cidade);
    }

    public StringProperty cidadeProperty() {
        return cidade;
    }

    public String getEstado() {
        return estado.get();
    }

    public void setEstado(String estado) {
        this.estado.set(estado);
    }

    public StringProperty estadoProperty() {
        return estado;
    }
}