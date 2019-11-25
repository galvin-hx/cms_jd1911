package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.Logs;

public interface ILogsService {

	List<Logs> findAll();
	void saveOrUpdate(Logs logs);
	int deleteById(long id);
}
