package edu.curso.model;

import java.time.LocalDate;

public class Desenvolvedor {

    private Long id;
    private String nomeEmpresa;
    private String cnpjCpf;
    private String email;
    private String telefone;
    private LocalDate dataNasc;
    private String senhaConta;
    
    public Desenvolvedor(Long id, String nomeEmpresa, String cnpjCpf, String email, String telefone, LocalDate dataNasc,
            String senhaConta) {

        this.id = id;
        this.nomeEmpresa = nomeEmpresa;
        this.cnpjCpf = cnpjCpf;
        this.email = email;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
        this.senhaConta = senhaConta;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCnpjCpf() {
        return cnpjCpf;
    }

    public void setCnpjCpf(String cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getSenhaConta() {
        return senhaConta;
    }

    public void setSenhaConta(String senhaConta) {
        this.senhaConta = senhaConta;
    }

}
