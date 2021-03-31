package com.example.demo.service;

import com.example.demo.entity.member.Member;
import com.example.demo.repository.registration.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    SignUpRepository repository;

    @Override
    public void register(Member member) throws Exception {
        repository.register(member);
    }
}
