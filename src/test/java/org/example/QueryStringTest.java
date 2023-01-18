package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueryStringTest {
    @Test
    void createTest() {
        QueryString queryString = new QueryString("operand","11");

        Assertions.assertThat(queryString).isNotNull();
    }
}

