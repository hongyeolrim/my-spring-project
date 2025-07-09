package com.yedam.app.jpa.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository // Persistence 영역을 제어하는 Bean
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	// findAll, findById, save, deleteById 제외 별도 추가

	// SELECT * FROM customer WHERE name = ?1
	public List<Customer> findByName(String name);

	// SELECT * FROM customer WHERE name =?1 AND phone= ?2
	public List<Customer> findByNameAndPhone(String name, String phone);

	// SELECT * FROM customer WHERE name LIKE '%'?1'%'
	public List<Customer> findByNameContaining(String keyword);

	// JPQL - 실제 테이블과 컬럼 이름이 아닌 Entity명과(따로 지정 안 하면 = 클래스명) 필드명 사용
	// 1) SELECT
	@Query("SELECT u FROM Customer u WHERE u.name LIKE ?1ORDER BY u.id DESC")
	public List<Customer> findByAndSort(String name);

	// 2) DML
	@Query("UPDATE Customer c SET c.name = ?1 WHERE c.id = ?2")
	public int setFixedNameFor(String name, Long id);
}
