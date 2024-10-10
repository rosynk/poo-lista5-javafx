package Ex20;

import java.util.ArrayList;
import java.util.List;

public class AlunoControl {
    
    private List<Aluno> lista = new ArrayList<Aluno>();

    public void gravar (Aluno a){
        lista.add(a);
    }

    public Aluno pesquisarPorNome (String nome){
        for (Aluno a : lista){
            if (a.getNome().contains(nome)){
                return a;
            }
        }

        return null;
    }

}
