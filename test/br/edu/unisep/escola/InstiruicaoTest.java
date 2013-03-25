package br.edu.unisep.escola;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class InstiruicaoTest {

    Turma tur;
    Turma tur2;
    Aluno al;
    Aluno al2;
    ArrayList<Turma> t = new ArrayList<>();
    ArrayList<Aluno> a = new ArrayList<>();
    Instituicao inst;

    @Before
    public void init() {
        inst = new Instituicao();
        tur = new Turma(12, "Turma1");
        tur2 = new Turma(14, "Teste");
        al = new Aluno(1234, "");
        al.setNotaG1(1);
        al.setNotaG2(10);

        al2 = new Aluno(123, "");
        al2.setNotaG1(5);
        al2.setNotaG2(5);
    }

    @Test
    public void addTurma() {
        t = inst.getTurmas();
        assertFalse(t.size() > 0);
        inst.addTurma(tur);
        assertEquals(1, inst.quantidadeTurmas(), 0);
        inst.addTurma(tur2);
        assertEquals(2, inst.quantidadeTurmas(), 0);

    }

    @Test
    public void removerTurma() {
        inst.addTurma(tur);
        inst.addTurma(tur2);
        assertEquals(2, inst.quantidadeTurmas(), 0);

        inst.removerTurma(tur);
        assertEquals(1, inst.quantidadeTurmas(), 0);

        inst.removerTurma(tur2);
        assertEquals(0, inst.quantidadeTurmas(), 0);
    }

    @Test
    public void addAluno() {
        a = inst.getAlunos();
        assertFalse(a.size() > 0);
        inst.addAluno(al);
        assertEquals(1, inst.quantidadeAlunos(), 0);
        inst.addAluno(al2);
        assertEquals(2, inst.quantidadeAlunos(), 0);
    }

    @Test
    public void removerAluno() {
        a = inst.getAlunos();
        assertFalse(a.size() > 0);
        
        inst.addAluno(al);
        assertEquals(1, inst.quantidadeAlunos(), 0);
        
        inst.addAluno(al2);
        assertEquals(2, inst.quantidadeAlunos(), 0);
        
        inst.removerAluno(al);
        assertEquals(1, inst.quantidadeAlunos(), 0);
        
        inst.removerAluno(al2);
        assertEquals(0, inst.quantidadeAlunos(), 0);
    }
}
