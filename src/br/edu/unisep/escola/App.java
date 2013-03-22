package br.edu.unisep.escola;

import br.com.utilitarios.henrique.io.console;

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
        console.escrever("C - Relatorios ||");
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
                console.escreverLn("Opção inválida.");
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
                console.escreverLn("Opção inválida.");
                P_menuCadastros();
        }

    }

    private void P_menuRelatorios() {
        console.escreverLn("A - Quantidade de alunos por Turma");
        console.escreverLn("B - Quantidade de Alunos Aprovados");
        console.escreverLn("C - Quantidade de Alunos Reprovados");
        console.escreverLn("D - Porcentagem de Alunos Aprovados");
        console.escreverLn("E - Porcentagem de Alunos Reprovados");
        console.escreverLn("F - Media geral por Turma");
        console.escreverLn("G - Voltar");

        switch (console.ler().toUpperCase()) {
            case "A":
                P_relatorioAlunosPorTurma();
                break;
            case "B":
                P_quantidadeAprovados();
                break;
            case "C":
                P_quantidadeReprovados();
                break;
            case "D":
                P_porcentagemAprovados();
                break;
            case "E":
                P_porcentagemReprovados();
                break;
            case "F":
                P_mediaGeral();
                break;
            case "G":
                P_menuPrincipal();
                break;
            default:
                console.escreverLn("Opção inválida.");
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
            default:
                console.escreverLn("Opção inválida.");
                P_menuManutencao();
        }
    }

    private void P_cadastrarTurma() {
        int nCodigo;
        String cDescricao;
        boolean lAux = true;

        do {
            do {
                console.escrever("Digite o Código da Turma... ");
                nCodigo = Integer.parseInt(console.ler());
                if (!F_validaCodigoTurma(nCodigo)) {
                    console.escreverLn("Já existe turma com esse código!");
                    lAux = false;
                }
            } while (!lAux);

            console.escrever("Digite uma Descrição para a Turma... ");
            cDescricao = console.ler();

            Turma tur = new Turma(nCodigo, cDescricao);
            insti.addTurma(tur);

            console.escreverLn("Turma " + cDescricao + " Cadastrada com Sucesso!");
            console.escreverLn("Deseja realizar outro cadastro? \n   [S]im  [N]ão");

        } while (console.ler().equalsIgnoreCase("S"));

        P_menuCadastros();
    }

    private void P_cadastrarAluno() {
        int ra;
        String nome;
        boolean lAux = true;
        do {
            do {

                console.escrever("Digite o R.A.... ");
                ra = Integer.parseInt(console.ler());
                if (!F_validaCodigoAluno(ra)) {
                    console.escreverLn("Já existe aluno com esse R.A.\n");
                    lAux = false;
                }
            } while (!lAux);

            console.escrever("Digite o Nome... ");
            nome = console.ler();

            Aluno al = new Aluno(ra, nome);
            insti.addAluno(al);

            console.escreverLn("Aluno " + nome + " Cadastrado com Sucesso!");
            console.escreverLn("Deseja realizar outro cadastro? \n   [S]im  [N]ão");

        } while (console.ler().equalsIgnoreCase("S"));

        P_menuCadastros();
    }

    private void P_matricularAlunos() {
        Aluno a = null;
        Turma t = null;
        boolean lAux;
        do {
            do {
                lAux = false;

                console.escrever("\nDigite o código da Turma... ");
                int turma = Integer.parseInt(console.ler());

                for (int nContador = 0; nContador < insti.turmas.size(); nContador++) {
                    t = insti.turmas.get(nContador);
                    if (t.getCodigo() == turma) {
                        lAux = true;
                        break;
                    }
                }
                if (!lAux) {
                    console.escreverLn("Turma não Encontrada! Informe uma das seguintes turmas...\n");
                    insti.listarTurmas();
                }
            } while (!lAux);

            do {
                lAux = false;

                console.escrever("Digite o código do Aluno.. ");
                int aluno = Integer.parseInt(console.ler());

                for (int nContador = 0; nContador < insti.alunos.size(); nContador++) {
                    a = insti.alunos.get(nContador);
                    if (a.getRa() == aluno) {
                        lAux = true;
                        break;
                    }
                }
                if (!lAux) {
                    console.escreverLn("Aluno não Encontrada! Informe uma dos seguintes Alunos...\n");
                    insti.listarAlunos();
                }
            } while (!lAux);


            t.matricula(a);
            console.escreverLn("Aluno " + a.getNome() + " Matriculado com Sucesso!\n");
            console.escreverLn("Deseja realizar outro cadastro? \n   [S]im  [N]ão");

        } while (console.ler().equalsIgnoreCase("S"));


    }

    private void P_relatorioAlunosPorTurma() {
    }

    private void P_quantidadeAprovados() {
    }

    private void P_quantidadeReprovados() {
    }

    private void P_porcentagemAprovados() {
    }

    private void P_porcentagemReprovados() {
    }

    private void P_mediaGeral() {
    }

    public boolean F_validaCodigoAluno(int ra) {
        Aluno a;
        for (int nContador = 0; nContador < insti.alunos.size(); nContador++) {
            a = insti.alunos.get(nContador);
            if (a.getRa() == ra) {
                return false;
            }
        }
        return true;
    }

    public boolean F_validaCodigoTurma(int codigo) {
        Turma t;
        for (int nContador = 0; nContador < insti.turmas.size(); nContador++) {
            t = insti.turmas.get(nContador);
            if (t.getCodigo() == codigo) {
                return false;
            }
        }

        return true;
    }
}
