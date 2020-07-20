import com.google.gson.Gson;
import controller.AlgorithmExecutor;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GraphDataServlet")
public class GraphVerticesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AlgorithmExecutor executor = new AlgorithmExecutor();
        Gson gson = new Gson();
        response.getWriter().print(gson.toJson(executor.getVertices()));
    }
}
