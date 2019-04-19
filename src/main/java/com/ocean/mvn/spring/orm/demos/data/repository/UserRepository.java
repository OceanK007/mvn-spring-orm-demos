package com.ocean.mvn.spring.orm.demos.data.repository;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ocean.mvn.spring.orm.demos.data.entity.User;
import com.ocean.mvn.spring.orm.demos.data.entity.projection.UserSummaryProjection;

/** 
 	Repository Interface 
 			^
 	CrudRepository Interface
 			^
 	PagingAndSortingRepository Interface
 			^
 	JpaRepository Interface
**/

@CacheConfig(cacheNames="userDaoCache")
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>
{
	/** 
		If return type is Page and you are using 'FETCH' in query: you have to define countQuery since internally it tries to execute a query to fetch the count.
		And if you don't define countQuery then an exception will occur during run time (on project startup) ::  
	 	Invocation of init method failed; nested exception is java.lang.IllegalArgumentException: Count query validation failed for method public abstract org.springframework.data.domain.Page
	**/
	//@Cacheable	// If you make it cacheable then findUserObjectsByPage(Pageable pageable) data will be fetched from cache and will give error.
	@Query(value="SELECT u FROM User u LEFT JOIN FETCH u.role r LEFT JOIN FETCH u.userDetail ud", countQuery="SELECT COUNT(u) FROM User u")
	Page<User> findUserByPage(Pageable pageable);
	
	/** To use Pageable with native query we need to add \n#pageable\n in query **/
	//@Cacheable
	@Query(value="SELECT u.id, u.username, ud.first_name, ud.last_name, r.role FROM user u LEFT JOIN role r ON u.role_id = r.id LEFT JOIN user_detail ud ON u.user_detail_id = ud.id \n#pageable\n", countQuery="SELECT COUNT(u) FROM User u", nativeQuery=true)
	Page<Object[]> findUserObjectsByPage(Pageable pageable);
	
	@Cacheable
	@Query(value="SELECT u.id, u.username, ud.first_name, ud.last_name, r.role FROM user u LEFT JOIN role r ON u.role_id = r.id LEFT JOIN user_detail ud ON u.user_detail_id = ud.id where u.id = :userId", nativeQuery=true)
	List<Object[]> findUserObjectById(@Param("userId") Long id);
	
	@Cacheable
	User findById(Long id);
	
	//@Cacheable	// Projection is not cacheable right now //java.io.NotSerializableException: org.springframework.data.projection.DefaultMethodInvokingMethodInterceptor
	@Query(value="SELECT u.id as userId, u.username as userName, u.userDetail.firstName as firstName, u.userDetail.lastName as lastName, u.userDetail.email as email, u.role.roleType as role FROM User u")
	Page<UserSummaryProjection> findUserBriefByPage(Pageable pageable);
}
