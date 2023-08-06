import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CurrencyConverter extends JFrame
{
    private JTextField amountField;
    private JComboBox<String> fromCurrencyComboBox;
    private JComboBox<String> toCurrencyComboBox;
    private JLabel resultLabel;

    private static final double INR_TO_USD = 0.012;
    private static final double INR_TO_EUR = 0.011;
    private static final double INR_TO_SGD = 0.016;
    private static final double USD_TO_EUR = 0.91;
    private static final double USD_TO_SGD = 1.33;
    private static final double USD_TO_INR = 82.26;
    private static final double EUR_TO_INR = 90.79;
    private static final double EUR_TO_USD = 1.10;
    private static final double EUR_TO_SGD = 1.47;
    private static final double SGD_TO_INR = 61.81;
    private static final double SGD_TO_USD = 0.75;
    private static final double SGD_TO_EUR = 0.68;

    public CurrencyConverter() {
        setTitle("Currency Converter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 250);
        setLayout(new GridLayout(4, 2, 10, 10));

        amountField = new JTextField();
        fromCurrencyComboBox = new JComboBox<>(new String[]{"INR","USD", "EUR", "SGD"});
        toCurrencyComboBox = new JComboBox<>(new String[]{"INR","USD", "EUR", "SGD"});
        resultLabel = new JLabel("");

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                convertCurrency();
            }
        });

        add(new JLabel("Amount: "));
        add(amountField);
        add(new JLabel("From Currency: "));
        add(fromCurrencyComboBox);
        add(new JLabel("To Currency: "));
        add(toCurrencyComboBox);
        add(convertButton);
        add(resultLabel);
    }

    private void convertCurrency()
    {
        try
        {
            String amountText = amountField.getText();
            double amount = Double.parseDouble(amountText);
            String fromCurrency = (String) fromCurrencyComboBox.getSelectedItem();
            String toCurrency = (String) toCurrencyComboBox.getSelectedItem();

            double convertedAmount = convert(amount, fromCurrency, toCurrency);
            DecimalFormat df = new DecimalFormat("#.####");
            resultLabel.setText(df.format(convertedAmount) + " " + toCurrency);
        } catch (NumberFormatException ex)
        {
            resultLabel.setText("Invalid input");
        }
    }

    private double convert(double amount, String fromCurrency, String toCurrency) {
        if (fromCurrency.equals("USD") && toCurrency.equals("EUR")) {
            return amount * USD_TO_EUR;
        } else if (fromCurrency.equals("USD") && toCurrency.equals("SGD")) {
            return amount * USD_TO_SGD;
        }else if (fromCurrency.equals("USD") && toCurrency.equals("INR")) {
            return amount * USD_TO_INR;
        } else if (fromCurrency.equals("INR") && toCurrency.equals("USD")) {
            return amount * INR_TO_USD;
        } else if (fromCurrency.equals("INR") && toCurrency.equals("EUR")) {
            return amount * INR_TO_EUR;
        } else if (fromCurrency.equals("INR") && toCurrency.equals("SGD")) {
            return amount * INR_TO_SGD;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("INR")) {
            return amount * EUR_TO_INR;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("USD")) {
            return amount * EUR_TO_USD;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("SGD")) {
            return amount * EUR_TO_SGD;
        } else if (fromCurrency.equals("SGD") && toCurrency.equals("INR")) {
            return amount * SGD_TO_INR;
        }
        else if (fromCurrency.equals("SGD") && toCurrency.equals("USD")) {
            return amount * SGD_TO_USD;
        }
        else if (fromCurrency.equals("SGD") && toCurrency.equals("EUR")) {
            return amount * SGD_TO_EUR;
        } else {
            return amount;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CurrencyConverter().setVisible(true);
            }
        });
    }
}
