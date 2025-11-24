package sbtest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestCont {

	private final TestRepo testRepo;

	public TestCont(TestRepo testRepo) {
		this.testRepo = testRepo;
	}

	@GetMapping("/")
	public String EntityTest1() {

		//IDから取得テスト
		var entity = testRepo.findById(2L).orElse(new TestEntity());

		System.out.println(entity.getName());


		return "v_test";
	}

}
