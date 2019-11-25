package com.briup.apps.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.Logs;
import com.briup.apps.cms.bean.LogsExample;
import com.briup.apps.cms.dao.LogsMapper;
import com.briup.apps.cms.service.ILogsService;

@Service
public class LogsServiceImpl implements ILogsService {

	@Resource
    private LogsMapper logsMapper;
	
	@Override
	public List<Logs> findAll() {
		LogsExample example = new LogsExample();
		return logsMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void saveOrUpdate(Logs logs) {
		logsMapper.insert(logs);
	}

	@Override
	public int deleteById(long id) {
		logsMapper.deleteByPrimaryKey(id);
		return 0;
	}

}
