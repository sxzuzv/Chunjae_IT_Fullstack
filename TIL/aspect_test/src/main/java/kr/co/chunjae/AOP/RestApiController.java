package kr.co.chunjae.AOP;

import org.springframework.web.bind.annotation.*;

/**
 * Log 찍기 예제 : AOP를 사용하지 않는 경우
 */

// @RestController = @Controller(Bean에 등록) + @ResponseBody(view가 없이도 웹으로 출력 가능 (String 혹은 JSON))
// @Controller가 @RestController 내에 포함돼 있다.

@RestController
@RequestMapping("/aoptest")
public class RestApiController {

    @GetMapping("/get/{id}")
    public void get(@PathVariable Long id,
                    @RequestParam String name) {
        System.out.println("get method");
        System.out.println("get method " + id);
        System.out.println("get method " + name);
    }

    @PostMapping("/post")
    public void post(@RequestBody User user) {
        System.out.println("post method : " + user);
    }
}
