
package com.model;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author josemiguel
 * Connects to MySQL through JDBCTemplate
 * 
 */

public final class Connection {
  
    private DriverManagerDataSource dataSource  = new DriverManagerDataSource();

    public DriverManagerDataSource getDataSource() {
        return dataSource;
    }
    
    public Connection() {
        
        this.connectMysql();

    }
       
    public DriverManagerDataSource connectMysql() {

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/USER");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        return dataSource;
    }
  
}
