package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleTone {
    private static final String URL="jdbc:mysql://127.0.0.1:3306/mydb";
    private static final String LOGIN="root";
    private static final String PASSWORD="root";
    private static Connection connection=null;

    private ConnectionSingleTone(){}

    public static Connection getConnection() {
        if(connection==null){
            try{
            connection= DriverManager.getConnection(URL,LOGIN,PASSWORD);
                System.out.println("���������� � �� �����������");

        }
        catch (SQLException ex){
            System.out.println("������ ���������� � ��");
            ex.printStackTrace();

        }
        }
        return connection;
    }

    public static void closeConnection() {
        if(connection!=null){
            try{
            connection.close();
                System.out.println("���������� �������");}
            catch (SQLException ex){
                System.out.println("��������� ������ �������� ����������");
                ex.printStackTrace();
            }
        }
    }
}
