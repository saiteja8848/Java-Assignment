package com.centime.demorestapi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.centime.demorestapi.entity.RequestWSO;

@Service
public interface DemoService {
	public Optional<String> getConcatedStrings(RequestWSO payload);
}
