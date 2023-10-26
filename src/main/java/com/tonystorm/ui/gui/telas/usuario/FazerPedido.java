package com.tonystorm.ui.gui.telas.usuario;

import com.tonystorm.ui.gui.telas.TelaPrincipal;
import com.tonystorm.ui.models.Comida;
import com.tonystorm.ui.models.ItemPedido;
import com.tonystorm.ui.models.PedidoToSend;
import com.tonystorm.ui.models.Restaurante;
import com.tonystorm.ui.utils.APIRequestUtil;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FazerPedido extends JPanel {
    public FazerPedido(TelaPrincipal telaPrincipal, Restaurante restaurante) {
        setLayout(new BorderLayout());

        List<Comida> comidasDisponiveis = restaurante.getComidas();
        List<ItemPedido> carrinhoComidas = new ArrayList<>();

        PedidoToSend pedidoAtual = new PedidoToSend();

        for (Comida comida : comidasDisponiveis) {
            JLabel labelComida = new JLabel(comida.getNome());
            JButton botaoAdicionar = new JButton("Adicionar");
            JButton botaoRemover = new JButton("Remover");

            setLayout(new GridLayout(0, 3, 10, 10));


            botaoAdicionar.addActionListener(e -> {
                ItemPedido itemPedido = carrinhoComidas.stream()
                        .filter(item -> item.getComida() == comida)
                        .findFirst()
                        .orElse(null);

                if (itemPedido == null) {
                    itemPedido = new ItemPedido();
                    itemPedido.setComida(comida);
                    itemPedido.setQuantidade(1);
                    carrinhoComidas.add(itemPedido);
                } else {
                    itemPedido.setQuantidade(itemPedido.getQuantidade() + 1);
                }
            });

            botaoRemover.addActionListener(e -> {
                ItemPedido itemPedido = carrinhoComidas.stream()
                        .filter(item -> item.getComida() == comida)
                        .findFirst()
                        .orElse(null);

                if (itemPedido != null) {
                    if (itemPedido.getQuantidade() > 1) {
                        itemPedido.setQuantidade(itemPedido.getQuantidade() - 1);
                    } else {
                        carrinhoComidas.remove(itemPedido);
                    }
                } else {
                    JOptionPane.showMessageDialog(telaPrincipal, "Comida não existente no carrinho!");
                }
            });

            add(labelComida);
            add(botaoAdicionar);
            add(botaoRemover);
        }

        JButton botaoRealizarPedido = new JButton("Realizar Pedido");
        botaoRealizarPedido.addActionListener(e -> {
            System.out.println(carrinhoComidas);
            pedidoAtual.setItensPedido(carrinhoComidas);
            realizarPedido(pedidoAtual, telaPrincipal);
        });
        add(botaoRealizarPedido);

        JPanel backButtonPanel = telaPrincipal.getBackButton("ShowRestaurantesT");
        add(backButtonPanel, BorderLayout.NORTH);
    }

    private void realizarPedido(
            PedidoToSend pedido,
            TelaPrincipal telaPrincipal
    ) {

        try {
            String endpoint = "/usuarios/" + telaPrincipal.getUsuarioLogado().getId() + "/pedidos";
            System.out.println(endpoint);
            String reqnew = new APIRequestUtil(endpoint).sendPostRequest(pedido);
            System.out.println(reqnew);
            JOptionPane.showMessageDialog(telaPrincipal, "Pedido realizado com sucesso!");
            telaPrincipal.mostrarTela("HomeUsuarioT");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(telaPrincipal, "Erro ao realizar o pedido.");
        }
    }
}
