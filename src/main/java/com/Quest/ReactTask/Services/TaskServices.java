package com.Quest.ReactTask.Services;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.Quest.ReactTask.Entity.CSequenceEntity;
import com.Quest.ReactTask.Entity.TaskEntity;
import com.Quest.ReactTask.Repository.TaskRepository;


@Service
public class TaskServices {

	@Autowired
	TaskRepository tr;
	
	@Autowired
	 MongoOperations mongo;
	
	@Autowired
	TaskServices ts;
	
	public int getNextSequence(String seqName) {
		CSequenceEntity counter = mongo.findAndModify(
                query(where("_id").is(seqName)),
                new Update().inc("sqe",1),
                options().returnNew(true).upsert(true),
                CSequenceEntity.class);
            return counter.getSqe();
	}
	
	public TaskEntity saveall(TaskEntity t) {
		t.setId(ts.getNextSequence(TaskEntity.sqe_name));
		t.setTstatus("started");
		tr.save(t);
		return t;
	}
	
	public List<TaskEntity> getall(){
		List<TaskEntity> li = tr.findAll();
		return li;
	}
	
	public int deletebyid(int id) {
		tr.deleteById(id);
		return id;
	}

	public void saveupdated(int id, String tstatus) {
		Optional<TaskEntity> ot = tr.findById(id);
		TaskEntity te = ot.get();
		te.setTstatus("completed");
		tr.save(te);
	}

	
}
