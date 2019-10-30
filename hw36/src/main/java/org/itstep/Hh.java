package org.itstep;

public class Hh implements Report{
    private String reportDevelopment = "report Hh subDivision";

    @Override
    public void showReport() {
        System.out.println(reportDevelopment);
    }
}
