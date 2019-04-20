package com.ocean.mvn.spring.orm.demos.mongo.data.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ocean.mvn.spring.orm.demos.mongo.data.entity.User;

/** 
 	Repository Interface 
 			^
 	CrudRepository Interface
 			^
 	PagingAndSortingRepository Interface
 			^
 	MongoRepository Interface
**/

//If you don't user @Repository(value="userMongoRepository") then spring will try to create bean with name userRepository which already exist since we have another UserRepository file and it will throw exception.
@Repository(value="userMongoRepository")
public interface UserRepository extends MongoRepository<User, String>
{
	User findByUsername(String username);
	
	// db.users.findOne({"userDetail.address" : {$regex : ".*text.*"}});
	@Query(value="{'userDetail.address': {$regex: ?0}}")		// This is equals to: address like '%text%'
	List<User> findByAddress(String address);
}