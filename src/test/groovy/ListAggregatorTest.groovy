import com.aor.numbers.GenericListDeduplicator
import com.aor.numbers.ListAggregator

class ListAggregatorTest {
    def "Should sum the numbers in an array"() {
        given:
            List<Integer> list = Arrays.asList(1,2,4,2,5)
        when:
            ListAggregator aggregator = new ListAggregator()
            int sum = aggregator.sum(list)
        then:
            sum == 14
    }

    def "Should give the max value of an array"() {
        given:
        List<Integer> list = Arrays.asList(1,2,4,2,5)
        when:
        ListAggregator aggregator = new ListAggregator()
        int max = aggregator.max(list)
        then:
        max == 5
    }

    def "Should give the max value of an array of negative integers"() {
        given:
        List<Integer> list = Arrays.asList(-1,-4,-5)
        when:
        ListAggregator aggregator = new ListAggregator()
        int max = aggregator.max(list)
        then:
        max == -1
    }

    def "Should give the min value of an array"() {
        given:
        List<Integer> list = Arrays.asList(1,2,4,2,5)
        when:
        ListAggregator aggregator = new ListAggregator()
        int min = aggregator.min(list)
        then:
        min == 1
    }

    def "Should count the number of distinct values in an array"() {
        given:
        List<Integer> list = Arrays.asList(1, 2, 4, 2, 5)
        def deduplicator = Mock(GenericListDeduplicator)
        deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2, 5)) >> Arrays.asList(1, 2, 4, 5)
        when:
        ListAggregator aggregator = new ListAggregator()
        def distinct = aggregator.distinct(list, deduplicator)
        then:
        distinct == 4
    }

    def "distinct_bug_8726"() {
        given:
        List<Integer> list = Arrays.asList(1, 2, 4, 2)
        def deduplicator = Mock(GenericListDeduplicator)
        deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2)) >> Arrays.asList(1, 2, 4)
        when:
        ListAggregator aggregator = new ListAggregator()
        def distinct = aggregator.distinct(list, deduplicator)
        then:
        distinct == 3
    }
}
