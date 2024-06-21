package Model;

import java.util.Scanner;

public class Alimento extends Produto {
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

    public void cadastrarAlimento(Scanner teclado) {
        cadastrarProduto(teclado);
        System.out.println("Digite a data de validade do alimento: ");
        dataValidade = teclado.nextLine();
    }

    @Override
    public String detalhesVendidos() {
        return super.detalhesVendidos() + "\nData de Validade: " + dataValidade;
    }
}
