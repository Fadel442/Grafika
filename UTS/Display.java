package UTS;
import java.awt.*;
import javax.swing.*;

public class Display extends JFrame {

    MenuBarItem menuBarItem = new MenuBarItem();

    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu spacerMenu;
    private Canvas canvas;

    private static Dimension dim;

    int thick = 1;

    public Display(int width, int height)
    {
        this.dim = new Dimension(width, height);
        createDisplay();
    } 

    private void createDisplay()
    {
        createFrame();
        createMenuBar();
    }
    
    private void createFrame()
    {
        frame = new JFrame("Uts");
        frame.setSize(dim);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        controlBox();
        createMenuBar();
        createCanvas();
        
        frame.setVisible(true);
        frame.getContentPane().add(canvas);
    }

    public void paintColor(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        String selectedColor = (String) menuBarItem.comboBox3.getSelectedItem();

        if (selectedColor.equals("Hitam")) {
            g2d.setColor(new Color(0,0,0));
        } else if (selectedColor.equals("Merah")) {
            g2d.setColor(new Color(220,20,60));
        } else if (selectedColor.equals("Biru")) {
            g2d.setColor(new Color(30, 144, 255));
        }
    }
    
    private void createCanvas()
    {
        canvas = new Canvas(){
            public void paint(Graphics g) {
                super.paint(g);
        
                String selectedShape = (String) menuBarItem.comboBox1.getSelectedItem();
                String selectedLine = (String) menuBarItem.comboBox2.getSelectedItem();

                Graphics2D g2d = (Graphics2D) g;
                if(selectedShape.equals("Garis")){
                    //draw line
                    if(selectedLine.equals("Tipe Garis Solid")){
                        g2d.setStroke(new BasicStroke(thick, thick, thick, thick, null, thick));
                    } else if (selectedLine.equals("Tipe Garis Putus Panjang")){
                        g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{10}, thick));
                    } else if (selectedLine.equals("Tipe Garis Putus Pendek")){
                        g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{4}, thick));
                    } else if (selectedLine.equals("Tipe Garis Titik-Titik")){
                        g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{1}, thick));
                    }
                        paintColor(g2d);
                        g.drawLine(100,100,200,200);
                }
                 if(selectedShape.equals("Persegi Panjang")){
                    //draw line
                    if(selectedLine.equals("Tipe Garis Solid")){
                        g2d.setStroke(new BasicStroke(thick, thick, thick, thick, null, thick));
                    } else if (selectedLine.equals("Tipe Garis Putus Panjang")){
                        g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{10}, thick));
                    } else if (selectedLine.equals("Tipe Garis Putus Pendek")){
                        g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{4}, thick));
                    } else if (selectedLine.equals("Tipe Garis Titik-Titik")){
                        g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{1}, thick));
                    }           
                    
                    paintColor(g2d);
                    g.drawRect(50,50,200,100);
                }
                if(selectedShape.equals("Ellips")){
                    //draw line
                    if(selectedLine.equals("Tipe Garis Solid")){
                        g2d.setStroke(new BasicStroke(thick, thick, thick, thick, null, thick));
                    } else if (selectedLine.equals("Tipe Garis Putus Panjang")){
                        g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{10}, thick));
                    } else if (selectedLine.equals("Tipe Garis Putus Pendek")){
                        g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{4}, thick));
                    } else if (selectedLine.equals("Tipe Garis Titik-Titik")){
                        g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{1}, thick));
                    }           
                    paintColor(g2d);
                    g.drawOval(100,100,200,200);
                }
                if(selectedShape.equals("Segitiga")){
                    //draw line
                    if(selectedLine.equals("Tipe Garis Solid")){
                        g2d.setStroke(new BasicStroke(thick, thick, thick, thick, null, thick));
                    } else if (selectedLine.equals("Tipe Garis Putus Panjang")){
                        g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{10}, thick));
                    } else if (selectedLine.equals("Tipe Garis Putus Pendek")){
                        g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{4}, thick));
                    } else if (selectedLine.equals("Tipe Garis Titik-Titik")){
                        g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{1}, thick));
                    }           
                    paintColor(g2d);
                    g.drawLine(100,100,200,200);
                    g.drawLine(200, 200, 300, 100);
                    g.drawLine(300, 100, 100, 100);
                }
            }
        };   
        // canvas.setPreferredSize(dim);
        // canvas.setMinimumSize(dim);
        // canvas.setMaximumSize(dim);
    }

    public void createMenuBar()
    {
        menuBar = new JMenuBar();
        spacerMenu = new JMenu();
        spacerMenu.setEnabled(false);
        spacerMenu.setPreferredSize(new Dimension(10, 1));

        menuBar.add(spacerMenu);
        menuBar.add(menuBarItem.jLabel);
        menuBar.add(menuBarItem.comboBox1);
        menuBar.add(spacerMenu);
        menuBar.add(menuBarItem.modeGrais);
        menuBar.add(menuBarItem.comboBox2);
        menuBar.add(spacerMenu);
        menuBar.add(menuBarItem.warna);  
        menuBar.add(menuBarItem.comboBox3);

        frame.setJMenuBar(menuBar);

    }

    public void controlBox()
    {
        menuBarItem.comboBox1.addActionListener(e -> {
            canvas.repaint();
        });

        menuBarItem.comboBox2.addActionListener(e -> {
            canvas.repaint();
        });

        menuBarItem.comboBox3.addActionListener(e -> {
            canvas.repaint();
        });
    }


    public static void main(String[] args)  
    {
        Display display = new Display(1000, 500);
    }
}
