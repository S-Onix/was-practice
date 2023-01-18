package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestLineTest {
    @Test
    void create(){
        RequestLine requestLine = new RequestLine("GET /calculate?operand1=11&operator=*&operand2=22");
        Assertions.assertThat(requestLine).isNotNull();
        Assertions.assertThat(requestLine).isEqualTo(new RequestLine("GET","/calculate","operand1=11&operator=*&operand2=22"));
    }

}