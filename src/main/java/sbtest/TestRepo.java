package sbtest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//Spring Data JPA で CRUD 操作を自動化
public interface TestRepo extends JpaRepository<TestEntity, Long> {

	//完全一致検索
	List<TestEntity> findByName(String name);


}
