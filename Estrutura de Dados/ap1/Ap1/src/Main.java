import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Tamanho mínimo da imagem
        int imageSize = 100;
        // Gera uma imagem aleatória
        int[][] image = generateImage(imageSize, imageSize);
        // Padrão a ser encontrado
        int[][] pattern = {{1, 1}, {1, 0}, {0, 1}};

        // Imprime o padrão
        System.out.println("Padrão a ser encontrado:");
        printMatrix(pattern);

        // Imprime o gabarito da matriz
        System.out.println("\n\nGabarito da matriz:");
        printMatrix(image);

        // Inicia o cronômetro
        long startTime = System.currentTimeMillis();
        // Encontra as ocorrências do padrão na imagem
        int occurrences = findPatternOccurrences(image, pattern);
        // Para o cronômetro
        long endTime = System.currentTimeMillis();

        System.out.println("\n\nPadrão encontrado " + occurrences + " vezes.");
        System.out.println("Tempo gasto: " + (endTime - startTime) + " ms");
    }

    public static int[][] generateImage(int rows, int cols) {
        int[][] image = new int[rows][cols];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                image[i][j] = random.nextInt(2); // Gera um valor aleatório entre 0 e 1
            }
        }
        return image;
    }


    // Função para imprimir uma matriz
    public static void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Função para encontrar as ocorrências de um padrão em uma imagem
    public static int findPatternOccurrences(int[][] image, int[][] pattern) {
        int occurrences = 0;
        int rows = image.length;
        int cols = image[0].length;
        int patternRows = pattern.length;
        int patternCols = pattern[0].length;

        for (int i = 0; i <= rows - patternRows; i++) {
            for (int j = 0; j <= cols - patternCols; j++) {
                boolean match = true;
                for (int k = 0; k < patternRows; k++) {
                    for (int l = 0; l < patternCols; l++) {
                        if (image[i + k][j + l] != pattern[k][l]) {
                            match = false;
                            break;
                        }
                    }
                    if (!match) {
                        break;
                    }
                }
                if (match) {
                    occurrences++;
                }
            }
        }
        return occurrences;
    }
}
