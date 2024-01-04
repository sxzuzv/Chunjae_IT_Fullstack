package kr.co.chunjae;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/webpage02")
public class Example02Controller {
	// tiles가 적용된 Controller를 단순 복사한다고 해서 tiles가 그대로 적용되는 것이 아니다.
	// 해당 Controller에 대한 definition name을 지정해주어야 tiles가 적용된다.

	@GetMapping
	public String showForm() {
		return "webpage02";
	}	
		
}
