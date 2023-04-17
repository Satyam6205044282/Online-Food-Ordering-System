package com.satyamcompany.app.dao;

        import java.util.List;
        import com.satyamcompany.app.exceptions.SystemException;
        import com.satyamcompany.app.model.Customer;

public interface CustomerDao {

    List<Customer> getAllCustomer() throws SystemException;
    Customer getCustomerById(int customer_id) throws SystemException;

}



