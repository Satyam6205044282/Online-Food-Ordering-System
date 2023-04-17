package com.satyamcompany.app.dao;

        import java.util.List;
        import com.satyamcompany.app.exceptions.SystemException;
        import com.satyamcompany.app.model.Menu;

public interface MenuDao {

    List<Menu> getAllMenu() throws SystemException;
    Menu getMenuById(int menu_id) throws SystemException;

}
