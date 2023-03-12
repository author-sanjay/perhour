package com.articz.perhour.perhour.Dao;

import com.articz.perhour.perhour.Entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectsDao extends JpaRepository<Projects,Long> {
    public List<Projects> findByTitle(String name);
    public List<Projects> findByCategory(String category);


}
