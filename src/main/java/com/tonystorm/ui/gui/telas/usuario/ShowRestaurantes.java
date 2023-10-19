package com.tonystorm.ui.gui.telas.usuario;

import com.tonystorm.ui.gui.telas.TelaPrincipal;
import com.tonystorm.ui.gui.telas.restaurante.ShowPedido;
import com.tonystorm.ui.models.Pedido;
import com.tonystorm.ui.models.Restaurante;
import com.tonystorm.ui.models.Usuario;
import com.tonystorm.ui.services.get.APIGetPedido;
import com.tonystorm.ui.services.get.APIGetRestaurante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ShowRestaurantes extends JPanel {
    public ShowRestaurantes(TelaPrincipal telaPrincipal) throws Exception {
        setLayout(new BorderLayout());

        JPanel backButtonPanel = telaPrincipal.getBackButton("HomeUsuarioT");
        add(backButtonPanel, BorderLayout.NORTH);

        java.util.List<Restaurante> restaurantes = getRestaurantes(telaPrincipal);

        JPanel usuariosPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        for (Restaurante restaurante : restaurantes) {
            JButton usuarioButton = new JButton(restaurante.getNome());
            usuarioButton.setPreferredSize(new Dimension(200, 50));

            usuarioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        ShowComidas showComidas = new ShowComidas(telaPrincipal, restaurante);
                        telaPrincipal.getCardPanel().add(showComidas, "ShowComidasT");
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }

                    telaPrincipal.mostrarTela("ShowComidasT");
                }
            });

            usuariosPanel.add(usuarioButton, gbc);
        }

        add(usuariosPanel, BorderLayout.CENTER);
    }

    public List<Restaurante> getRestaurantes(TelaPrincipal telaPrincipal) throws Exception {
        return new APIGetRestaurante().getAll();
    }
}
