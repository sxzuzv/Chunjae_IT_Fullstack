package kr.co.chunjae;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/webpage01")
public class Example01Controller {	

	@GetMapping
	public String showForm() {
		// tiles가 WEB-INF 하위에 위치하므로, 곧바로 호출할 수가 없다.
		// 그러므로 controller를 통해서 호출하는 방식을 사용한다.
		return "webpage01";
	}	
		
}
