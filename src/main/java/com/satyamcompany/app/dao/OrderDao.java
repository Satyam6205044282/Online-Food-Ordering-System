package com.satyamcompany.app.dao;

        import java.util.List;
        import com.satyamcompany.app.exceptions.SystemException;
        import com.satyamcompany.app.model.Order;

public interface OrderDao {

    List<Order> getAllOrder() throws SystemException;
    Order getOrderById(int Order_id) throws SystemException;

}

