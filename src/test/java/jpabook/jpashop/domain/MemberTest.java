package jpabook.jpashop.domain;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class MemberTest {

    @Test
    void creation() {
        Member member = new Member();
        member.setId(1L);
        member.setName("name");

        assertThat(member.getId()).as("ID 검사").isEqualTo(1L);
        assertThat(member.getName()).as("Name 검사").isEqualTo("name");

    }

}
