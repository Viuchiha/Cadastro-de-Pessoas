package Service;
import Model.Pessoa;
import Repository.PessoaRepository;
import java.util.Scanner;

public class PessoaService {
    PessoaRepository repository = new PessoaRepository();
    Scanner scanner = new Scanner(System.in);

    public void verificaLista(){
        if(repository.listarPessoas() == null){
            System.out.println("Lista de pessoas vazia.");
        }else{
            System.out.println(repository.listarPessoas());
        }
    }

    //aux 1 verifica e retorna os dados do nome
    //aux 2 verifica e remove o mesmo da lista
    public Pessoa verificaNomeExistente(String nome,int aux){
        if(repository.buscaPorNome(nome)==null){
            System.out.println("Pessoa não cadastrada");
            return null;
        }
        if(aux==1) return repository.buscaPorNome(nome);
        if(aux==2)repository.removePorNome(nome);
        return null;
    }

    public void atualizaNome(Pessoa pessoa,String nome){
        pessoa.setNome(nome);
    }

    public void atualizaEmail(Pessoa pessoa,String email){
        this.verificaCadastrarPessoa(pessoa,0);
        pessoa.setEmail(email);
    }

    public void atualizaIdade(Pessoa pessoa,int idade){
        this.verificaCadastrarPessoa(pessoa,0);
        pessoa.setIdade(idade);
    }

    public void verificaRemovePessoa(int escolhaRemove){
        if (escolhaRemove == 1) repository.removeUltimo();
        else if (escolhaRemove == 2) {
            System.out.println("Digite o nome da pessoa que deseja remover: ");
            String nomePessoaRemove = scanner.nextLine();
            this.verificaNomeExistente(nomePessoaRemove,2);
            repository.removePorNome(nomePessoaRemove);
        }
    }

    public void verificaCadastrarPessoa(Pessoa pessoa,int aux){
        if(pessoa.getIdade()<=0 || pessoa.getIdade()>130){
            System.out.println("Idade inválida");
            return;
        }
        if(pessoa.getEmail().indexOf('@')==-1){
            System.out.println("Email inválido");
            return;
        }
        if(aux==1)repository.cadastrarPessoas(pessoa);
    }
}
