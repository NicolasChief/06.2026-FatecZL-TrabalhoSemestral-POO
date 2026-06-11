package edu.curso.view;

import edu.curso.control.LoginUC;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginUI extends Application {

    private Label lblNome = new Label("Nome:");
    private Label lblSenha = new Label("Senha:");

    private TextField txtNome = new TextField();
    private PasswordField txtSenha = new PasswordField();

    private Button btnAcessar = new Button("Acessar");
    private Button btnPrimeiraVez = new Button("Primeira Vez?");
    private Button btnAdmin = new Button("+");

    private LoginUC LoginUC = new LoginUC();

    @Override
    public void start(Stage stage) {

        HBox hbNome = new HBox();
        HBox hbSenha = new HBox();
        HBox hbBotoes = new HBox();
        VBox vbPrincipal = new VBox();
        BorderPane bp = new BorderPane();

        txtNome.setPrefWidth(250);
        txtSenha.setPrefWidth(250);
        btnAcessar.setPrefSize(120, 40);
        btnPrimeiraVez.setPrefSize(120, 40);

        hbNome.setSpacing(10);
        hbSenha.setSpacing(10);
        hbBotoes.setSpacing(10);
        vbPrincipal.setSpacing(15);
        vbPrincipal.setPadding(new Insets(20));

        hbNome.getChildren().addAll(lblNome, txtNome);
        hbSenha.getChildren().addAll(lblSenha, txtSenha);
        hbBotoes.getChildren().addAll(btnAcessar, btnPrimeiraVez, btnAdmin);
        vbPrincipal.getChildren().addAll(hbNome, hbSenha, hbBotoes);
        bp.setCenter(vbPrincipal);

        hbNome.setAlignment(Pos.CENTER);
        hbSenha.setAlignment(Pos.CENTER);
        hbBotoes.setAlignment(Pos.CENTER);
        vbPrincipal.setAlignment(Pos.CENTER);

        btnPrimeiraVez.setOnAction(e -> {new CadastroDesenvolvedorUI().start(stage);});
        btnAcessar.setOnAction(e -> {
            boolean autenticador = LoginUC.autenticar(txtNome.getText(), txtSenha.getText());
            if (autenticador) {
                new JogoUI().start(stage);
            } else {
                new Alert(AlertType.INFORMATION, "Usuário não foi encontrado").show();
            }
        });
        btnAdmin.setOnAction(e -> {new AdminUI().start(stage);});

        Scene scene = new Scene(bp, 500, 300);
        stage.setTitle("MiniSteam");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}