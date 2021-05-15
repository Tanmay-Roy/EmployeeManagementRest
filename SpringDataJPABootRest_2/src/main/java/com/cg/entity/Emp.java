package com.cg.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cg_emp")
public class Emp {
	
	@Id
	@Column(name="emp_id")
	@SequenceGenerator(name="emp_seqgn", sequenceName="emp_seq1",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="emp_seqgn")
	private Integer empId;
	
	@Column(name="emp_name", length=25, nullable=false)
	private String empName;
	
	@Column(name="emp_sal")
	private Double empSal;
	
	@Column(name="emp_doj")
	private LocalDate empDoj;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="did", referencedColumnName="dept_id")
	private Dept dept;
	
	public Emp()
	{
		
	}

	public Emp(Integer empId, String empName, Double empSal, LocalDate empDoj) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.empDoj = empDoj;
	}



	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}

	public LocalDate getEmpDoj() {
		return empDoj;
	}

	public void setEmpDoj(LocalDate empDoj) {
		this.empDoj = empDoj;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return empId+" "+empName+" "+empSal+" "+empDoj;
	}
}