package com.satyamcompany.app.dao;

        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.List;
        import java.util.ArrayList;
        import com.satyamcompany.app.exceptions.SystemException;
        import com.satyamcompany.app.model.Order;
        import com.satyamcompany.app.utill.DBUtil;

public class OrderDaoImplJdbc implements OrderDao{

    private static final String FIND_ALL_ORDER = "SELECT * FROM `ORDER`";
    private static final String FIND_ORDER_BY_ID = "SELECT * FROM ORDER WHERE ID=?";

    private Connection connection = null;
    public OrderDaoImplJdbc(Connection connection) throws SystemException {
        this.connection=connection;
    }

    @Override
    public List<Order> getAllOrder()throws SystemException{
        PreparedStatement ps= null;
        ResultSet rs= null;
        List<Order> orders= new ArrayList<>();
        try {
            ps= connection.prepareStatement(FIND_ALL_ORDER);
//    Set the parameter
            rs= ps.executeQuery();
            while(rs.next()) {
//       create order from each row
                Order ord = new Order(
                		rs.getInt("order_id"),
                        rs.getInt("customer_id"),
                        rs.getString("order_date"),
                        rs.getString("total_amount")
                       );
//       Adding the customer to the list
                orders.add(ord);

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
        return orders;
    }


    @Override
    public Order getOrderById(int order_id) throws SystemException {
        PreparedStatement ps= null;
        ResultSet rs= null;
        Order ord= null;
        try {
            ps= connection.prepareStatement(FIND_ORDER_BY_ID);
//    Set the parameter
            ps.setInt(1, order_id);
            rs= ps.executeQuery();
            while (rs.next()) {
//       create order from each row
                ord = new Order(
                		rs.getInt("order_id"),
                        rs.getInt("customer_id"),
                        rs.getString("order_date"),
                        rs.getString("total_amount")
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
        return ord;
    }

}
