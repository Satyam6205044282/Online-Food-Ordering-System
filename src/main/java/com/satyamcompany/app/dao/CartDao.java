package com.satyamcompany.app.dao;

        import java.util.List;
        import com.satyamcompany.app.exceptions.SystemException;
        import com.satyamcompany.app.model.Cart;

public interface CartDao {

    List<Cart> getAllCart() throws SystemException;
    Cart getCartById(int cart_id) throws SystemException;

}
