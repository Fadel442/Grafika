package UTS;

import javax.swing.*;

public class MenuBarItem extends JFrame {
    
    JComboBox<String> comboBox1 = new JComboBox<>
    (new String[]{"Buat Garis","Buat Persegi Panjang",
    "Buat Ellips","Buat Segitiga"});
    JComboBox<String> comboBox2 = new JComboBox<>
    (new String[]{"Tipe Garis Solid","Tipe Garis Putus Panjang",
    "Tipe Garis Putus Pendek","Tipe Garis Titik-Titik"});

}
