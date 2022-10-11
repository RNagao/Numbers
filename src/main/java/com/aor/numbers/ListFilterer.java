package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer {
    GenericListFilter listFilter;

    public ListFilterer(GenericListFilter filter) {
        this.listFilter = filter;
    }

    public List<Integer> filter(List<Integer> list) {
        List<Integer> filteredList = new ArrayList<>();
        for (Integer number : list) {
            if (listFilter.accept(number))
                filteredList.add(number);
        }

        return filteredList;
    }
}
