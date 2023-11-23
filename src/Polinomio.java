import javax.swing.*;

public class Polinomio {
    private static int[] polynomial;
    private static int[] derivative;

    public static int getInput(String message) {
        return Integer.parseInt(JOptionPane.showInputDialog(message));
    }

    public static void showOutput(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    // Deja que el usuario digite los coeficientes del polinomio
    public static void inputPolynomial() {
        final int numberOfCoefficients = getInput("Digite dimensiones del vector");

        // Crea el polinomio
        polynomial = new int[numberOfCoefficients + 1];
        for (int i = 0; i != polynomial.length; ++i) {
            polynomial[i] = getInput("Digite coeficiente P[" + i + "] =");
        }

        // Crea la derivada
        derivative = new int[numberOfCoefficients];
        for (int i = 0; i != derivative.length; ++i) {
            derivative[i] = polynomial[i + 1] * (i + 1);
        }
    }

    // Crea un String con los coeficientes del polinomio
    public static void mostrarPolinomio() {
        String polynomialString = "";
        for (int i = 0; i != polynomial.length; ++i) {
            polynomialString += polynomial[i] + "x^" + i;
            if (i != polynomial.length - 1)
                polynomialString += " + ";
        }

        showOutput("Polynomial:\nf(x) = " + polynomialString);
    }

    // Crea un String con los coeficientes del derivado
    public static void mostrarDerivado() {
        String derivativeString = "";
        for (int i = 0; i != derivative.length; ++i) {
            derivativeString += derivative[i] + "x^" + i;
            if (i != derivative.length - 1)
                derivativeString += " + ";
        }

        showOutput("Polynomial:\nf'(x) = " + derivativeString);
    }

    // Calcula el integral
    public static void mostrarIntegral() {
        int leftLimit = getInput("Digite limite menor");
        int rightLimit = getInput("Digite limite mayor");
        double sum = 0;
        for (int i = 0; i < polynomial.length; ++i) {
            sum += polynomial[i] * (Math.pow(leftLimit, i + 1) - Math.pow(rightLimit, i + 1)) / (i + 1);
        }

        showOutput("La integral es " + sum);
    }
}
