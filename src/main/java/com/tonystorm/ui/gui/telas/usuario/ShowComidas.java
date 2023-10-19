package com.tonystorm.ui.gui.telas.usuario;

import com.tonystorm.ui.gui.telas.TelaPrincipal;
import com.tonystorm.ui.models.Comida;
import com.tonystorm.ui.models.Pedido;
import com.tonystorm.ui.models.PedidoToSend;
import com.tonystorm.ui.models.Restaurante;
import com.tonystorm.ui.utils.APIRequestUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShowComidas extends JPanel {
    public ShowComidas(TelaPrincipal telaPrincipal, Restaurante restaurante) {
        setLayout(new BorderLayout());

        List<Comida> comidasDisponiveis = restaurante.getComidas();
        List<UUID> carrinhoComidas = new ArrayList<>();

        PedidoToSend pedidoAtual = new PedidoToSend();

        for (Comida comida : comidasDisponiveis) {
            JLabel labelComida = new JLabel(comida.getNome());
            JButton botaoAdicionar = new JButton("Adicionar");
            JButton botaoRemover = new JButton("Remover");

            setLayout(new GridLayout(0, 3, 10, 10));

            botaoAdicionar.addActionListener(e -> carrinhoComidas.add(comida.getId()));

            botaoRemover.addActionListener(e -> carrinhoComidas.remove(comida.getId()));

            add(labelComida);
            add(botaoAdicionar);
            add(botaoRemover);
        }

        JButton botaoRealizarPedido = new JButton("Realizar Pedido");
        botaoRealizarPedido.addActionListener(e -> {
            System.out.println(carrinhoComidas);
            pedidoAtual.setComidas(carrinhoComidas);
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
