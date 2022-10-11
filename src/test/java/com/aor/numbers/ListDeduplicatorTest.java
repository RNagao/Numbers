package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {
    List<Integer> list = new ArrayList<>();

    @BeforeEach
    public void setupList() {
        list = Arrays.asList(1,2,4,2,5);
    }
    @Test
    public void deduplicate() {

        GenericListSorter listSorter = Mockito.mock(GenericListSorter.class);
        Mockito.when(listSorter.sort(Mockito.anyList())).thenReturn(Arrays.asList(1,2,2,4,5));

        List<Integer> expected = Arrays.asList(1,2,4,5);

        ListDeduplicator deduplicator = new ListDeduplicator();
        List<Integer> distinct = deduplicator.deduplicate(list, listSorter);

        Assertions.assertEquals(expected, distinct);
    }

    @Test
    public void deduplicate_bug_8726() {
        GenericListSorter listSorter = Mockito.mock(GenericListSorter.class);
        Mockito.when(listSorter.sort(Mockito.anyList())).thenReturn(Arrays.asList(1,2,2,4));

        List<Integer> expected = Arrays.asList(1,2,4);

        ListDeduplicator deduplicator = new ListDeduplicator();
        List<Integer> distinct = deduplicator.deduplicate(list, listSorter);

        Assertions.assertEquals(expected, distinct);
    }
}
