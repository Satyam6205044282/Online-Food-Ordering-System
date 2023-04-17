package com.satyamcompany.app.dao;

        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.List;
        import java.util.ArrayList;
        import com.satyamcompany.app.exceptions.SystemException;
        import com.satyamcompany.app.model.Menu;
        import com.satyamcompany.app.utill.DBUtil;

public class MenuDaoImplJdbc implements MenuDao{

    private static final String FIND_ALL_MENU = "SELECT * FROM MENU";
    private static final String FIND_MENU_BY_ID = "SELECT * FROM MENU WHERE ID=?";

    private Connection connection = null;
    public MenuDaoImplJdbc(Connection connection) throws SystemException {
        this.connection=connection;
    }

    @Override
    public List<Menu> getAllMenu()throws SystemException{
        PreparedStatement ps= null;
        ResultSet rs= null;
        List<Menu> menus= new ArrayList<>();
        try {
            ps= connection.prepareStatement(FIND_ALL_MENU);
//    Set the parameter
            rs= ps.executeQuery();
            while(rs.next()) {
//       create menu from each row
                Menu mn = new Menu(
                        rs.getInt("menu_id"),
                        rs.getString("menu_name"),
                        rs.getFloat("price"),
                        rs.getInt("menu_type_id")                      
                );
//       Adding the menu to the list
                menus.add(mn);

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
        return menus;
    }


    @Override
    public Menu getMenuById(int menu_id) throws SystemException {
        PreparedStatement ps= null;
        ResultSet rs= null;
        Menu mn= null;
        try {
            ps= connection.prepareStatement(FIND_MENU_BY_ID);
//    Set the parameter
            ps.setInt(1, menu_id);
            rs= ps.executeQuery();
            while (rs.next()) {
//       create customer from each row
                mn = new Menu(
                		 rs.getInt("menu_id"),
                         rs.getString("menu_name"),
                         rs.getFloat("price"),
                         rs.getInt("menu_type_id")                      
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
        return mn;
    }

}
