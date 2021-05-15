package com.cg;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.cg.dao.IEmpDao;
import com.cg.entity.Emp;
import com.cg.exceptions.EmpNotFoundException;
import com.cg.service.EmpServiceImpl;
import com.cg.service.IEmpService;

@SpringBootTest
public class TestViewById {
	
	@Mock
	private IEmpDao dao;
	
	@InjectMocks
	private IEmpService service= new EmpServiceImpl();

	@BeforeEach
	public void beforeEach()
	{
		Optional<Emp> optemp1= Optional.of(new Emp());
		Optional<Emp> optemp2= Optional.empty();
		when(dao.findById(1001)).thenReturn(optemp1);
		when(dao.findById(1002)).thenReturn(optemp2);
	}
	
	@Test
	@DisplayName(value= "testviewbyid for 1001")
	public void testviewbyId1() throws EmpNotFoundException
	{
		assertNotNull(service.viewEmployee(1001));
	}
	
	@Test
	@DisplayName(value="testviewbyid for 1002")
	public void testviewbyId2()
	{
		assertThrows(EmpNotFoundException.class, ()->service.viewEmployee(1002));
		
	}
}
