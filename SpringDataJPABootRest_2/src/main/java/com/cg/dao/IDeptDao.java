package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Dept;

@Repository
public interface IDeptDao extends JpaRepository<Dept,Integer>{

	public Dept findByDeptName(String deptName);
}
