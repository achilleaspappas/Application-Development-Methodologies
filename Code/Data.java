package gr.zeus;

import java.io.*;

public class Data {

    /** Η δουλεία της κλάσης Data είναι το διάβασμα των δεδομένων από αρχείο και η εγγραφή δεδομένων στο αρχείο */

    private static String orderID = "", orderDate = "", clientName = "", itemName = "";
    private static int appID, unitsCount;
    private static double netItemPrice, taxPercentage;

    /** Διάβασμα δεδομένων από αρχείο */
    public static void readData(String filePath) {
        FileInputStream fin = null;
        DataInputStream din = null;
        int i = 0, fieldCount = 1;
        String temp = "";
        /** Θα διαβάσουμε την τιμή κάθε χαρακτήρα ξεχωριστά ώστε όταν συναντάμε ; το πρόγραμμα να καταλαβαίνει
         * ότι πρέπει να αλλάξει πεδίο. Θα προσθέσουμε κάθε χαρακτήρα σε ένα προσωρινό string και είτε θα το
         * περάσουμε κατευθείαν στο πεδίο που πρέπει είτε θα το μετατρέψουμε σε int ή double και θα το περάσουμε μετά */
        try {
            fin = new FileInputStream(filePath);
            din = new DataInputStream(fin);
            /** Ανάγνωση δεδομένων μέχρι να μην υπάρχουν άλλα δεδομένα */
            while (din.available() > 0) {
                /** Το fieldCount μετράει σε μία γραμμή ποιο πεδίο διαβάζουμε */
                while (fieldCount != 9) {
                    switch (fieldCount) {
                        case 1:
                            i = din.read();
                            while (i != ';') {
                                temp += (char)i;
                                i = din.read();
                            }
                            /** Για αποφυγή NumberFormatException ή IOException έπρεπε να αφαιρέσουμε κάποιους χαρακτήρες
                             * παράσιτα που τοποθετούνταν ανάμεσα σε κάθε χαρακτήρα. Αυτοί είχαν όλοι UTF τιμή ίση με \u0000 */
                            temp = temp.replace("\u0000", "");
                            fieldCount++;
                            appID = Integer.parseInt(temp);
                            break;
                        case 2:
                            temp = "";
                            i = din.read();
                            while (i != ';') {
                                orderID += (char)i;
                                i = din.read();
                            }
                            temp = temp.replace("\u0000", "");
                            fieldCount++;
                            break;
                        case 3:
                            temp = "";
                            i = din.read();
                            while (i != ';') {
                                orderDate += (char)i;
                                i = din.read();
                            }
                            temp = temp.replace("\u0000", "");
                            fieldCount++;
                            break;
                        case 4:
                            temp = "";
                            i = din.read();
                            while (i != ';') {
                                clientName += (char)i;
                                i = din.read();
                            }
                            temp = temp.replace("\u0000", "");
                            fieldCount++;
                            break;
                        case 5:
                            temp = "";
                            i = din.read();
                            while (i != ';') {
                                itemName += (char)i;
                                i = din.read();
                            }
                            temp = temp.replace("\u0000", "");
                            fieldCount++;
                            break;
                        case 6:
                            temp = "";
                            i = din.read();
                            while (i != ';') {
                                temp += (char)i;
                                i = din.read();
                            }
                            temp = temp.replace("\u0000", "");
                            fieldCount++;
                            unitsCount = Integer.parseInt(temp);
                            break;
                        case 7:
                            temp = "";
                            i = din.read();
                            temp = "";
                            /** Σε περίπτωση που συναντήσουμε , (κόμμα) το μετατρέπουμε σε . (τελεία) */
                            while (i != ';') {
                                if (i == ',') {
                                    i = '.';
                                }
                                temp += (char)i;
                                i = din.read();
                            }
                            temp = temp.replace("\u0000", "");
                            fieldCount++;
                            netItemPrice = Double.parseDouble(temp);
                            break;
                        case 8:
                            temp = "";
                            i = din.read();
                            /** Ελέγχουμε αν είναι το τέλος */
                            while ((i != '\n') && (i != '\r') && (i != -1)) {
                                /** Σε περίπτωση που συναντήσουμε , (κόμμα) το μετατρέπουμε σε . (τελεία) */
                                if (i == ',') {
                                    i = '.';
                                }
                                temp += (char)i;
                                i = din.read();
                            }
                            temp = temp.replace("\u0000", "");
                            fieldCount++;
                            taxPercentage = Double.parseDouble(temp);
                            break;
                        default:
                            break;

                    }
                }
                /** Κλήση του διαχειριστή λίστας για να τοποθετήσει τα δεδομένα στην λίστα */
                /** Γίνεται κλήση για κάθε γραμμή που διαβάζεται από το αρχείο ξεχωριστά */
                new ListAdmin(appID, orderID, orderDate, clientName, itemName, unitsCount, netItemPrice, taxPercentage);
                /** Επαναφέρουμε τα πεδία ώστε να διαβάσουμε την επόμενη γραμμή */
                fieldCount = 1;
                temp = "";
                orderID = "";
                orderDate = "";
                clientName = "";
                itemName = "";
                unitsCount = 0;
                netItemPrice = 0.0;
                taxPercentage = 0.0;
            }
        } catch (NumberFormatException e) {
            ExceptionList.NumberFormatExceptionList();
        } catch (FileNotFoundException e) {
            ExceptionList.FileNotFoundExceptionList();
        } catch (IOException e) {
            ExceptionList.IOExceptionList();
        } finally {
            try {
                din.close();
            } catch (IOException e) {
                ExceptionList.IOExceptionList();
            }
        }
    }

    /** Εγγραφή δεδομένων στο αρχείο */
    public static void writeData(String filePath){
        FileOutputStream fout = null;
        DataOutputStream dout = null;
        /** Ζητείται από τον διαχειριστή λίστας πόσα αντικείμενα τύπου Order υπάρχουν στην λίστα */
        /** Ο διαχειριστής λίστας επιστρέφει ένα δείκτη */
        int requestIndex = ListAdmin.getListIndex();
        try {
            fout = new FileOutputStream(filePath);
            dout = new DataOutputStream(fout);
            /** Μέχρι να μηδενιστεί ο δείκτης ζητείται από τον διαχειριστή λίστας να επιστρέφει τα πεδία του κάθε αντικειμένου */
            while (requestIndex >= 0) {
                    dout.writeChars(Integer.toString( ListAdmin.getListAppID(requestIndex) ) );
                    dout.writeChar(';');
                    dout.writeChars(ListAdmin.getListOrderID(requestIndex));
                    dout.writeChar(';');
                    dout.writeChars(ListAdmin.getListOrderDate(requestIndex));
                    dout.writeChar(';');
                    dout.writeChars(ListAdmin.getListClientName(requestIndex));
                    dout.writeChar(';');
                    dout.writeChars(ListAdmin.getListItemName(requestIndex));
                    dout.writeChar(';');
                    dout.writeChars(Integer.toString( ListAdmin.getListUnitsCount(requestIndex) ));
                    dout.writeChar(';');

                    /** Αλλαγή της . σε , για ορθή αποθήκευση στο αρχείο */
                    /** Μετατρέπεται ο τύπος double σε string και στην συνέχεια ελέγχουμε ξεχωριστά τους χαρακτήρες
                     * του string για να ψάξουμε για την . (τελεία) και να την μετατρέψουμε σε , (κόμμα) */
                    String str1 = Double.toString( ListAdmin.getListNetItemPrice(requestIndex));
                    for(int z=0; z<str1.length(); z++){
                        char ch = str1.charAt(z);
                        if(ch == '.') {
                            ch=',';
                        }
                        dout.writeChar(ch);
                    }
                    dout.writeChar(';');
                    String str2 = Double.toString( ListAdmin.getListNetItemPrice(requestIndex));
                    for(int z=0; z<str2.length(); z++){
                        char ch = str2.charAt(z);
                        if(ch == '.') {
                            ch=',';
                        }
                        dout.writeChar(ch);
                    }
                    dout.writeChar('\n');
                    requestIndex--;
            }
        }
        catch(FileNotFoundException e) {
            ExceptionList.FileNotFoundExceptionList();
        }
        catch(IOException e){
            ExceptionList.IOExceptionList();
        }
        finally {
            try {
                dout.close();
            } catch (IOException e) {
                ExceptionList.IOExceptionList();
            }
        }
    }

}
