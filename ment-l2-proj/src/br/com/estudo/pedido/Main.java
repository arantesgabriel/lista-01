package br.com.estudo.pedido;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Produto produto1 = new Produto("cigarro 1");
        LocalDateTime dataAntiga = LocalDateTime.now().minusDays(30);
        Produto produto2 = new Produto("cigarro 2", dataAntiga);

        Pedido pedido = new Pedido("2024123456", Arrays.asList(produto1, produto2));

        try {
            pedido.verificarPedidoRecente();
            pedido.exibirProdutos();
        } catch (PedidoAntigoException e) {
            System.out.println(e.getMessage());
        }
    }
}
