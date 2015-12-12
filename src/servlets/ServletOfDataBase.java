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


public class ServletOfDataBase extends HttpServlet { // Сервлет, который будет обрабатывать запросы пользователя на выборку данных из бд

    private static Logger log = Logger.getLogger(ServletOfDataBase.class.getName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { // Срабатывает при get запросе
        HttpSession session = req.getSession(); // Создаётся сессия, которая существует, пока существует программа в памяти
        DataBase dataBase = new DataBase(); // Объект который будет работать с бд
        List<Employee> employees = dataBase.getAllEmp();// выбираем всех сотрудников
        String parameter = req.getParameter("value"); // Получаем данные из запроса пользователя
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

        session.setAttribute("employees", employees); // Записываем в сессию результат, который пришёл к нам из БД
        session.setAttribute("par", parameter);

        req.getRequestDispatcher("emp.jsp").forward(req, resp); // Показываем пользователю страницу с полученной ранее информацией о сотрудниках



    }
}
