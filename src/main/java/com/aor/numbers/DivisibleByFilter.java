package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter{
    Integer divisor;

    public DivisibleByFilter(Integer number) {
        this.divisor = number;
    }

    @Override
    public boolean accept(Integer number) {
        if (number % divisor == 0)
            return true;
        else return false;
    }
}
