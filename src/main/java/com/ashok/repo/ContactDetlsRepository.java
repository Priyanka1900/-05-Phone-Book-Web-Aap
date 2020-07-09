package com.ashok.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ashok.entity.ContactEntity;

public interface ContactDetlsRepository extends JpaRepository<ContactEntity,Serializable>{

}
