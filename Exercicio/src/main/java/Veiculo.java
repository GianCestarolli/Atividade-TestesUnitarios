public class Veiculo {
    protected String modelo;
    protected double valorDiaria;

    public Veiculo(String modelo, double valorDiaria) {
        if (valorDiaria <= 0) {
            throw new IllegalArgumentException("Valor da diária inválido.");
        }
        this.modelo = modelo;
        this.valorDiaria = valorDiaria;

    }

    public double calcularCusto(double valorDiaria, int diasAluguel, int diasAtraso) {
        try {
            if (diasAluguel <= 0) {
                throw new IllegalArgumentException("Quantidade de dias inválida.");
            }

            double valorFinal;

            if (diasAluguel >= 7 && diasAtraso == 0) {
                valorFinal = desconto(valorDiaria, diasAluguel);
            } else {
                valorFinal = valorDiaria * diasAluguel;
            }

            return calcularMultas(valorFinal, diasAtraso);

        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao calcular custo: " + e.getMessage());
            return 0;
        } finally {
            System.out.println("Cálculo de custo finalizado.");
        }
    }

    public double desconto(double valorDiaria, int diasAluguel) {
        double porcentagemDesconto = 0;
        if (diasAluguel >= 28) {
            porcentagemDesconto = 0.20;
        } else if (diasAluguel >= 14) {
            porcentagemDesconto = 0.15;
        } else if (diasAluguel >= 7) {
            porcentagemDesconto = 0.10;
        }

        return (valorDiaria * diasAluguel) * (1 - porcentagemDesconto);
    }

    public double calcularMultas(double valor, int diasAtraso) {
        return valor + (valor * (diasAtraso * 0.2));
    }
}