package Ex20;

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
import java.time.LocalDate;

public class AlunoBoundary extends Application {
    private AlunoControl control = new AlunoControl();

    private TextField textId = new TextField();
    private TextField textRa = new TextField();
    private TextField textNome = new TextField();
    private TextField textNascimento = new TextField();

    @Override
    public void start (Stage stage){
        GridPane pane = new GridPane();
        ColumnConstraints colLabels = new ColumnConstraints();
        colLabels.setPercentWidth(30);

        ColumnConstraints colTextFields = new ColumnConstraints();
        colTextFields.setPercentWidth(70);
        pane.getColumnConstraints().addAll(colLabels, colTextFields);

        RowConstraints linhaConstraint = new RowConstraints();
        linhaConstraint.setPercentHeight(20.0);

        for (int i = 0; i < 4; i++) {
            pane.getRowConstraints().add(linhaConstraint);
        }

        Scene snc = new Scene(pane, 600, 300);

        pane.add(new Label("ID"), 0, 0);
        pane.add(textId, 1,0 );
        pane.add(new Label("RA"), 0, 1);
        pane.add(textRa, 1, 1);
        pane.add(new Label ("Nome"), 0, 2);
        pane.add(textNome, 1, 2);
        pane.add(new Label("Nascimento"), 0, 3);
        pane.add(textNascimento, 1, 3);

        Button btnGravar = new Button("Gravar");
        
        btnGravar.setOnAction(e -> {
            control.gravar(boundaryToEntity());
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Alunos");
            alert.setHeaderText("Informativo");
            alert.setContentText("Aluno adicionado com sucesso!");
            alert.show();


            textId.setText("");
            textNascimento.setText("");
            textNome.setText("");
            textRa.setText("");

        });

        Button btnPesquisar = new Button("Pesquisar");

        btnPesquisar.setOnAction(e -> {

            Aluno a = control.pesquisarPorNome(textNome.getText());
            if (a != null){
                entityToBoundary(a);
            } else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Agenda de Alunos");
                alert.setHeaderText("Aviso");
                alert.setContentText("Não foi encontrado um aluno com esse nome!");
                alert.show();        
            }
        });

        pane.add(btnGravar, 0, 5);  
        pane.add(btnPesquisar, 1, 5);  

        stage.setScene(snc);
        stage.setTitle("Alunos");
        stage.show();
    }


    public Aluno boundaryToEntity (){
        Aluno a = new Aluno();
        a.setId(Long.parseLong(textId.getText()));
        a.setNascimento(LocalDate.parse(textNascimento.getText()));
        a.setNome(textNome.getText());
        a.setRa(textRa.getText());

        return a;
    }

    public void entityToBoundary(Aluno a){
        if (a != null){
            textNome.setText(a.getNome());
            textNascimento.setText(a.getNascimento().toString());
            textRa.setText(a.getRa());
            textId.setText(String.valueOf(a.getId()));
        }

    }


}
