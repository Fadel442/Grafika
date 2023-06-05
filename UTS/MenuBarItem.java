package UTS;

import javax.swing.*;

public class MenuBarItem extends JFrame {

    //Jlabel
    JLabel jLabel =  new JLabel("Bentuk Gambar : ");
    JLabel modeGrais = new JLabel("Mode : ");
    JLabel warna = new JLabel("Warna : ");
    JLabel warnaa = new JLabel("War : ");
    
    //JComboBox
    JComboBox<String> comboBox1 = new JComboBox<>
    (new String[]{"Garis","Persegi Panjang",
    "Ellips","Segitiga"});

    JComboBox<String> comboBox2 = new JComboBox<>
    (new String[]{"Tipe Garis Solid","Tipe Garis Putus Panjang",
    "Tipe Garis Putus Pendek","Tipe Garis Titik-Titik"});

    JComboBox<String> comboBox3 = new JComboBox<>
    (new String[]{"Hitam", "Merah", "Biru"});

}
