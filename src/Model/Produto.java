package Model;

import java.util.Scanner;

public class Produto {
    private int codigo;
    private String descricao;
    private int quantidade;
    Scanner teclado = new Scanner(System.in);

    public Produto() {
    }

    public Produto(int codigo, String descricao, int quantidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.quantidade = quantidade;

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void cadastrarProduto() {
        try {
            System.out.println("Informe o código do produto: ");
            codigo = teclado.nextInt();
            System.out.println("Informe a descrição do produto: ");
            descricao = teclado.next();
            System.out.println("Informe a quantidade do produto: ");
            quantidade = teclado.nextInt();
        } catch (Exception e) {
            System.out.println("Informação inválida, informe novamente!!");
            teclado.nextLine(); // Clear the buffer
        }
    }

    public void entradaEstoque(int quantidade){
        this.quantidade += quantidade;
    }

    public void baixarEstoque(int quantidadeEscolhida){
        if (quantidadeEscolhida <= this.quantidade) {
            this.quantidade -= quantidadeEscolhida;
        } else {
            System.out.println("Quantidade em estoque insuficiente.");
        }
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Descrição: " + descricao + ", Quantidade: " + quantidade;
    }
}
