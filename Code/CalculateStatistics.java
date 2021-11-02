package gr.zeus;

public class CalculateStatistics {

    /** Με την κλάση CalculateStatistics υπολογίζουμε κάποια στατιστικά σχετικά με τις παραγελίες
        τα οποία δίνουμε στην κλάση StatisticsWindow για να τα εμφανίσει στον χρήστη */

    private static int sumOrderNumber = 0;
    private static double sumCostNoTax = 0.0, sumCostWithTax = 0.0, expensiveOrderPrice = 0.0, cheapOrderPrice = Double.POSITIVE_INFINITY;
    private static String expensiveOrderID = "", cheapOrderID = "";

    /** Υπολογισμός αριθμού συνολικών παραγγελιών */
    public static void calculateSumOrderNumber() {
        sumOrderNumber++;
    }

    /** Υπολογισμός όλων των κόστων των πραγμάτων χωρίς φόρο */
    public static void calculateSumCostNoTax(double netItemPrice) {
        sumCostNoTax += netItemPrice;
    }

    /** Υπολογισμός όλων των κόστων των πραγμάτων με φόρο */
    public static void calculateSumCostWithTax(double netItemPrice, double taxPercentage) {
        sumCostWithTax += netItemPrice + netItemPrice*taxPercentage/100;
    }

    /** Έυρεση κωδικού ακριβότερης παραγγελίας */
    public static void calculateExpensiveOrder(String orderID, double netItemPrice, double taxPercentage) {
        if (expensiveOrderPrice < netItemPrice + netItemPrice*taxPercentage/100) {
            expensiveOrderPrice = netItemPrice + netItemPrice*taxPercentage/100;
            expensiveOrderID = orderID;
        }
    }

    /** Έυρεση κωδικού φθηνότερης παραγγελίας */
    public static void calculateCheapOrder(String orderID, double netItemPrice, double taxPercentage) {
        if (cheapOrderPrice > netItemPrice + netItemPrice*taxPercentage/100) {
            cheapOrderPrice = netItemPrice + netItemPrice*taxPercentage/100;
            cheapOrderID = orderID;
        }
    }

    /** Getters */
    public static int getSumOrderNumber() {
        return sumOrderNumber;
    }

    public static double getSumCostNoTax() {
        return sumCostNoTax;
    }

    public static double getSumCostWithTax() {
        return sumCostWithTax;
    }

    public static String getExpensiveOrderID() {
        return expensiveOrderID;
    }

    public static String getCheapOrderID() {
        return cheapOrderID;
    }


}
