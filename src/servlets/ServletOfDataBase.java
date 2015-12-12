package servlets;

import checker.CheckNumeric;
import employee.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;


public class ServletOfDataBase extends HttpServlet { // �������, ������� ����� ������������ ������� ������������ �� ������� ������ �� ��

    private static Logger log = Logger.getLogger(ServletOfDataBase.class.getName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { // ����������� ��� get �������
        HttpSession session = req.getSession(); // �������� ������, ������� ����������, ���� ���������� ��������� � ������
        DataBase dataBase = new DataBase(); // ������ ������� ����� �������� � ��
        List<Employee> employees = dataBase.getAllEmp();// �������� ���� �����������
        String parameter = req.getParameter("value"); // �������� ������ �� ������� ������������
        String show = req.getParameter("show");
        String showAll = req.getParameter("showAll");


        if (showAll != null &&  showAll.equals("show all")) {
            employees = dataBase.getAllEmp();
        }

        if (show != null && show.equals("show")) {
            if (parameter != null) {
                if (CheckNumeric.isDigit(parameter)) employees = dataBase.searchEmpById(Integer.parseInt(parameter));
                else employees = dataBase.searchEmpByName(parameter);
            }
        }

        session.setAttribute("employees", employees); // ���������� � ������ ���������, ������� ������ � ��� �� ��
        session.setAttribute("par", parameter);

        req.getRequestDispatcher("emp.jsp").forward(req, resp); // ���������� ������������ �������� � ���������� ����� ����������� � �����������



    }
}
