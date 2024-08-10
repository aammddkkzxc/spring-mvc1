package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("전체 파라미터 조회 - start");
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            System.out.println(paramName + "=" + req.getParameter(paramName));
        }
        req.getParameterNames().asIterator().forEachRemaining(name -> System.out.println(name + "= " + req.getParameter(name)));
        System.out.println("전체 파라미터 조회 - end");

        System.out.println("단일 파라미터 조회");
        String username = req.getParameter("username");
        System.out.println("request.getParameter(username) = " + username);
        String age = req.getParameter("age");
        System.out.println("request.getParameter(age) = " + age);

        System.out.println("이름이 같은 복수 파라미터 조회");
        System.out.println("request.getParameterValues(username)");
        String[] userNames = req.getParameterValues("username");
        for (String name : userNames) {
            System.out.println("username=" + name); }

        resp.getWriter().write("ok");
    }
}
