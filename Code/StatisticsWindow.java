package gr.zeus;

import java.awt.*;
import javax.swing.*;

public class StatisticsWindow extends JFrame {

    /** Με την κλάση StatisticsWindow δημιουργούμε ένα νέο παράθυρο ώστε ο χρήστης να βλέπει κάποια στατιστικά που αφορούν τις παραγελίες */

    private final int FRAME_WIDTH = 700;
    private final int FRAME_HEIGHT = 300;
    private JPanel statisticsWindowPanel;
    private JLabel logo, sumOrderNumberLabel, sumCostNoTaxLabel, sumCostWithTaxLabel, expensiveOrderIDLabel, cheapOrderIDLabel;

    StatisticsWindow(){
        super("Statistics");

        /** Δημιουργία JPanel με GridLayout Manager */
        statisticsWindowPanel = new JPanel(new GridLayout(6,1));

        /**  Δημιουργία συστατικών και προσθήκη στο Panel */
        createJLabels();
        addJLabelsToPanel();

        /** Ορισμός ιδιοτήτων παραθύρου */
        this.add(statisticsWindowPanel);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setResizable(false);
        this.setVisible(true);
    }

    /** Δημιουργία JLabel */
    public void createJLabels() {
        logo = new JLabel("Zeus - Statistics", JLabel.CENTER);
        logo.setFont(new Font("Arial", Font.BOLD, 20));
        sumOrderNumberLabel = new JLabel("Number of all orders: " + CalculateStatistics.getSumOrderNumber(), JLabel.CENTER);
        sumCostNoTaxLabel = new JLabel("Summary cost of all orders (Excludes Tax): " + CalculateStatistics.getSumCostNoTax() + " $", JLabel.CENTER);
        sumCostWithTaxLabel = new JLabel("Summary cost of all orders (Includes Tax): " + CalculateStatistics.getSumCostWithTax() + " $", JLabel.CENTER);
        expensiveOrderIDLabel = new JLabel("OrderID of the most expensive order: " + CalculateStatistics.getExpensiveOrderID(), JLabel.CENTER);
        cheapOrderIDLabel = new JLabel("OrderID of the cheapest order: " + CalculateStatistics.getCheapOrderID(), JLabel.CENTER);
    }

    /** Προθήκη JLabel στο Panel */
    public void addJLabelsToPanel() {
        statisticsWindowPanel.add(logo);
        statisticsWindowPanel.add(sumOrderNumberLabel);
        statisticsWindowPanel.add(sumCostNoTaxLabel);
        statisticsWindowPanel.add(sumCostWithTaxLabel);
        statisticsWindowPanel.add(expensiveOrderIDLabel);
        statisticsWindowPanel.add(cheapOrderIDLabel);
    }
}
