package org.itstep.example;

// Простой отдел, который не может включать другие подразделение
public class Department extends Unit {

    public Department(String name) {
        super(name);
    }

    @Override
    public String report() {
        return String.format("Отчет для отдела: %s\n", getName());
    }

    @Override
    public void add(Unit unit) {
        throw new RuntimeException("Отдел не может включать подразделения!");
    }

    @Override
    public Unit getUnit(String name) {
        throw new RuntimeException("Отдел не может включать подразделения!");
    }
}