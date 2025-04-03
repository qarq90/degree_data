package com.example.exp10_bank_app;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    private TextField txtcuid, txtname, txtamount, txtbalance, txtdate;
    private TextArea txtAddress;
    private ListView<String> lsttype;
    private Label lblCustId, lblName, lblAddress, lblDate, lblType, lblAmount, lblBalance;

    private ObservableList<Customer> customers;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Bank Management System");

        customers = FXCollections.observableArrayList();
        addPredefinedCustomers();

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        Label lblCustIdInput = new Label("Customer ID:");
        txtcuid = new TextField();
        grid.add(lblCustIdInput, 0, 0);
        grid.add(txtcuid, 1, 0);

        Label lblNameInput = new Label("Name:");
        txtname = new TextField();
        grid.add(lblNameInput, 0, 1);
        grid.add(txtname, 1, 1);

        Label lblAddressInput = new Label("Address:");
        txtAddress = new TextArea();
        txtAddress.setPrefHeight(60);
        grid.add(lblAddressInput, 0, 2);
        grid.add(txtAddress, 1, 2);

        Label lblDateInput = new Label("Date:");
        txtdate = new TextField();
        grid.add(lblDateInput, 0, 3);
        grid.add(txtdate, 1, 3);

        Label lblAmountInput = new Label("Amount:");
        txtamount = new TextField();
        grid.add(lblAmountInput, 0, 4);
        grid.add(txtamount, 1, 4);

        Label lblBalanceInput = new Label("Balance:");
        txtbalance = new TextField();
        grid.add(lblBalanceInput, 0, 5);
        grid.add(txtbalance, 1, 5);

        Label lblTypeInput = new Label("Type:");
        ObservableList<String> types = FXCollections.observableArrayList("Savings", "Current");
        lsttype = new ListView<>(types);
        lsttype.setPrefHeight(50);
        grid.add(lblTypeInput, 0, 6);
        grid.add(lsttype, 1, 6);

        lblCustId = new Label();
        lblName = new Label();
        lblAddress = new Label();
        lblDate = new Label();
        lblType = new Label();
        lblAmount = new Label();
        lblBalance = new Label();

        grid.add(lblCustId, 0, 8);
        grid.add(lblName, 0, 9);
        grid.add(lblAddress, 0, 10);
        grid.add(lblDate, 0, 11);
        grid.add(lblType, 0, 12);
        grid.add(lblAmount, 0, 13);
        grid.add(lblBalance, 0, 14);

        Button cmdview = new Button("View Customer");
        Button cmdviewall = new Button("View All");
        Button clearBtn = new Button("Clear");
        Button addCustomer = new Button("Add Customer");

        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(cmdview, cmdviewall, clearBtn, addCustomer);
        grid.add(buttonBox, 1, 7);

        cmdview.setOnAction(e -> viewCustomer());
        cmdviewall.setOnAction(e -> viewAllCustomers(grid));
        clearBtn.setOnAction(e -> clearFields());
        addCustomer.setOnAction(e -> addCustomer());

        Scene scene = new Scene(grid, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addPredefinedCustomers() {
        customers.add(new Customer(1, "Alice Smith", "123 Elm St", "2024-01-01", "Savings", 1000.0, 500.0));
        customers.add(new Customer(2, "Bob Johnson", "456 Oak St", "2024-01-02", "Current", 2000.0, 1500.0));
        customers.add(new Customer(3, "Charlie Brown", "789 Pine St", "2024-01-03", "Savings", 3000.0, 2500.0));
        customers.add(new Customer(4, "Diana Prince", "321 Maple St", "2024-01-04", "Current", 1500.0, 1000.0));
        customers.add(new Customer(5, "Ethan Hunt", "654 Cedar St", "2024-01-05", "Savings", 2500.0, 2000.0));
        customers.add(new Customer(6, "Fiona Gallagher", "987 Birch St", "2024-01-06", "Current", 1200.0, 800.0));
        customers.add(new Customer(7, "George Michael", "159 Spruce St", "2024-01-07", "Savings", 1800.0, 1200.0));
    }

    private void viewCustomer() {
        int custId = Integer.parseInt(txtcuid.getText());

        for (Customer customer : customers) {
            if (customer.getCustId() == custId) {
                lblCustId.setText("Customer ID: " + customer.getCustId());
                lblName.setText("Name: " + customer.getName());
                lblAddress.setText("Address: " + customer.getAddress());
                lblDate.setText("Date: " + customer.getDate());
                lblType.setText("Type: " + customer.getType());
                lblAmount.setText("Amount: " + customer.getAmount());
                lblBalance.setText("Balance: " + customer.getBalance());
                return;
            }
        }

        Alert alert = new Alert(Alert.AlertType.WARNING, "Customer not found!");
        alert.show();
    }

    private void viewAllCustomers(GridPane grid) {

        GridPane customerGrid = new GridPane();
        customerGrid.setPadding(new Insets(10, 10, 10, 10));
        customerGrid.setVgap(5);
        customerGrid.setHgap(10);

        customerGrid.add(new Label("Customer ID"), 0, 0);
        customerGrid.add(new Label("Name"), 1, 0);
        customerGrid.add(new Label("Address"), 2, 0);
        customerGrid.add(new Label("Date"), 3, 0);
        customerGrid.add(new Label("Type"), 4, 0);
        customerGrid.add(new Label("Amount"), 5, 0);
        customerGrid.add(new Label("Balance"), 6, 0);

        int row = 1;
        for (Customer customer : customers) {
            customerGrid.add(new Label(String.valueOf(customer.getCustId())), 0, row);
            customerGrid.add(new Label(customer.getName()), 1, row);
            customerGrid.add(new Label(customer.getAddress()), 2, row);
            customerGrid.add(new Label(customer.getDate()), 3, row);
            customerGrid.add(new Label(customer.getType()), 4, row);
            customerGrid.add(new Label(String.valueOf(customer.getAmount())), 5, row);
            customerGrid.add(new Label(String.valueOf(customer.getBalance())), 6, row);
            row++;
        }

        grid.getChildren().clear();
        grid.add(customerGrid, 0, 0, 2, 8);
    }

    private void clearFields() {
        txtcuid.clear();
        txtname.clear();
        txtAddress.clear();
        txtdate.clear();
        txtamount.clear();
        txtbalance.clear();
        lsttype.getSelectionModel().clearSelection();
        clearLabels();
    }

    private void clearLabels() {
//        lblCustId.setText("");
//        lblName.setText("");
//        lblAddress.setText("");
//        lblDate.setText("");
//        lblType.setText("");
//        lblAmount.setText("");
//        lblBalance.setText("");
    }

    private void addCustomer() {
        try {
            int custId = Integer.parseInt(txtcuid.getText().trim());
            String name = txtname.getText().trim();
            String address = txtAddress.getText().trim();
            String date = txtdate.getText().trim();
            String type = lsttype.getSelectionModel().getSelectedItem();
            double amount = Double.parseDouble(txtamount.getText().trim());
            double balance = Double.parseDouble(txtbalance.getText().trim());

            if (name.isEmpty() || address.isEmpty() || date.isEmpty() || type == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Please fill in all fields!");
                alert.show();
                return;
            }

            Customer newCustomer = new Customer(custId, name, address, date, type, amount, balance);
            customers.add(newCustomer);

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Customer added successfully!");
            alert.show();

            clearFields();

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter valid numeric values for ID, Amount, and Balance.");
            alert.show();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "An error occurred while adding the customer.");
            alert.show();
        }
    }


    public static class Customer {
        private final SimpleIntegerProperty custId;
        private final SimpleStringProperty name;
        private final SimpleStringProperty address;
        private final SimpleStringProperty date;
        private final SimpleStringProperty type;
        private final SimpleDoubleProperty amount;
        private final SimpleDoubleProperty balance;

        public Customer(int custId, String name, String address, String date, String type, double amount, double balance) {
            this.custId = new SimpleIntegerProperty(custId);
            this.name = new SimpleStringProperty(name);
            this.address = new SimpleStringProperty(address);
            this.date = new SimpleStringProperty(date);
            this.type = new SimpleStringProperty(type);
            this.amount = new SimpleDoubleProperty(amount);
            this.balance = new SimpleDoubleProperty(balance);
        }

        public int getCustId() {
            return custId.get();
        }

        public String getName() {
            return name.get();
        }

        public String getAddress() {
            return address.get();
        }

        public String getDate() {
            return date.get();
        }

        public String getType() {
            return type.get();
        }

        public double getAmount() {
            return amount.get();
        }

        public double getBalance() {
            return balance.get();
        }
    }
}
