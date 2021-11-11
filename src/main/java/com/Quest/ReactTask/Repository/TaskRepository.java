package com.Quest.ReactTask.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.Quest.ReactTask.Entity.TaskEntity;

public interface TaskRepository extends MongoRepository<TaskEntity, Integer>{

	
}
