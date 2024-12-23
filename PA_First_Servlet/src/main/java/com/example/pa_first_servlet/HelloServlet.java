package com.example.pa_first_servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    static final String TEMPLATE = "<html>" +  //як константа додаємо HTML-шаблон
            "<head><title>com.example.pa_first_servlet</title></head>" + //HTML-документ, далі %s - змінна,
            "<body><h1>Привіт, %s</h1></body></html>"; //модифікатор від String.format() для конкатенації рядка
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException { //перевизначаємо метод
        //doPost, щоб наші дані не були видні в URL
        String name = req.getParameter("name"); //створюємо змінну для доступу до параметра запиту
        //і отримуємо значення за назвою параметра

        resp.setContentType("text/html"); //для відповіді встановлюємо тип контенту - text/html
        PrintWriter printWriter = resp.getWriter(); //створюємо PrintWriter для запису даних (в нашому випадку тексту)
        printWriter.println(String.format(TEMPLATE, name)); //і виводимо клієнту на екран
    }
}
