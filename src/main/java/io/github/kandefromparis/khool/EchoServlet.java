package io.github.kandefromparis.khool;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Enumeration;
import java.util.logging.Logger;
import java.util.stream.Collectors;

// Path is define in resources/META-INF/web.xml
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

        Collections.list(req.getHeaderNames()).forEach(name -> {sb.append("\t").append(name).append(" : ").append(req.getParameter(name)).append("\n");});
        sb.append("\n");
        sb.append("Method:").append(req.getMethod()).append("\n");
        sb.append("\n");

        sb.append("URI:").append(req.getRequestURI()).append("\n");
        sb.append("\n");
        sb.append("Parameters : \n");
        Collections.list(req.getParameterNames()).forEach(name -> {sb.append("\t").append(name).append(" : ").append(req.getParameter(name)).append("\n");});
        sb.append("\n");
        sb.append("Body:").append(req.getReader().lines().collect(Collectors.joining())).append("\n");

        log.info("-------------");
        log.info(sb.toString());
        log.info("-------------");

        PrintWriter writer = resp.getWriter();
        writer.write(sb.toString());
        writer.close();
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
