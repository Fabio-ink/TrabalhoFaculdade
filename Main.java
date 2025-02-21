import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Avaliacao avaliacao = new Avaliacao(0, "", 0.0);
        String continuar = "s";

        while (continuar.equalsIgnoreCase("s")) {
            System.out.println("\nDigite seu comentário: ");
            String comentario = sc.nextLine();
            System.out.println("Digite sua nota (0-10): ");
            double nota = sc.nextDouble();
            sc.nextLine(); 

            avaliacao.criarAvaliacao(comentario, nota);

            System.out.println("\nResumo das Avaliações:");
            System.out.println("Último comentário: " + avaliacao.getComentario());
            System.out.println("Última nota: " + avaliacao.getNota());
            System.out.println("Total de avaliações: " + avaliacao.getTotalAvaliacao());
            System.out.println("Média das avaliações: " + avaliacao.getMediaAvaliacao());
            
            System.out.println("\nTodos os comentários:");
            List<String> comentarios = avaliacao.getTodosComentarios();
            for (int i = 0; i < comentarios.size(); i++) {
                System.out.println((i + 1) + ". " + comentarios.get(i));
            }

            System.out.println("\nDeseja fazer outro comentário? (s/n)");
            continuar = sc.nextLine();
        }
        sc.close();

        Produto produto = new Produto("Smartphone", "Smartphone com 128GB de armazenamento");
        System.out.println("Produto: " + produto.getNome());
        System.out.println("Descrição: " + produto.getDescricao());
        
        Preco preco = new Preco(2000.00, 10.0);
        double valorComDesconto = preco.calcularValorComDesconto();
        System.out.println("Valor do produto: R$" + preco.getValorProduto());
        System.out.println("Valor com desconto geral: R$" + valorComDesconto);

        MetodoPagamento pagamento = new MetodoPagamento("Cartão de Crédito", 3, 5.0);
        pagamento.calcularPagamento(valorComDesconto);
        System.out.println("Método de Pagamento: " + pagamento.getMetodoPag());
        System.out.println("Valor final com desconto na modalidade: R$" + pagamento.getValorFinal());
        System.out.println("Valor de cada parcela: R$" + pagamento.getValorParcela());
    }
}