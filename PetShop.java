import java.util.ArrayList;
import java.util.Scanner;

public class PetShop {
    public static void main(String[] args) {
        int opt = 0;
        Scanner scanner = new Scanner(System.in);

        ArrayList<Categoria> categorias = new ArrayList<Categoria>();
        ArrayList<Tutor> tutores = new ArrayList<Tutor>();
        ArrayList<Animal> animais = new ArrayList<Animal>();

        do {
            System.out.println("Opções: ");
            System.out.println("[1] - Cadastrar Categoria");
            System.out.println("[2] - Cadastrar Tutor");
            System.out.println("[3] - Cadastrar Animal");
            System.out.println("[4] - Listar Categoria");
            System.out.println("[5] - Listar Tutor");
            System.out.println("[6] - Listar Animal");
            System.out.println("[7] - Sair");

            try {
                opt = scanner.nextInt();
                scanner.nextLine();  
            } catch (Exception e) {
                System.out.println("Opção inválida");
                scanner.nextLine();  
                continue;
            }

            switch (opt) {
                case 1:
                    System.out.println("Digite o ID da categoria: ");
                    int idCategoria = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.println("Digite a descrição da categoria: ");
                    String descricaoCategoria = scanner.nextLine();
                    Categoria categoria = new Categoria(idCategoria, descricaoCategoria);
                    categorias.add(categoria);
                    System.out.println("Categoria cadastrada com sucesso!");
                    break;

                case 2:
                    System.out.println("Digite o ID do tutor: ");
                    int idTutor = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o nome do tutor: ");
                    String nomeTutor = scanner.nextLine();
                    System.out.println("Digite o telefone do tutor: ");
                    String telefoneTutor = scanner.nextLine();
                    System.out.println("Digite o email do tutor: ");
                    String emailTutor = scanner.nextLine();
                    Tutor tutor = new Tutor(idTutor, nomeTutor, telefoneTutor, emailTutor);
                    tutores.add(tutor);
                    System.out.println("Tutor cadastrado com sucesso!");
                    break;

                case 3:
                    System.out.println("Digite o ID do animal: ");
                    int idAnimal = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o nome do animal: ");
                    String nomeAnimal = scanner.nextLine();
                    System.out.println("Digite a raça do animal: ");
                    String raca = scanner.nextLine();
                    System.out.println("Digite o peso do animal: ");
                    double peso = scanner.nextDouble();
                    System.out.println("Digite o ID da Categoria: ");
                    int idCat = scanner.nextInt();
                    System.out.println("Digite o ID do tutor: ");
                    int idTut = scanner.nextInt();
                    scanner.nextLine();
                    Animal animal = new Animal(idAnimal, nomeAnimal, raca, peso, idCat, idTut);
                    animais.add(animal);
                    System.out.println("Animal cadastrado com sucesso!");
                    break;

                    //Não sabia como fazer direito ai peguei com o meu amigo gbt, mas entendi como fazer agora.
                case 4:
                    for (Categoria cat : categorias) {
                        long count = animais.stream().filter(a -> a.getIdCategoria() == cat.getId()).count();
                        System.out.println("Categoria: " + cat.getDescricao() + " - Quantidade de animais: " + count);
                    }
                    break;

                case 5:
                    for (Tutor tut : tutores) {
                        long count = animais.stream().filter(a -> a.getIdTutor() == tut.getId()).count();
                        System.out.println("Tutor: " + tut.getNome() + " - Quantidade de animais: " + count);
                    }
                    break;

                case 6:
                    for (Animal anim : animais) {
                        Categoria cat = categorias.stream().filter(c -> c.getId() == anim.getIdCategoria()).findFirst().orElse(null);
                        Tutor tut = tutores.stream().filter(t -> t.getId() == anim.getIdTutor()).findFirst().orElse(null);
                        System.out.println("Animal: " + anim.getNome() + 
                                           ", Categoria: " + (cat != null ? cat.getDescricao() : "N/A") + 
                                           ", Tutor: " + (tut != null ? tut.getNome() : "N/A"));
                    }
                    break;

                case 7:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opt != 7);

        scanner.close();
    }
}
