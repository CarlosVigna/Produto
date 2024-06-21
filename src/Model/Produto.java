package Model;

import java.util.Scanner;

public class Produto {
    private int codigo;
    private String descricao;
    private int quantidade;
    private int quantidadeVendida;

    public Produto() {
    }

    public Produto(int codigo, String descricao, int quantidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.quantidadeVendida = 0;
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

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public void cadastrarProduto(Scanner teclado) {
        System.out.println("Digite o código do produto: ");
        codigo = teclado.nextInt();
        teclado.nextLine(); // consumir o \n deixado pelo nextInt()
        System.out.println("Digite a descrição do produto: ");
        descricao = teclado.nextLine();
        System.out.println("Digite a quantidade do produto: ");
        quantidade = teclado.nextInt();
        teclado.nextLine(); // consumir o \n deixado pelo nextInt()
    }

    public void baixarEstoque(int quantidadeVendida) {
        if (quantidade >= quantidadeVendida) {
            quantidade -= quantidadeVendida;
        }
    }

    public String detalhesVendidos() {
        return "Código: " + codigo + "\nDescrição: " + descricao + "\nQuantidade Vendida: " + quantidadeVendida;
    }
}
