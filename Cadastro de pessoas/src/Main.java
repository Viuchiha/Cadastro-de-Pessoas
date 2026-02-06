import Model.Pessoa;
import Service.PessoaService;

void main() {
    Scanner scanner = new Scanner(System.in);
    PessoaService service = new PessoaService();


    while (true) {
        System.out.println("----------MENU----------");
        System.out.println("|                      |");
        System.out.println("| 1- Cadastrar Pessoa  |");
        System.out.println("| 2- Listar Pessoas    |");
        System.out.println("| 3- Buscar por nome   |");
        System.out.println("| 4- Remover Pessoa    |");
        System.out.println("| 5- Atualizar Pessoa  |");
        System.out.println("| 6- Sair              |");
        System.out.println("------------------------");
        System.out.println("Digite o numero correspondente");

        int escolhaMenu = scanner.nextInt();
        scanner.nextLine();

        switch (escolhaMenu){
            case 1:
                System.out.println("Digite seu nome");
                String nome = scanner.nextLine();

                System.out.println("Digite sua idade");
                int idade = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Digite seu email");
                String email = scanner.nextLine();

                Pessoa pessoa = new Pessoa(nome, idade, email);
                service.verificaCadastrarPessoa(pessoa, 1);
                break;

            case 2:
                service.verificaLista();
                break;

            case 3:
                System.out.println("Digite o nome da pessoa desejada: ");
                String nomePessoaBusca = scanner.nextLine();

                service.verificaNomeExistente(nomePessoaBusca, 1);
                break;

            case 4:
                System.out.println("1- Remover a última pessoa");
                System.out.println("2- Remover por nome");
                System.out.println("Digite o numero correspondente");

                int escolhaRemove = scanner.nextInt();
                scanner.nextLine();
                service.verificaRemovePessoa(escolhaRemove);

                break;

            case 5:
                System.out.println("Qual nome da pessoa que deseja atualizar?");
                String nomeAtualiza = scanner.nextLine();
                Pessoa pessoaAtualiza = service.verificaNomeExistente(nomeAtualiza, 1);

                System.out.println("O que deseja alterar?");
                System.out.println("1- nome");
                System.out.println("2- idade");
                System.out.println("3- email");
                System.out.println("4- sair");
                System.out.println("Digite o numero correspondente");
                int escolhaAtualiza = scanner.nextInt();
                scanner.nextLine();

                switch (escolhaAtualiza){
                    case 1:
                        System.out.println("Digite o novo nome: ");
                        String novoNome = scanner.nextLine();
                        service.atualizaNome(pessoaAtualiza, novoNome);
                        break;

                    case 2:
                        System.out.println("Digite a nova idade: ");
                        int novaIdade = scanner.nextInt();
                        scanner.nextLine();
                        service.atualizaIdade(pessoaAtualiza, novaIdade);
                        break;

                    case 3:
                        System.out.println("Digite o novo email: ");
                        String novoEmail = scanner.nextLine();
                        service.atualizaEmail(pessoaAtualiza, novoEmail);
                        break;

                    case 4:
                        return;

                    default:
                        System.out.println("Número inválido");
                        break;
                }
                break;

            case 6:
                return;

            default:
                System.out.println("Número inválido!");
                break;
        }
    }
}
