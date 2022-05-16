package mx.tec.com.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.validation.constraints.Min;

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
@RequestMapping("/expense")
@Validated
public class ExpenseController {
	//private static final Logger log = LoggerFactory.getLogger(Controller.class);
	
	/*
	 * Reference to the Expense Manager
	 */
	@Resource
	private ExpenseManager expense_manager;
	
	@PostMapping("/{user_id}")
	public ResponseEntity<ExpenseVO> addExpense(@RequestBody ExpenseVO expense, @PathVariable(value = "user_id") @Min(value=0, message="User id must be positive.")Long user_id) {
		return new ResponseEntity<>(expense_manager.addExpense(expense, user_id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ExpenseVO> updateExpense(@RequestBody ExpenseVO expense,  @PathVariable(value = "id") @Min(value=0, message="Expense id must be positive.") Long id) {
		return new ResponseEntity<>(expense_manager.updateExpense(expense, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteExpense(@PathVariable(value = "id") @Min(value = 0, message="ID of Expense to delete must be positive.") Long id) {
		expense_manager.deleteExpense(id);
		return new ResponseEntity<>("Expense with id: " + id + " has been deleted.", HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ExpenseVO> viewExpense(@PathVariable(value = "id") @Min(value = 0, message="Expense id must be positive.") Long id) {
		Optional<ExpenseVO> exp = expense_manager.viewExpense(id);
		if (exp.isPresent()) {
			return new ResponseEntity<>(exp.get(), HttpStatus.OK);	
		}else {
			return new ResponseEntity<>(new ExpenseVO(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/day/{user_id}")
	public ResponseEntity<List<ExpenseVO>> viewExpensesToday(@PathVariable(value = "user_id") @Min(value = 0, message="User id must be positive.") Long user_id) {
		return new ResponseEntity<>(expense_manager.viewExpensesToday(user_id), HttpStatus.OK);
	}
	
	@GetMapping("/month/{user_id}")
	public ResponseEntity<List<ExpenseVO>> viewExpensesMonth(@PathVariable(value = "user_id") @Min(value = 0, message="User id must be positive.") Long user_id) {
		
		return new ResponseEntity<>(Arrays.asList(new ExpenseVO()), HttpStatus.OK);
	}
	
	@GetMapping("/all/{user_id}")
	public ResponseEntity<List<ExpenseVO>> viewExpenses(@PathVariable(value = "user_id") @Min(value = 0, message="User id must be positive.") Long user_id) {
		
		return new ResponseEntity<>(expense_manager.viewExpenses(user_id), HttpStatus.OK);
	}
}
