package lab.latte.issue.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import lab.latte.issue.model.TimelineVO;
import lab.latte.issue.service.IAPIService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController<T, K, V> {
	
	@SuppressWarnings("unused")
	private static final Logger logger = 
			LoggerFactory.getLogger(HomeController.class);
	
	@Resource(name="envProperties")
	private Properties env;
	
	@Resource(name = "apiService")
	private IAPIService<T, K, V> apiService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {	
		TimelineVO timeunit = apiService.getLastTimeunit();
		model.addAttribute("timeunit", timeunit);
		
		return "home";
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home_post(
			Model model, @RequestParam Map<String,Object> reqMap ) {
		
		int yymmdd = Integer.parseInt((String)reqMap.get("yymmdd")) % 1000000;
		int hhmm = Integer.parseInt((String)reqMap.get("hhmm"));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("yymmdd", yymmdd);
		map.put("hhmm", hhmm);
		
		TimelineVO timeunit = apiService.getTimeunitByTime((Map<K, V>)map);
		model.addAttribute("timeunit", timeunit);
	
		return "home";
	}
	
	
	@RequestMapping(value = "/page-test", method = RequestMethod.GET)
	public String pageTest(Locale locale, Model model) {
		
		return "page-test";
	}
	
	
	@Resource(name = "restTemplate")
	protected RestTemplate restTemplate;
	
	@RequestMapping(value = "api/searching" , method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> searchNaver (String[] main , String keyword , String nowTime  ,
			Model model ) throws  Exception {
		
		// 보내줄 저장공간 선언
        Map<String, Object> resultMap = new HashMap<String, Object>();
        
     

		try {

			
			String apiURL = "https://openapi.naver.com/v1/search/news.json?query=" + keyword ;
			
			for(int i=0; i< 3 ;i++) {
				
				if(i < main.length) {
					apiURL += "+|+" + main[i];
				}else {
					break;
				}
				
				
			}
    		apiURL += "&display=10&start=1&sort=sim";
    		
		
    	
    		
    	//api 요청
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		Map<String,String> keyvalue = new HashMap<String, String>();
		String ID = env.getProperty("clientId");
		String IDID = env.getProperty("clientSecret");
		
		keyvalue.put("X-Naver-Client-Id" , ID);
		keyvalue.put( "X-Naver-Client-Secret", IDID);
		
		headers.setAll(keyvalue);
		
		HttpEntity entity = new HttpEntity("parameters" , headers);
		ResponseEntity response = restTemplate.exchange(apiURL,  HttpMethod.GET , entity , String.class);
		
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(response.getBody().toString());
		JSONArray docuArray = (JSONArray)jsonObject.get("items");
		
		
		//처리된 데이터 저장 장소
		List originallink = new ArrayList();
		List description = new ArrayList();
		List title = new ArrayList();
		List clink = new ArrayList();
		List cdes = new ArrayList();
		
			/* for(int i = 0 ; i <docuArray.size() ; i++) { */
		for(int i = 0 ; i < 4 ; i++) {	
			//데이터 전처리
			JSONObject tmp = (JSONObject)docuArray.get(i);
			if( i < tmp.size()) {
					
						String cutlink = (String)tmp.get("originallink");
						String[] cutlink2 =	cutlink.split("/");
						String cutdes = (String)tmp.get("description");
						
						
							//뉴스기사 길이 100개로 자르고 저장공간에 add!
							if(cutdes.length()>80) {
								String cutdes2 = cutdes.substring(0,80) + "...";
									cdes.add(cutdes2);
								}else{	
								String cutdes2 = cutdes + "...";
									cdes.add(cutdes2);
				
								}
							
					    //타이블 저장공간에 add
						title.add((String)tmp.get("title"));
						//뉴스 본문 저장공간에 add
						description.add((String)tmp.get("description"));
			
						//링크 주소 저장공간에 add
						//간략 주소 저장공간에 add
						if(((String)tmp.get("originallink")).length() != 0) {
							originallink.add((String)tmp.get("originallink"));
							clink.add(cutlink2[2]);
						}else {
							clink.add("");
							originallink.add("");
						}
						
						
			}else {
				cdes.add("");
				title.add("");
				originallink.add("");
				description.add("");
				clink.add("");
				}
			
		}
		//ajax로 보내기 위한 공간에 저장된 저장공간 추가!
			resultMap.put("cdes" , cdes);		
			resultMap.put("clink" , clink);
			resultMap.put("description", description);
			resultMap.put("title", title);
			resultMap.put("originallink", originallink);
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		//ajax로 전송!
    	return resultMap;
	}
}

