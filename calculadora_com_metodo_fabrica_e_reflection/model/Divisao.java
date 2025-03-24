package calculadora_com_metodo_fabrica_e_reflection.model;

public class Divisao implements Operacao {
    @Override
    public void calcular(double valor1, double valor2) {
        System.out.println("Resultado: " + (valor1 / valor2));
    }
}
