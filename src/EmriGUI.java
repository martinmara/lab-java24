import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EmriGUI extends JFrame implements ActionListener {
    private JTextField emriField;
    private JLabel emriLabel;
    private JButton afishoButton;

    public EmriGUI() {
        setTitle("Afishimi i Emrit");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Krijo panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        // Krijo label për instruksionin
        JLabel instruksioniLabel = new JLabel("Vendosni emrin tuaj:");
        panel.add(instruksioniLabel);

        // Krijo textField për emrin
        emriField = new JTextField(20);
        panel.add(emriField);

        // Krijo buttonin për të afishuar emrin
        afishoButton = new JButton("Afisho Emrin");
        afishoButton.addActionListener(this);
        panel.add(afishoButton);

        // Krijo label për afishimin e emrit
        emriLabel = new JLabel("");
        panel.add(emriLabel);

        // Shto panelin në frame
        add(panel);

        // Shfaq frame-in
        setVisible(true);
    }



