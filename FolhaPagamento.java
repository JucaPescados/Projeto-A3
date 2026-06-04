import java.util.ArrayList;
import java.util.Scanner;

// Classe base para representar qualquer tipo de Funcionário
class Funcionario {
    private String nome;
    private int matricula;
    private String tipo;
    private double extras;
    private double salarioFinal;

    // Construtor
    public Funcionario(String nome, int matricula, String tipo, double extras, double salarioFinal) {
        this.nome = nome;
        this.matricula = matricula;
        this.tipo = tipo;
        this.extras = extras;
        this.salarioFinal = salarioFinal;
    }

    // Métodos para acessar as informações (Getters)
    public String getNome() { return nome; }
    public int getMatricula() { return matricula; }
    public String getTipo() { return tipo; }
    public double getExtras() { return extras; }
    public double getSalarioFinal() { return salarioFinal; }
}

public class FolhaPagamento {

    // AJUSTADO: Constante do Salário Fixo redefinida para R$ 2000.00
    private static final double SALARIO_FIXO = 2000.00;
    
    // Lista dinâmica (ArrayList) para armazenar os funcionários cadastrados
    private static ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Cadastrar Funcionario Padrao");
            System.out.println("2 - Cadastrar Funcionario Comissionado");
            System.out.println("3 - Cadastrar Funcionario Producao");
            System.out.println("4 - Gerar Folha de Pagamento");
            System.out.println("0 - Sair do Programa");
            System.out.print("Escolha uma opcao: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do teclado

            switch (opcao) {
                case 1:
                    cadastrarPadrao();
                    break;
                case 2:
                    cadastrarComissionado();
                    break;
                case 3:
                    cadastrarProducao();
                    break;
                case 4:
                    gerarFolha();
                    break;
                case 0:
                    System.out.println("\nEncerrando o processamento...");
                    break;
                default:
                    System.out.println("\n❌ Opcao invalida! Tente de novo.");
            }

        } while (opcao != 0);
    }

    // 1 - Cadastrar Funcionário Padrão
    private static void cadastrarPadrao() {
        System.out.println("\n[1 - Cadastro Padrao]");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Matricula: ");
        int matricula = scanner.nextInt();

        double extras = 0.0;
        double salarioFinal = SALARIO_FIXO;

        listaFuncionarios.add(new Funcionario(nome, matricula, "Extras", extras, salarioFinal));
        System.out.println("✅ Funcionário Padrao cadastrado com sucesso!");
    }

    // 2 - Cadastrar Funcionário Comissionado
    private static void cadastrarComissionado() {
        System.out.println("\n[2 - Cadastro Comissionado]");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Matricula: ");
        int matricula = scanner.nextInt();
        System.out.print("Informe valor das vendas: ");
        double vendas = scanner.nextDouble();
        System.out.print("Informe comissão percentual: ");
        double percentual = scanner.nextDouble();

        // Cálculo: Comissão = (vendas * percentual / 100)
        double comissao = (vendas * percentual) / 100;
        double salarioFinal = SALARIO_FIXO + comissao;

        listaFuncionarios.add(new Funcionario(nome, matricula, "Comissao", comissao, salarioFinal));
        System.out.println("✅ Funcionário Comissionado cadastrado com sucesso!");
    }

    // 3 - Cadastrar Funcionário Produção
    private static void cadastrarProducao() {
        System.out.println("\n[3 - Cadastro Producao]");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Matrícula: ");
        int matricula = scanner.nextInt();
        System.out.print("Informe qtde de peças: ");
        int qtdPecas = scanner.nextInt();
        System.out.print("Informe valor da peça: ");
        double valorPeca = scanner.nextDouble();

        // Cálculo: Produtividade = (valorPorPeça * quantidadeProduzida)
        double produtividade = qtdPecas * valorPeca;
        double salarioFinal = SALARIO_FIXO + produtividade;

        listaFuncionarios.add(new Funcionario(nome, matricula, "Produtividade", produtividade, salarioFinal));
        System.out.println("✅ Funcionario de Producao cadastrado com sucesso!");
    }

    // 4 - Gerar Folha de Pagamento
    private static void gerarFolha() {
        System.out.println("\n=== FOLHA DE PAGAMENTO ===");
        System.out.println("Total de pessoas cadastradas: " + listaFuncionarios.size());

        if (listaFuncionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado ate o momento.");
            return;
        }

        // Loop para listar cada um dos funcionários da lista
        for (Funcionario f : listaFuncionarios) {
            System.out.println("\nNome: " + f.getNome());
            System.out.println("Matricula: " + f.getMatricula());
            System.out.printf("Salario Fixo: %.1f%n", SALARIO_FIXO);
            System.out.printf("%s: %.1f%n", f.getTipo(), f.getExtras());
            System.out.printf("Salario final: %.1f%n", f.getSalarioFinal());
        }
        System.out.println("-----------------------------------------");
    }
}