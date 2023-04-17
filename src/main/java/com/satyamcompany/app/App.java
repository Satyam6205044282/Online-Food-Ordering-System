package com.satyamcompany.app;


import com.satyamcompany.app.dao.CustomerDao;
import com.satyamcompany.app.dao.CustomerDaoImplJdbc;
import com.satyamcompany.app.dao.MenuDao;
import com.satyamcompany.app.dao.MenuDaoImplJdbc;
import com.satyamcompany.app.dao.MenuTypeDao;
import com.satyamcompany.app.dao.MenuTypeDaoImplJdbc;
import com.satyamcompany.app.dao.OrderDao;
import com.satyamcompany.app.dao.OrderDaoImplJdbc;
import com.satyamcompany.app.dao.CartDao;
import com.satyamcompany.app.dao.CartDaoImplJdbc;
import com.satyamcompany.app.dao.PaymentDao;
import com.satyamcompany.app.dao.PaymentDaoImplJdbc;
import com.satyamcompany.app.dao.RatingDao;
import com.satyamcompany.app.dao.RatingDaoImplJdbc;
import com.satyamcompany.app.exceptions.SystemException;
import com.satyamcompany.app.utill.DBUtil;

public class App{
    public static void main(String[] args) {
        System.out.println("Start of Main");
        
        System.out.println("\n---CUSTOMER---");

        try {
            CustomerDao dao= new CustomerDaoImplJdbc(DBUtil.getConnection());
            dao.getAllCustomer().forEach(e-> System.out.println(e));
        }catch (SystemException e) {

            e.printStackTrace();
        }
        
        System.out.println("\n---MENU---");

        try {
            MenuDao dao= new MenuDaoImplJdbc(DBUtil.getConnection());
            dao.getAllMenu().forEach(e-> System.out.println(e));
        }catch (SystemException e) {

            e.printStackTrace();
        }
        
        
        System.out.println("\n---MENU TYPE---");
        try {
            MenuTypeDao dao= new MenuTypeDaoImplJdbc(DBUtil.getConnection());
            dao.getAllMenuType().forEach(e-> System.out.println(e));
        }catch (SystemException e) {

            e.printStackTrace();
        }
        

        System.out.println("\n---ORDER---");

        try {
            OrderDao dao= new OrderDaoImplJdbc(DBUtil.getConnection());
            dao.getAllOrder().forEach(e-> System.out.println(e));
        }catch (SystemException e) {

            e.printStackTrace();
        }
        
        
        System.out.println("\n---CART-DETAILS---");

        try {
            CartDao dao= new CartDaoImplJdbc(DBUtil.getConnection());
            dao.getAllCart().forEach(e-> System.out.println(e));
        }catch (SystemException e) {

            e.printStackTrace();
        }
        
        
        System.out.println("\n---PAYMENT---");

        try {
            PaymentDao dao= new PaymentDaoImplJdbc(DBUtil.getConnection());
            dao.getAllPayment().forEach(e-> System.out.println(e));
        }catch (SystemException e) {

            e.printStackTrace();
        }
        
        
        System.out.println("\n---RATING---");

        try {
            RatingDao dao= new RatingDaoImplJdbc(DBUtil.getConnection());
            dao.getAllRating().forEach(e-> System.out.println(e));
        }catch (SystemException e) {

            e.printStackTrace();
        }
        
        
        System.out.println("End of Main");
    }
}
