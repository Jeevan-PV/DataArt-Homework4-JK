package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CurriculumVitae {
	
	// important fields for validation
	private String name;
	private int age;
	private String address;
	private String email;
	
}
