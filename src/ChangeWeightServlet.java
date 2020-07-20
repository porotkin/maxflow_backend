import com.google.gson.Gson;
import controller.AlgorithmExecutor;
import controller.FileIO;
import model.GraphRelationsObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangeWeightServlet")
public class ChangeWeightServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson = new Gson();
        GraphRelationsObject relation = gson.fromJson(request.getReader().readLine(), GraphRelationsObject.class);
        AlgorithmExecutor executor = new AlgorithmExecutor();
        var newList = executor.getChangedRelationsList(relation);
        FileIO.writeDataToFile(FileIO.CATALINA_HOME + "relations.json", newList);
        response.getWriter().print("Success");
    }
}
