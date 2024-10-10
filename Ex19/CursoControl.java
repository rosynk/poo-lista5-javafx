package Ex19;

import java.util.ArrayList;
import java.util.List;


public class CursoControl {
    private List<Curso> lista = new ArrayList<Curso>();


    public void gravar(Curso c){
        lista.add(c);
    }

    public Curso pesquisar(int idCurso) { 
        for (Curso c : lista) { 
            if (c.getId() == idCurso) { 
                return c;
            }
        }
        return null;
    }
}
