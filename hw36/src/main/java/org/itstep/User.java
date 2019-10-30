package org.itstep;

import org.itstep.example.*;

public class User {
    public static void main(String[] args) {

        // Здесь нет реализации паттерна Композиция!!!

        // Зачем так много классов? Классов должно быть только два -
        // первый - который представляет составной объект (подразделение)
        // и второй - простой - отдел. Естественно должен быть и базовый класс

        // Пример находится в пакете example

        Unit corporation = new Branch("MS");
        corporation.add(new Branch("Dev"));
        corporation.getUnit("Dev").add(new Department("OS"));
        corporation.getUnit("Dev").add(new Department("Game"));
        corporation.getUnit("Dev").add(new Department("Office"));

        System.out.println(corporation.report());

        // Report subdivisionHh = new Hh();
        // Report subdivisionMarket = new Market();
        // Report subdivisionDevelopment = new Development();

        // Report marketSubdivisionsUsa = new Usa();
        // Report marketSubdivisionsUk = new Uk();
        // Report marketSubdivisionsEu = new Eu();

        // Report developmentSubdivisionsGame = new Game();
        // Report developmentSubdivisionsOffice = new Office();
        // Report developmentSubdivisionsOs = new Os();

        // Ms msCorporation = new Ms();

        // Ms hhSubdivisions = new Ms();
        // msCorporation.addCompany(subdivisionHh);

        // Ms marketSubdivisions = new Ms();
        // marketSubdivisions.addCompany(subdivisionMarket);
        // marketSubdivisions.addCompany(marketSubdivisionsUsa);
        // marketSubdivisions.addCompany(marketSubdivisionsUk);
        // marketSubdivisions.addCompany(marketSubdivisionsEu);

        // Ms developmentSubdivisions = new Ms();
        // developmentSubdivisions.addCompany(subdivisionDevelopment);
        // developmentSubdivisions.addCompany(developmentSubdivisionsGame);
        // developmentSubdivisions.addCompany(developmentSubdivisionsOffice);
        // developmentSubdivisions.addCompany(developmentSubdivisionsOs);

        // msCorporation.addCompany(hhSubdivisions);
        // msCorporation.addCompany(marketSubdivisions);
        // msCorporation.addCompany(developmentSubdivisions);

        // msCorporation.showReport();
    }
}
