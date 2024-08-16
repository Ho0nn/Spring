package org.example.jdbc.config;

import org.example.jdbc.repository.EmpJDBCRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class BeanConfiguration {
    @Bean
    @Scope("singletone")
    public EmpJDBCRepo getEmpRepo() {
        return new EmpJDBCRepo();
    }
}
