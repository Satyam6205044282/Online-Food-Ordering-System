package com.satyamcompany.app.dao;

        import java.util.List;
        import com.satyamcompany.app.exceptions.SystemException;
        import com.satyamcompany.app.model.Rating;

public interface RatingDao {

    List<Rating> getAllRating() throws SystemException;
    Rating getRatingById(int rating_id) throws SystemException;

}  
