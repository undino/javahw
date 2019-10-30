package org.itstep.example;

import java.util.ArrayList;

// Составное подразделение
public class Branch extends Unit {

    public Branch(String name) {
        super(name);
        units = new ArrayList<>(); // В подразделении может находится другие подразделения и отделы
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder("Отчет отдела: " + getName() + "\n");
        // Для формирования отчета необходимо пройтись по всем подразделениям
        for (Unit u : units) {
            sb.append(u.report());
        }
        return sb.toString();
    }

    @Override
    public Unit getUnit(String name) {        
        return units.stream().filter(u -> u.getName().equals(name)).findFirst().orElse(null);
    }

}