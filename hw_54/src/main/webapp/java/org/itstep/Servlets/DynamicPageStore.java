package org.itstep.Servlets;

import org.itstep.Databases.ProductDb;
import org.itstep.Entity.Product;

import java.util.List;

public class DynamicPageStore {
    private String store = "";
    private List<Product> listProduct = new ProductDb().getAllProduct();

    public String allProducts(int customerId, String login, String password) {

        String startPage = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Store</title>\n" +
                "    <link href=\"../css/store.css\" rel=\"stylesheet\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<div id=\"menu\">\n" +
                "    <p>СПИСОК ТОВАРОВ</p>\n" +
                "\n" +
                "</div>\n" +
                "<ol>\n" +
                "    <li>ТИП</li>\n" +
                "    <li>МОДЕЛЬ</li>\n" +
                "    <li>ЦЕНА</li>\n" +
                "</ol>";

        String dynamicPage = "";

        for (Product p : listProduct) {
            dynamicPage += "<div>\n" +
                    "    <form action=\"transaction\" method=\"post\" id=\"buyProducts\">\n" +
                    "    <ol>\n" +
                    "        <li>" + p.getType() + "</li>\n" +
                    "        <li>" + p.getTitle() + "</li>\n" +
                    "        <li>" + p.getPrice() + "</li>\n" +
                    "    </ol>\n" +
                    "    <input class=\"inputData\" name=\"customerId\" type=\"number\" value=\"" + customerId + "\">\n" +
                    "    <input class=\"inputData\" name=\"sellerId\" type=\"number\" value=\"" + p.getSellerId() + "\">\n" +
                    "    <input class=\"inputData\" name=\"productId\" type=\"number\" value=\"" + p.getId() + "\">\n" +
                    "    <input class=\"inputData\" name=\"login_for_store\" type=\"text\" value=\"" + login + "\">\n" +
                    "    <input class=\"inputData\" name=\"password_for_store\" type=\"text\" value=\"" + password + "\">\n" +
                    "    <input type=\"submit\" value=\"КУПИТЬ\">\n" +
                    "</form>\n" +
                    "</div>";
        }

        String endPage = "</body>\n" +
                "</html>";

        store = store.concat(startPage).concat(dynamicPage).concat(endPage);

        return store;
    }
}
