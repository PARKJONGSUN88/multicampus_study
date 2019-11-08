package lab.latte.issue.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lab.latte.issue.model.TimelineVO;
import lab.latte.issue.service.IAPIService;


@Controller
public class APIsController<T, K, V> {
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(APIsController.class);

	@Resource(name = "apiService")
	private IAPIService<T, K, V> apiService;
	
	@Resource(name="envProperties")
	private Properties env;

	
	@RequestMapping(value = "/apis/getLastTimeunit", method = RequestMethod.POST)
	@ResponseBody
	public TimelineVO getLastTimeline() {
		TimelineVO result = apiService.getLastTimeunit();
		return result;	
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/apis/getPastTimeline", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getPastTimeline(@RequestBody Map<String, Object> params) {
		String yymmdd = (String)params.get("yymmdd");
		String hhmm = (String)params.get("hhmm");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("yymmddhhmm", yymmdd + hhmm);
		map.put("ea", 5);
				
		List<TimelineVO> pastTimeline = 
				(List<TimelineVO>)(apiService.getPastTimeline((Map<K, V>)map));
		
		List<TimelineVO> futureTimeline = 
				(List<TimelineVO>)(apiService.getFutureTimeline((Map<K, V>)map));
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("past", pastTimeline);
		resultMap.put("future", futureTimeline);
		
		return resultMap;
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/apis/getAround", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAround(@RequestBody Map<String, Object> params) {
		String yymmdd = (String)params.get("yymmdd");
		String hhmm = (String)params.get("hhmm");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("yymmdd", yymmdd);
		map.put("hhmm", hhmm);
		
		int cnt = apiService.isExistTimeunit((Map<K, V>)map);
		boolean isExist = cnt > 0 ? true : false;
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (cnt > 0) {
			resultMap.put("direction", 0);
			resultMap.put("yymmdd", yymmdd);
			resultMap.put("hhmm", hhmm);
		} else {
			map.put("yymmddhhmm", yymmdd + hhmm);
			List<TimelineVO> tList = 
					(List<TimelineVO>)apiService.getAroundTimeunit((Map<K, V>)map);
			
			if (tList.size() > 0) {
				resultMap.put("direction", 1);
				resultMap.put("yymmdd", tList.get(0).getYymmdd());
				resultMap.put("hhmm", tList.get(0).getHhmm());
				
			} else {
				resultMap.put("direction", -1);
			}		
		}
		
		return resultMap;	
	}
	
	
	
	
	
	
	@RequestMapping(value = "/apis/getTimeunitByPos", method = RequestMethod.POST)
	@ResponseBody
	public TimelineVO getTimelineByPos(@RequestBody Map<String, Object> params) {
		
		int posNum = (Integer)params.get("pos");
		
		TimelineVO result = apiService.getTimeunitByPos(posNum);
		return result;	
	}
}
