package jpabook.jpashop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class JpashopApplicationTests {

    @Test
    void contextLoads() {
        Hello hello = new Hello();
        hello.setData("hello");

        assertThat(hello.getData()).isEqualTo("hello");
    }

}
