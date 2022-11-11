import com.aor.numbers.GenericListDeduplicator
import com.aor.numbers.ListDeduplicator

class ListDeduplicatorTest {
    def "Should remove the duplicated values of an array"() {
        given:
        List<Integer> list = Arrays.asList(1, 2, 4, 2, 5)
        def listSorter = Mock(GenericListSorter)
        listSorter.sort(Arrays.asList(1, 2, 4, 2, 5)) >> Arrays.asList(1, 2, 2, 4, 5)
        when:
        ListDeduplicator deduplicator = new ListDeduplicator()
        List<Integer> distinct = deduplicator.deduplicate(list, listSorter)
        then:
        distinct == Arrays.asList(1,2,4,5)
    }

    def "deduplicate_bug_8726"() {
        given:
        List<Integer> list = Arrays.asList(1, 2, 4, 2)
        def listSorter = Mock(GenericListSorter)
        listSorter.sort(Arrays.asList(1, 2, 4, 2)) >> Arrays.asList(1, 2, 2, 4)
        when:
        ListDeduplicator deduplicator = new ListDeduplicator()
        List<Integer> distinct = deduplicator.deduplicate(list, listSorter)
        then:
        distinct == Arrays.asList(1, 2, 4)
    }
}
