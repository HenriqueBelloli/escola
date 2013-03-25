package br.edu.unisep.escola;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class TurmaTest {

    Turma tu;
    Aluno al;
    Aluno al2;

    @Before
    public void init() {
        tu = new Turma(12, "Turma1");
        al = new Aluno(1234, "");
        al.setNotaG1(1);
        al.setNotaG2(10);

        al2 = new Aluno(123, "");
        al2.setNotaG1(5);
        al2.setNotaG2(5);
    }

    @Test
    public void matricula() {
        tu.matricula(al);
        assertTrue(tu.quantidade_alunos() > 0);
    }

    @Test
    public void removeMatricula() {
        tu.cancelarMatricula(al);
        assertFalse(tu.quantidade_alunos() > 0);
    }

    @Test
    public void quantidade_alunos() {
        assertFalse(tu.quantidade_alunos() > 0);
        tu.matricula(al);
        assertTrue(tu.quantidade_alunos() > 0);
        assertEquals(1, tu.quantidade_alunos(), 0);
        tu.matricula(al2);
        assertTrue(tu.quantidade_alunos() > 0);
        assertEquals(2, tu.quantidade_alunos(), 0);
        tu.cancelarMatricula(al);
        assertEquals(1, tu.quantidade_alunos(), 0);
        tu.cancelarMatricula(al2);
        assertEquals(0, tu.quantidade_alunos(), 0);
    }

    @Test
    public void quantidade_alunos_aprovados() {
        tu.matricula(al);
        tu.matricula(al2);
        assertTrue(tu.quantidade_alunos() > 0);
        assertEquals(2, tu.quantidade_alunos(), 0);
        assertEquals(1, tu.quantidade_alunos_aprovados(), 0);
        tu.cancelarMatricula(al2);
        assertEquals(1, tu.quantidade_alunos_aprovados(), 0);
        tu.cancelarMatricula(al);
        assertEquals(0, tu.quantidade_alunos_aprovados(), 0);

    }

    @Test
    public void quantidade_alunos_reprovados() {
        tu.matricula(al);
        tu.matricula(al2);
        assertTrue(tu.quantidade_alunos() > 0);
        assertEquals(2, tu.quantidade_alunos(), 0);
        assertEquals(1, tu.quantidade_alunos_reprovados(), 0);
        tu.cancelarMatricula(al);
        assertEquals(1, tu.quantidade_alunos_reprovados(), 0);
        tu.cancelarMatricula(al2);
        assertEquals(0, tu.quantidade_alunos_reprovados(), 0);
    }

    @Test
    public void porcentagem_alunos_aprovados() {
        tu.matricula(al);
        tu.matricula(al2);
        assertEquals(50, tu.porcentagem_alunos_aprovados(), 0);
        tu.cancelarMatricula(al2);
        assertEquals(100, tu.porcentagem_alunos_aprovados(), 0);
        tu.cancelarMatricula(al);
        assertEquals(0, tu.porcentagem_alunos_aprovados(), 0);

    }

    @Test
    public void porcentagem_alunos_reprovados() {
        tu.matricula(al);
        tu.matricula(al2);
        assertTrue(tu.quantidade_alunos() > 0);
        assertEquals(2, tu.quantidade_alunos(), 0);
        assertEquals(1, tu.quantidade_alunos_reprovados(), 0);
        tu.cancelarMatricula(al);
        assertEquals(1, tu.quantidade_alunos_reprovados(), 0);
        tu.cancelarMatricula(al2);
        assertEquals(0, tu.quantidade_alunos_reprovados(), 0);
    }

    @Test
    public void media_geral_turma() {
        tu.matricula(al);
        assertEquals(7, tu.media_geral_turma(), 0);
        tu.matricula(al2);
        assertEquals(6, tu.media_geral_turma(), 0);
        
        tu.cancelarMatricula(al);
        assertEquals(5, tu.media_geral_turma(), 0);
        tu.cancelarMatricula(al2);
        assertEquals(0, tu.media_geral_turma(), 0);
    }
}
