package mx.tec.com.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import mx.tec.com.entity.Expense;
import mx.tec.com.vo.ExpenseVO;

import org.modelmapper.ModelMapper;

@Component
public class ExpenseMapper {

	@Resource
	private ModelMapper mapper;
	
	/**
	 * Convert from Expense entity to ExpenseVO
	 * @param expense
	 * @return
	 */
	public ExpenseVO convertToVO(final Expense expense) {
		return mapper.map(expense, ExpenseVO.class);
	}
	
	/**
	 * Convert from an ExpenseVO to an Expense entity
	 * @param expensevo
	 * @return
	 */
	public Expense convertToEntity(final ExpenseVO expensevo) {
		return mapper.map(expensevo, Expense.class);
	}
	
	/**
	 * Convert from an optional Expense entity to an optional expense VO
	 * @param expense
	 * @return
	 */
	public Optional<ExpenseVO> convertToOptionalVO(final Optional<Expense> expense) {
		Optional<ExpenseVO> expenseVO = Optional.empty();
		
		if (expense.isPresent()) {
			expenseVO = Optional.of(convertToVO(expense.get()));
		}
		
		return expenseVO;
	}
	
	/**
	 * Convert a list of Expense entities into a list of ExpenseVOs
	 * @param expenses
	 * @return
	 */
	public List<ExpenseVO> convertToVOList(final List<Expense> expenses) {
		final List<ExpenseVO> expVOs = new ArrayList<>();
		
		for (final Expense exp: expenses) {
			expVOs.add(convertToVO(exp));
		}
		
		return expVOs;
	}
}
