package com.satyamcompany.app.dao;

        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.List;
        import java.util.ArrayList;
        import com.satyamcompany.app.exceptions.SystemException;
        import com.satyamcompany.app.model.Customer;
        import com.satyamcompany.app.utill.DBUtil;

public class CustomerDaoImplJdbc implements CustomerDao{

    private static final String FIND_ALL_CUSTOMER = "SELECT * FROM CUSTOMER";
    private static final String FIND_CUSTOMER_BY_ID = "SELECT * FROM CUSTOMER WHERE ID=?";

    private Connection connection = null;
    public CustomerDaoImplJdbc(Connection connection) throws SystemException {
        this.connection=connection;
    }

    @Override
    public List<Customer> getAllCustomer()throws SystemException{
        PreparedStatement ps= null;
        ResultSet rs= null;
        List<Customer> customers= new ArrayList<>();
        try {
            ps= connection.prepareStatement(FIND_ALL_CUSTOMER);
//    Set the parameter
            rs= ps.executeQuery();
            while(rs.next()) {
//       create customer from each row
                Customer cust = new Customer(
                        rs.getInt("customer_id"),
                        rs.getString("customer_first_name"),
                        rs.getString("customer_last_name"),
                        rs.getString("customer_email"),
                        rs.getString("customer_phone_number"),
                        rs.getString("customer_username"),
                        rs.getString("customer_password"),
                        rs.getInt("account_status")       
                );
//       Adding the customer to the list
                customers.add(cust);

            }
        }catch(Exception e) {
//    Log
            throw new SystemException(e.getMessage());
        }finally {
            try {

                if(ps!=null)
                    ps.close();
                if(rs!=null)
                    rs.close();
            }catch(SQLException e) {
//    Log
                throw new SystemException(e.getMessage());
            }
        }
        return customers;
    }


    @Override
    public Customer getCustomerById(int customer_id) throws SystemException {
        PreparedStatement ps= null;
        ResultSet rs= null;
        Customer cust= null;
        try {
            ps= connection.prepareStatement(FIND_CUSTOMER_BY_ID);
//    Set the parameter
            ps.setInt(1, customer_id);
            rs= ps.executeQuery();
            while (rs.next()) {
//       create customer from each row
                cust = new Customer(
                		rs.getInt("customer_id"),
                        rs.getString("customer_first_name"),
                        rs.getString("customer_last_name"),
                        rs.getString("customer_email"),
                        rs.getString("customer_phone_number"),
                        rs.getString("customer_username"),
                        rs.getString("customer_password"),
                        rs.getInt("account_status")      
                );

            }
        }catch(Exception e) {
//    Log
            throw new SystemException(e.getMessage());
        }finally {
            try {
                ps.close();
                rs.close();
            }catch(SQLException e) {
//    Log
                throw new SystemException(e.getMessage());
            }
        }
        return cust;
    }

}
