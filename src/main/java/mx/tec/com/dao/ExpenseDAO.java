package mx.tec.com.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import mx.tec.com.mapper.ExpenseMapper;
import mx.tec.com.repository.ExpenseRepository;
import mx.tec.com.vo.ExpenseVO;

@Component("jpa")
public class ExpenseDAO {
	@Resource
	private ExpenseRepository expenseRepo;
	
	@Resource
	private ExpenseMapper expenseMapper;
	
	public ExpenseVO save(ExpenseVO expense) {
		return expenseMapper.convertToVO(expenseRepo.save(expenseMapper.convertToEntity(expense)));
	}
	
	public void update(ExpenseVO expense) {
		expenseRepo.save(expenseMapper.convertToEntity(expense));
	}
	
	public void delete(Long id) {
		expenseRepo.deleteById(id);
	}
	
	public Optional<ExpenseVO> findById(Long id) {
		return expenseMapper.convertToOptionalVO(expenseRepo.findById(id));
	}
	
	public List<ExpenseVO> findIfMonth(Long user_id, Date date) {
		return expenseMapper.convertToVOList(expenseRepo.findIfMonth(user_id, date));
	}
	
	public List<ExpenseVO> findIfDay(Long user_id, Date date) {
		return expenseMapper.convertToVOList(expenseRepo.findIfDay(user_id, date));
	}
	
	public List<ExpenseVO> findByUserId(Long user_id) {
		return expenseMapper.convertToVOList(expenseRepo.findByUserId(user_id));
	}
}
