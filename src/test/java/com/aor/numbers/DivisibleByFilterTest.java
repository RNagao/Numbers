package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DivisibleByFilterTest {
    @Test
    public void accept_true() {
        Integer number = 4;
        Integer divisor = 2;

        DivisibleByFilter numberFilter = new DivisibleByFilter(divisor);
        Boolean accepted = numberFilter.accept(number);

        Assertions.assertEquals(true, accepted);
    }

    @Test
    public void accept_false() {
        Integer number = 5;
        Integer divisor = 2;

        DivisibleByFilter numberFilter = new DivisibleByFilter(divisor);
        Boolean accepted = numberFilter.accept(number);

        Assertions.assertEquals(false, accepted);
    }
}
