package mx.tec.com.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.tec.com.manager.ExpenseManager;
import mx.tec.com.vo.ExpenseVO;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/")
//@Validated
public class Controller {
	//private static final Logger log = LoggerFactory.getLogger(Controller.class);
	
	/*
	 * Reference to the Expense Manager
	 */
	@Resource
	private ExpenseManager expense_manager;
	
	@PostMapping("/expense")
	public ResponseEntity<ExpenseVO> addExpense(@RequestBody ExpenseVO expense) {
		return new ResponseEntity<>(expense_manager.addExpense(expense), HttpStatus.OK);
	}
	
	@PutMapping("/expense")
	public ResponseEntity<String> updateExpense(@RequestBody ExpenseVO expense) {
		
		return ResponseEntity.ok("obo");
	}
	
	@DeleteMapping("/expense/{id}")
	public ResponseEntity<String> deleteExpense(@PathVariable(value = "id") @Min(value = 0, message="Expense id must be positive.") Long id) {
		
		return ResponseEntity.ok("obo");
	}
	
	@GetMapping("/expense/{id}")
	public ResponseEntity<ExpenseVO> viewExpense(@PathVariable(value = "id") @Min(value = 0, message="Expense id must be positive.") Long id) {
		
		return new ResponseEntity<>(new ExpenseVO(), HttpStatus.OK);
	}
	
	@GetMapping("/expense/day/{user_id}")
	public ResponseEntity<List<ExpenseVO>> viewExpensesToday(@PathVariable(value = "user_id") @Min(value = 0, message="User id must be positive.") Long user_id) {
		
		return new ResponseEntity<>(Arrays.asList(new ExpenseVO()), HttpStatus.OK);
	}
	
	@GetMapping("/expense/month/{user_id}")
	public ResponseEntity<List<ExpenseVO>> viewExpensesMonth(@PathVariable(value = "user_id") @Min(value = 0, message="User id must be positive.") Long user_id) {
		
		return new ResponseEntity<>(Arrays.asList(new ExpenseVO()), HttpStatus.OK);
	}
	
	@GetMapping("/expense/all/{user_id}")
	public ResponseEntity<List<ExpenseVO>> viewExpenses(@PathVariable(value = "user_id") @Min(value = 0, message="User id must be positive.") Long user_id) {
		
		return new ResponseEntity<>(Arrays.asList(new ExpenseVO()), HttpStatus.OK);
	}
}
