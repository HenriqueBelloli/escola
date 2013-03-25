package br.edu.unisep.escola;

import java.util.ArrayList;

public class Turma {

    private int nCodigo;
    private String cDescricao;
    private ArrayList<Aluno> alunos;

    public Turma(int codigo, String descricao) {
        this.nCodigo = codigo;
        this.cDescricao = descricao;
        alunos = new ArrayList<>();
    }

    public int getCodigo() {
        return nCodigo;
    }

    public void setCodigo(int nCodigo) {
        this.nCodigo = nCodigo;
    }

    public String getDescricao() {
        return cDescricao;
    }

    public void setDescricao(String cDescricao) {
        this.cDescricao = cDescricao;
    }

    public ArrayList<Aluno> getAlunos() {
        return this.alunos;
    }

    public void matricula(Aluno al) {
        this.alunos.add(al);
        al.setTurma(this.getCodigo());
    }

    public void cancelarMatricula(Aluno al) {
        this.alunos.remove(al);
        al.setTurma(-1);
        al.setNotaG1(0);
        al.setNotaG2(0);
    }

    public int quantidade_alunos() {
        return this.alunos.size();
    }

    public int quantidade_alunos_aprovados() {
        int nContador, nTotal = 0;

        for (nContador = 0; nContador < this.alunos.size(); nContador++) {
            if (alunos.get(nContador).media() >= 7) {
                nTotal++;
            }
        }
        return nTotal;
    }

    public int quantidade_alunos_reprovados() {
        int nContador, nTotal = 0;

        for (nContador = 0; nContador < this.alunos.size(); nContador++) {
            if (alunos.get(nContador).media() < 7) {
                nTotal++;
            }
        }
        return nTotal;
    }

    public int porcentagem_alunos_aprovados() {

        if (quantidade_alunos() > 0) {
            return quantidade_alunos_aprovados() * 100 / quantidade_alunos();
        } else {
            return 0;
        }
    }

    public int porcentagem_alunos_reprovados() {
        if (quantidade_alunos() > 0) {
            return quantidade_alunos_reprovados() * 100 / quantidade_alunos();
        } else {
            return 0;
        }
    }

    public float media_geral_turma() {
        int nContador;
        float nTotal = 0;
        
        if (quantidade_alunos() > 0) {
            for (nContador = 0; nContador < this.alunos.size(); nContador++) {
                nTotal += alunos.get(nContador).media();
            }
            return nTotal / this.alunos.size();
        } else {
            return 0;
        }
    }
}
