package org.itstep;

public class User {
    public static void main(String[] args) {
        Report subdivisionHh = new Hh();
        Report subdivisionMarket = new Market();
        Report subdivisionDevelopment = new Development();

        Report marketSubdivisionsUsa = new Usa();
        Report marketSubdivisionsUk = new Uk();
        Report marketSubdivisionsEu = new Eu();

        Report developmentSubdivisionsGame = new Game();
        Report developmentSubdivisionsOffice = new Office();
        Report developmentSubdivisionsOs = new Os();

        Ms msCorporation = new Ms();

        Ms hhSubdivisions = new Ms();
        msCorporation.addCompany(subdivisionHh);

        Ms marketSubdivisions = new Ms();
        marketSubdivisions.addCompany(subdivisionMarket);
        marketSubdivisions.addCompany(marketSubdivisionsUsa);
        marketSubdivisions.addCompany(marketSubdivisionsUk);
        marketSubdivisions.addCompany(marketSubdivisionsEu);

        Ms developmentSubdivisions = new Ms();
        developmentSubdivisions.addCompany(subdivisionDevelopment);
        developmentSubdivisions.addCompany(developmentSubdivisionsGame);
        developmentSubdivisions.addCompany(developmentSubdivisionsOffice);
        developmentSubdivisions.addCompany(developmentSubdivisionsOs);

        msCorporation.addCompany(hhSubdivisions);
        msCorporation.addCompany(marketSubdivisions);
        msCorporation.addCompany(developmentSubdivisions);

        msCorporation.showReport();
    }
}
