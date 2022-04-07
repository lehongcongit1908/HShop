package com.eshop.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eshop.entity.Customer;
import com.eshop.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer>{
	@Query("SELECT o FROM Product o WHERE o.category.id=?1")
	List<Product> findAllByCategory(Integer categoryId);

	@Query("SELECT o FROM Product o WHERE o.name LIKE %?1% OR o.category.name LIKE %?1% OR o.category.nameVN LIKE %?1%")
	List<Product> findByKeywords(String keywords);

	@Query("SELECT o FROM Product o ORDER BY size(o.orderDetails) DESC")
	List<Product> findByBestSellers(Pageable page);

	@Query("SELECT o FROM Product o WHERE o.latest=true")
	List<Product> findByLatest();

	@Query("SELECT o FROM Product o WHERE o.discount > 0 ORDER BY o.discount DESC")
	List<Product> findBySalesOff(Pageable page);

	@Query("SELECT o FROM Product o WHERE o.clickCount > 0 ORDER BY o.clickCount DESC")
	List<Product> findByMostViewed(Pageable page);

	@Query("SELECT o FROM Product o WHERE o.special=true")
	List<Product> findBySpecial();

	@Query("SELECT o FROM Product o WHERE o.id IN ?1")
	List<Product> findByIds(List<Integer> list);

	@Query("SELECT DISTINCT d.product FROM OrderDetail d WHERE d.order.customer=?1")
	List<Product> findByCustomer(Customer user);
}
