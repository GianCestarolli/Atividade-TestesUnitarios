import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VeiculoTest {

    @Test
    public void testCalculoSemDescontoSemMulta() {
        Veiculo veiculo = new Veiculo("Mobi", 100);
        double resultado = veiculo.calcularCusto(100, 5, 0);
        assertEquals(500.0, resultado);
    }

    @Test
    public void testCalculoComDescontoSemMulta() {
        Veiculo veiculo = new Veiculo("Creta", 100);
        double resultado = veiculo.calcularCusto(100, 7, 0);
        assertEquals(630, resultado, 0.01);
    }

    @Test
    public void testCalculoComMultaSemDesconto() {
        Veiculo veiculo = new Veiculo("HB20", 100);
        double resultado = veiculo.calcularCusto(100, 5, 2);
        assertEquals(700, resultado, 0.01);
    }

    @Test
    public void testCalculoComDescontoEComMulta() {
        Veiculo veiculo = new Veiculo("Onix", 100);
        double resultado = veiculo.calcularCusto(100, 14, 2);
        assertEquals(1960, resultado, 0.01);
    }

    @Test
    public void testDesconto15Porcento() {
        Veiculo veiculo = new Veiculo("Argo", 100);
        double valorComDesconto = veiculo.desconto(100, 14);
        assertEquals(1190, valorComDesconto, 0.01);
    }

    @Test
    public void testDesconto20Porcento() {
        Veiculo veiculo = new Veiculo("Peugeot 208", 50);
        double valorComDesconto = veiculo.desconto(100, 28); // 20% de desconto
        assertEquals(2240, valorComDesconto, 0.01);
    }

    @Test
    public void testCalculoMultas() {
        Veiculo veiculo = new Veiculo("Pulse", 100);
        double valorComMulta = veiculo.calcularMultas(500, 2);
        assertEquals(700.0, valorComMulta, 0.01);
    }

    @Test
    public void testValorDiariaInvalido() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Veiculo("Toro", 0);
        });
        assertEquals("Valor da diária inválido.", exception.getMessage());
    }

    @Test
    public void testQuantidadeDiasInvalida() {
        Veiculo veiculo = new Veiculo("Fastback", 120);
        double resultado = veiculo.calcularCusto(120, 0, 0);
        assertEquals(0.0, resultado);
    }

}

