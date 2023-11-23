public class Main {
    public static void main(String[] args) {
        // Para averiguar si el usuario ya ha digitado el polinomio
        boolean polynomialInputted = false;

        while (true) {
            try {
                int option = Polinomio.getInput("Elige el numero de la opcion que quieres hacer:\n" +
                        "[1] Digitar el polinomio\n" +
                        "[2] Mostrar el polinomio\n" +
                        "[3] Mostrar el derivado\n" +
                        "[4] Calcular el integral\n" +
                        "[5] Cerrar el programa");

                switch (option) {
                    case 1:
                        Polinomio.inputPolynomial();
                        polynomialInputted = true;
                        break;
                    case 2:
                        if (!polynomialInputted)
                            Polinomio.inputPolynomial();
                        Polinomio.mostrarPolinomio();
                        break;
                    case 3:
                        if (!polynomialInputted)
                            Polinomio.inputPolynomial();
                        Polinomio.mostrarDerivado();
                        break;
                    case 4:
                        if (!polynomialInputted)
                            Polinomio.inputPolynomial();
                        Polinomio.mostrarIntegral();
                        break;
                    case 5:
                        return;
                    default:
                        Polinomio.showOutput("El numero " + option + " no es una de las opciones");
                }
            }
            catch (Exception e) {
                // Un error pasa si el usuario empuja 'cancelar' en el JOptionPane o si no digita numero
                Polinomio.showOutput("Hubo un error con el numero que digitaste");
            }
        }
    }
}
