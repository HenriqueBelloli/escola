package br.edu.unisep.escola;

import br.com.utilitarios.henrique.io.console;
import java.util.ArrayList;

public class Instituicao {

    private ArrayList<Turma> turmas = new ArrayList<Turma>();
    private ArrayList<Aluno> alunos = new ArrayList<Aluno>();

    public void addTurma(Turma tur) {
        this.turmas.add(tur);
    }

    public void addAluno(Aluno al) {
        this.alunos.add(al);
    }

    public void removerTurma(Turma tur) {
        this.turmas.remove(tur);
    }

    public void removerAluno(Aluno al) {
        this.alunos.remove(al);
    }

    public int quantidadeTurmas() {
        return this.turmas.size();
    }

    public int quantidadeAlunos() {
        return this.alunos.size();
    }

    public ArrayList<Aluno> getAlunos() {
        return this.alunos;
    }

    public ArrayList<Turma> getTurmas() {
        return this.turmas;
    }

    public void listarTurmas() {
        if (quantidadeTurmas() > 0) {
            Turma t;
            console.escreverLn("------------------------------------");
            console.escreverLn("Código \tDescrição");
            console.escreverLn("------------------------------------");

            for (int nContador = 0; nContador < this.turmas.size(); nContador++) {
                t = this.turmas.get(nContador);
                console.escreverLn(t.getCodigo() + "\t" + t.getDescricao());
            }
        } else {
            console.escreverLn("Nenhuma Turma Cadastrada!");
        }
    }

    public void listarAlunos() {
        console.escreverLn("------------------------------------");

        if (quantidadeAlunos() > 0) {
            Aluno a;
            console.escreverLn("R.A \tNome");
            console.escreverLn("------------------------------------");

            for (int nContador = 0; nContador < this.alunos.size(); nContador++) {
                a = this.alunos.get(nContador);
                console.escreverLn(a.getRa() + "\t" + a.getNome());
            }
        } else {
            console.escreverLn("Nenhum Aluno Cadastrado!");
        }
    }
}
