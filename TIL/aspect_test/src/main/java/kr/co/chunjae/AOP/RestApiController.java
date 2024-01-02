package kr.co.chunjae.AOP;

import kr.co.chunjae.AOP.annotation.Timer;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

/**
 * Log 찍기 예제 : AOP를 사용하지 않는 경우
 */

// @RestController = @Controller(Bean에 등록) + @ResponseBody(view가 없이도 웹으로 출력 가능 (String 혹은 JSON))
// @Controller가 @RestController 내에 포함돼 있다.

@RestController
@RequestMapping("/aoptest")
public class RestApiController {

//    @GetMapping("/get/{id}")
//    public void get(@PathVariable Long id,
//                    @RequestParam String name) {
//        System.out.println("get method");
//        System.out.println("get method " + id);
//        System.out.println("get method " + name);
//    }
//
//    // GET method 이외의 method는 웹 상에서 정상 작동되는지 확인이 불가하다.
//    // 그러므로, POSTMAN을 사용하여 정상 작동이 되는지 파악하도록 한다.
//    @PostMapping("/post")
//    public void post(@RequestBody User user) {
//        System.out.println("post method : " + user);
//    }

    /**
     * Log 찍기 예제 : AOP를 사용하는 경우
     */
//    @GetMapping("/get/{id}")
//    public String get(@PathVariable Long id,
//                      @RequestParam String name) {
//        System.out.println("get method");
//        // System.out.println("get method " + id);
//        // System.out.println("get method " + name);\
//
//        // @RestController annotation을 사용하였으므로 별도의 view(.jsp) 없이도 웹 상에서 return문을 확인할 수 있다.
//        return id + " " + name;
//    }

//    @PostMapping("/post")
//    public User post(@RequestBody User user) {
//        System.out.println("post method : " + user);
//        return user;
//    }


    /**
     * Timer 사용 예제 : AOP를 사용하지 않는 경우
     */

    // 시간을 측정하는 StopWatch를 메소드마다 만들어주고 실행한다.
    // 비즈니스 로직과는 전혀 상고나 없는 부가적인 로직이 메소드마다 포함돼 있다.
    // 이를 해결하기 위해 AOP를 사용한다. (비즈니스 로직과 부가적인 로직을 분리한다.)
    @PostMapping("/post")
    public User post(@RequestBody User user) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println("post method : " + user);
        Thread.sleep(1000 * 2);
        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());
        return user;
    }
//
//
//    @DeleteMapping("/delete")
//    public void delete() throws InterruptedException {
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//        stopWatch.stop();
//
//        Thread.sleep(1000 * 2);
//        // AOP를 사용하지 않았으므로 출력문을 통해 시간을 확인한다.
//        System.out.println("total time : " + stopWatch.getTotalTimeSeconds());
//    }

    //  @Timer : 메소드의 시간을 측정할 수 있으므로 외부와 통신을 하거나, DataBase를 사용하여 시간이 얼마나 걸렸는지 필요할 경우에 사용한다.
    // @Timer를 사용하여 측정한 시간을 Database에 저장하거나, 모니터링 하는데 사용할 수 있다.
    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {
        // AOP를 적용하였으므로 별도의 출력문이 필요하지 않다.
        Thread.sleep(1000 * 2);
    }

}
