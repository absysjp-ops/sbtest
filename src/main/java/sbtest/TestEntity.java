package sbtest;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "test")
@Getter
@Setter
public class TestEntity {
	//@Id + @GeneratedValue → 主キー（id）が自動生成
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//たとえば、nameをセット → save() → INSERT文
	private String name;
}
