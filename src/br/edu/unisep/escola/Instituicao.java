package br.edu.unisep.escola;

import br.com.utilitarios.henrique.io.console;
import java.util.ArrayList;

public class Instituicao {

    ArrayList<Turma> turmas = new ArrayList<Turma>();
    ArrayList<Aluno> alunos = new ArrayList<Aluno>();

    public void addTurma(Turma tur) {
        this.turmas.add(tur);
    }

    public void addAluno(Aluno al) {
        this.alunos.add(al);
    }

    public void listarTurmas() {
        Turma t;
        console.escreverLn("------------------------------------");
        console.escreverLn("Código \tDescrição");
        console.escreverLn("------------------------------------");

        for (int nContador = 0; nContador < this.turmas.size(); nContador++) {
            t = this.turmas.get(nContador);
            console.escreverLn(t.getCodigo() + "\t" + t.getDescricao());
        }
    }

    public void listarAlunos() {
        Aluno a;
        console.escreverLn("------------------------------------");
        console.escreverLn("R.A \nNome");
        console.escreverLn("------------------------------------");

        for (int nContador = 0; nContador < this.turmas.size(); nContador++) {
            a = this.alunos.get(nContador);
            console.escreverLn(a.getRa() + "\n" + a.getNome());
        }
    }
}
