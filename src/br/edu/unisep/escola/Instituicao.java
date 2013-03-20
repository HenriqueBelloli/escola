package br.edu.unisep.escola;
import java.util.ArrayList;

public class Instituicao {
     ArrayList<Turma> turmas = new ArrayList<Turma>();
    
    public void addTurma(Turma tur) {
        this.turmas.add(tur);
    }
    
}
