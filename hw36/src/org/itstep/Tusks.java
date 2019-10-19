package org.itstep;

import java.util.List;

public class Tusks implements Container {
    List<Report> listIterator;
    public Tusks(List list) {
        listIterator = list;
    }

    @Override
    public Iterator getIterator() {
        return new TaskIterator();
    }

    private class TaskIterator implements Iterator {
        int index = 0;

        @Override
        public Report next() {
            return listIterator.get(index++);
        }

        @Override
        public boolean hasNext() {
            if (index < listIterator.size()) {
                return true;
            } else {
                return false;
            }
        }
    }
}
