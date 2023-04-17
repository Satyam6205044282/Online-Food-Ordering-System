package com.satyamcompany.app.dao;

        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.List;
        import java.util.ArrayList;
        import com.satyamcompany.app.exceptions.SystemException;
        import com.satyamcompany.app.model.Payment;
        import com.satyamcompany.app.utill.DBUtil;

public class PaymentDaoImplJdbc implements PaymentDao{

    private static final String FIND_ALL_PAYMENT = "SELECT * FROM PAYMENT";
    private static final String FIND_PAYMENT_BY_ID = "SELECT * FROM PAYMENT WHERE ID=?";

    private Connection connection = null;
    public PaymentDaoImplJdbc(Connection connection) throws SystemException {
        this.connection=connection;
    }

    @Override
    public List<Payment> getAllPayment()throws SystemException{
        PreparedStatement ps= null;
        ResultSet rs= null;
        List<Payment> payments= new ArrayList<>();
        try {
            ps= connection.prepareStatement(FIND_ALL_PAYMENT);
//    Set the parameter
            rs= ps.executeQuery();
            while(rs.next()) {
//       create Payment from each row
                Payment pay = new Payment(
                        rs.getInt("payment_id"),
                        rs.getInt("order_id"),
                        rs.getFloat("final_amount"),
                        rs.getString("paid_by"),
                        rs.getString("payment_date")
                        
                );
//       Adding the Payment to the list
                payments.add(pay);

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
        return payments;
    }


    @Override
    public Payment getPaymentById(int payment_id) throws SystemException {
        PreparedStatement ps= null;
        ResultSet rs= null;
        Payment pay= null;
        try {
            ps= connection.prepareStatement(FIND_PAYMENT_BY_ID);
//    Set the parameter
            ps.setInt(1, payment_id);
            rs= ps.executeQuery();
            while (rs.next()) {
//       create Payment from each row
                pay = new Payment(
                		 rs.getInt("payment_id"),
                         rs.getInt("order_id"),
                         rs.getFloat("final_amount"),
                         rs.getString("paid_by"),
                         rs.getString("payment_date")   
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
        return pay;
    }

}
