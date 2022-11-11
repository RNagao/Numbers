import com.aor.numbers.DivisibleByFilter

class DivisibleByFilterTest {
    def "Should return true if the number is divisible by the other"() {
        given:
            int number1 = 4;
            int number2 = 5;
            int divisor = 2;
        when:
            DivisibleByFilter numberFilter = new DivisibleByFilter(divisor)
            Boolean accepted1 = numberFilter.accept(number1)
            Boolean accepted2 = numberFilter.accept(number2)
        then:
            accepted1 == true
            accepted2 == false
    }
}
