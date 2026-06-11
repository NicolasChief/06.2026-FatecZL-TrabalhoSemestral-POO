package edu.curso.control;

import java.time.LocalDate;

import edu.curso.bank.DesenvolvedorDAO;
import edu.curso.bank.DesenvolvedorDAOImpl;
import edu.curso.model.Desenvolvedor;
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

public class LoginUC {

    private ObservableList<Jogo> listaJogo = FXCollections.observableArrayList();
    private ObservableList<Desenvolvedor> listaDesenvolvedor = FXCollections.observableArrayList();

    LongProperty idJ = new SimpleLongProperty( -1 );
    StringProperty nomeJ = new SimpleStringProperty("");
    DoubleProperty precoJ = new SimpleDoubleProperty(0.0);
    ObjectProperty<LocalDate> dataLancamentoJ = new SimpleObjectProperty<>(LocalDate.now());
    DoubleProperty espacoGBJ = new SimpleDoubleProperty(0.0);
    StringProperty generoJ = new SimpleStringProperty("");
    StringProperty descricaoJ = new SimpleStringProperty("");

    LongProperty idD = new SimpleLongProperty( -1 );
    StringProperty nomeEmpresaD = new SimpleStringProperty("");
    StringProperty cnpjcpfD = new SimpleStringProperty("");
    StringProperty emailD = new SimpleStringProperty("");
    StringProperty telefoneD = new SimpleStringProperty("");
    ObjectProperty<LocalDate> dataNascD = new SimpleObjectProperty<>(LocalDate.now());
    StringProperty senhaContaD = new SimpleStringProperty("");    

    private DesenvolvedorDAO Desenvolvedordao = new DesenvolvedorDAOImpl();

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

    public Desenvolvedor toEntityDesenvolvedor() { 

        Desenvolvedor desenvolvedor = new Desenvolvedor(null, null, null, null, null, null, null);

        desenvolvedor.setId(idD.get());
        desenvolvedor.setNomeEmpresa(nomeEmpresaD.get());
        desenvolvedor.setCnpjCpf(cnpjcpfD.get());
        desenvolvedor.setEmail(emailD.get());
        desenvolvedor.setTelefone(telefoneD.get());
        desenvolvedor.setDataNasc(dataNascD.get());
        desenvolvedor.setSenhaConta(senhaContaD.get());

        return desenvolvedor;

    }

    public ObservableList<Desenvolvedor> getListaDesenvolvedor() { 
        return listaDesenvolvedor;
    }

    public ObservableList<Jogo> getListaJogo() { 
        return listaJogo;
    }

        public void toBoundaryDesenvolvedor(Desenvolvedor desenvolvedor) { 
        if (desenvolvedor != null) {

            idD.set(desenvolvedor.getId());
            nomeEmpresaD.set(desenvolvedor.getNomeEmpresa());
            cnpjcpfD.set(desenvolvedor.getCnpjCpf());
            emailD.set(desenvolvedor.getEmail());
            telefoneD.set(desenvolvedor.getTelefone());
            dataNascD.set(desenvolvedor.getDataNasc());
            senhaContaD.set(desenvolvedor.getSenhaConta());

        }
    }

    public void pesquisar() { 

        listaDesenvolvedor.clear();
        listaDesenvolvedor.addAll(Desenvolvedordao.consultarDesenvolvedor(nomeEmpresaD.get()));

    }

    public void carregar() { 

        listaDesenvolvedor.clear();
        listaDesenvolvedor.addAll(Desenvolvedordao.consultarDesenvolvedor(""));

    }

    public boolean autenticar(String nomeEmpresa, String senhaConta) {
        if (nomeEmpresa == null || senhaConta == null) {
            return false;
        }
        Desenvolvedor desenvolvedor = Desenvolvedordao.autenticar(nomeEmpresa, senhaConta);
        return desenvolvedor != null;
    }

    public void apagar(int index){ 

        Desenvolvedor desenvolvedor = listaDesenvolvedor.get(index);
        Desenvolvedordao.apagarDesenvolvedor(desenvolvedor.getId());
        carregar();

    }

    public LoginUC() {

        carregar();

    }

    public void limparCampos() {

        idD.set(-1);
        nomeEmpresaD.set("");
        cnpjcpfD.set("");
        emailD.set("");
        telefoneD.set("");
        dataNascD.set(LocalDate.now());
        senhaContaD.set("");

    }

}
