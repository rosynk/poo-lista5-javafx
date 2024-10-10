package Ex19;

public class Curso {
    private int id;
    private String nome;
    private int codCurso;
    private String nomeCoordenador;
    private int quantidadeAlunos;

    public int getQuantidadeAlunos() {
        return quantidadeAlunos;
    }
    public void setQuantidadeAlunos(int quantidadeAlunos) {
        this.quantidadeAlunos = quantidadeAlunos;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome (String nome){
        this.nome = nome;
    }

    public int getCodCurso(){
        return codCurso;
    }
    public void setCodCurso(int codCurso){
        this.codCurso = codCurso;
    }

    public String getNomeCoordenador (){
        return nomeCoordenador;
    }

    public void setNomeCoordenador(String nomeCoordenador){
        this.nomeCoordenador = nomeCoordenador;
    }

    @Override
    public String toString() { 
        return String.format("Contato(Código Curso='%s', ID='%s', Nome='%s', Nome Coordenador='%s', Quantidade de Alunos= '%s')", 
                    this.codCurso, this.id, this.nome, this.nomeCoordenador, this.quantidadeAlunos);
    }
}
