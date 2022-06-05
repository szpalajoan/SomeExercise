package pl.jkap

import spock.lang.Specification

class BalancedWordsCounterTest extends Specification {

    def "Should return count of balanced subwords exist in input word"() {
        when:
        int resultCount = BalancedWordsCounter.count(input as String)

        then:
        resultCount == result

        where:
        input         | result
        'aabbabcccba' | 28
        ''            | 0
    }

    def "Should return an exception when input is null or invalid"() {
        when:
        BalancedWordsCounter.count(input as String)

        then:
        thrown RuntimeException

        where:
        input << [null, 'abababa1']

    }
}
