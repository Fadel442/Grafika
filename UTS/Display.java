package UTS;
import java.awt.*;
import javax.swing.*;

public class Display extends JFrame {

    private JFrame frame;
    private JMenuBar menuBar;
    private Canvas canvas;

    //private String title;
    // private int width, height;

    private static Dimension dim;

    public Display(int width, int height)
    {
        this.dim = new Dimension(width, height);
        createFrame();
        createMenuBar();
    } 
    
    private void createFrame()
    {
        createMenuBar();
        frame = new JFrame("Uts");
        frame.setSize(dim);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);

        frame.getContentPane().add(canvas);
        //createCanvas();
    }

    private void createCanvas()
    {
        canvas = new Canvas();
        canvas.setPreferredSize(dim);
        canvas.setMinimumSize(dim);
        canvas.setMaximumSize(dim);
    }

    private void createMenuBar()
    {
        menuBar = new JMenuBar();
    
        MenuBarItem menuBarItem = new MenuBarItem();

        menuBar.add(menuBarItem.comboBox1);
        menuBar.add(menuBarItem.comboBox2);  
    }


    public static void main(String[] args)  
    {
        Display display = new Display(1000, 2000);
    }
}
