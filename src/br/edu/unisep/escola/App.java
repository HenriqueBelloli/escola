package br.edu.unisep.escola;

import br.com.utilitarios.henrique.io.console;

public class App {

     Instituicao insti = new Instituicao();

    public static void main(String[] args) {
        App app = new App();
        app.P_menuPrincipal();
    }

    private void P_menuPrincipal() {
        console.escreverLn("--------------------------------------------");
        console.escrever  ("A - Cadastros || " );
        console.escrever  ("B - Relatorios || ");
        console.escreverLn("C - Sair "         );
        console.escreverLn("--------------------------------------------");

        switch (console.ler().toUpperCase()) {
            case "A":
                P_menuCadastros();
                break;
            case "B":
                P_menuRelatorios();
                break;
            case "C":
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

    private void P_cadastrarTurma() {
        int nCodigo;
        String cDescricao;

        do {
            console.escrever("Digite o Código da Turma... ");
            nCodigo = Integer.parseInt(console.ler());

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
        double notaG1;
        double notaG2;

        do {
            console.escrever("Digite o R.A... ");
            ra = Integer.parseInt(console.ler());

            console.escrever("Digite o Nome... ");
            nome = console.ler();

            console.escrever("Digite a nota G1... ");
            notaG1 = Double.parseDouble(console.ler());

            console.escrever("Digite a nota G2... ");
            notaG2 = Double.parseDouble(console.ler());

            Aluno al = new Aluno(ra, nome);

            console.escreverLn("Aluno " + nome + " Cadastrado com Sucesso!");
            console.escreverLn("Deseja realizar outro cadastro? \n   [S]im  [N]ão");

        } while (console.ler().equalsIgnoreCase("S"));

        P_menuCadastros();
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
                P_menuCadastros();
                break;
            default:
                console.escreverLn("Opção inválida.");
                P_menuRelatorios();
        }
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
    
    private boolean F_validaCodigoAluno(int turma, int codigo){
        Turma t;
        Aluno a;
        for(int nContador = 0; nContador <= insti.turmas.size(); nContador++){
            t = insti.turmas.get(nContador);
            if(t.getCodigo() == codigo){
                for(int nContador2 = 0; nContador2 <= t.alunos.size(); nContador2++){
                    a = t.alunos.get(nContador2);
                }
            }
        }
        
        return true;
    }
}
