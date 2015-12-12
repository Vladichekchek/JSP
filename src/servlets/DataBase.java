package servlets;

import com.mysql.jdbc.*;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import employee.Employee;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


// ���� ����� ��������� ����������� � ���� ������ � ���������� � ��� �������� ��������

public class DataBase {
    private MysqlDataSource mysqlDataSource;
    private static Logger log = Logger.getLogger(DataBase.class.getName());
    public DataBase()  // ���������������� �����������
    {
        mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setDatabaseName("scott");
        mysqlDataSource.setPassword("");
        mysqlDataSource.setPort(3306);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setServerName("localhost");
        mysqlDataSource.setRetainStatementAfterResultSetClose(true);
    }

    public Connection getConnection() { // ��������� ���������� � ����� ������
        Connection connection = null;
        try {
          connection = mysqlDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public List<Employee> searchEmpById(int id){ // ����� ���������� �� �� �������
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        List<Employee> employees = new ArrayList<>();
        Employee employee = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM EMP WHERE EMPNO = ?"); // ����������� sql - ������
            preparedStatement.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        ResultSet resultSet = null;

        try {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){ // ���������� ������� ������ �� ������ ���� ������
                employee = new Employee();
                employee.setNumber(resultSet.getInt("EMPNO"));
                employee.setName(resultSet.getString("ENAME"));
                employee.setJob(resultSet.getString("JOB"));
                employee.setMgr(resultSet.getInt("MGR"));
                employee.setHiredate(resultSet.getDate("HIREDATE"));
                employee.setSalary(resultSet.getInt("SAL"));
                employee.setComm(resultSet.getInt("COMM"));
                employee.setDeptno(resultSet.getInt("DEPTNO"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return employees;
    }


    public List<Employee> searchEmpByName(String name)  { // ����� ���������� �� �� �������
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        List<Employee> employees = new ArrayList<>();
        Employee employee = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM EMP WHERE ENAME = ?");
            preparedStatement.setString(1, name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSet = null;

        try {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                employee = new Employee();
                employee.setNumber(resultSet.getInt("EMPNO"));
                employee.setName(resultSet.getString("ENAME"));
                employee.setJob(resultSet.getString("JOB"));
                employee.setMgr(resultSet.getInt("MGR"));
                employee.setHiredate(resultSet.getDate("HIREDATE"));
                employee.setSalary(resultSet.getInt("SAL"));
                employee.setComm(resultSet.getInt("COMM"));
                employee.setDeptno(resultSet.getInt("DEPTNO"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
                log.info("Connection close!"); // ����������� ���������� � ����� ������
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return employees;
    }

    public List<Employee> getAllEmp(){ // ������� ���� �����������
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        List<Employee> employees = new ArrayList<>();
        Employee employee = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM EMP");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        ResultSet resultSet = null;

        try {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                employee = new Employee();
                employee.setNumber(resultSet.getInt("EMPNO"));
                employee.setName(resultSet.getString("ENAME"));
                employee.setJob(resultSet.getString("JOB"));
                employee.setMgr(resultSet.getInt("MGR"));
                employee.setHiredate(resultSet.getDate("HIREDATE"));
                employee.setSalary(resultSet.getInt("SAL"));
                employee.setComm(resultSet.getInt("COMM"));
                employee.setDeptno(resultSet.getInt("DEPTNO"));
                employees.add(employee);
            }

            //employees.get(0).getName();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return employees;
    }

}
