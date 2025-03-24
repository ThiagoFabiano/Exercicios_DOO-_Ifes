package calculadora_com_metodo_fabrica_e_reflection.factory;
import calculadora_com_metodo_fabrica_e_reflection.model.Operacao;

public class Factory {

    private static Factory instance; 

    private Factory() {
    }

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public static Operacao factory(char operador) {

        Object classeInstanciada = null;
        String nomeClasse;
        switch (operador) {
            case '+':
                nomeClasse = "Soma";
                break;
            case '-':
                nomeClasse = "Subtracao";
                break;
            case '*':
                nomeClasse = "Multiplicacao";
                break;
            case '/':
                nomeClasse = "Divisao";
                break;
            default:
                throw new IllegalArgumentException("Operador inválido: " + operador);
        }
        try {
            classeInstanciada = Class.forName("calculadora_com_metodo_fabrica_e_reflection.model."+nomeClasse).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return (Operacao) classeInstanciada;

    }

}
