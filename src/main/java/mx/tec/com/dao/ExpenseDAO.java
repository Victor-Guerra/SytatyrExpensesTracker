package mx.tec.com.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import mx.tec.com.repository.ExpenseRepository;

@Component("jpa")
public class ExpenseDAO {
	@Resource
	private ExpenseRepository expenseRepo;
	
	@Resource
	private ExpenseMapper expenseMapper;
	
	public ExpenseVO save(ExpenseVO expense) {
		return 
	}
}
