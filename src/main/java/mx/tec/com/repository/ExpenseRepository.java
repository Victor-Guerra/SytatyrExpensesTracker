package mx.tec.com.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.tec.com.entity.Expense;
import mx.tec.com.vo.UserVO;
/**
 * Expense JPA Repository
 * @author victorg
 *
 */
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{
	
	@Query("FROM Expense e WHERE MONTH(e.date) = MONTH(?2) and YEAR(e.date) = YEAR(?2) and e.user = ?1")
	List<Expense> findIfMonth(UserVO user, Date date);
	
	@Query("FROM Expense e WHERE DAY(e.date) = DAY(?2) and MONTH(e.date) = MONTH(?2) and YEAR(e.date) = YEAR(?2) and e.user  = ?1")
	List<Expense> findIfDay(UserVO user, Date date);
	
	@Query("FROM Expense e WHERE e.user = ?1")
	List<Expense> findByUserId(UserVO user);
}
