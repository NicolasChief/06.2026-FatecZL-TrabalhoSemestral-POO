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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class JogoUC {

    private ObservableList<Jogo> listaJogo = FXCollections.observableArrayList();

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

    public ObservableList<Jogo> getListaJogo() { 
        return listaJogo;
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

    public void pesquisar(String nome) {

        listaJogo.clear();
        listaJogo.addAll(Jogodao.consultarJogo(nome));

    }

    public void carregar() { 

        listaJogo.clear();
        listaJogo.addAll(Jogodao.consultarJogo(""));

    }

    public void apagarPorId(long id) {

        Jogodao.apagarJogo(id);
        carregar();

    }

    public JogoUC() {

        carregar();

    }

    public void limparCampos() {

        idJ.set(-1);
        nomeJ.set("");
        precoJ.set(0.0);
        dataLancamentoJ.set(LocalDate.now());
        espacoGBJ.set(0.0);
        generoJ.set("");
        descricaoJ.set("");

    }

}
