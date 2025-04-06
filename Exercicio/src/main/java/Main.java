import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite o modelo do veículo: ");
            String modelo = scanner.nextLine();

            System.out.print("O veículo foi entregue com atraso? (Sim ou Nao): ");
            String respostaAtraso = scanner.nextLine().trim().toLowerCase();
            int diasAtraso = 0;

            if (respostaAtraso.equals("sim")) {
                System.out.print("Digite a quantidade de dias de atraso: ");
                diasAtraso = scanner.nextInt();
            }

            System.out.print("Digite o valor da diária: ");
            double valorDiaria = scanner.nextDouble();

            System.out.print("Digite a quantidade de dias alugados: ");
            int diasAluguel = scanner.nextInt();

            Veiculo veiculo = new Veiculo(modelo, valorDiaria);
            double valorSemDesconto = valorDiaria * diasAluguel;

            double valorComDesconto;
            double desconto = 0;

            if (diasAtraso == 0 && diasAluguel >= 7) {
                valorComDesconto = veiculo.desconto(valorDiaria, diasAluguel);
                desconto = valorSemDesconto - valorComDesconto;
            } else {
                valorComDesconto = valorSemDesconto;
            }

            double custoTotal = veiculo.calcularCusto(valorDiaria, diasAluguel, diasAtraso);

            System.out.printf("Custo do aluguel do %s: R$ %.2f\n", modelo, custoTotal);
            if (diasAtraso == 0 && diasAluguel >= 7) {
                System.out.printf("Foi aplicado um desconto de: R$ %.2f\n", desconto);
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Programa finalizado.");
        }
    }
}
