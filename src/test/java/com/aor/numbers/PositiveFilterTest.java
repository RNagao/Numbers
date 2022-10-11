package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositiveFilterTest {
    @Test
    public void accept_positive() {
        Integer number = 5;

        PositiveFilter numberFilter = new PositiveFilter();
        Boolean accepted = numberFilter.accept(number);

        Assertions.assertEquals(true, accepted);
    }

    @Test
    public void accept_negative() {
        Integer number = -1;

        PositiveFilter numberFilter = new PositiveFilter();
        Boolean accepted = numberFilter.accept(number);

        Assertions.assertEquals(false, accepted);
    }
}
