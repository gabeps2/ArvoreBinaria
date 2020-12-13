import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        int op;

        Arvore minhaArvore = new Arvore();

        do {
            clearScreen();

            System.out.println("ÁRVORE BINÁRIA"); // Menu de Opções
            System.out.println("==============\n");
            System.out.println("Opções: \n");
            System.out.println("1 - Inserir Elemento na Árvore");
            System.out.println("2 - Pesquisar um Elemento na Árvore");
            System.out.println("3 - Listar Elementos da Árvore - Método \"EM ORDEM\"");
            System.out.println("4 - Listar Elementos da Árvore - Método \"PRÉ-ORDEM\"");
            System.out.println("5 - Listar Elementos da Árvore - Método \"PÓS-ORDEM\"");
            System.out.println("6 - Excluir um Elemento da Árvore");
            System.out.println("7 - Esvaziar a Árvore");
            System.out.println("8 - Sair\n");

            System.out.print("Digite sua Opção: ");
            op = Integer.parseInt(s.nextLine());

            switch (op) {
                case 1: {
                    boolean Status;

                    int numero, matricula;
                    String nome, email;

                    System.out.print("\n\nDigite um Número Inteiro: ");
                    numero = Integer.parseInt(s.nextLine());
                    System.out.print("\nDigite o número da matrícula: ");
                    matricula = Integer.parseInt(s.nextLine());
                    System.out.print("\nDigite o Nome do Funcionário: ");
                    nome = s.nextLine();
                    System.out.print("\nDigite o e-mail: ");
                    email = s.nextLine();

                    Status = minhaArvore.inserir(numero, matricula, nome, email);

                    if (Status) {
                        System.out.println("\nElemento inserido na Árvore!\n\n");
                    } else {
                        System.out.println("\nElemento já existe na Árvore!\n\n");
                    }

                    s.nextLine();

                    break;
                }
                case 2: {
                    int Altura;

                    int x;

                    System.out.print("\n\nDigite o Número para Pesquisa: ");
                    x = Integer.parseInt(s.nextLine());

                    Altura = minhaArvore.pesquisar(x);

                    if (Altura == -1) {
                        System.out.println("\nO Elemento não existe na Árvore!\n\n");
                    } else {
                        System.out.println("\nO Elemento existe na Árvore!");
                        System.out.printf("Altura da Árvore: %1$d \n\n", Altura);
                    }

                    s.nextLine();
                    break;
                }

                case 3: {
                    if (minhaArvore.raiz == null) {
                        System.out.println("\nA Árvore não possui nenhum Elemento...\n\n");
                    } else {
                        System.out.println("\n\nListagem dos Elementos - Método EM ORDEM");
                        System.out.println("========================================\n");

                        minhaArvore.listarEMORDEM(minhaArvore.raiz);
                    }
                    s.nextLine();
                    break;
                }

                case 4: {
                    if (minhaArvore.raiz == null) {
                        System.out.println("\nA Árvore não possui nenhum Elemento...\n\n");
                    } else {
                        System.out.println("\n\nListagem dos Elementos - Método PRÉ-ORDEM");
                        System.out.println("=============================================\n");

                        minhaArvore.listarPREORDEM(minhaArvore.raiz);
                    }
                    s.nextLine();
                    break;
                }
                case 5: {
                    if (minhaArvore.raiz == null) {
                        System.out.println("\nA Árvore não possui nenhum Elemento...\n\n");
                    } else {
                        System.out.println("\n\nListagem dos Elementos - Método PÓS-ORDEM");
                        System.out.println("=============================================\n");

                        minhaArvore.listarPOSORDEM(minhaArvore.raiz);
                    }
                    s.nextLine();
                    break;
                }
                case 6: {
                    int x;

                    int Altura;

                    System.out.print("\n\nDigite o Número para Exclusão: ");
                    x = Integer.parseInt(s.nextLine());

                    Altura = minhaArvore.pesquisar(x);

                    if (Altura == -1) {
                        System.out.println("\nO Elemento não existe na Árvore!\n\n");
                    } else {
                        minhaArvore.raiz = minhaArvore.excluir(minhaArvore.raiz, x);

                        System.out.println("\nElemento excluído da Árvore!\n\n");
                    }

                    s.nextLine();
                    break;
                }
                case 7: {
                    minhaArvore.raiz = null;

                    System.out.println("\nÁrvore Vazia!\n\n");
                    s.nextLine();
                    break;
                }
            }

        } while (op != 8);
    }

    public static void clearScreen() {
        // Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }
    }
}
