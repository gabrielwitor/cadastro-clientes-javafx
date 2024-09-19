package com.example.cadastroclientesjavafx;

public class Cliente {
    private static Integer contador = 0;

    private Integer codigo;
    private String nome;
    private Endereco endereco;
    private String telefone;

    public Cliente() {
        this.codigo = contador;
        this.nome = "";
        this.endereco = new Endereco();
        this.telefone = "";

        contador++;
    }

    public Cliente(String nome, Endereco endereco, String telefone) {
        this.codigo = contador;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;

        contador++;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    void validarTelefone() throws IllegalArgumentException {
        if (!getTelefone().matches("\\(\\d{2}\\) ?\\d{5}-?\\d{4}?")) {
            throw new IllegalArgumentException("O número de telefone é inválido.");
        }
    }
}
