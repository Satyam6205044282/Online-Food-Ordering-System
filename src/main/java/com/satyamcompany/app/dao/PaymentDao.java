package com.satyamcompany.app.dao;

        import java.util.List;
        import com.satyamcompany.app.exceptions.SystemException;
        import com.satyamcompany.app.model.Payment;

public interface PaymentDao {

    List<Payment> getAllPayment() throws SystemException;
    Payment getPaymentById(int payment_id) throws SystemException;

}

