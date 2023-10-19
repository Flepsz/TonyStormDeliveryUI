package com.tonystorm.ui.gui.telas.usuario;

import com.tonystorm.ui.gui.telas.TelaPrincipal;
import com.tonystorm.ui.gui.telas.restaurante.ShowPedido;
import com.tonystorm.ui.models.Pedido;
import com.tonystorm.ui.models.Usuario;
import com.tonystorm.ui.services.get.APIGetPedido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ShowRestaurantes extends JPanel {
    public ShowRestaurantes(TelaPrincipal telaPrincipal) throws Exception {
        setLayout(new BorderLayout());

        JPanel backButtonPanel = telaPrincipal.getBackButton("HomeRestauranteT");
        add(backButtonPanel, BorderLayout.NORTH);

        java.util.List<Pedido> pedidos = getPedido(telaPrincipal);

        JPanel usuariosPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        for (Pedido pedido : pedidos) {
            Usuario usuarioDoPedido = pedido.getUsuario();
            JButton usuarioButton = new JButton(usuarioDoPedido.getNome());
            usuarioButton.setPreferredSize(new Dimension(200, 50));

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

            usuariosPanel.add(usuarioButton, gbc);
        }

        add(usuariosPanel, BorderLayout.CENTER);
    }

    public List<Pedido> getPedido(TelaPrincipal telaPrincipal) throws Exception {
        return new APIGetPedido(telaPrincipal.getRestauranteLogado().getId().toString()).getAllFromRestaurante();
    }
}
