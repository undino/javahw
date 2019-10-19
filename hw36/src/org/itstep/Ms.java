package org.itstep;

import java.util.ArrayList;
import java.util.List;

public class Ms implements Report {
    private List<Report> listCompanies = new ArrayList<>();
    private Tusks tusksIterator = new Tusks(listCompanies);
    private Iterator iterator = tusksIterator.getIterator();

    public List<Report> getListCompanies() {
        return listCompanies;
    }

    void addCompany(Report company){
        listCompanies.add(company);
    }

    void removeCompany(Report company){
        listCompanies.remove(company);
    }

    @Override
    public void showReport() {
        while (iterator.hasNext()){
            iterator.next().showReport();
        }
    }
}
