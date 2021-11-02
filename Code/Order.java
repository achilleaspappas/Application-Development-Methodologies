package gr.zeus;

public class Order {

    /** Κάθε παραγγελία αποθηκεύεται ως ένα αντικείμενο τύπου Order */

    private String orderID, orderDate, clientName, itemName;
    private int appID, unitsCount;
    private double netItemPrice, taxPercentage;

    /** Κατασκευαστής αντικειμένου Order που καλείται από το δίαβασμα αρχείου */
    Order(int appID, String orderID, String orderDate, String clientName, String itemName, int unitsCount, double netItemPrice, double taxPercentage) {
        this.appID = appID;
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.clientName = clientName;
        this.itemName = itemName;
        this.unitsCount = unitsCount;
        this.netItemPrice = netItemPrice;
        this.taxPercentage = taxPercentage;
        statisticsHelper();
    }

    /** Καταστκευαστής αντικειμένου Order που καλείται από το παράθυρο νέας παραγγελίας */
    Order(String orderID, String orderDate, String clientName, String itemName, String unitsCount, String netItemPrice, String taxPercentage) {
        this.appID = 18390010;
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.clientName = clientName;
        this.itemName = itemName;
        this.unitsCount = Integer.parseInt(unitsCount);
        this.netItemPrice = Double.parseDouble(netItemPrice);
        this.taxPercentage = Double.parseDouble(taxPercentage);
        statisticsHelper();
    }

    public void statisticsHelper(){
        /** Κλήση μεθόδων για τον υπολογισμός στατιστικών */
        CalculateStatistics.calculateSumCostNoTax(netItemPrice);
        CalculateStatistics.calculateSumCostWithTax(netItemPrice, taxPercentage);
        CalculateStatistics.calculateExpensiveOrder(orderID, netItemPrice, taxPercentage);
        CalculateStatistics.calculateCheapOrder(orderID, netItemPrice, taxPercentage);
    }

    /** Getters */
    public int getAppID(){
        return appID;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getClientName() {
        return clientName;
    }

    public String getItemName() {
        return itemName;
    }

    public int getUnitsCount() {
        return unitsCount;
    }

    public double getNetItemPrice() {
        return netItemPrice;
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }
}
