package UTS;

import javax.swing.*;

public class MenuBarItem extends JFrame {

    //Jlabel
    JLabel jLabel =  new JLabel("Bentuk Gambar", SwingConstants.CENTER);
    JLabel modeGrais = new JLabel("Mode", SwingConstants.CENTER);
    JLabel warna = new JLabel("Warna", SwingConstants.CENTER);
    JLabel Position = new JLabel("Position", SwingConstants.CENTER);
    JLabel Rotate = new JLabel("Rotasi", SwingConstants.CENTER);
    //JLabel space = new JLabel("|", SwingConstants.CENTER);
    
    //JComboBox
    JComboBox<String> comboBox1 = new JComboBox<>
    (new String[]{"None","Garis","Persegi Panjang",
    "Ellips","Segitiga"});

    JComboBox<String> comboBox2 = new JComboBox<>
    (new String[]{"None","Tipe Garis Solid","Tipe Garis Putus Panjang",
    "Tipe Garis Putus Pendek","Tipe Garis Titik-Titik"});

    JComboBox<String> comboBox3 = new JComboBox<>
    (new String[]{"None","Hitam", "Merah", "Biru", "Gradient"});

    JComboBox<String> positionObj = new JComboBox<>
    (new String[]{"None","Kiri", "Tengah", "Kanan"});

    JComboBox<String> rotationObj = new JComboBox<>
    (new String[]{"None","Normal", "Rotate 1", "Rotate 2"});

}
