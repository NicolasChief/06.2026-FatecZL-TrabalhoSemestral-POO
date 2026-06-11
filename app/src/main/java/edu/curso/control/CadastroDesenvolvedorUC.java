package edu.curso.control;

import java.time.LocalDate;

import edu.curso.bank.DesenvolvedorDAO;
import edu.curso.bank.DesenvolvedorDAOImpl;
import edu.curso.model.Desenvolvedor;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CadastroDesenvolvedorUC {

    private ObservableList<Desenvolvedor> listaDesenvolvedor = FXCollections.observableArrayList();

    LongProperty idD = new SimpleLongProperty( -1 );
    StringProperty nomeEmpresaD = new SimpleStringProperty("");
    StringProperty cnpjcpfD = new SimpleStringProperty("");
    StringProperty emailD = new SimpleStringProperty("");
    StringProperty telefoneD = new SimpleStringProperty("");
    ObjectProperty<LocalDate> dataNascD = new SimpleObjectProperty<>(LocalDate.now());
    StringProperty senhaContaD = new SimpleStringProperty("");    

    private DesenvolvedorDAO Desenvolvedordao = new DesenvolvedorDAOImpl();

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

    public void salvar() {

        Desenvolvedor desenvolvedor = toEntityDesenvolvedor();

        if (desenvolvedor.getId() > 0) {
            Desenvolvedordao.atualizarDesenvolvedor(desenvolvedor.getId(), desenvolvedor);
        } else {
            Desenvolvedordao.cadastrarDesenvolvedor(desenvolvedor);
        }

    }

    public void carregarDesenvolvedor(Desenvolvedor desenvolvedor) {
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

    public void preencherCampos(String nomeEmpresa, String cnpjCpf, String email, String telefone, String dataNascStr, String senha) {

        nomeEmpresaD.set(nomeEmpresa == null ? "" : nomeEmpresa);
        cnpjcpfD.set(cnpjCpf == null ? "" : cnpjCpf);
        emailD.set(email == null ? "" : email);
        telefoneD.set(telefone == null ? "" : telefone);
        senhaContaD.set(senha == null ? "" : senha);
        try {
            if (dataNascStr != null && !dataNascStr.isBlank()) {
                dataNascD.set(LocalDate.parse(dataNascStr));
            } else {
                dataNascD.set(LocalDate.now());
            }
        } catch (Exception ex) {

            dataNascD.set(LocalDate.now());

        }
    }

}
