package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "mem")
@Data
public class MemDto {
	@Id
	@Column(name = "num")
	private int num;
	
	@Column(nullable = false)
	private String name;
	
	private String addr;
}
