package UTS;
import java.awt.*;

import javax.swing.JFrame;

public class PaintController extends JFrame {

    private int thick = 1;
    MenuBarItem menuBarItem = new MenuBarItem();
    
    public void paint(Graphics g) {
        super.paint(g);

        String selectedShape = (String) menuBarItem.comboBox1.getSelectedItem();
        String selectedLine = (String) menuBarItem.comboBox2.getSelectedItem();
        if(selectedShape.equals("Buat Garis")){
            //draw line
            Graphics2D g2d = (Graphics2D) g;
            if(selectedLine.equals("Tipe Garis Solid")){
                g2d.setStroke(new BasicStroke(thick, thick, thick, thick, null, thick));
            } else if (selectedLine.equals("Tipe Garis Putus Panjang")){
                g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{10}, thick));
            } else if (selectedLine.equals("Tipe Garis Putus Pendek")){
                g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{4}, thick));
            } else if (selectedLine.equals("Tipe Garis Titik-Titik")){
                g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{1}, thick));
            }

            g.setColor(Color.black);
            g.drawLine(100,100,200,200);
        }
    }
}
