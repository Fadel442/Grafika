package UTS;
import java.awt.*;
import javax.swing.*;

public class Display extends JFrame {

    MenuBarItem menuBarItem = new MenuBarItem();

    private JFrame frame;
    private JMenuBar menuBar;
    private Canvas canvas;

    private static Dimension dim;

    int thick = 1;

    public Display(int width, int height)
    {
        this.dim = new Dimension(width, height);
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
        // frame.setJMenuBar(menuBar);
        
        frame.setVisible(true);
        
        frame.getContentPane().add(canvas);
        
        
        
        //createCanvas();
    }
    
    private void createCanvas()
    {
        canvas = new Canvas(){
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
                                if(selectedShape.equals("Buat Persegi Panjang")){
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
                    g.drawRect(50,50,200,100);
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

        menuBar.add(menuBarItem.comboBox1);
        menuBar.add(menuBarItem.comboBox2);  

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
    }


    public static void main(String[] args)  
    {
        Display display = new Display(1000, 2000);

    }
}
