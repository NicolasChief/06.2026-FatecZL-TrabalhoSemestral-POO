package edu.curso.view;

import edu.curso.control.AdminUC;
import edu.curso.model.Desenvolvedor;
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

public class AdminUI extends Application {

    private TableView<Desenvolvedor> tabelaD = new TableView<>();

    private Button bCadastrar = new Button("Cadastrar");
    private Button bConsultar = new Button("Consultar");
    private Button bAtualizar = new Button("Atualizar");
    private Button btnDeletar = new Button("Deletar");

    private TextField txtCampo = new TextField();

    private AdminUC AdminUC = new AdminUC();

    public void start(Stage stage) {

        HBox hb = new HBox();

        BorderPane bp = new BorderPane();

        Scene scn = new Scene(bp, 800, 600);

        hb.getChildren().addAll(bCadastrar, bConsultar, bAtualizar, btnDeletar, txtCampo);

        bp.setTop(hb);
        bp.setCenter(tabelaD);

        BorderPane.setMargin(hb, new Insets(10, 10, 10, 10));

        hb.setSpacing(10);

        TableColumn<Desenvolvedor, String> colId = new TableColumn<>("ID");
        colId.setCellValueFactory( 
            itemData -> new ReadOnlyStringWrapper(itemData.getValue().getId().toString())
        );
        TableColumn<Desenvolvedor, String> colNomeEmpresa = new TableColumn<>("Nome do Estúdio");
        colNomeEmpresa.setCellValueFactory( 
            itemData -> new ReadOnlyStringWrapper(itemData.getValue().getNomeEmpresa())
        );
        TableColumn<Desenvolvedor, String> colCnpjCpf = new TableColumn<>("CNPJ / CPF");
        colCnpjCpf.setCellValueFactory( 
            itemData -> new ReadOnlyStringWrapper(itemData.getValue().getCnpjCpf())
        );
        TableColumn<Desenvolvedor, String> colEmail = new TableColumn<>("Email");
        colEmail.setCellValueFactory( 
            itemData -> new ReadOnlyStringWrapper(itemData.getValue().getEmail())
        );
        TableColumn<Desenvolvedor, String> colTelefone = new TableColumn<>("Telefone");
        colTelefone.setCellValueFactory( 
            itemData -> new ReadOnlyStringWrapper(itemData.getValue().getTelefone())
        );
        TableColumn<Desenvolvedor, String> colDataNasc = new TableColumn<>("Data de Nascimento");
        colDataNasc.setCellValueFactory( 
            itemData -> new ReadOnlyStringWrapper(itemData.getValue().getDataNasc().toString())
        );
        TableColumn<Desenvolvedor, String> colSenha = new TableColumn<>("Senha da Conta");
        colSenha.setCellValueFactory( 
            itemData -> new ReadOnlyStringWrapper(itemData.getValue().getSenhaConta())
        );

        tabelaD.getColumns().add(colId);
        tabelaD.getColumns().add(colNomeEmpresa);
        tabelaD.getColumns().add(colCnpjCpf);
        tabelaD.getColumns().add(colEmail);
        tabelaD.getColumns().add(colTelefone);
        tabelaD.getColumns().add(colDataNasc);
        tabelaD.getColumns().add(colSenha);

        tabelaD.setItems(AdminUC.getListaDesenvolvedor());

        tabelaD.getSelectionModel().selectedItemProperty().addListener(
            (obj, antigo, nova) -> AdminUC.toBoundaryDesenvolvedor(nova)
        );

        bCadastrar.setOnAction(e -> {new CadastroDesenvolvedorUI(true).start(stage);});
        bConsultar.setOnAction(e -> {AdminUC.pesquisar(txtCampo.getText());});
        bAtualizar.setOnAction(e -> {
            Desenvolvedor selecionado = tabelaD.getSelectionModel().getSelectedItem();
            if (selecionado == null) {
                String nome = txtCampo.getText();
                if (nome == null || nome.isBlank()) {
                    new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION, "Selecione um desenvolvedor na tabela ou informe o nome para atualizar").show();
                    return;
                }
                AdminUC.pesquisar(nome);
                if (AdminUC.getListaDesenvolvedor().isEmpty()) {
                    new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION, "Desenvolvedor não encontrado").show();
                    return;
                }
                selecionado = AdminUC.getListaDesenvolvedor().get(0);
            }
            new CadastroDesenvolvedorUI(selecionado, true).start(stage);
        });
        btnDeletar.setOnAction(e -> {
            String textoId = txtCampo.getText();
            try {
                long id = Long.parseLong(textoId);
                AdminUC.apagarPorId(id);
            } catch (NumberFormatException ex) {
                System.out.println("ID inválido: " + textoId);
            }
        });

        stage.setScene(scn);
        stage.show();

    }

}
