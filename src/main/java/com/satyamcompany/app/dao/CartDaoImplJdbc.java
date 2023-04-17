package com.satyamcompany.app.dao;

        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.List;
        import java.util.ArrayList;
        import com.satyamcompany.app.exceptions.SystemException;
        import com.satyamcompany.app.model.Cart;
        import com.satyamcompany.app.utill.DBUtil;

public class CartDaoImplJdbc implements CartDao{

    private static final String FIND_ALL_CART = "SELECT * FROM `CART`";
    private static final String FIND_CART_BY_ID = "SELECT * FROM CART WHERE ID=?";

    private Connection connection = null;
    public CartDaoImplJdbc(Connection connection) throws SystemException {
        this.connection=connection;
    }

    @Override
    public List<Cart> getAllCart()throws SystemException{
        PreparedStatement ps= null;
        ResultSet rs= null;
        List<Cart> cart= new ArrayList<>();
        try {
            ps= connection.prepareStatement(FIND_ALL_CART);
//    Set the parameter
            rs= ps.executeQuery();
            while(rs.next()) {
//       create order from each row
                Cart crt = new Cart(
                		rs.getInt("cart_id"),
                        rs.getInt("customer_id"),
                        rs.getInt("menu_id"),
                        rs.getFloat("price"),
                        rs.getInt("quantity"),
                        rs.getFloat("total_amount")
                );
//       Adding the order details to the list
                cart.add(crt);

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
        return cart;
    }


    @Override
    public Cart getCartById(int cart_id) throws SystemException {
        PreparedStatement ps= null;
        ResultSet rs= null;
        Cart crt= null;
        try {
            ps= connection.prepareStatement(FIND_CART_BY_ID);
//    Set the parameter
            ps.setInt(1, cart_id);
            rs= ps.executeQuery();
            while (rs.next()) {
//       create order from each row
                crt = new Cart(
                		rs.getInt("cart_id"),
                        rs.getInt("customer_id"),
                        rs.getInt("menu_id"),
                        rs.getFloat("price"),
                        rs.getInt("quantity"),
                        rs.getFloat("total_amount")
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
        return crt;
    }

}
