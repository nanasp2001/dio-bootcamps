/*EXERCICIO

3. Escreva um codigo onde temos o controle de banho de um petshop, a maquina de banhos dos pets deve ter as seguintes operacoes:
- Dar banho no pet;
- Abastecer com agua;
- Abastecer com shampoo;
- verificar nivel de agua;
- verificar nivel de shampoo;
- verificar se tem pet no banho;
- colocar pet na maquina;
- retirar pet da maquina;
- limpar maquina.

Siga as seguintes regras para implementacao
- A maquina de banho deve permitir somente 1 pet por vez;
- Cada banho realizado ira consumir 10 litros de agua e 2 litros de shampoo;
- A maquina tem capacidade maxima de 30 litros de agua e 10 litros de shampoo;
- Se o pet for retirado da maquina sem estar limpo sera necessario limpar a maquina para permitir a entrada de outro pet;
- A limpeza da maquina ira consumir 3 litros de agua e 1 litro de shampoo;
- O abastecimento de agua e shampoo deve permitir 2 litros por vez que for acionado;
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PetMachine petMachine = new PetMachine();
        int opcao;

        do {
            System.out.println("\n=== Escolha uma das opcoes ===");
            System.out.println("1 - Dar banho no pet");
            System.out.println("2 - Abastecer a maquina com agua");
            System.out.println("3 - Abastecer a maquina com shampoo");
            System.out.println("4 - Verificar agua da maquina");
            System.out.println("5 - Verificar shampoo da maquina");
            System.out.println("6 - Verificar se tem pet no banho");
            System.out.println("7 - Colocar pet na maquina");
            System.out.println("8 - Retirar pet da maquina");
            System.out.println("9 - Limpar maquina");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Digite um numero valido: ");
                scanner.next();
            }
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> petMachine.darBanho();
                case 2 -> petMachine.abastecerAgua();
                case 3 -> petMachine.abastecerShampoo();
                case 4 -> petMachine.verificarNivelAgua();
                case 5 -> petMachine.verificarNivelShampoo();
                case 6 -> petMachine.temPetNoBanho();
                case 7 -> {
                    System.out.print("Digite o nome do pet: ");
                    String nomePet = scanner.nextLine();
                    Pet pet = new Pet(nomePet);
                    petMachine.colocarPet(pet);
                }
                case 8 -> petMachine.retirarPet();
                case 9 -> petMachine.limparMaquina();
                case 0 -> System.out.println("Encerrando programa...");
                default -> System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}