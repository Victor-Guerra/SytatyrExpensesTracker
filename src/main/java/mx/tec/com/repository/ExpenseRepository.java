package mx.tec.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import mx.tec.com.entity.Expense;
/**
 * Expense JPA Repository
 * @author victorg
 *
 */
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{
	
}
