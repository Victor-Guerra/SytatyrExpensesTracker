package mx.tec.com.manager;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mx.tec.com.dao.ExpenseDAO;
import mx.tec.com.dao.UserDAO;
import mx.tec.com.vo.ExpenseVO;
import mx.tec.com.vo.UserVO;

@Service
public class ExpenseManager {

	@Resource
	private ExpenseDAO expense_dao;
	@Resource 
	private UserDAO user_dao;
	
	public ExpenseVO addExpense(ExpenseVO expense, Long user_id) {
		UserVO u = user_dao.findUserById(user_id);
		return expense_dao.save(expense, u);
	}
	
	public ExpenseVO updateExpense(ExpenseVO expense, Long id) {
		return expense_dao.update(expense, id);
	}
	
	public void deleteExpense(Long id) {
		expense_dao.delete(id);
	}
	
	public Optional<ExpenseVO> viewExpense(Long id) {
		return expense_dao.findById(id);
	}
	
	public List<ExpenseVO> viewExpensesToday(Long user_id) {
		Date today = Date.from(Instant.now());
		UserVO user = user_dao.findUserById(user_id);
		return expense_dao.findIfDay(user, today);
	}
	
	public List<ExpenseVO> viewExpensesMonth(Long user_id) {
		Date today = Date.from(Instant.now());
		UserVO user = user_dao.findUserById(user_id);
		return expense_dao.findIfMonth(user, today);
	}
	
	public List<ExpenseVO> viewExpenses(Long user_id) {
		UserVO user = user_dao.findUserById(user_id);
		return expense_dao.findByUserId(user);
	}
}
