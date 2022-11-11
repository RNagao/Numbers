import com.aor.numbers.GenericListFilter
import com.aor.numbers.ListFilterer
import org.mockito.Mockito

class ListFiltererTest {
    List<Integer> list = Arrays.asList(1, 2, 3, 4)

    def "Should return true for all the array" (){
        given:
        def numberFilter = Mock(GenericListFilter)
        numberFilter.accept(Mockito.anyInt()) >> true
        when:
        ListFilterer listFilter = mew ListFilterer(numberFilter)
        List<Integer> filteredList = listFilter.filter(list)
        then:
        filteredList == Arrays.asList(1,2,3,4)
    }

    def "Should return false for all the array" (){
        given:
        def numberFilter = Mock(GenericListFilter)
        numberFilter.accept(Mockito.anyInt()) >> false
        when:
        ListFilterer listFilter = mew ListFilterer(numberFilter)
        List<Integer> filteredList = listFilter.filter(list)
        then:
        filteredList == Arrays.asList()
    }
}
