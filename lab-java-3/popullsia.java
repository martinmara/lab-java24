import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class popullsia {
    private JFrame frame;
    private JComboBox<String> qytetiComboBox;
    private JTextField popullsiaField;
    private JTextField teDhenatField; 
    private JButton shfaqButton;
    private JButton saveButton;

    private static final String FILE_PATH = "popullsia.txt";

    public popullsia() {
        frame = new JFrame("popullsia e Qyteteve në Shqipëri");
        frame.setLayout(null);
        frame.setSize(400, 250); 

        JLabel qytetiLabel = new JLabel("Zgjidh Qytetin:");
        qytetiLabel.setBounds(20, 20, 100, 20);
        frame.add(qytetiLabel);

        String[] qytetet = {"Tirana", "Durrësi", "Tropoja", "Shkodra",  "Fieri", "Korça", "Berati"};
        qytetiComboBox = new JComboBox<>(qytetet);
        qytetiComboBox.setBounds(130, 20, 150, 20);
        frame.add(qytetiComboBox);

        JLabel popullsiaLabel = new JLabel("popullsia:");
        popullsiaLabel.setBounds(20, 50, 100, 20);
        frame.add(popullsiaLabel);

        popullsiaField = new JTextField();
        popullsiaField.setBounds(130, 50, 150, 20);
        frame.add(popullsiaField);

        JLabel teDhenatLabel = new JLabel("Të dhënat nga skedari:");
        teDhenatLabel.setBounds(20, 80, 150, 20);
        frame.add(popullsiaField);

        teDhenatField = new JTextField();
        teDhenatField.setBounds(20, 110, 350, 20);
        teDhenatField.setEditable(false); 
        frame.add(teDhenatField);

        shfaqButton = new JButton("Shfaq");
        shfaqButton.setBounds(100, 140, 80, 30);
        shfaqButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                shfaqPopullsine();
            }
        });
        frame.add(shfaqButton);

        saveButton = new JButton("Save");
        saveButton.setBounds(200, 140, 80, 30);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ruajPopullsine();
            }
        });
        frame.add(saveButton);

       
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ruajTeDhenat();
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        
        shfaqPopullsine();
    
		
	}

	private void shfaqPopullsine() {
        String qyteti = (String) qytetiComboBox.getSelectedItem();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(qyteti)) {
                    teDhenatField.setText(parts[1]);
                    return;
                }
            }
            teDhenatField.setText("Nuk ka të dhëna për këtë qytet.");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Gabim gjatë leximit të të dhënave.");
        }
    }

    private void ruajPopullsine() {
        String qyteti = (String) qytetiComboBox.getSelectedItem();
        String popullsia = popullsiaField.getText();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            bw.write(qyteti + "," + popullsia + "\n");
            JOptionPane.showMessageDialog(frame, "Të dhënat e popullsisë janë ruajtur me sukses.");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Gabim gjatë ruajtjes së të dhënave.");
        }
    }

   
    private void shfaqTeDhenat() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            teDhenatField.setText(sb.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Gabim gjatë leximit të të dhënave.");
        }
    }

  
    private void  ruajTeDhenat() {
        String teDhena = teDhenatField.getText();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            bw.write(teDhena);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Gabim gjatë ruajtjes së të dhënave.");
        }
    }

    public static void main(String[] args) {
        new popullsia();
    }
}