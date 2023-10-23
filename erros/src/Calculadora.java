import java.util.Scanner;

class DivisaoPorZeroException extends Exception {
    public DivisaoPorZeroException(String message) {
        super(message);
    }
}

public class Calculadora {
    public static double soma(double a, double b) {
        return a + b;
    }

    public static double subtracao(double a, double b) {
        return a - b;
    }

    public static double multiplicacao(double a, double b) {
        return a * b;
    }

    public static double divisao(double a, double b) throws DivisaoPorZeroException {
        if (b == 0) {
            throw new DivisaoPorZeroException("Erro: Divisão por zero!");
        }
        return a / b;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        double numero1 = scanner.nextDouble();

        System.out.print("Digite o operador (+, -, *, /): ");
        char operador = scanner.next().charAt(0);

        System.out.print("Digite o segundo número: ");
        double numero2 = scanner.nextDouble();

        double resultado = 0;

        try {
            if (operador == '+') {
                resultado = Calculadora.soma(numero1, numero2);
            } else if (operador == '-') {
                resultado = Calculadora.subtracao(numero1, numero2);
            } else if (operador == '*') {
                resultado = Calculadora.multiplicacao(numero1, numero2);
            } else if (operador == '/') {
                resultado = Calculadora.divisao(numero1, numero2);
            } else {
                System.out.println("Operador inválido!");
                return;
            }

            System.out.println("Resultado: " + resultado);
        } catch (DivisaoPorZeroException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            System.out.println("Operação concluída!");
            scanner.close();
        }
    }
}
