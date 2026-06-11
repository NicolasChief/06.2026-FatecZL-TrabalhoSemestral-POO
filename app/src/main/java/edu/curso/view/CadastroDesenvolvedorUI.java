package edu.curso.view;

import edu.curso.control.CadastroDesenvolvedorUC;

import edu.curso.model.Desenvolvedor;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CadastroDesenvolvedorUI extends Application {

    private Label tNomeEmpresa = new Label("Nome do Desenvolvedor: ");
    private Label tcnpjCpf = new Label("CNPJ / CPF: ");
    private Label tEmail = new Label("Email: ");
    private Label tTelefone = new Label("Telefone: ");
    private Label tDataNasc = new Label("Data de Nascimento: ");
    private Label tSenhaConta = new Label("Senha da Conta: ");

    private TextField fNomeEmpresa = new TextField();
    private TextField fcnpjCpf = new TextField();
    private TextField fEmail = new TextField();
    private TextField fTelefone = new TextField();
    private TextField fDataNasc = new TextField();
    private TextField fSenhaConta = new TextField();

    private Button bCadastro = new Button("Cadastrar");

    private CadastroDesenvolvedorUC CadastroDesenvolvedorUC = new CadastroDesenvolvedorUC();
    private Desenvolvedor desenvolvedorAtual;
    private boolean adminMode = false;

    public CadastroDesenvolvedorUI() {
    }

    public CadastroDesenvolvedorUI(boolean adminMode) {
        this.adminMode = adminMode;
    }

    public CadastroDesenvolvedorUI(Desenvolvedor desenvolvedor) {
        this(desenvolvedor, false);
    }

    public CadastroDesenvolvedorUI(Desenvolvedor desenvolvedor, boolean adminMode) {
        this.desenvolvedorAtual = desenvolvedor;
        this.adminMode = adminMode;
        if (desenvolvedor != null) {
            bCadastro.setText("Atualizar");
        }
    }

    @Override
    public void start(Stage stage) {

        HBox hbN = new HBox();
        HBox hbC = new HBox();
        HBox hbE = new HBox();
        HBox hbT = new HBox();
        HBox hbD = new HBox();
        HBox hbS = new HBox();

        VBox vb = new VBox();

        BorderPane bp = new BorderPane();

        Scene scn = new Scene(bp, 800, 600);

        fNomeEmpresa.setPrefWidth(250);
        fcnpjCpf.setPrefWidth(250);
        fEmail.setPrefWidth(250);
        fTelefone.setPrefWidth(250);
        fDataNasc.setPrefWidth(250);
        fSenhaConta.setPrefWidth(250);

        bCadastro.setPrefSize(120, 40);

        hbN.setSpacing(10);
        hbC.setSpacing(10);
        hbE.setSpacing(10);
        hbT.setSpacing(10);
        hbD.setSpacing(10);
        hbS.setSpacing(10);

        vb.setSpacing(15);
        vb.setPadding(new Insets(20));

        hbN.getChildren().addAll(tNomeEmpresa, fNomeEmpresa);
        hbC.getChildren().addAll(tcnpjCpf, fcnpjCpf);
        hbE.getChildren().addAll(tEmail, fEmail);
        hbT.getChildren().addAll(tTelefone, fTelefone);
        hbD.getChildren().addAll(tDataNasc, fDataNasc);
        hbS.getChildren().addAll(tSenhaConta, fSenhaConta);

        vb.getChildren().addAll(hbN, hbC, hbE, hbT, hbD, hbS, bCadastro);

        bp.setCenter(vb);

        hbN.setAlignment(Pos.CENTER);
        hbC.setAlignment(Pos.CENTER);
        hbE.setAlignment(Pos.CENTER);
        hbT.setAlignment(Pos.CENTER);
        hbD.setAlignment(Pos.CENTER);
        hbS.setAlignment(Pos.CENTER);
        vb.setAlignment(Pos.CENTER);

        if (desenvolvedorAtual != null) {
            fNomeEmpresa.setText(desenvolvedorAtual.getNomeEmpresa());
            fcnpjCpf.setText(desenvolvedorAtual.getCnpjCpf());
            fEmail.setText(desenvolvedorAtual.getEmail());
            fTelefone.setText(desenvolvedorAtual.getTelefone());
            fDataNasc.setText(desenvolvedorAtual.getDataNasc().toString());
            fSenhaConta.setText(desenvolvedorAtual.getSenhaConta());
        }

        bCadastro.setOnAction((e) -> {
            if (desenvolvedorAtual != null) {
                CadastroDesenvolvedorUC.carregarDesenvolvedor(desenvolvedorAtual);
            }
            CadastroDesenvolvedorUC.preencherCampos(fNomeEmpresa.getText(), fcnpjCpf.getText(), fEmail.getText(), fTelefone.getText(), fDataNasc.getText(), fSenhaConta.getText());
            CadastroDesenvolvedorUC.salvar();
            new Alert(AlertType.INFORMATION, desenvolvedorAtual != null ? "Desenvolvedor atualizado com sucesso" : "Desenvolvedor foi salvo com sucesso").show();
            if (adminMode) {
                new AdminUI().start(stage);
            } else {
                new LoginUI().start(stage);
            }
        });

        stage.setScene(scn);
        stage.show();

    }

}