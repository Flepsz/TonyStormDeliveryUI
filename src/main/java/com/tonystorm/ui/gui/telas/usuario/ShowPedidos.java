package com.tonystorm.ui.gui.telas.usuario;

import com.tonystorm.ui.gui.telas.TelaPrincipal;
import com.tonystorm.ui.models.Pedido;
import com.tonystorm.ui.models.Usuario;
import com.tonystorm.ui.services.get.APIGetPedido;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ShowPedidos extends JPanel {
    public ShowPedidos(TelaPrincipal telaPrincipal) throws Exception {
        setLayout(new BorderLayout());

        JPanel backButtonPanel = telaPrincipal.getBackButton("HomeUsuarioT");
        add(backButtonPanel, BorderLayout.NORTH);

        java.util.List<Pedido> pedidos = getPedido(telaPrincipal);

        JPanel usuariosPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        for (Pedido pedido : pedidos) {
            Usuario usuarioDoPedido = pedido.getUsuario();
            JButton usuarioButton = new JButton(pedido.getStatus());
            usuarioButton.setPreferredSize(new Dimension(200, 50));

            usuarioButton.addActionListener(e -> {
                telaPrincipal.setUsuarioLogado(usuarioDoPedido);
                try {
                    ShowPedidoU showPedido = new ShowPedidoU(telaPrincipal, pedido);
                    telaPrincipal.getCardPanel().add(showPedido, "ShowPedidoUT");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

                telaPrincipal.mostrarTela("ShowPedidoUT");
            });

            usuariosPanel.add(usuarioButton, gbc);
        }

        add(usuariosPanel, BorderLayout.CENTER);
    }

    public List<Pedido> getPedido(TelaPrincipal telaPrincipal) throws Exception {
        return new APIGetPedido(telaPrincipal.getUsuarioLogado().getId().toString()).getAll();
    }
}
