package edu.curso.control;

import java.time.LocalDate;

import edu.curso.bank.JogoDAO;
import edu.curso.bank.JogoDAOImpl;
import edu.curso.model.Jogo;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CadastroJogoUC {

    LongProperty idJ = new SimpleLongProperty( -1 );
    StringProperty nomeJ = new SimpleStringProperty("");
    DoubleProperty precoJ = new SimpleDoubleProperty(0.0);
    ObjectProperty<LocalDate> dataLancamentoJ = new SimpleObjectProperty<>(LocalDate.now());
    DoubleProperty espacoGBJ = new SimpleDoubleProperty(0.0);
    StringProperty generoJ = new SimpleStringProperty("");
    StringProperty descricaoJ = new SimpleStringProperty("");   

    private JogoDAO Jogodao = new JogoDAOImpl();

    public Jogo toEntityJogo() { 

        Jogo jogo = new Jogo(null, null, null, null, null, null, null);

        jogo.setId(idJ.get());
        jogo.setNome(nomeJ.get());
        jogo.setPreco(precoJ.get());
        jogo.setDataLancamento(dataLancamentoJ.get());
        jogo.setEspacoGB(espacoGBJ.get());
        jogo.setGenero(generoJ.get());
        jogo.setDescricao(descricaoJ.get());

        return jogo;

    }

    public void preencherCampos(String nome, String precoStr, String dataLancamentoStr, String espacoStr, String genero, String descricao) {

        nomeJ.set(nome == null ? "" : nome);

        try {
            if (precoStr != null && !precoStr.isBlank()) {
                precoJ.set(Double.parseDouble(precoStr));
            } else {
                precoJ.set(0.0);
            }
        } catch (NumberFormatException ex) {
            precoJ.set(0.0);
        }

        try {
            if (dataLancamentoStr != null && !dataLancamentoStr.isBlank()) {
                dataLancamentoJ.set(java.time.LocalDate.parse(dataLancamentoStr));
            } else {
                dataLancamentoJ.set(LocalDate.now());
            }
        } catch (Exception ex) {
            dataLancamentoJ.set(LocalDate.now());
        }

        try {
            if (espacoStr != null && !espacoStr.isBlank()) {
                espacoGBJ.set(Double.parseDouble(espacoStr));
            } else {
                espacoGBJ.set(0.0);
            }
        } catch (NumberFormatException ex) {
            espacoGBJ.set(0.0);
        }

        generoJ.set(genero == null ? "" : genero);
        descricaoJ.set(descricao == null ? "" : descricao);

    }

    public void toBoundaryJogo(Jogo jogo) {
        if (jogo != null) {
            idJ.set(jogo.getId());
            nomeJ.set(jogo.getNome());
            precoJ.set(jogo.getPreco());
            dataLancamentoJ.set(jogo.getDataLancamento());
            espacoGBJ.set(jogo.getEspacoGB());
            generoJ.set(jogo.getGenero());
            descricaoJ.set(jogo.getDescricao());
        }
    }

    public void salvar() {

        Jogo jogo = toEntityJogo();

        if (jogo.getId() != null && jogo.getId() > 0) {
            Jogodao.atualizarJogo(jogo.getId(), jogo);
        } else {
            Jogodao.cadastrarJogo(jogo);
        }

    }

}
