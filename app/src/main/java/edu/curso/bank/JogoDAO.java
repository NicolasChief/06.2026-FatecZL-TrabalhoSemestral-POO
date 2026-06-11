package edu.curso.bank;

import java.util.List;

import edu.curso.model.Jogo;

public interface JogoDAO {

    void cadastrarJogo(Jogo jogo);
    List<Jogo> consultarJogo(String nome);
    void atualizarJogo(long id, Jogo jogo);
    void apagarJogo(Long id);

}
