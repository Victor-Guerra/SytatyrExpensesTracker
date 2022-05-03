package mx.tec.com.manager;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
	
	public void updateExpense(ExpenseVO expense) {
		expense_dao.update(expense);
	}
	
	public void deleteExpense(Long id) {
		expense_dao.delete(id);
	}
	
	public Optional<ExpenseVO> viewExpense(Long id) {
		return expense_dao.findById(id);
	}
	
	public List<ExpenseVO> viewExpensesToday(Long user_id) {
		Date today = Date.from(Instant.now());
		return expense_dao.findIfMonth(user_id, today);
	}
	
	public List<ExpenseVO> viewExpensesMonth(Long user_id) {
		Date today = Date.from(Instant.now());
		return expense_dao.findIfDay(user_id, today);
	}
	
	public List<ExpenseVO> viewExpenses(Long user_id) {
		return expense_dao.findByUserId(user_id);
	}
}
