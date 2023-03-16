/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;


import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author yo
 */
public class Main {
    
    public static List selectAll(Class clazz, ResultSet rs) throws SQLException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InstantiationException {

        ArrayList ret = new ArrayList();

        Field[] fields = clazz.getFields();

        while (rs.next()) {
            Object o = clazz.newInstance();
            ret.add(o);
            for (Field f : fields) {
                String name = f.getName();
                if (f.getType().equals(String.class)) {
                    String val = rs.getString(name);
                    f.set(o, val);
                } else if (f.getType().equals(Integer.class) || f.getType().equals(int.class)) {
                    Integer val = rs.getInt(name);
                    f.set(o, val);
                } else if (f.getType().equals(Boolean.class) || f.getType().equals(boolean.class)) {
                    Boolean val = rs.getBoolean(name);
                    f.set(o, val);
                }
            }
        }
        return ret;
    }       
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root123");
              return connection;                    
    }
        
    public static void main(String[] args) throws NoSuchFieldException, SQLException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InstantiationException {
        User u = new User();

        try(Connection c = getConnection();
            ResultSet resultSet = c.createStatement().executeQuery("SELECT * FROM users");){ 
            
            List list = selectAll(User.class, resultSet); 
            System.out.println(list);
        }  
    } 
}
