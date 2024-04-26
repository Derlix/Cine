package ChristianArias;

import javax.swing.*;
import java.awt.*;

public class ImagenDeFondoPanel extends JPanel {

    private Image imagenDeFondo;

    public ImagenDeFondoPanel(String rutaImagen) {
        // Cargar la imagen durante la creación del panel.
        try {
            imagenDeFondo = new ImageIcon(ClassLoader.getSystemResource(rutaImagen)).getImage();
        } catch (Exception e) {
            // Manejo de error si la imagen no se encuentra
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Esto es crucial, asegura que el panel se limpie antes de dibujar encima.
        if (imagenDeFondo != null) {
            g.drawImage(imagenDeFondo, 0, 0, getWidth(), getHeight(), this);
        } else {
            System.out.println("Imagen de fondo no encontrada");
        }
    }

}
