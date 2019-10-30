package org.itstep;

public class Development implements Report {
    private String reportDevelopment = "report Development subDivision";

    @Override
    public void showReport() {
        System.out.println(reportDevelopment);
    }
}
