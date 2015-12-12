import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.*;


public class CalcServlet extends HttpServlet { // ������� ����������� �����������

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Math math = new Math();
        // �������� ������ �� ������������
        String first = req.getParameter("firstNumber");
        String second = req.getParameter("secondNumber");
        String operation = req.getParameter("operation");
        try {
            req.setAttribute("res", String.valueOf(math.getResult(Integer.parseInt(first), Integer.parseInt(second), operation))); // ��������� ��������
            req.setAttribute("f", first);
            req.setAttribute("s", second);
        }
        catch (Exception e){
            System.out.println("Enter number!");
        }

        req.getRequestDispatcher("index.jsp").forward(req, resp); // ���������� �������� ������������
    }
}
