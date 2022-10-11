package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {
    List<Integer> list = new ArrayList<>();

    @BeforeEach
    public void setupList() {
            list = Arrays.asList(1,2,3,4);
        }

    @Test
    public void filterTrueList() {
        GenericListFilter numberFilter = Mockito.mock(GenericListFilter.class);
        Mockito.when(numberFilter.accept(Mockito.anyInt())).thenReturn(true);

        List<Integer> expect = Arrays.asList(1,2,3,4);

        ListFilterer listFilter = new ListFilterer(numberFilter);
        List<Integer> filteredList = listFilter.filter(list);

        Assertions.assertEquals(expect, filteredList);
    }

    @Test
    public void filterFalseList() {
        GenericListFilter numberFilter = Mockito.mock(GenericListFilter.class);
        Mockito.when(numberFilter.accept(Mockito.anyInt())).thenReturn(false);

        List<Integer> expect = Arrays.asList();

        ListFilterer listFilter = new ListFilterer(numberFilter);
        List<Integer> filteredList = listFilter.filter(list);

        Assertions.assertEquals(expect, filteredList);
    }
}
