package Model;

public class Vestuario extends Produto{
    private String tamanho;

    public Vestuario() {
    }

    public Vestuario(String tamanho) {
        this.tamanho = tamanho;
    }

    public Vestuario(int codigo, String descricao, int quantidade, String tamanho) {
        super(codigo, descricao, quantidade);
        this.tamanho = tamanho;
    }

    public void cadastrarVestuario(){
        super.cadastrarProduto();
        System.out.println("Informe o tamanho: ");
        tamanho = teclado.nextLine();
        teclado.nextLine();
    }
}
