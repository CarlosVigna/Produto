package Model;

public class Alimento extends Produto{
    private String dataValidade;


    public Alimento() {
    }

    public Alimento(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Alimento(int codigo, String descricao, int quantidade, String dataValidade) {
        super(codigo, descricao, quantidade);
        this.dataValidade = dataValidade;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public void cadastrarAlimento(){
        super.cadastrarProduto();
        System.out.println("Informe a data de validade: ");
        dataValidade = teclado.nextLine();
        teclado.nextLine();
    }

}
