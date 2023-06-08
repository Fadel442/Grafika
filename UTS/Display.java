package UTS;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class Display extends JFrame {

    MenuBarItem menuBarItem = new MenuBarItem();

    private JFrame frame;
    private JMenuBar menuBar;
    private Canvas canvas;

    
    private static Dimension dim;
    
    int windowHeight = 500;
    int thick = 2;
    
    //   private Image theImage;
    //   private BufferedImage buffi;

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
        frame = new JFrame("UTS");
        frame.setSize(dim);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        controlBox();
        createCanvas();
        
        frame.setVisible(true);
        frame.getContentPane().add(canvas);
    }

    public void paintColor(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        Color c1 = new Color(1.0f,0.0f,0.0f);
        Color c2 = new Color(0.0f,1.0f,0.0f);

        String selectedColor = (String) menuBarItem.comboBox3.getSelectedItem();

        if (selectedColor.equals("Hitam")) {
            g2d.setColor(new Color(0,0,0));
        } else if (selectedColor.equals("Merah")) {
            g2d.setColor(new Color(220,20,60));
        } else if (selectedColor.equals("Biru")) {
            g2d.setColor(new Color(30, 144, 255));
        } else if (selectedColor.equals("Gradient")) {
            GradientPaint gradPaint1 = new GradientPaint(150,150,c1,250,250,c2,true);
            g2d.setPaint(gradPaint1);
        }
    }

    public void PaintPost(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;

        String selectedPosition = (String) menuBarItem.positionObj.getSelectedItem();

        AffineTransform yUp = new AffineTransform();
        AffineTransform translate = new AffineTransform();

        yUp.setToScale(1,-1);
        
        if (selectedPosition.equals("Kiri")) {
            translate.setToTranslation(-40,windowHeight-250);
            yUp.preConcatenate(translate);
        } 
        else if (selectedPosition.equals("Tengah")) {
            translate.setToTranslation(350,windowHeight-250);
            yUp.preConcatenate(translate);
        }
        else if (selectedPosition.equals("Kanan")) {
            translate.setToTranslation(700,windowHeight-250);
            yUp.preConcatenate(translate);
        }
        g2d.transform(yUp);
    }
    
    private void createCanvas()
    {
        canvas = new Canvas(){
            public void paint(Graphics g) {
                super.paint(g);
        
                String selectedShape = (String) menuBarItem.comboBox1.getSelectedItem();
                String selectedLine = (String) menuBarItem.comboBox2.getSelectedItem();
                String selectedRotation = (String) menuBarItem.rotationObj.getSelectedItem();

                AffineTransform rotation = new AffineTransform();

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
                    Line2D.Double line = new Line2D.Double(120, 50, 360, 50);
                    paintColor(g2d);
                    PaintPost(g2d);

                    //Rotate Shape
                    if (selectedRotation.equals("Normal")) {
                        g2d.draw(line);
                    }
                    if (selectedRotation.equals("Rotate 1")) {
                        rotation.setToRotation(Math.PI/7);
                    }
                    else if (selectedRotation.equals("Rotate 2")) {
                        rotation.setToRotation(Math.PI/-7);
                    }

                    g2d.draw(rotation.createTransformedShape(line));                   
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
                      
                    Rectangle2D.Double rect = new Rectangle2D.Double(50,50,200,100); 
                    paintColor(g2d);
                    PaintPost(g2d);
                    
                    //Rotate Shape
                    if (selectedRotation.equals("Normal")) {
                        g2d.draw(rect);
                    }
                    if (selectedRotation.equals("Rotate 1")) {
                        rotation.setToRotation(Math.PI/7);
                    }
                    else if (selectedRotation.equals("Rotate 2")) {
                        rotation.setToRotation(Math.PI/-7);
                    }

                    g2d.draw(rotation.createTransformedShape(rect));

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
                    Ellipse2D.Double ellips = new Ellipse2D.Double(100,100,100,100);
                    paintColor(g2d);
                    PaintPost(g2d);

                    //Rotate Shape
                    if (selectedRotation.equals("Normal")) {
                        g2d.draw(ellips);
                    }
                    if (selectedRotation.equals("Rotate 1")) {
                        rotation.setToRotation(Math.PI/7);
                    }
                    else if (selectedRotation.equals("Rotate 2")) {
                        rotation.setToRotation(Math.PI/-7);
                    }

                    g2d.draw(rotation.createTransformedShape(ellips));
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
                    Line2D.Double line1 = new Line2D.Double(100,100,200,200);
                    Line2D.Double line2 = new Line2D.Double(200, 200, 300, 100);
                    Line2D.Double line3 = new Line2D.Double(300, 100, 100, 100);
                    paintColor(g2d);
                    PaintPost(g2d);

                    //Rotate Shape
                    if (selectedRotation.equals("Normal")) {
                        g2d.draw(line1);
                        g2d.draw(line2);
                        g2d.draw(line3);
                    }
                    if (selectedRotation.equals("Rotate 1")) {
                        rotation.setToRotation(Math.PI/7);
                    }
                    else if (selectedRotation.equals("Rotate 2")) {
                        rotation.setToRotation(Math.PI/-7);
                    }

                    g2d.draw(rotation.createTransformedShape(line1));
                    g2d.draw(rotation.createTransformedShape(line2));
                    g2d.draw(rotation.createTransformedShape(line3));
                }
                // //Image Texture
                // else if (selectedShape.equals("Gambar")) {
                //    ImageIcon image = new ImageIcon(getClass().getResource("da.png"));
                //    JLabel displayField = new JLabel(image);
                //    //frame.add(displayField);
                // }
            }
        };   
        // canvas.setPreferredSize(dim);
        // canvas.setMinimumSize(dim);
        // canvas.setMaximumSize(dim);
    }

    public void createMenuBar()
    {
        menuBar = new JMenuBar();
        
        menuBar.setLayout(new GridLayout(2, 2));
        menuBar.add(menuBarItem.jLabel);
        menuBar.add(menuBarItem.modeGrais);
        menuBar.add(menuBarItem.warna);
        menuBar.add(menuBarItem.Position);
        menuBar.add(menuBarItem.Rotate);  
        menuBar.add(menuBarItem.comboBox1);
        menuBar.add(menuBarItem.comboBox2);
        menuBar.add(menuBarItem.comboBox3);
        menuBar.add(menuBarItem.positionObj);
        menuBar.add(menuBarItem.rotationObj);

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

        menuBarItem.positionObj.addActionListener(e -> {
            canvas.repaint();
        });

        menuBarItem.rotationObj.addActionListener(e -> {
            canvas.repaint();
        });
    }

    public static void main(String[] args)  
    {
        Display display = new Display(1000, 500);
    }
}
