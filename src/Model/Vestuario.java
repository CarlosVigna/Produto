package Model;
import Java.util;

public class Vestuario extends Produto {
    private String tamanho;

    Scanner teclado = new Scanner(System.in);
    public Vestuario() {
    }

    public Vestuario(String tamanho) {
        this.tamanho = tamanho;
    }

    public Vestuario(int codigo, String descricao, int quantidade, String tamanho) {
        super(codigo, descricao, quantidade);
        this.tamanho = tamanho;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void cadastrarVestuario() {
        super.cadastrarProduto();
        System.out.println("Digite o tamanho do vestuário: ");
        tamanho = teclado.nextLine();
    }

    @Override
    public String detalhesVendidos() {
        return super.detalhesVendidos() + "\nTamanho: " + tamanho;
    }
}
