package com.zxk.controller;

import com.zxk.domain.Student;
import com.zxk.domain.User;
import com.zxk.service.StudentService;
import com.zxk.service.StudentServiceImpl;
import com.zxk.service.UserService;
import com.zxk.service.UserServiceImpl;
import com.zxk.utils.UUIDUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @program: StudentManagerMyBatis
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-13 11:46
 **/
@WebServlet("/stu")
public class NewMServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String action = req.getParameter("action");
        System.out.println(action);
        if ("login".equals(action)) {
            login(req, resp);
        } else if ("selectAll".equals(action)) {
            selectAll(req, resp);
        } else if ("delete".equals(action)) {
            delete(req, resp);
        } else if ("toUpdate".equals(action)) {
            toUpdate(req, resp);
        } else if ("update".equals(action)) {
            update(req, resp);
        } else if ("insert".equals(action)) {
            insert(req, resp);
        } else if ("conditions".equals(action)) {
            selectConditions(req, resp);
        } else if ("toRegist".equals(action)) {
            roRegist(req, resp);
        } else if ("regist".equals(action)) {
            regist(req, resp);
        }
    }

    private void regist(HttpServletRequest req, HttpServletResponse resp) {
        User user = new User();
        Map<String, String[]> pm = req.getParameterMap();

        try {
            DateConverter converter = new DateConverter();
            converter.setPattern("yyyy-MM-dd");
            ConvertUtils.register(converter, Date.class);
            BeanUtils.populate(user, pm);
            Integer i=userService.insert(user);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void roRegist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("uid", UUIDUtils.getUUID32());
        req.setAttribute("ucode", UUIDUtils.getUUID32());
        req.getRequestDispatcher("regist.jsp").forward(req, resp);
    }

    private void selectConditions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name") + "%";
        String score = req.getParameter("score") + "%";
        List<Student> studentList = studentService.selectConditions(name, score);
        req.setAttribute("studentList", studentList);
        req.getRequestDispatcher("selectAll.jsp").forward(req, resp);
    }

    private void insert(HttpServletRequest req, HttpServletResponse resp) {
        Student student = new Student();
        Map<String, String[]> pm = req.getParameterMap();
        try {
            //在BeanUtils中，默认支持的格式转化是 yyyy-MM-dd字符串到 java.sql.Date的转换
            //支持 yyyy-MM-dd格式字符串到 java.util.Date的自动转换
            DateConverter converter = new DateConverter();
            converter.setPattern("yyyy-MM-dd");
            ConvertUtils.register(converter, Date.class);
            BeanUtils.populate(student, pm);
            Integer i = studentService.insert(student);
            selectAll(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) {
        Student student = new Student();
        Map<String, String[]> pm = req.getParameterMap();
        try {
            //在BeanUtils中，默认支持的格式转化是 yyyy-MM-dd字符串到 java.sql.Date的转换
            //支持 yyyy-MM-dd格式字符串到 java.util.Date的自动转换
            DateConverter converter = new DateConverter();
            converter.setPattern("yyyy-MM-dd");
            ConvertUtils.register(converter, Date.class);
            BeanUtils.populate(student, pm);
            Integer i = studentService.update(student);
            selectAll(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void toUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        Student student = studentService.selectByID(id);
        req.setAttribute("student", student);
        req.getRequestDispatcher("update.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        Integer i = studentService.delete(id);
        selectAll(req, resp);
    }

    @Test
    public void ssTest(){
        List<Student> studentList = studentService.selectAll();
        System.out.println(studentList);
    }
    private void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> studentList = studentService.selectAll();
        req.setAttribute("studentList", studentList);
        req.getRequestDispatcher("selectAll.jsp").forward(req, resp);
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginname = req.getParameter("loginname");
        String password = req.getParameter("password");
        Boolean res = userService.login(loginname, password);
        if (res) {
            req.getSession().setAttribute("loginname", loginname);
            resp.sendRedirect(getServletContext().getContextPath()+"/index.jsp");
            //req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            req.setAttribute("errorMsg", "账号或密码错误");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
