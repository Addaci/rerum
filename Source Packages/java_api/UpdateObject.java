
package java_api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bhaberbe
 */
public class UpdateObject extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            URL postUrl = new URL(Java_Constants.ANNOTATION_SERVER_ADDR + "/anno/updateAnnotation.action");
            HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); //ideally this would be json, but the Servlet.action is not expecting it. 
            connection.connect();
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            //TODO value to save
            out.writeBytes("content=" + URLEncoder.encode(request.getParameter("content"), "utf-8"));
            out.flush();
            out.close(); // flush and close
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
            String line="";
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null){
                //line = new String(line.getBytes(), "utf-8");  
                //System.out.println(line);
                sb.append(line);
            }
            reader.close();
            connection.disconnect();
            response.setStatus(HttpServletResponse.SC_OK);
            response.setHeader("Content-Location", "absoluteURI");
            response.getWriter().print(sb.toString());
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Unsupported encoding exception.");
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.toString());
            response.getWriter().print(ex);
        } catch (IOException ex) {
            System.out.println("IO exception.");
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.toString());
            response.getWriter().print(ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Update an existing object in the data store.  *NOTE: This is a pure update and will not perform 'set' operations because of the Servlet.action being used.  Only key:value pairs that already"
                + "exist on the object will be updated.  All other key:value pairs will be ignored.";
    }

}
