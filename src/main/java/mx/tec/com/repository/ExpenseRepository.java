package mx.tec.com.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.tec.com.entity.Expense;
/**
 * Expense JPA Repository
 * @author victorg
 *
 */
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{
	
	//@Query("FROM Expense WHERE user_id = 1");//MONTH(date) = MONTH(%:date%) and YEAR(date) = YEAR(%:date%) and user_id = %:user_id%;")
	List<Expense> findIfMonth(@Param("user_id") Long user_id,@Param("date") Date date);
	
	//@Query("FROM Expense WHERE user_id = 1");//DAY(date) = DAY(%:date%) and MONTH(date) = MONTH(%:date%) and YEAR(date) = YEAR(%:date%) and user_id = %:user_id%;")
	List<Expense> findIfDay(@Param("user_id") Long user_id, @Param("date") Date date);
	
	//@Query("FROM Expense WHERE user_id = 1");//%:user_id%;")
	List<Expense> findByUserId(@Param("user_id") Long user_id);
}
