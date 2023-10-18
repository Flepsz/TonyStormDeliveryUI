package com.tonystorm.ui.gui.telas.restaurante;

import com.tonystorm.ui.gui.telas.TelaPrincipal;
import com.tonystorm.ui.models.Pedido;
import com.tonystorm.ui.models.Usuario;
import com.tonystorm.ui.services.get.APIGetPedido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ShowUsuariosPedido extends JPanel {
    public ShowUsuariosPedido(TelaPrincipal telaPrincipal) throws Exception {
        setLayout(new BorderLayout());

//        JPanel panel = new JPanel(new GridLayout(2, 1));
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.insets = new Insets(10, 10, 40, 10);

        JLabel titleLabel = new JLabel("Pedidos");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.gridwidth = 4;
        add(titleLabel, BorderLayout.NORTH);

        List<Pedido> pedidos = getPedido(telaPrincipal);

        for (Pedido pedido : pedidos) {
            Usuario usuarioDoPedido = pedido.getUsuario();
            JButton usuarioButton = new JButton(usuarioDoPedido.getNome());
            add(usuarioButton, BorderLayout.CENTER);

            usuarioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    telaPrincipal.setUsuarioLogado(usuarioDoPedido);
                    try {
                        ShowPedido showPedido = new ShowPedido(telaPrincipal, pedido);
                        telaPrincipal.getCardPanel().add(showPedido, "ShowPedidoT");
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }

                    telaPrincipal.mostrarTela("ShowPedidoT");
                }
            });
        }

        JPanel backButtonPanel = telaPrincipal.getBackButton("HomeRestauranteT");
        add(backButtonPanel, BorderLayout.NORTH);

    }

    public List<Pedido> getPedido(TelaPrincipal telaPrincipal) throws Exception {
        return new APIGetPedido(telaPrincipal.getRestauranteLogado().getId().toString()).getAllFromRestaurante();
    }

    public List<Usuario> getUsuarios(TelaPrincipal telaPrincipal) throws Exception {
        List<Pedido> pedidos = getPedido(telaPrincipal);
        List<Usuario> usuariosComPedidos = new ArrayList<>();

        for (Pedido pedido : pedidos) {
            Usuario usuarioDoPedido = pedido.getUsuario();

            usuariosComPedidos.add(usuarioDoPedido);
        }

        return usuariosComPedidos;
    }
}
