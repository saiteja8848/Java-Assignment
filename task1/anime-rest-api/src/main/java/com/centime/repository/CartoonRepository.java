package com.centime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.centime.entity.Cartoon;

@Repository
public interface CartoonRepository extends JpaRepository<Cartoon, Integer>{

}
