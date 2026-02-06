package Repository;
import Model.Pessoa;
import java.util.ArrayList;
import java.util.List;

public class PessoaRepository {
    private List<Pessoa> pessoas = new ArrayList<>();

    public void cadastrarPessoas(Pessoa pessoa){
        pessoas.add(pessoa);
    }


    public List<Pessoa> listarPessoas(){
        return pessoas;

    }

    public Pessoa buscaPorNome(String nome){
        for (Pessoa pessoa : pessoas){
            if(pessoa.getNome().equals(nome)){
                return pessoa;
            }
        }
        return null;
    }

    public void removeUltimo(){
        pessoas.removeLast();
    }

    public void removePorNome(String nome){
        pessoas.removeIf(p -> p.getNome().equals(nome));
    }

}
