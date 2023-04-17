package com.satyamcompany.app.dao;

        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.List;
        import java.util.ArrayList;
        import com.satyamcompany.app.exceptions.SystemException;
        import com.satyamcompany.app.model.Rating;
        import com.satyamcompany.app.utill.DBUtil;

public class RatingDaoImplJdbc implements RatingDao{

    private static final String FIND_ALL_RATING = "SELECT * FROM RATING";
    private static final String FIND_RATING_BY_ID = "SELECT * FROM RATING WHERE ID=?";

    private Connection connection = null;
    public RatingDaoImplJdbc(Connection connection) throws SystemException {
        this.connection=connection;
    }

    @Override
    public List<Rating> getAllRating()throws SystemException{
        PreparedStatement ps= null;
        ResultSet rs= null;
        List<Rating> ratings= new ArrayList<>();
        try {
            ps= connection.prepareStatement(FIND_ALL_RATING);
//    Set the parameter
            rs= ps.executeQuery();
            while(rs.next()) {
//       create rating from each row
                Rating rate = new Rating(
                        rs.getInt("rating_id"),
                        rs.getInt("menu_id"),
                        rs.getInt("rate"),
                        rs.getString("feedback"),
                        rs.getString("date_recorded"),
                        rs.getInt("customer_id")                       
                );
//       Adding the rating to the list
                ratings.add(rate);

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
        return ratings;
    }


    @Override
    public Rating getRatingById(int rating_id) throws SystemException {
        PreparedStatement ps= null;
        ResultSet rs= null;
        Rating rate= null;
        try {
            ps= connection.prepareStatement(FIND_RATING_BY_ID);
//    Set the parameter
            ps.setInt(1, rating_id);
            rs= ps.executeQuery();
            while (rs.next()) {
//       create rate from each row
                rate = new Rating(
                		 rs.getInt("rating_id"),
                         rs.getInt("menu_id"),
                         rs.getInt("rate"),
                         rs.getString("feedback"),
                         rs.getString("date_recorded"),
                         rs.getInt("customer_id")  
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
        return rate;
    }

}
