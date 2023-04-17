package com.satyamcompany.app.dao;

        import java.util.List;
        import com.satyamcompany.app.exceptions.SystemException;
        import com.satyamcompany.app.model.MenuType;

public interface MenuTypeDao {

    List<MenuType> getAllMenuType() throws SystemException;
    MenuType getMenuTypeById(int Menu_type_id) throws SystemException;

}
