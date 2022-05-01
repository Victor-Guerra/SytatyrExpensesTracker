package mx.tec.com.manager;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mx.tec.com.dao.ExpenseDAO;
import mx.tec.com.vo.ExpenseVO;

@Service
public class ExpenseManager {

	@Resource
	private ExpenseDAO expense_dao;
	
	public ExpenseVO addExpense(ExpenseVO expense) {
		
		return expense_dao.save(expense);
	}
	
	public ExpenseVO updateExpense(ExpenseVO expense) {
		return expense_dao.update(expense);
	}
	
	public ExpenseVO deleteExpense(Long id) {
		return expense_dao.delete(id);
	}
	
	public ExpenseVO viewExpense(Long id) {
		return expense_dao.findById(id);
	}
	
	public List<ExpenseVO> viewExpensesToday(Long user_id) {
		Date today = Date.from(Now);
		return expense_dao.findIfDate(user_id, today);
	}
	
	public List<ExpenseVO> viewExpensesMonth(Long user_id) {
		Date today = Date.from(Now);
		return expense_dao.findIdDate(user_id, todday);
	}
	
	public List<ExpenseVO> viewExpenses(Long user_id) {
		return expense_dao.findByUserId(user_id);
	}
}
