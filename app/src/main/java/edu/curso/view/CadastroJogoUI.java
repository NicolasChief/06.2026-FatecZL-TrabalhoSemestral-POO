package edu.curso.view;

import edu.curso.model.Jogo;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CadastroJogoUI extends Application {

    private Label tNome = new Label("Nome: ");
    private Label tPreco = new Label("Preço: ");
    private Label tDataLancamento = new Label("Data de Lançamento: ");
    private Label tEspacoGB = new Label("Espaço (GB): ");
    private Label tGenero = new Label("Gênero: ");
    private Label tDescricao = new Label("Descrição: ");

    private TextField fNome = new TextField();
    private TextField fPreco = new TextField();
    private TextField fDataLancamento = new TextField();
    private TextField fEspacoGB = new TextField();
    private TextField fGenero = new TextField();
    private TextField fDescricao = new TextField();

    private Button bCadastro = new Button("Cadastrar");

    private edu.curso.control.CadastroJogoUC CadastroJogoUC = new edu.curso.control.CadastroJogoUC();
    private Jogo jogoAtual;

    public CadastroJogoUI() {
    }

    public CadastroJogoUI(Jogo jogoAtual) {
        this.jogoAtual = jogoAtual;
        if (jogoAtual != null) {
            bCadastro.setText("Atualizar");
        }
    }

    @Override
    public void start(Stage stage) {

        HBox hbN = new HBox();
        HBox hbP = new HBox();
        HBox hbD = new HBox();
        HBox hbE = new HBox();
        HBox hbG = new HBox();
        HBox hbDE = new HBox();

        VBox vb = new VBox();

        BorderPane bp = new BorderPane();

        Scene scn = new Scene(bp, 800, 600);

        fNome.setPrefWidth(250);
        fPreco.setPrefWidth(250);
        fDataLancamento.setPrefWidth(250);
        fEspacoGB.setPrefWidth(250);
        fGenero.setPrefWidth(250);
        fDescricao.setPrefWidth(250);

        bCadastro.setPrefSize(120, 40);

        hbN.setSpacing(10);
        hbP.setSpacing(10);
        hbD.setSpacing(10);
        hbE.setSpacing(10);
        hbG.setSpacing(10);
        hbDE.setSpacing(10);

        vb.setSpacing(15);
        vb.setPadding(new Insets(20));

        hbN.getChildren().addAll(tNome, fNome);
        hbP.getChildren().addAll(tPreco, fPreco);
        hbD.getChildren().addAll(tDataLancamento, fDataLancamento);
        hbE.getChildren().addAll(tEspacoGB, fEspacoGB);
        hbG.getChildren().addAll(tGenero, fGenero);
        hbDE.getChildren().addAll(tDescricao, fDescricao);

        vb.getChildren().addAll(hbN, hbP, hbD, hbE, hbG, hbDE, bCadastro);

        bp.setCenter(vb);

        hbN.setAlignment(Pos.CENTER);
        hbP.setAlignment(Pos.CENTER);
        hbD.setAlignment(Pos.CENTER);
        hbE.setAlignment(Pos.CENTER);
        hbG.setAlignment(Pos.CENTER);
        hbDE.setAlignment(Pos.CENTER);

        vb.setAlignment(Pos.CENTER);

        if (jogoAtual != null) {
            fNome.setText(jogoAtual.getNome());
            fPreco.setText(jogoAtual.getPreco() != null ? jogoAtual.getPreco().toString() : "");
            fDataLancamento.setText(jogoAtual.getDataLancamento() != null ? jogoAtual.getDataLancamento().toString() : "");
            fEspacoGB.setText(jogoAtual.getEspacoGB() != null ? jogoAtual.getEspacoGB().toString() : "");
            fGenero.setText(jogoAtual.getGenero());
            fDescricao.setText(jogoAtual.getDescricao());
        }

        bCadastro.setOnAction(e -> {
            if (jogoAtual != null) {
                CadastroJogoUC.toBoundaryJogo(jogoAtual);
            }
            CadastroJogoUC.preencherCampos(
                fNome.getText(),
                fPreco.getText(),
                fDataLancamento.getText(),
                fEspacoGB.getText(),
                fGenero.getText(),
                fDescricao.getText()
            );
            CadastroJogoUC.salvar();
            new Alert(AlertType.INFORMATION, jogoAtual != null ? "Jogo atualizado com sucesso" : "Jogo salvo com sucesso").show();
            new JogoUI().start(stage);
        });

        stage.setScene(scn);
        stage.show();

    }

}
