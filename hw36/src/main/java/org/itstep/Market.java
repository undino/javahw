package org.itstep;

public class Market implements Report {
    private String reportDevelopment = "report Market subDivision";

    @Override
    public void showReport() {
        System.out.println(reportDevelopment);
    }
}
