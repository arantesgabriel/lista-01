package br.com.estudo.pedido;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;


public class Pedido {
    private String numeroPedido;
    private List<Produto> listaProdutos;
    private LocalDateTime dataPedido;

    public Pedido(String numeroPedido, List<Produto> listaProdutos) {
        this.numeroPedido = numeroPedido;
        this.listaProdutos = listaProdutos;
        this.dataPedido = LocalDateTime.now();
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void verificarPedidoRecente() throws PedidoAntigoException {
        Period periodo = Period.between(dataPedido.toLocalDate(), LocalDateTime.now().toLocalDate());
        if (periodo.getDays() > 7 || periodo.getMonths() > 0 || periodo.getYears() > 0) {
            throw new PedidoAntigoException("O pedido é muito antigo.");
        } else {
            System.out.println("O pedido é recente.");
        }
    }

    public void exibirProdutos() {
        System.out.println("produtos no pedido:");
        listaProdutos.forEach(produto -> {
            String status = produto.isRecente() ? "recente" : "antigo";
            System.out.println(" - " + produto + " [" + status + "]");
        });
    }
}

