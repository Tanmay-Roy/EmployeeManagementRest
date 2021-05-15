package com.cg;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

import java.security.Provider.Service;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.cg.dao.IDeptDao;
import com.cg.dao.IEmpDao;
import com.cg.dto.EmpDto;
import com.cg.entity.Dept;
import com.cg.entity.Emp;
import com.cg.exceptions.DeptException;
import com.cg.service.EmpServiceImpl;
import com.cg.service.IEmpService;

@SpringBootTest
public class TestAddEmployee {
	
	@Mock
	private IEmpDao empdao;

	@Mock
	private IDeptDao deptdao;
	
	@InjectMocks
	private IEmpService service= new EmpServiceImpl();
	
	@BeforeEach
	public void beforeEach()
	{
		when(deptdao.findByDeptName("hr")).thenReturn(new Dept());
		when(deptdao.findByDeptName("aaa")).thenReturn(null);
		Emp persistedemp= new Emp(1001,"ratan", 42000.0, LocalDate.of(2018, 02, 16));
		when(empdao.save(any(Emp.class))).thenReturn(persistedemp);
	}
	
	@Test
	@DisplayName(value= "testaddemployee for dept hr")
	public void testAddEmployee1() throws DeptException
	{
		EmpDto empdto= new EmpDto(1001,"tanmay",42000.0,LocalDate.of(2018, 05, 16),"hr");
		assertNotNull(service.addEmployee(empdto));
	}
	
	@Test
	@DisplayName(value= "testaddemployee for dept aaa")
	public void testAddEmployee2() throws DeptException
	{
		EmpDto empdto= new EmpDto("tanmay",42000.0,LocalDate.of(2018, 05, 16),"aaa");
		assertThrows(DeptException.class, ()-> service.addEmployee(empdto));
	}
	
	@Test
	@DisplayName(value="testaddemployee for dept hr")
	public void testAddEmployee3() throws DeptException
	{
		EmpDto empdto= new EmpDto(1001,"tanmay",42000.0,LocalDate.of(2018, 05, 16),"hr");
		assertTrue(service.addEmployee(empdto)==1001);
		
		
	}
	
	
	
	
	
}