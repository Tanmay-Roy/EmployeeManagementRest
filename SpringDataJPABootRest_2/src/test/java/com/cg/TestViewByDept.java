package com.cg;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.cg.dao.IEmpDao;
import com.cg.entity.Emp;
import com.cg.exceptions.EmpNotFoundException;
import com.cg.service.EmpServiceImpl;
import com.cg.service.IEmpService;

@SpringBootTest
public class TestViewByDept {
	
	@Mock
	private IEmpDao empdao;

	@InjectMocks
	private IEmpService service= new EmpServiceImpl();

	@BeforeEach
	public void beforeEach()
	{
		List<Emp> lst= new ArrayList<>();
		lst.add(new Emp(1001,"jatin",54000.0,LocalDate.of(2018, 06, 18)));
		lst.add(new Emp(1002,"hope",62000.0,LocalDate.of(2019, 06, 12)));
		List<Emp> lst2= new ArrayList<>();
		when(empdao.viewEmployee("hr")).thenReturn(lst);
		when(empdao.viewEmployee("aaa")).thenReturn(lst2);
	}
	
	@Test
	@DisplayName(value= "testviewbydept for hr")
	public void testviewbydept1() throws EmpNotFoundException
	{
		assertTrue(service.viewEmployee("hr").size()>0);
	}
	
	@Test
	@DisplayName(value="testviewbydept for aaa")
	public void testviewbydept2()
	{
		assertThrows(EmpNotFoundException.class, ()-> service.viewEmployee("aaa"));
	}
}
