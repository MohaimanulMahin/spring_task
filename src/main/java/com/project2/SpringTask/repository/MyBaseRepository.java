package com.project2.SpringTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
interface MyBaseRepository<T, ID> extends JpaRepository<T, ID> { }
