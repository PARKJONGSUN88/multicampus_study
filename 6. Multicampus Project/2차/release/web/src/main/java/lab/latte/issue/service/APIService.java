package lab.latte.issue.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.latte.issue.dao.ITimelineDAO;
import lab.latte.issue.model.TimelineVO;

@Service("apiService")
public class APIService<T, K, V> implements IAPIService<T, K, V> {
	
	@Autowired
	private ITimelineDAO<T, K, V> dao;

	@Override
//	@Transactional
	public TimelineVO getLastTimeunit() {
		return dao.getLastTimeunit();
	}
	
	@Override
	public TimelineVO getTimeunitByTime(Map<K, V> map) {
		return dao.getTimeunitByTime(map);
	}
	
	@Override
	public int isExistTimeunit(Map<K, V> map) {
		return dao.isExistTimeunit(map);
	}
	
	@Override
	public List<T> getAroundTimeunit(Map<K, V> map) {
		return dao.getAroundTimeunit(map);
	}

	@Override
	public TimelineVO getTimeunitByPos(int pos) {
		return dao.getTimeunitByPos(pos);
	}
	
	@Override
	public List<T> getPastTimeline(Map<K, V> map) {
		return dao.getPastTimeline(map);
	}
	
	@Override
	public List<T> getFutureTimeline(Map<K, V> map) {
		return dao.getFutureTimeline(map);
	}
	
}
