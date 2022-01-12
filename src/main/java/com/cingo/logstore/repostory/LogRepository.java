package com.cingo.logstore.repostory;

import com.cingo.logstore.entity.Log;

import javax.persistence.Query;
import java.util.List;

public class LogRepository extends Repository {

	public List findAllOrdened() {
		Query query = this.getManager().createQuery("SELECT e FROM Log e ORDER BY occurrences desc");
		return query.getResultList();
	}
	
	public void add(Log log) {
		if (this.alreadyExists(log.getContent())) {
			Log firstLogFound = (Log) this.getLogs(log.getContent()).get(0);
			firstLogFound.newOcurrence(log.getOccurrences());
			this.update(firstLogFound);
		} else {
			super.add(log);
		}
	}
	
	private boolean alreadyExists(String content){
	    return !this.getLogs(content).isEmpty();
	}
	
	private List getLogs(String content){
	    Query query = this.getManager().createQuery("SELECT e FROM Log e WHERE content = :content");
	    query.setParameter("content", content);
	    return query.getResultList();
	}
}
