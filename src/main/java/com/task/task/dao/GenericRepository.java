package com.task.task.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

/**
 * @author  Alaa Yehia
 * @implNote this Generic Repository for extend this for any repository
 * @param <T> this for every entity extend this repo
 */
@NoRepositoryBean
public interface GenericRepository<T> extends JpaRepository<T,Long> , JpaSpecificationExecutor<T> {
}
