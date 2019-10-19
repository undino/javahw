package org.itstep;

public class Office extends Development {
    private String reportOffice = "report Office division";

    @Override
    public void showReport() {
        System.out.println(reportOffice);
    }
}
