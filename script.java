import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class script {

    private static final String[] NOMES = {
        "Alice", "Bruno", "Carla", "Daniel", "Eduardo",
        "Fernanda", "Gabriel", "Helena", "Igor", "Julia",
        "Kleber", "Larissa", "Marcelo", "Natália", "Otávio",
        "Paula", "Rafael", "Sofia", "Tiago", "Vanessa",
        "André", "Beatriz", "Caio", "Diego", "Elaine",
        "Felipe", "Giovana", "Henrique", "Isabela", "João",
        "Karina", "Leonardo", "Marta", "Nicole", "Oscar",
        "Patrícia", "Rodrigo", "Simone", "Thiago", "Viviane",
        "Augusto", "Bianca", "Cristina", "Douglas", "Emanuel",
        "Fábio", "Gustavo", "Hugo", "Jéssica", "Letícia",
        "Maurício", "Nádia", "Pedro", "Renata", "Samuel",
        "Tatiane", "Ulisses", "Valéria", "Wagner", "Yasmin",
        "Zeca", "Camila", "Diana", "Flávia", "Ingrid",
        "Jonas", "Lívia", "Manuela", "Nelson", "Olívia",
        "Paulo", "Queila", "Rogério", "Sérgio", "Talita",
        "Ursula", "Victor", "Willian", "Yuri", "Zilda",
        "Gian","Vicenzo"
    };

    private static final String[] TIPOS = {"COMUM", "VIP"};
    private static final String[] CONTAS = {"CORRENTE", "POUPANCA", "SALARIO"};

    private static final String[][] BANCOS = {
        {"Banco do Brasil", "1"},
        {"Caixa Econômica", "104"},
        {"Itaú", "341"},
        {"Bradesco", "237"},
        {"Santander", "33"},
        {"Banrisul","460"}
    };

    public static void main(String[] args) {
        String arquivo = "clientes-v1.csv";
        int quantidade = 100;
        gerarCSV(arquivo, quantidade);
        System.out.println("Arquivo '" + arquivo + "' gerado com sucesso!");
    }

    public static void gerarCSV(String caminho, int quantidade) {
        Random random = new Random();

        try (FileWriter writer = new FileWriter(caminho)) {
            writer.write("id,nome,idade,tipo,conta,saldo,banco_nome,banco_numero\n");

            for (int i = 1; i <= quantidade; i++) {
                String nome = NOMES[random.nextInt(NOMES.length)];
                int idade = 18 + random.nextInt(50);
                String tipo = TIPOS[random.nextInt(TIPOS.length)];
                String conta = CONTAS[random.nextInt(CONTAS.length)];
                double saldo = Math.round((500 + random.nextDouble() * 100000) * 100.0) / 100.0;

                String[] banco = BANCOS[random.nextInt(BANCOS.length)];
                String bancoNome = banco[0];
                String bancoNumero = banco[1];

                writer.write(i + "," + nome + "," + idade + "," + tipo + "," +
                        conta + "," + saldo + "," + bancoNome + "," + bancoNumero + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao gerar CSV: " + e.getMessage());
        }
    }
}
