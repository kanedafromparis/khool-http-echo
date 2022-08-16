package io.github.kandefromparis.khool;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.logging.Logger;
import java.util.stream.Collectors;

//@Path("/echoservlet")
public class EchoServlet extends HttpServlet {
    static final Logger log = Logger.getLogger("EchoServlet");
    public static final String MESSAGE = "message";

    private String message;

    @Override
    public void init(final ServletConfig config) throws ServletException {
        super.init(config);
        log.info("Start EchoServlet");
        message = config.getInitParameter(MESSAGE);
    }

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Headers:\n");

        extractedHeaders(req, sb);
        sb.append("\n");
        sb.append("Method:").append(req.getMethod()).append("\n");
        sb.append("\n");

        sb.append("URI:").append(req.getRequestURI()).append("\n");
        sb.append("\n");
        sb.append("Parameters : \n");
        extractedParameters(req, sb);
        sb.append("\n");
        sb.append("Body:").append(req.getReader().lines().collect(Collectors.joining())).append("\n");

        log.info("-------------");
        log.info(sb.toString());
        log.info("-------------");

        PrintWriter writer = resp.getWriter();
        writer.write(sb.toString());
        writer.close();
    }

    private void extractedHeaders(HttpServletRequest req, StringBuilder sb) {
        Enumeration<String> names = req.getHeaderNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            sb.append("\t").append(name).append(" : ").append(req.getHeader(name)).append("\n");
        }
    }

    private void extractedParameters(HttpServletRequest req, StringBuilder sb) {
        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            sb.append("\t").append(name).append(" : ").append(req.getParameter(name)).append("\n");
        }
    }
    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
