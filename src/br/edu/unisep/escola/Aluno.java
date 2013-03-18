package br.edu.unisep.escola;

public class Aluno {

    private int ra;
    private String nome;
    private double notaG1;
    private double notaG2;
    private int turma;

    public Aluno(int ra, String nome) {
        this.ra = ra;
        this.nome = nome;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNotaG1() {
        return notaG1;
    }

    public void setNotaG1(double notaG1) {
        this.notaG1 = notaG1;
    }

    public double getNotaG2() {
        return notaG2;
    }

    public void setNotaG2(double notaG2) {
        this.notaG2 = notaG2;
    }

    public int getTurma() {
        return turma;
    }

    public void setTurma(int turma) {
        this.turma = turma;
    }

    public double media() {
        return (this.notaG1 + this.notaG2 * 2) / 3;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.ra;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        if (this.ra != other.ra) {
            return false;
        }
        return true;
    }
}
