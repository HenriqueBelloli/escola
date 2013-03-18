package br.edu.unisep.escola;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class AlunoTest {

    Aluno al;

    @Before
    public void init() {
        al = new Aluno(1234, "");
        al.setNotaG1(1);
        al.setNotaG2(10);

    }

    @Test
    public void media() {
        assertEquals(7, al.media(), 0);
    }

    @Test
    public void nomeNulo() {
        assertEquals("", al.getNome());
        assertEquals(1234, al.getRa());
    }
}
