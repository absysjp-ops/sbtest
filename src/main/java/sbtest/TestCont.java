package sbtest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestCont {


	@GetMapping("/test")
	public String EntityTest1() {


		return "v_test";
	}

}
