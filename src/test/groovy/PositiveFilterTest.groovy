import com.aor.numbers.PositiveFilter
import com.sun.org.apache.xpath.internal.operations.Bool

class PositiveFilterTest {
    def "Should return true if the number is positive"() {
        given:
        Integer positive = 5
        Integer negative = -1
        when:
        PositiveFilter numberFilter = new PositiveFilter()
        Boolean accept_true = numberFilter.accept(positive)
        Boolean accept_false = numberFilter.accept(negative)
        then:
        accept_true == true
        accept_false == false
    }
}
