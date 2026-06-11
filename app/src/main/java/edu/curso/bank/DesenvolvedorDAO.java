package edu.curso.bank;

import java.util.List;

import edu.curso.model.Desenvolvedor;

public interface DesenvolvedorDAO {

    void cadastrarDesenvolvedor(Desenvolvedor desenvolvedor);
    List<Desenvolvedor> consultarDesenvolvedor(String nome);
    Desenvolvedor autenticar(String nomeEmpresa, String senhaConta);
    void atualizarDesenvolvedor(long id, Desenvolvedor desenvolvedor);
    void apagarDesenvolvedor(Long id);

}