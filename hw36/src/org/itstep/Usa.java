package org.itstep;

public class Usa extends Market {
    private String reportUsa = "report Usa division";

    @Override
    public void showReport() {
        System.out.println(reportUsa);
    }
}
