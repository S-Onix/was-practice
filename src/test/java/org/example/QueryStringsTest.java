package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class QueryStringsTest {
    @Test
    void create(){

        QueryStrings queryStrings = new QueryStrings("operand1=11&operator=*&operand2=22");

        Assertions.assertThat(queryStrings).isNotNull();

    }
}