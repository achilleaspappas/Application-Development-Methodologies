package gr.zeus;

import java.awt.*;
import javax.swing.*;

public class AboutWindow extends JFrame {

    /** Με την κλάση AboutWindow δημιουργούμε ένα νέο παράθυρο που παρουσιάζει στον χρήστη πληροφορίες σχετικά με την εφαρμογή */

    private final int FRAME_WIDTH = 1200;
    private final int FRAME_HEIGHT = 550;
    private JPanel aboutWindowPanel;
    private JLabel logo, description, descriptionImage;
    private final String text = "Developer: Pappas Achilleas 18390010," +
            " Creation Period: 24/05/2020 - 28/05/2020," + " Created on: MacOS, Java version: JDK 1.8,  IDE: Intellij";

    AboutWindow(){
        super("About Zeus");
        /** Δημιουργία panel με GridLayout Manager */
        aboutWindowPanel = new JPanel(new BorderLayout());

        /**  Δημιουργία συστατικών και προσθήκη στο Panel */
        setJLabels();
        setFonts();
        addToPanel();

        /** Ορισμός ιδιοτήτων παραθύρου */
        this.add(aboutWindowPanel);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setResizable(false);
        this.setVisible(true);
    }

    /** Δημιουργία ετικετών */
    public void setJLabels() {
          logo = new JLabel("Zeus", JLabel.CENTER);
          description = new JLabel(text, JLabel.CENTER);
          Icon img = new ImageIcon("src/gr/zeus/zeus-screenshot.png");
          descriptionImage = new JLabel(img, JLabel.CENTER);
    }

    /** Ορισμός γραμματοσειρών */
    public void setFonts() {
          logo.setFont(new Font("Arial", Font.BOLD, 28));
          description.setFont(new Font("Arial", Font.ITALIC, 18));
    }

    /** Προσθήκη στο Panel */
    public void addToPanel() {
        aboutWindowPanel.add(logo, BorderLayout.NORTH);
        aboutWindowPanel.add(descriptionImage, BorderLayout.CENTER);
        aboutWindowPanel.add(description,  BorderLayout.SOUTH);
    }

}
