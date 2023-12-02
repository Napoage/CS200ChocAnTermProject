package com.example.demo;

/**
 * This class represents the Provider Menu before it gets implemented into the HTML file.
 * It contains methods for billing ChocAn services and requesting the Provider Directory.
 * The functionality of these methods relies on the implementation of the HTML navigation and the SQL database.
 */
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import java.sql.*;
//import java.util.Map;
//import java.util.HashMap;

//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.HttpStatus;

@RestController("/api/provider")
public class ProviderMenu {

    /*Statement stmt;
    Connection conn;
    ResultSet resultSet;

    public static class BillingData{
        public int memberID;
        public int serviceID;
    }*/
    @PostMapping("/requestProviderDirectory")
    public ResponseEntity<Integer> requestProviderDirectory() {
        return ResponseEntity.ok(1);
    }
    /**
     * This method compiles all of the service costs for services provided in a specific session.
     * It relies on the completion of the QueryDatabase class.
     */
    // ...

    /**
     * Calculates and bills the ChocAn service for a member.
     * It retrieves the cost of the service from the database, updates the amount owed by the member,
     * and returns the result of the billing operation.
     * 
     * @param billingData The billing data containing the member ID and service ID.
     * @return A ResponseEntity containing a map with the billing result.
     
    @PostMapping("/billChocAn")
    public ResponseEntity<Map<String, Double>> billChocAn(@RequestBody BillingData billingData) {
        Double result;
        try {
            // Get the cost of the service associated with the serviceID from the database
            Double serviceCost = getServiceCost(billingData.serviceID);

            // Get the current amount owed by the member from the database
            Double currentAmountOwed = getCurrentAmountOwed(billingData.memberID);

            // Calculate the new amount owed by adding the service cost to the current amount owed
            Double newAmountOwed = serviceCost + currentAmountOwed;

            // Update the member table with the new amount owed
            updateAmountOwed(billingData.memberID, newAmountOwed);

            result = serviceCost; // Success
        } catch (SQLException e) {
            result = -1.0; // Error occurred
        }

        Map<String, Double> responseBody = new HashMap<>();
        responseBody.put("billResult", result);

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    /**
     * Retrieves the cost of a service from the database based on the service ID.
     * 
     * @param serviceID The ID of the service.
     * @return The cost of the service.
     * @throws SQLException If an error occurs while accessing the database.
     
    private Double getServiceCost(int serviceID) throws SQLException {
        // Call the SQL function to get the cost of the service associated with the serviceID
        // Implement the SQL query and connection logic here
        // ...

        // For demonstration purposes, let's assume the service cost is retrieved from the database
        Double serviceCost = null;
        try {
            String query = "SELECT cost FROM ProviderDirectory WHERE ServiceCode = " + serviceID;
            resultSet = stmt.executeQuery(query);
            if(resultSet.next()){
                serviceCost = resultSet.getDouble("cost");
            }
        } catch(SQLException e) {
            System.out.println(e);
        }
        return serviceCost;
    }

    /**
     * Retrieves the current amount owed by a member from the database based on the member ID.
     * 
     * @param memberID The ID of the member.
     * @return The current amount owed by the member.
     * @throws SQLException If an error occurs while accessing the database.
     
    private Double getCurrentAmountOwed(int memberID) throws SQLException {
        // Call the SQL function to get the current amount owed by the member
        // Implement the SQL query and connection logic here
        // ...
        Double amountOwed = null;
        try {
            String query = "SELECT amountOwed FROM Members WHERE memberID = " + memberID;
            resultSet = stmt.executeQuery(query);
            if(resultSet.next()){
                amountOwed = resultSet.getDouble("amountOwed");
            }
        } catch(SQLException e) {
            System.out.println(e);
        }
        return amountOwed;
    }

    /**
     * Updates the amount owed by a member in the database.
     * 
     * @param memberID The ID of the member.
     * @param newAmountOwed The new amount owed by the member.
     * @throws SQLException If an error occurs while accessing the database.
     
    private void updateAmountOwed(int memberID, Double newAmountOwed) throws SQLException {
        try {
        String query = "UPDATE Members SET amountOwed = amountOwed + ? WHERE memberID = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setDouble(1, newAmountOwed);
        pstmt.setInt(2, memberID);
        pstmt.executeUpdate();
        } 
        catch(SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * Requests the Provider Directory information.
     * This method should be a function call to display the Provider Directory's information,
     * which the Directory itself is calling from the QueryDatabase.
     * 
     * @return A ResponseEntity containing the file path of the Provider Directory.
     
    @PostMapping("/requestProviderDirectory")
    public ResponseEntity<String> requestProviderDirectory() {
        String filePath = "C:/path/to/provider_directory.txt"; // Replace with the actual file path

        return ResponseEntity.ok(filePath);
    }
}
 {
    */
}
