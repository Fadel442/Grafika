import java.awt.*;
import javax.swing.*;

public class KelasLatihan1 extends JFrame{
    private static String selectedLine = "solid";
    private static String selectedColor = "black";
    public static void main(String[] args) {
    //create the frame
    JFrame jframe = new KelasLatihan1();
    jframe.setSize(1000,2000);
    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //create the menubar
    JMenuBar jmenu = new JMenuBar();

    //Create Spacing MenuBar
    JMenu spacer = new JMenu();
    
    spacer.setEnabled(false);
    spacer.setMinimumSize(new Dimension(10, 1));
    spacer.setPreferredSize(new Dimension(10, 1));
    spacer.setMaximumSize(new Dimension(10, 1));

    //create jcombobox
    JLabel jLabel = new JLabel("tes");
    JComboBox<String> comboBox1 = new JComboBox<>
    (new String[]{"Buat Garis","Buat Persegi Panjang",
    "Buat Ellips","Buat Segitiga"});
    JComboBox<String> comboBox2 = new JComboBox<>
    (new String[]{"Tipe Garis Solid","Tipe Garis Putus Panjang",
    "Tipe Garis Putus Pendek","Tipe Garis Titik-Titik"});
    JComboBox<String> comboBox3 = new JComboBox<>
    (new String[]{"Hitam","Merah"});
    
    //add the combobox to the menu
    jmenu.add(jLabel);
    jmenu.add(spacer);
    jmenu.add(comboBox1);
    jmenu.add(comboBox2);
    jmenu.add(comboBox3);
    
    //create the textfield
    JTextField textField = new JTextField(10);
    textField.setText("1");

    // add the menus to the menubar
    jmenu.add(textField);
    
    //create canvas for painting shapes
    Canvas canvas = new Canvas(){
        public void paint(Graphics g){
            super.paint(g);
            int thick = Integer.valueOf(textField.getText());
            //get the value comboBox1
            String selectedShape = (String) comboBox1.getSelectedItem();
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
                // g.setColor(Color.black);

                //color test
                if (selectedColor.equals("Hitam")) {
                    g2d.setColor(new Color(255,160,122));
                } else if (selectedColor.equals("Merah")) {
                    g2d.setColor(new Color(135,206,250));
                } 

                g.drawLine(100,100,200,200);
                }

                // if(selectedShape.equals("Buat Persegi Panjang")){
                //     //draw line
                //     Graphics2D g2d = (Graphics2D) g;
                //     if(selectedLine.equals("Tipe Garis Solid")){
                //         g2d.setStroke(new BasicStroke(thick, thick, thick, thick, null, thick));
                //     } else if (selectedLine.equals("Tipe Garis Putus Panjang")){
                //         g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{10}, thick));
                //     } else if (selectedLine.equals("Tipe Garis Putus Pendek")){
                //         g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{4}, thick));
                //     } else if (selectedLine.equals("Tipe Garis Titik-Titik")){
                //         g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{1}, thick));
                //     }           
                //     g.setColor(Color.black);
                //     g.drawRect(50,50,200,100);
                // }
                // if(selectedShape.equals("Buat Ellips")){
                //     //draw line
                //     Graphics2D g2d = (Graphics2D) g;
                //     if(selectedLine.equals("Tipe Garis Solid")){
                //         g2d.setStroke(new BasicStroke(thick, thick, thick, thick, null, thick));
                //     } else if (selectedLine.equals("Tipe Garis Putus Panjang")){
                //         g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{10}, thick));
                //     } else if (selectedLine.equals("Tipe Garis Putus Pendek")){
                //         g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{4}, thick));
                //     } else if (selectedLine.equals("Tipe Garis Titik-Titik")){
                //         g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{1}, thick));
                //     }           
                //     g.setColor(Color.black);
                //     g.drawOval(100,100,200,200);
                // }
                // if(selectedShape.equals("Buat Segitiga")){
                //     //draw line
                //     Graphics2D g2d = (Graphics2D) g;
                //     if(selectedLine.equals("Tipe Garis Solid")){
                //         g2d.setStroke(new BasicStroke(thick, thick, thick, thick, null, thick));
                //     } else if (selectedLine.equals("Tipe Garis Putus Panjang")){
                //         g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{10}, thick));
                //     } else if (selectedLine.equals("Tipe Garis Putus Pendek")){
                //         g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{4}, thick));
                //     } else if (selectedLine.equals("Tipe Garis Titik-Titik")){
                //         g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{1}, thick));
                //     }           
                //     g.setColor(Color.black);
                //     g.drawLine(100,100,200,200);
                //     g.drawLine(200, 200, 300, 100);
                //     g.drawLine(300, 100, 100, 100);
                // }
            }
        };
        jframe.getContentPane().add(canvas);
        
        // add action listener for comboBox1,2,3
        comboBox1.addActionListener(e -> {
            //canvas.repaint();
            canvas.repaint(); // redraw the canvas when combobox1 is changed
        });

        comboBox2.addActionListener(e -> {
            selectedLine = (String) comboBox2.getSelectedItem();
            canvas.repaint(); // redraw the canvas when combobox1 is changed
         
        });

        comboBox3.addActionListener(e -> {
            selectedColor = (String) comboBox3.getSelectedItem();
            canvas.repaint();
        });
        

        textField.addActionListener(e -> {
            canvas.repaint();
        });

        // set the menubar for the frame
        jframe.setJMenuBar(jmenu);

        // show the frame
        jframe.setVisible(true);
    }
}