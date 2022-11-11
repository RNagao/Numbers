import com.aor.numbers.ListSorter

class ListSorterTest {
    def "Should sort the list"() {
        given:
        List<Integer> list = Arrays.asList(3,2,6,1,4,5,7)
        when:
        ListSorter sorter = new ListSorter()
        List<Integer> sorted = sorter.sort(list)
        then:
        sorted == Arrays.asList(1,2,3,4,5,6,7)
    }

    def "sort_bug_8726"() {
        given:
        List<Integer> list = Arrays.asList(1,2,4,2)
        when:
        ListSorter sorter = new ListSorter()
        List<Integer> sorted = sorter.sort(list)
        then:
        sorted == Arrays.asList(1,2,2,4)
    }
}
