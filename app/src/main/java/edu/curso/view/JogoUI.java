package edu.curso.view;

import edu.curso.control.JogoUC;
import edu.curso.model.Jogo;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JogoUI extends Application {

    private TableView<Jogo> tabelaJ = new TableView<>();

    private Button btnCadastrar = new Button("Cadastrar");
    private Button btnConsultar = new Button("Consultar");
    private Button btnAtualizar = new Button("Atualizar");
    private Button btnDeletar = new Button("Deletar");

    private TextField txtCampo = new TextField();

    private JogoUC JogoUC = new JogoUC();

    public void start(Stage stage) {

        HBox hb = new HBox();

        BorderPane bp = new BorderPane();

        Scene scn = new Scene(bp, 800, 600);

        hb.getChildren().addAll(btnCadastrar, btnConsultar, btnAtualizar, btnDeletar, txtCampo);

        bp.setTop(hb);
        bp.setCenter(tabelaJ);

        BorderPane.setMargin(hb, new Insets(10, 10, 10, 10));

        hb.setSpacing(10);

        TableColumn<Jogo, String> colId = new TableColumn<>("ID");
        colId.setCellValueFactory( 
            itemData -> new ReadOnlyStringWrapper(itemData.getValue().getId().toString())
        );
        TableColumn<Jogo, String> colNome = new TableColumn<>("Título do Jogo");
        colNome.setCellValueFactory( 
            itemData -> new ReadOnlyStringWrapper(itemData.getValue().getNome())
        );
        TableColumn<Jogo, String> colPreco = new TableColumn<>("Preço");
        colPreco.setCellValueFactory( 
            itemData -> new ReadOnlyStringWrapper(itemData.getValue().getPreco().toString())
        );
        TableColumn<Jogo, String> coldataLancamento = new TableColumn<>("Data de Lançamento");
        coldataLancamento.setCellValueFactory( 
            itemData -> new ReadOnlyStringWrapper(itemData.getValue().getDataLancamento().toString())
        );
        TableColumn<Jogo, String> colEspacoGB = new TableColumn<>("Espaço (GB)");
        colEspacoGB.setCellValueFactory( 
            itemData -> new ReadOnlyStringWrapper(itemData.getValue().getEspacoGB().toString())
        );
        TableColumn<Jogo, String> colGenero = new TableColumn<>("Gênero de Jogo");
        colGenero.setCellValueFactory( 
            itemData -> new ReadOnlyStringWrapper(itemData.getValue().getGenero())
        );

        tabelaJ.getColumns().add(colId);
        tabelaJ.getColumns().add(colNome);
        tabelaJ.getColumns().add(colPreco);
        tabelaJ.getColumns().add(coldataLancamento);
        tabelaJ.getColumns().add(colEspacoGB);
        tabelaJ.getColumns().add(colGenero);

        tabelaJ.setItems(JogoUC.getListaJogo());

        tabelaJ.getSelectionModel().selectedItemProperty().addListener(
            (obj, antigo, nova) -> JogoUC.toBoundaryJogo(nova)
        );

        btnCadastrar.setOnAction(e -> {new CadastroJogoUI().start(stage);});
        btnConsultar.setOnAction(e -> {JogoUC.pesquisar(txtCampo.getText());});
        btnAtualizar.setOnAction(e -> {
            Jogo selecionado = tabelaJ.getSelectionModel().getSelectedItem();
            if (selecionado == null) {
                String nome = txtCampo.getText();
                if (nome == null || nome.isBlank()) {
                    new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION, "Selecione um jogo na tabela ou informe o nome para atualizar").show();
                    return;
                }
                JogoUC.pesquisar(nome);
                if (JogoUC.getListaJogo().isEmpty()) {
                    new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION, "Jogo não encontrado").show();
                    return;
                }
                selecionado = JogoUC.getListaJogo().get(0);
            }
            new CadastroJogoUI(selecionado).start(stage);
        });
        btnDeletar.setOnAction(e -> {
            String textoId = txtCampo.getText();
            try {
                long id = Long.parseLong(textoId);
                JogoUC.apagarPorId(id);
            } catch (NumberFormatException ex) {
                System.out.println("ID inválido: " + textoId);
            }
        });

        stage.setScene(scn);
        stage.show();

    }
    
}
