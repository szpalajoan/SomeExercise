package pl.jkap

import spock.lang.Specification

class BubbleSortTest extends Specification {

    def "Should return sorted numbers in ascending order"() {
        when: "sorting the list"
        Double[] resultSort = BubbleSort.sort(input as Double[])

        then: "the list sorted in ascending order is returned"
        resultSort == result as Double[]

        where:

        input                     | result
        [1, 4, 5, 6, 8, 3, 8]     | [1, 3, 4, 5, 6, 8, 8]
        [-9.3, 0.2, 4, 0.1, 5, 9] | [-9.3, 0.1, 0.2, 4, 5, 9]
        []                        | []
        [null, 5.0001]            | [5.0001]

    }

    def "Should return an exception when trying to sort a null list"() {
        when: "Trying to sort a null list"
        BubbleSort.sort(null)
        then: "an exception is returned"
        thrown RuntimeException
    }

}
