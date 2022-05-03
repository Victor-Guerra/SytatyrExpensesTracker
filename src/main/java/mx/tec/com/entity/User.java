package mx.tec.com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import mx.tec.com.vo.ExpenseVO;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String email;
	
	private String password;
	
	private String name;
	
	@OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL)
	private List<Expense> user_expenses;
}
