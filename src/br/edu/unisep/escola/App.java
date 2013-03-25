package br.edu.unisep.escola;

import br.com.utilitarios.henrique.io.console;
import br.com.utilitarios.henrique.validadores.StringUtils;

public class App {

    Instituicao insti = new Instituicao();

    public static void main(String[] args) {
        App app = new App();
        app.P_menuPrincipal();
    }

    private void P_menuPrincipal() {
        console.escreverLn("-------------------------------------------------------------");
        console.escrever("A - Cadastros || ");
        console.escrever("B - Manutenção || ");
        console.escrever("C - Relatorios || ");
        console.escreverLn("D - Sair ");
        console.escreverLn("-------------------------------------------------------------");

        switch (console.ler().toUpperCase()) {
            case "A":
                P_menuCadastros();
                break;
            case "B":
                P_menuManutencao();
                break;
            case "C":
                P_menuRelatorios();

            case "D":
                System.exit(0);
            default:
                console.escreverLn("Opção inválida.\n");
                P_menuPrincipal();
        }

    }

    private void P_menuCadastros() {
        console.escreverLn("A - Cadastrar Alunos");
        console.escreverLn("B - Cadastrar Turmas");
        console.escreverLn("C - Voltar");

        switch (console.ler().toUpperCase()) {
            case "A":
                P_cadastrarAluno();
                break;
            case "B":
                P_cadastrarTurma();
                break;
            case "C":
                P_menuPrincipal();
            default:
                console.escreverLn("Opção inválida.\n");
                P_menuCadastros();
        }

    }

    private void P_menuRelatorios() {
        console.escreverLn("A - Alunos Cadastrados");
        console.escreverLn("B - Turmas Cadastradas");
        console.escreverLn("C - Alunos não Matriculados");
        console.escreverLn("D - Alunos por Turma");
        console.escreverLn("E - Quantidade de alunos por Turma");
        console.escreverLn("F - Quantidade  de Alunos Aprovados  por Turma");
        console.escreverLn("G - Quantidade  de Alunos Reprovados por Turma");
        console.escreverLn("H - Porcentagem de Alunos Aprovados  por Turma");
        console.escreverLn("I - Porcentagem de Alunos Reprovados por Turma");
        console.escreverLn("J - Nota dos Alunos");
        console.escreverLn("K - Nota dos Alunos por Turma");
        console.escreverLn("L - Media geral por Turma");
        console.escreverLn("M - Voltar");

        switch (console.ler().toUpperCase()) {
            case "A":
                P_relatorioAlunosCadastrados();
                break;
            case "B":
                P_relatorioTurmasCadastradas();
                break;
            case "C":
                P_relatorioAlunosSemMatricula();
                break;
            case "D":
                P_relatorioAlunosPorTurma();
                break;
            case "E":
                P_relatorioQuantidadeAlunosPorTurma();
                break;
            case "F":
                P_relatorioQuantidadeAprovadosPorTurma();
                break;
            case "G":
                P_relatorioQuantidadeReprovadosPorTurma();
                break;
            case "H":
                P_relatorioPorcentagemAprovadosPorTurma();
                break;
            case "I":
                P_relatorioPorcentagemReprovadosPorTurma();
                break;
            case "J":
                P_relatorioNotasAlunos();
                break;
            case "K":
                P_relatorioNotasAlunosPorTurma();
                break;
            case "L":
                P_relatorioMediaGeral();
                break;
            case "M":
                P_menuPrincipal();
                break;
            default:
                console.escreverLn("Opção inválida.\n");
                P_menuRelatorios();
        }
    }

    private void P_menuManutencao() {
        console.escreverLn("A - Matricular Aluno");
        console.escreverLn("B - Lançar Notas");
        console.escreverLn("C - Remover alunos da Turma");
        console.escreverLn("D - Remover alunos");
        console.escreverLn("E - Remover turmas");
        console.escreverLn("F - Voltar");

        switch (console.ler().toUpperCase()) {
            case "A":
                P_matricularAlunos();
                break;
            case "B":
                P_lancarNotas();
                break;
            case "C":
                P_removerAlunoTurma();
                break;
            case "D":
                P_removerAluno();
            case "E":
                P_removerTurma();
            case "F":
                P_menuPrincipal();
            default:
                console.escreverLn("Opção inválida.\n");
                P_menuManutencao();
        }
    }

    private void P_cadastrarTurma() {
        int nCodigo = 0;
        String cDescricao;
        String _cCodigo;
        boolean lAux = true;

        do {
            do {
                lAux = true;
                console.escrever("Digite o Código da Turma... ");
                _cCodigo = console.ler();

                if (!StringUtils.ehInteiro(_cCodigo)) {
                    console.escreverLn("Digite um número Inteiro\n");
                    lAux = false;
                } else {
                    nCodigo = Integer.parseInt(_cCodigo);
                    if (!F_validaCodigoTurma(nCodigo)) {
                        console.escreverLn("Já existe turma com esse código!\n");
                        lAux = false;
                    }
                }
            } while (!lAux);

            console.escrever("Digite uma Descrição para a Turma... ");
            cDescricao = console.ler();

            Turma tur = new Turma(nCodigo, cDescricao);
            insti.addTurma(tur);

            console.escreverLn("\nTurma " + cDescricao + " Cadastrada com Sucesso!");
            console.escreverLn("Deseja realizar outro cadastro? \n   [S]im  [N]ão");

        } while (console.ler().equalsIgnoreCase("S"));

        P_menuCadastros();
    }

    private void P_cadastrarAluno() {
        int ra = 0;
        String _ra;
        String nome;
        boolean lAux = true;

        do {
            do {
                lAux = true;
                console.escrever("Digite o R.A.... ");
                _ra = console.ler();

                if (!StringUtils.ehInteiro(_ra)) {
                    console.escreverLn("Digite um número Inteiro.\n");
                    lAux = false;
                } else {
                    ra = Integer.parseInt(_ra);
                    if (!F_validaCodigoAluno(ra)) {
                        console.escreverLn("Já existe aluno com esse R.A.\n");
                        lAux = false;
                    }
                }
            } while (!lAux);

            console.escrever("Digite o Nome... ");
            nome = console.ler();

            Aluno al = new Aluno(ra, nome);
            insti.addAluno(al);

            console.escreverLn("\nAluno " + nome + " Cadastrado com Sucesso!");
            console.escreverLn("Deseja realizar outro cadastro? \n   [S]im  [N]ão");

        } while (console.ler().equalsIgnoreCase("S"));

        P_menuCadastros();
    }

    private void P_matricularAlunos() {
        if(insti.quantidadeAlunos() > 0){
            if(insti.quantidadeTurmas() > 0){      
                do {
                    Turma t = F_selecionarTurma();
                    Aluno a = F_selecionarAluno(true);

                    t.matricula(a);
                    console.escreverLn("\nAluno " + a.getNome() + " Matriculado com Sucesso!\n");
                    console.escreverLn("Deseja realizar outro cadastro? \n   [S]im  [N]ão");

                } while (console.ler().equalsIgnoreCase("S"));
            }else{
                console.escreverLn("Nenhuma Turma Cadastrada\nRealize o cadastro e tente Novamente.\n");
                F_Wait();                
            }
        }else{
                console.escreverLn("Nenhum Aluno Cadastrado\nRealize o cadastro e tente Novamente.\n");
                F_Wait();                
        }
        

        P_menuManutencao();
    }

    private void P_lancarNotas() {
        if(insti.quantidadeAlunos() > 0){    
            do {
                Aluno a = F_selecionarAluno(false);
                boolean lAux = true;
                float g1 = 0;
                float g2 = 0;

                do {
                    console.escrever("Digite a nota da G1.. ");
                    String _g1 = console.ler();

                    if (!StringUtils.ehNumero(_g1)) {
                        console.escreverLn("\nExpressão Inválida!\n");
                        lAux = false;
                    } else {
                        g1 = Float.parseFloat(_g1);
                    }

                } while (!lAux);

                do {
                    console.escrever("Digite a nota da G2.. ");
                    String _g2 = console.ler();

                    if (!StringUtils.ehNumero(_g2)) {
                        console.escreverLn("\nExpressão Inválida!\n");
                        lAux = false;
                    } else {
                        g2 = Float.parseFloat(_g2);
                    }

                } while (!lAux);

                a.setNotaG1(g1);
                a.setNotaG2(g2);

                console.escreverLn("\nNotas do Aluno " + a.getNome() + " Lançadas com Sucesso!\n");
                console.escreverLn("Deseja realizar outro Lançamento? \n   [S]im  [N]ão");

            } while (console.ler().equalsIgnoreCase("S"));
        }else{
            console.escreverLn("Nenhum Aluno Cadastrado\nRealize o cadastro e tente Novamente.\n");
            F_Wait();                
        }
        
        P_menuManutencao();
    }

    private void P_removerAlunoTurma() {
        Turma t;
        Aluno a;
        
        if(insti.quantidadeAlunos() > 0){
            if(insti.quantidadeTurmas() > 0){  
                do {
                    if(insti.quantidadeAlunosSemTurma() != insti.quantidadeAlunos()){
                        do {
                            t = F_selecionarTurma();
                            a = F_selecionarAluno(false);
                        } while (!F_procurarAlunoNaTurma(a, t, true));

                        t.cancelarMatricula(a);
                        console.escreverLn("\nAluno " + a.getNome() + " removido da turma " + t.getDescricao() + " com Sucesso!\n");
                        console.escreverLn("Deseja cancelar outra matricula? \n   [S]im  [N]ão");
                    }else{
                        console.escreverLn("Nenhuma Aluno Matriculado\nRealize a matricula e tente Novamente.\n");    
                        F_Wait(); 
                        P_menuManutencao();
                    }
                } while (console.ler().equalsIgnoreCase("S"));
                
            }else{
                console.escreverLn("Nenhuma Turma Cadastrada\nRealize o cadastro e tente Novamente.\n");
                F_Wait();                
            }
        }else{
            console.escreverLn("Nenhum Aluno Cadastrado\nRealize o cadastro e tente Novamente.\n");
            F_Wait();                
        }
        
        P_menuManutencao();
    }

    private void P_removerAluno() {
        Turma t;
        Aluno a;
        
        if(insti.quantidadeAlunos() > 0){
            do {
                a = F_selecionarAluno(false);

                for (int nContador = 0; nContador < insti.quantidadeTurmas(); nContador++) {
                    t = insti.getTurmas().get(nContador);
                    if (F_procurarAlunoNaTurma(a, t, false)) {
                        t.cancelarMatricula(a);
                    }
                }
                insti.removerAluno(a);

                console.escreverLn("\nAluno " + a.getNome() + " removido com Sucesso!\n");
                console.escreverLn("Deseja remover outro aluno? \n   [S]im  [N]ão");

            } while (console.ler().equalsIgnoreCase("S"));
        }else{
            console.escreverLn("Nenhum Aluno Cadastrado\nRealize o cadastro e tente Novamente.\n");
            F_Wait();               
        }
        P_menuManutencao();
    }

    private void P_removerTurma() {
        if(insti.quantidadeTurmas() > 0){
            do {
                Aluno a;
                Turma t = F_selecionarTurma();

                for (int nContador = 0; nContador < t.quantidade_alunos(); nContador++) {
                    a = t.getAlunos().get(nContador);
                    t.cancelarMatricula(a);
                }
                insti.removerTurma(t);

                console.escreverLn("\nTurma " + t.getDescricao() + " removida com Sucesso!\n");
                console.escreverLn("Deseja remover outra turma? \n   [S]im  [N]ão");

            } while (console.ler().equalsIgnoreCase("S"));
        }else{
            console.escreverLn("Nenhuma Turma Cadastrada\nRealize o cadastro e tente Novamente.\n");
            F_Wait();   
        }
        
        P_menuManutencao();
    }

    private void P_relatorioAlunosCadastrados() {
        insti.listarAlunos();
        console.escreverLn("------------------------------------\n");

        F_Wait();
        P_menuRelatorios();
    }

    private void P_relatorioTurmasCadastradas() {
        insti.listarTurmas();
        console.escreverLn("------------------------------------\n");

        F_Wait();
        P_menuRelatorios();
    }

    private void P_relatorioAlunosSemMatricula() {
        Aluno a;

        if (insti.quantidadeAlunos() > 0) {
            if (insti.quantidadeAlunosSemTurma() > 0) {
                console.escreverLn("------------------------------------");
                console.escreverLn("R.A \tNome");
                console.escreverLn("------------------------------------");

                for (int nContador = 0; nContador < insti.quantidadeAlunos(); nContador++) {
                    a = insti.getAlunos().get(nContador);
                    if (a.getTurma() == -1) {
                        console.escreverLn(a.getRa() + "\t" + a.getNome());
                    }
                }
            } else {
                console.escreverLn("\n------------------------------------");
                console.escrever  ("Todos os Alunos Matriculados!");
            }
        } else {
            console.escreverLn("\n------------------------------------");
            console.escrever  ("Nenhum Aluno Cadastrado!");
        }

        console.escreverLn("\n------------------------------------\n");

        F_Wait();
        P_menuRelatorios();
    }

    private void P_relatorioAlunosPorTurma() {
        Turma t;
        Aluno a;

        if (insti.quantidadeTurmas() > 0) {
            for (int nContador = 0; nContador < insti.quantidadeTurmas(); nContador++) {
                console.escreverLn("\n------------------------------------");
                t = insti.getTurmas().get(nContador);
                console.escreverLn(t.getDescricao());
                console.escreverLn("------------------------------------");

                if (t.quantidade_alunos() > 0) {
                    for (int nContador2 = 0; nContador2 < t.quantidade_alunos(); nContador2++) {
                        a = t.getAlunos().get(nContador2);
                        console.escreverLn(a.getNome());
                    }
                } else {
                    console.escreverLn("Sem alunos");
                }
            }
        } else {
            console.escreverLn("\n------------------------------------");
            console.escrever  ("Nenhuma Turma Cadastrada!");
        }

        console.escreverLn("\n------------------------------------\n");

        F_Wait();
        P_menuRelatorios();
    }

    private void P_relatorioQuantidadeAlunosPorTurma() {
        Turma t;

        if (insti.quantidadeTurmas() > 0) {
            for (int nContador = 0; nContador < insti.quantidadeTurmas(); nContador++) {
                console.escreverLn("\n------------------------------------");
                t = insti.getTurmas().get(nContador);
                console.escreverLn(t.getDescricao());
                console.escreverLn("------------------------------------");
    
                if (t.quantidade_alunos() > 0) {
                    console.escrever(t.quantidade_alunos() + " ");
                    if (t.quantidade_alunos() > 1) {
                        console.escreverLn("Alunos");
                    } else {
                        console.escreverLn("Aluno");
                    }
                } else {
                    console.escreverLn("Sem alunos");
                }
            }
        } else {
            console.escreverLn("\n------------------------------------");
            console.escrever  ("Nenhuma Turma Cadastrada!");
        }

        console.escreverLn("\n------------------------------------\n");

        F_Wait();
        P_menuRelatorios();
    }

    private void P_relatorioQuantidadeAprovadosPorTurma() {
        Turma t;

        if (insti.quantidadeTurmas() > 0) {
            for (int nContador = 0; nContador < insti.quantidadeTurmas(); nContador++) {
                console.escreverLn("\n------------------------------------");
                t = insti.getTurmas().get(nContador);
                console.escreverLn(t.getDescricao());
                console.escreverLn("------------------------------------");

                if (t.quantidade_alunos_aprovados() > 0) {
                    console.escrever(t.quantidade_alunos_aprovados() + " ");
                    if (t.quantidade_alunos_aprovados() > 1) {
                        console.escreverLn("Alunos");
                    } else {
                        console.escreverLn("Aluno");
                    }
                } else {
                    console.escreverLn("Nenhum aluno");
                }
            }
        } else {
            console.escreverLn("\n------------------------------------");
            console.escrever  ("Nenhuma Turma Cadastrada!");
        }

        console.escreverLn("\n------------------------------------\n");

        F_Wait();
        P_menuRelatorios();
    }

    private void P_relatorioQuantidadeReprovadosPorTurma() {
        Turma t;

        if (insti.quantidadeTurmas() > 0) {
            for (int nContador = 0; nContador < insti.quantidadeTurmas(); nContador++) {
                console.escreverLn("\n------------------------------------");
                t = insti.getTurmas().get(nContador);
                console.escreverLn(t.getDescricao());
                console.escreverLn("------------------------------------");

                if (t.quantidade_alunos_reprovados() > 0) {
                    console.escrever(t.quantidade_alunos_reprovados() + " ");
                    if (t.quantidade_alunos_reprovados() > 1) {
                        console.escreverLn("Alunos");
                    } else {
                        console.escreverLn("Aluno");
                    }
                } else {
                    console.escreverLn("Nenhum aluno");
                }
            }
        } else {
            console.escreverLn("\n------------------------------------");
            console.escrever  ("Nenhuma Turma Cadastrada!");
        }
        console.escreverLn("\n------------------------------------\n");

        F_Wait();
        P_menuRelatorios();
    }

    private void P_relatorioPorcentagemAprovadosPorTurma() {
        Turma t;

        if (insti.quantidadeTurmas() > 0) {
            for (int nContador = 0; nContador < insti.quantidadeTurmas(); nContador++) {
                console.escreverLn("\n------------------------------------");
                t = insti.getTurmas().get(nContador);
                console.escreverLn(t.getDescricao());
                console.escreverLn("------------------------------------");

                console.escreverLn(t.porcentagem_alunos_aprovados() + "%");
            }
        } else {
            console.escreverLn("\n------------------------------------");
            console.escrever  ("Nenhuma Turma Cadastrada!");
        }
        console.escreverLn("\n------------------------------------\n");

        F_Wait();
        P_menuRelatorios();
    }

    private void P_relatorioPorcentagemReprovadosPorTurma() {
        Turma t;

        if (insti.quantidadeTurmas() > 0) {
            for (int nContador = 0; nContador < insti.quantidadeTurmas(); nContador++) {
                console.escreverLn("\n------------------------------------");
                t = insti.getTurmas().get(nContador);
                console.escreverLn(t.getDescricao());
                console.escreverLn("------------------------------------");

                console.escreverLn(t.porcentagem_alunos_reprovados() + "%");
            }
        } else {
            console.escreverLn("\n------------------------------------");
            console.escrever  ("Nenhuma Turma Cadastrada!");
        }
        console.escreverLn("\n------------------------------------\n");

        F_Wait();
        P_menuRelatorios();
    }

    private void P_relatorioNotasAlunos() {
        Aluno a;

        if (insti.quantidadeAlunos() > 0) {
            console.escreverLn("\n--------------------------------------");
            console.escreverLn("Aluno    \tG1  \tG2  \tMedia");
            console.escreverLn("--------------------------------------");
            for (int nContador = 0; nContador < insti.quantidadeAlunos(); nContador++) {
                a = insti.getAlunos().get(nContador);
                console.escreverLn(a.getNome().trim() + "   \t" + a.getNotaG1() + "  \t" + a.getNotaG2() + "  \t" + a.media());
            }
        } else {
            console.escreverLn("\n--------------------------------------");
            console.escrever  ("Nenhum Aluno Cadastrado!");
        }

        console.escreverLn("\n------------------------------------\n");

        F_Wait();
        P_menuRelatorios();
    }

    private void P_relatorioNotasAlunosPorTurma() {
        Turma t;
        Aluno a;
        
        if(insti.quantidadeAlunos() > 0){
            if (insti.quantidadeTurmas() > 0) {
                for (int nContador = 0; nContador < insti.quantidadeTurmas(); nContador++) {
                    console.escreverLn("\n------------------------------------");
                    t = insti.getTurmas().get(nContador);
                    console.escreverLn(t.getDescricao());
                    console.escreverLn("------------------------------------");

                    if (t.quantidade_alunos() > 0) {
                        console.escreverLn("Aluno    \tG1  \tG2  \tMedia\n");
                        for (int nContador2 = 0; nContador2 < t.quantidade_alunos(); nContador2++) {
                            a = t.getAlunos().get(nContador2);
                            console.escreverLn(a.getNome().trim() + "   \t" + a.getNotaG1() + "  \t" + a.getNotaG2() + "  \t" + a.media());
                        }
                    } else {
                        console.escreverLn("Sem alunos");
                    }
                }    
            } else {
                console.escreverLn("\n------------------------------------");
                console.escrever  ("Nenhuma Turma Cadastrada!");
            }
        } else {
            console.escreverLn("\n------------------------------------");
            console.escrever  ("Nenhum Aluno Cadastrado!");
        }
        
        console.escreverLn("\n------------------------------------\n");

        F_Wait();
        P_menuRelatorios();
    }

    private void P_relatorioMediaGeral() {
        Turma t;

        if (insti.quantidadeTurmas() > 0) {
            for (int nContador = 0; nContador < insti.quantidadeTurmas(); nContador++) {
                console.escreverLn("\n------------------------------------");
                t = insti.getTurmas().get(nContador);
                console.escreverLn(t.getDescricao());
                console.escreverLn("------------------------------------");

                console.escreverLn(t.media_geral_turma() + "");
            }
        } else {
            console.escreverLn("\n------------------------------------");
            console.escrever  ("Nenhuma Turma Cadastrada!");
        }
        console.escreverLn("\n------------------------------------\n");

        F_Wait();
        P_menuRelatorios();
    }

    public boolean F_validaCodigoAluno(int ra) {
        Aluno a;
        for (int nContador = 0; nContador < insti.quantidadeAlunos(); nContador++) {
            a = insti.getAlunos().get(nContador);
            if (a.getRa() == ra) {
                return false;
            }
        }
        return true;
    }

    public boolean F_validaCodigoTurma(int codigo) {
        Turma t;
        for (int nContador = 0; nContador < insti.quantidadeTurmas(); nContador++) {
            t = insti.getTurmas().get(nContador);
            if (t.getCodigo() == codigo) {
                return false;
            }
        }

        return true;
    }

    public Turma F_selecionarTurma() {
        Turma tur = null;
        boolean lAux;

        do {
            lAux = false;
            String _turma;
            int turma = 0;

            console.escrever("\nDigite o código da Turma... ");
            _turma = console.ler();

            if (!StringUtils.ehInteiro(_turma)) {
                console.escreverLn("O código deve ser inteiro");
            } else {
                turma = Integer.parseInt(_turma);
                for (int nContador = 0; nContador < insti.quantidadeTurmas(); nContador++) {
                    tur = insti.getTurmas().get(nContador);
                    if (tur.getCodigo() == turma) {
                        lAux = true;
                        break;
                    }
                }
                if (!lAux) {
                    console.escreverLn("Turma não Encontrada! Informe uma das seguintes turmas...\n");
                    insti.listarTurmas();
                }
            }
        } while (!lAux);

        return tur;

    }

    public Aluno F_selecionarAluno(boolean lMatricula) {
        Aluno al = null;
        boolean lAux;
        String _ra;
        int aluno;

        do {
            lAux = false;

            console.escrever("Digite o código do Aluno.. ");
            _ra = console.ler();

            if (!StringUtils.ehInteiro(_ra)) {
                console.escreverLn("Digite um número Inteiro.\n");
            } else {
                aluno = Integer.parseInt(_ra);

                for (int nContador = 0; nContador < insti.quantidadeAlunos(); nContador++) {
                    al = insti.getAlunos().get(nContador);
                    if (al.getRa() == aluno) {
                        lAux = true;
                        break;
                    }
                }
                if (!lAux) {
                    console.escreverLn("Aluno não Encontrado! Informe uma dos seguintes Alunos...\n");
                    insti.listarAlunos();
                } else {
                    if (lMatricula && al.getTurma() != -1) {
                        console.escreverLn("O Aluno já está matriculado na turma " + al.getTurma());
                        console.escreverLn("Deseja continuar? [S]im [N]ão");
                        if (console.ler().equalsIgnoreCase("N")) {
                            lAux = false;
                        }
                    }
                }
            }
        } while (!lAux);

        return al;
    }

    public boolean F_procurarAlunoNaTurma(Aluno al, Turma tur, boolean lMensagem) {
        Aluno a;

        for (int nContador = 0; nContador < tur.quantidade_alunos(); nContador++) {
            a = tur.getAlunos().get(nContador);
            if (a.getTurma() == al.getTurma()) {
                return true;
            }

        }
        if (lMensagem) {
            console.escreverLn("O aluno " + al.getNome() + " não está matriculado na turma " + tur.getDescricao());
        }
        return false;
    }

    public void F_Wait() {
        console.escrever("Pressione Qualquer tecla para continuar... ");
        console.ler();
    }
}
