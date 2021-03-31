package com.example.demo.repository.registration;

import com.example.demo.entity.member.Member;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Log
@Repository
public class SignUpRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void register(Member member) throws Exception {
        log.info("member.email: " + member.getEmail());

        String query = "insert into member(email, password, postcode, " +
                "address, detail) values(?, ?, ?, ?, ?)";

        jdbcTemplate.update(query, member.getEmail(), member.getPassword(),
                member.getSample6Postcode(), member.getSample6Address(),
                member.getSample6DetailAddress());
    }
}
