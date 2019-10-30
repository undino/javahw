package org.itstep.example;

import java.util.List;

// Базовый класс для составных и простых узлов
public abstract class Unit {
    private String name; // Название подразделения
    protected List<Unit> units; // Составные части подразделения

    public Unit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String report();

    public abstract Unit getUnit(String name);

    // Добавляем новуя составную часть подразделения
    public void add(Unit unit) {
        if (units != null) {
            units.add(unit);
        }
    }
}