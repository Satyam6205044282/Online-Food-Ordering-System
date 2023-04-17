package com.satyamcompany.app.dao;

        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.List;
        import java.util.ArrayList;
        import com.satyamcompany.app.exceptions.SystemException;
        import com.satyamcompany.app.model.MenuType;
        import com.satyamcompany.app.utill.DBUtil;

public class MenuTypeDaoImplJdbc implements MenuTypeDao{

    private static final String FIND_ALL_MENU_TYPE = "SELECT * FROM `MENU-TYPE`";
    private static final String FIND_MENU_TYPE_BY_ID = "SELECT * FROM `MENU-TYPE` WHERE ID=?";

    private Connection connection = null;
    public MenuTypeDaoImplJdbc(Connection connection) throws SystemException {
        this.connection=connection;
    }

    @Override
    public List<MenuType> getAllMenuType()throws SystemException{
        PreparedStatement ps= null;
        ResultSet rs= null;
        List<MenuType> menuTypes= new ArrayList<>();
        try {
            ps= connection.prepareStatement(FIND_ALL_MENU_TYPE);
//    Set the parameter
            rs= ps.executeQuery();
            while(rs.next()) {
//       create menu-type from each row
                MenuType mt = new MenuType(
                        rs.getInt("menu_type_id"),
                        rs.getString("type_name"),
                        rs.getString("description")
                );
//       Adding the menu-type to the list
                menuTypes.add(mt);

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
        return menuTypes;
    }


    @Override
    public MenuType getMenuTypeById(int menu_type_id) throws SystemException {
        PreparedStatement ps= null;
        ResultSet rs= null;
        MenuType mt= null;
        try {
            ps= connection.prepareStatement(FIND_MENU_TYPE_BY_ID);
//    Set the parameter
            ps.setInt(1, menu_type_id);
            rs= ps.executeQuery();
            while (rs.next()) {
//       create customer from each row
                mt = new MenuType(
                		rs.getInt("menu_type_id"),
                        rs.getString("type_name"),
                        rs.getString("description")
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
        return mt;
    }

}
