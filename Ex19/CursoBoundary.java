package Ex19;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CursoBoundary extends Application {

    private CursoControl control = new CursoControl();

    private TextField txtId = new TextField();
    private TextField txtNome = new TextField();
    private TextField txtCodCurso = new TextField();
    private TextField txtNomeCoordenador = new TextField();
    private TextField txtQuantidadeAlunos = new TextField();

    @Override
    public void start(Stage stage) {

        GridPane pane = new GridPane();
        ColumnConstraints colLabels = new ColumnConstraints();
        colLabels.setPercentWidth(30);

        ColumnConstraints colTextFields = new ColumnConstraints();
        colTextFields.setPercentWidth(70);
        pane.getColumnConstraints().addAll(colLabels, colTextFields);   

        RowConstraints linhaConstraint = new RowConstraints();
        linhaConstraint.setPercentHeight(20.0);

        
        for (int i = 0; i < 6; i++) {
            pane.getRowConstraints().add(linhaConstraint);
        }
        
        Scene scn = new Scene(pane, 600, 300);

        pane.add(new Label("ID"), 0 , 0);
        pane.add(txtId, 1, 0);  // Corrigi para adicionar o campo txtId
        pane.add(new Label("Nome"), 0, 1);
        pane.add(txtNome, 1, 1);
        pane.add(new Label("Código Curso"), 0, 2);
        pane.add(txtCodCurso, 1, 2);
        pane.add(new Label("Nome Coordenador"), 0, 3);
        pane.add(txtNomeCoordenador, 1, 3);
        pane.add(new Label("Quantidade de Alunos"), 0, 4);
        pane.add(txtQuantidadeAlunos, 1, 4);

       
        Button btnGravar = new Button("Gravar");
        btnGravar.setOnAction(e -> {
            control.gravar(boundaryToEntity());
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Cursos");
            alert.setHeaderText("Informativo");
            alert.setContentText("Curso foi salvo com sucesso");
            alert.show();

            txtCodCurso.setText("");
            txtId.setText("");
            txtNome.setText("");
            txtNomeCoordenador.setText("");
            txtQuantidadeAlunos.setText("");
        });

        Button btnPesquisar = new Button("Pesquisar");
        btnPesquisar.setOnAction(e -> { 
            int id = Integer.parseInt(txtId.getText());
            Curso c = control.pesquisar(id);

            
            if (c != null) {
                entityToBoundary(c);
            } else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Agenda de Cursos");
                alert.setHeaderText("Aviso");
                alert.setContentText("Não foi encontrado um curso com este ID");
                alert.show();                
            }
        });

        pane.add(btnGravar, 0, 5);  // Colocando o botão "Gravar" na linha 5
        pane.add(btnPesquisar, 1, 5);  // Colocando o botão "Pesquisar" na linha 5

        stage.setScene(scn);
        stage.setTitle("Agenda de Cursos");
        stage.show();
    }

    public Curso boundaryToEntity() {
        Curso c = new Curso();

        c.setCodCurso(Integer.parseInt(txtCodCurso.getText()));
        c.setId(Integer.parseInt(txtId.getText()));
        c.setNome(txtNome.getText());
        c.setNomeCoordenador(txtNomeCoordenador.getText());
        c.setQuantidadeAlunos(Integer.parseInt(txtQuantidadeAlunos.getText()));

        return c;
    }

    public void entityToBoundary(Curso c) {
        if (c != null) {
            txtId.setText(String.valueOf(c.getId()));
            txtNome.setText(c.getNome());
            txtCodCurso.setText(String.valueOf(c.getCodCurso()));
            txtNomeCoordenador.setText(c.getNomeCoordenador());
            txtQuantidadeAlunos.setText(String.valueOf(c.getQuantidadeAlunos()));
        }
    }
}
