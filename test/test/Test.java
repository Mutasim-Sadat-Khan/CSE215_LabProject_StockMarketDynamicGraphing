package test;

import chart.ModelChart;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author mutasim sadat khan
 */
public class Test extends javax.swing.JFrame {

    public static int n;
    
    public Test() throws InterruptedException {         
        Scanner input = new Scanner(System.in);
        
        System.out.println("Fetching data from Alpha Vantage API...");
        
        String trader = "empty";
        String name = "empty";
        
        switch(n) {
            case 1:
                trader = "AAPL";
                name = " (Apple Inc.) ";
                break;
            case 2:
                trader = "IBM";
                name = " (International Business Machines Corporation) ";
                break;
            case 3:
                trader = "KO";
                name = " (The Coca-Cola Company) ";
                break;
            case 4:
                trader = "BA";
                name = " (The Boeing Company) ";
                break;
            case 5:
                trader = "DIS";
                name = " (The Walt Disney Company) ";
                break;
            case 6:
                trader = "GE";
                name = " (General Electric Company) ";
                break;
            case 7:
                trader = "NVDA";
                name = " (NVIDIA Corp) ";
                break;
            case 8:
                trader = "ADBE";
                name = " (Adobe Inc) ";
                break;
            default:
                System.out.println("Invalid input!");
                break;
        }
        
        initComponents();
        chart.setTitle("Stock Market Data : " + trader + name);
        chart.addLegend("Open", Color.decode("#e65c00"), Color.decode("#F9D423"));
        chart.addLegend("High", Color.decode("#31c65b"), Color.decode("#30c6ad"));
        chart.addLegend("Low", Color.decode("#0099F7"), Color.decode("#3602ee"));
        chart.addLegend("Close", Color.decode("#d72635"), Color.decode("#80299d"));
        
        try {
            setData(trader);
        } catch(IOException e) {
            System.out.println("Not found!");
        }
    }

    public void setData(String trader) throws InterruptedException, IOException {
        URL url = null;
        
        switch (trader) {
            case "AAPL":
                url = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY&symbol=AAPL&apikey=J0IQIGTWJ70GV13H");
                break;
            case "IBM": 
                url = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY&symbol=IBM&apikey=J0IQIGTWJ70GV13H");
                break;
            case "KO":
                url = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY&symbol=KO&apikey=J0IQIGTWJ70GV13H");
                break;
            case "BA":
                url = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY&symbol=BA&apikey=J0IQIGTWJ70GV13H");
                break;
            case "DIS":
                url = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY&symbol=DIS&apikey=J0IQIGTWJ70GV13H");
                break;
            case "GE":
                url = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY&symbol=GE&apikey=J0IQIGTWJ70GV13H");
                break;
            case "NVDA":
                url = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY&symbol=NVDA&apikey=J0IQIGTWJ70GV13H");
                break;
            case "ADBE":
                url = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY&symbol=ADBE&apikey=J0IQIGTWJ70GV13H");
                break;
            default:
                break;
        }
        
        URLConnection urlConn = url.openConnection();
        InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
        BufferedReader buff = new BufferedReader(inStream);
        
        String price = "not found";
        String date = "not found";
        
        String line = buff.readLine();
        
        ArrayList<String> dateData = new ArrayList<String>();
        ArrayList<Double> openData = new ArrayList<Double>();
        ArrayList<Double> highData = new ArrayList<Double>();
        ArrayList<Double> lowData = new ArrayList<Double>();
        ArrayList<Double> closeData = new ArrayList<Double>();
        
        while(line != null) {
            if(line.contains("-")) {
                int target = line.indexOf("-");
                int dash = line.indexOf("-", target);
                int start = dash;
                
                while(line.charAt(start) != '\"') {
                    start--;
                }
                
                date = line.substring(start + 1, dash + 6);
                
                dateData.add(date);
            }
            
            if(line.contains("open\":")) {
                int target = line.indexOf("open\":");
                int deci = line.indexOf(".", target);
                int start = deci;
                
                while(line.charAt(start) != '\"') {
                    start--;
                }
                
                price = line.substring(start + 1, deci + 3);
                
                openData.add(Double.parseDouble(price));
            }
            
            if(line.contains("high\":")) {
                int target = line.indexOf("high\":");
                int deci = line.indexOf(".", target);
                int start = deci;
                
                while(line.charAt(start) != '\"') {
                    start--;
                }
                
                price = line.substring(start + 1, deci + 3);
                
                highData.add(Double.parseDouble(price));
            }
            
            if(line.contains("low\":")) {
                int target = line.indexOf("low\":");
                int deci = line.indexOf(".", target);
                int start = deci;
                
                while(line.charAt(start) != '\"') {
                    start--;
                }
                
                price = line.substring(start + 1, deci + 3);
                
                lowData.add(Double.parseDouble(price));
            }
            
            if(line.contains("close\":")) {
                int target = line.indexOf("close\":");
                int deci = line.indexOf(".", target);
                int start = deci;
                
                while(line.charAt(start) != '\"') {
                    start--;
                }
                
                price = line.substring(start + 1, deci + 3);
                
                closeData.add(Double.parseDouble(price));
            }
            
            line = buff.readLine();   
        }
        
        chart.clear();
        
        for(int i = 295; i >= 0; i--) {            
            if(i % 20 == 0)
                chart.addData(new ModelChart(dateData.get(i), new double[] {openData.get(i), highData.get(i), lowData.get(i), closeData.get(i)}));  //296
        }
        
        chart.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow1 = new panel.PanelShadow();
        chart = new chart.CurveLineChart();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelShadow1.setBackground(new java.awt.Color(62, 26, 87));
        panelShadow1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelShadow1.setColorGradient(new java.awt.Color(117, 43, 43));

        chart.setBackground(new java.awt.Color(0, 5, 174));
        chart.setForeground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("< Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1356, Short.MAX_VALUE)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Stop();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public static void choise(int n) {
        Test.n = n;
    }
    
    public static void Start() {
        Scanner input = new Scanner(System.in);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Test().setVisible(true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
public void Stop() {
    dispose();
    
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chart.CurveLineChart chart;
    private javax.swing.JButton jButton1;
    private panel.PanelShadow panelShadow1;
    // End of variables declaration//GEN-END:variables
}
