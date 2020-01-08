package org.itstep.Servlets;

import org.itstep.Databases.CustomerDb;
import org.itstep.Databases.SellerDb;
import org.itstep.Databases.StoreDbConnection;
import org.itstep.Entity.Customer;
import org.itstep.Entity.Seller;

import java.util.List;
import java.util.Map;

public class DynamicPageResponse extends StoreDbConnection {

    public String customerPage(Customer customer) {
        Map map = new CustomerDb().getDate(customer);
        List<String> ordersList = new CustomerDb().getOrders(customer);

        String response = "";
        String responseStart = "<!DOCTYPE html>" + "<html lang=\"en\">" + "<head>" + "<meta charset=\"UTF-8\">"
                + "<title>Title</title>" + "<link href=\"../css/cabinet.css\" rel=\"stylesheet\">" + "</head>"
                + "<body>" + "<div id=\"header\">" + "<p>Личный кабинет</p>" + "<div id=\"inner\">"
                + "<span id=\"login\">" + map.get("login") + "</span>" + "<span id=\"amount\">" + map.get("cash")
                + "</span>" + "<form method=\"post\" action=\"store\" id=\"store\">\n"
                + "            <input type=\"submit\" value=\"Магазин\">\n"
                + "            <input type=\"text\" name=\"login_for_store\" id=\"login_for_store\" value=\""
                + map.get("login") + "\">\n"
                + "            <input type=\"text\" name=\"id_for_store\" id=\"password_for_store\" value=\""
                + map.get("id") + "\">\n"
                + "            <input type=\"text\" name=\"password_for_store\" id=\"password_for_store\" value=\""
                + map.get("password") + "\">\n" + "        </form>"
                + "<form method=\"post\" action=\"../index.html\" id=\"out\">\n"
                + "            <input type=\"submit\" value=\"Выйти\">\n" + "</form>"
                + "<form method=\"post\" action=\"../html/add_money.html\" id=\"addMoney\">\n"
                + "             <input type=\"submit\" value=\"Пополнить счет\">\n" + "</form>" + "</div>"
                + "<ol>Мои покупки:";

        String responseGenerate = "";
        for (String s : ordersList) {
            responseGenerate += "<li>" + s + "</li>";
        }
        String responseEnd = "</ol>" + "</div>" + "</body>" + "</html>";

        response = response.concat(responseStart).concat(responseGenerate).concat(responseEnd);
        return response;

    }

    public String sellerPage(Seller seller) {
        Map map = new SellerDb().getDate(seller);
        List<String> ordersList = new SellerDb().getProducts(seller);

        String response = "";
        String responseStart = "<!DOCTYPE html>" + "<html lang=\"en\">" + "<head>" + "<meta charset=\"UTF-8\">"
                + "<title>Title</title>" + "<link href=\"../css/cabinet.css\" rel=\"stylesheet\">" + "</head>"
                + "<body>" + "<div id=\"header\">" + "<p>Личный кабинет</p>" + "<div id=\"inner\">"
                + "<span id=\"login\">" + map.get("login") + "</span>" + "<span id=\"amount\">" + map.get("cash")
                + "</span>" + "<form method=\"post\" action=\"../index.html\" id=\"out\">\n"
                + "            <input type=\"submit\" value=\"Выйти\">\n" + "        </form>" + "</div>"
                + "<ol>Мои товары:";

        String responseGenerate = "";
        for (String s : ordersList) {
            responseGenerate += "<li>" + s + "</li>";
        }
        String responseEnd = "</ol>" + "    <form action=\"addProduct\" method=\"post\" id=\"addProduct\">\n"
                + "        <div>ДОБАВИТЬ ЗАКАЗ</div>\n" + "        <label> Тип товара:\n"
                + "        <input type=\"text\" name=\"type\" id=\"typeProduct\" placeholder=\"тип\"><br>\n"
                + "        </label>\n" + "        <label>Название:\n"
                + "        <input type=\"text\" name=\"title\" id=\"titleProduct\" placeholder=\"Название\"><br>\n"
                + "        </label>\n" + "        <label>Количество:\n"
                + "        <input type=\"text\" name=\"quantity\" id=\"quantityProduct\" placeholder=\"quantity\"><br>\n"
                + "        </label>\n" + "        <label>Стоимость еденици:\n"
                + "        <input type=\"text\" name=\"price\" id=\"priceProduct\" placeholder=\"price\"><br>\n"
                + "        </label>\n" + "        <input value=\"" + map.get("id")
                + "\" type=\"text\" name=\"seller_id\" id=\"seller_loginProduct\"><br>\n"
                + "        <input type=\"submit\" value=\"Добавить заказ\">\n" + "    </form>" + "</div>" + "</body>"
                + "</html>";

        response = response.concat(responseStart).concat(responseGenerate).concat(responseEnd);
        return response;

    }
}
