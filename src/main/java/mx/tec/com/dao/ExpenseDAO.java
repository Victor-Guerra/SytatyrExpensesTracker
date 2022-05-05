package mx.tec.com.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import mx.tec.com.entity.Expense;
import mx.tec.com.entity.User;
import mx.tec.com.mapper.ExpenseMapper;
import mx.tec.com.mapper.UserMapper;
import mx.tec.com.repository.ExpenseRepository;
import mx.tec.com.repository.UserRepository;
import mx.tec.com.vo.ExpenseVO;
import mx.tec.com.vo.UserVO;

@Component("jpa")
public class ExpenseDAO {
	@Resource
	private ExpenseRepository expenseRepo;
	@Resource
	private UserRepository userRepo;
	
	@Resource
	private ExpenseMapper expenseMapper;
	
	@Resource
	private UserMapper userMapper;
	
	public ExpenseVO save(ExpenseVO expense, UserVO user) {
		Expense exp = expenseMapper.convertToEntity(expense);
		exp.setUser(userMapper.convertToEntity(user));
		return expenseMapper.convertToVO(expenseRepo.save(exp));
	}
	
	public ExpenseVO update(ExpenseVO expense, Long id) {
		Optional<Expense> old_exp = (expenseRepo.findById(id));
		
		if (old_exp.isPresent()) {
			Long user_id = old_exp.get().getUser().getId();
			
			Optional<User> user = userRepo.findById(user_id);
			if(user.isPresent()) {
				old_exp.get().setAmount(expense.getAmount());
				old_exp.get().setCategory(expense.getCategory());
				old_exp.get().setDate(expense.getDate());
				old_exp.get().setMethod(expense.getMethod());
				old_exp.get().setNotes(expense.getNotes());
				old_exp.get().setReason(expense.getReason());
				old_exp.get().setRecipient(expense.getRecipient());
				old_exp.get().setUser(user.get());
			}
			return expenseMapper.convertToVO(expenseRepo.save(old_exp.get()));
		}
		return new ExpenseVO();
	}
	
	public void delete(Long id) {
		expenseRepo.deleteById(id);
	}
	
	public Optional<ExpenseVO> findById(Long id) {
		Optional<ExpenseVO> expense  = Optional.empty(); 
		Optional<Expense> x = expenseRepo.findById(id);
		if(x.isPresent()) {
			Long user_id = x.get().getUser().getId();
			expense = Optional.of(expenseMapper.convertToVO(x.get()));
			expense.get().setUser_id(user_id);
		}
		
		return expense;
	}
	
	public List<ExpenseVO> findIfMonth(UserVO user, Date date) {
		return expenseMapper.convertToVOList(expenseRepo.findIfMonth(user, date));
	}
	
	public List<ExpenseVO> findIfDay(UserVO user, Date date) {
		return expenseMapper.convertToVOList(expenseRepo.findIfDay(user, date));
	}
	
	public List<ExpenseVO> findByUserId(UserVO user) {
		return expenseMapper.convertToVOList(expenseRepo.findByUserId(user));
	}
}
