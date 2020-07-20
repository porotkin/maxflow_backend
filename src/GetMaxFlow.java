import controller.AlgorithmExecutor;
import controller.FlowCounter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GetMaxFlow")
public class GetMaxFlow extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AlgorithmExecutor executor = new AlgorithmExecutor();
        response.getWriter().print(executor.execute());
    }
}
