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
    
    public void matricula(Aluno al){
        this.alunos.add(al);
    }
    
    public int quantidade_alunos() {
        return this.alunos.size();
    }

    public int quantidade_alunos_aprovados() {
        int nContador, nTotal = 0;

        for (nContador = 0; nContador <= this.alunos.size(); nContador++) {
            if (alunos.get(nContador).media() >= 7) {
                nTotal++;
            }
        }
        return nTotal;
    }

    public int quantidade_alunos_reprovados() {
        int nContador, nTotal = 0;

        for (nContador = 0; nContador <= this.alunos.size(); nContador++) {
            if (alunos.get(nContador).media() < 7) {
                nTotal++;
            }
        }
        return nTotal;
    }

    public int porcentagem_alunos_aprovados() {
        int nContador, nTotal = 0;

        for (nContador = 0; nContador <= this.alunos.size(); nContador++) {
            if (alunos.get(nContador).media() >= 7) {
                nTotal++;
            }
        }
        return (nTotal * 100) / alunos.size();
    }

    public int porcentagem_alunos_reprovados() {
        int nContador, nTotal = 0;

        for (nContador = 0; nContador <= this.alunos.size(); nContador++) {
            if (alunos.get(nContador).media() < 7) {
                nTotal++;
            }
        }
        return (nTotal * 100) / alunos.size();
    }

    public double media_geral_turma() {
        int nContador, nTotal = 0;

        for (nContador = 0; nContador <= this.alunos.size(); nContador++) {
            nTotal += alunos.get(nContador).media();
        }
        return nTotal / this.alunos.size();
    }
}
