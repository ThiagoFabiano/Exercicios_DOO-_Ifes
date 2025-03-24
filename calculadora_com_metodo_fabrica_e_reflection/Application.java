/*
 * Autor: Thiago Fabiano
 */

package calculadora_com_metodo_fabrica_e_reflection;

import java.util.Scanner;
import calculadora_com_metodo_fabrica_e_reflection.factory.Factory;
import calculadora_com_metodo_fabrica_e_reflection.model.Operacao;

public class Application {

    public static void main(String[] args) {
        System.out.println("Calculadora Iniciada! Digite: 'sair' caso deseje encerrar.");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            double num1 = lerNumero(scanner, "Digite o primeiro número: ");
            char operador = lerOperador(scanner, "Digite o operador (+, -, *, /): ");
            double num2 = lerNumero(scanner, "Digite o segundo número: ");

            try {
                Operacao operacao = Factory.factory(operador);
                operacao.calcular(num1, num2);
            } catch (Exception e) {
                System.out.println("Erro ao realizar a operação: " + e.getMessage());
            }
        }
    }

    private static double lerNumero(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = verificarSaida(scanner.next());
            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }
    }
    
    private static char lerOperador(Scanner scanner, String mensagem) {
        System.out.print(mensagem);
        String entrada = verificarSaida(scanner.next());
        return entrada.charAt(0);
    }
    
    private static String verificarSaida(String entrada) {
        if (entrada.equalsIgnoreCase("sair")) {
            System.exit(0);
        }
        return entrada;
    }
}