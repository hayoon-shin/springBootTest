package com.kh.domain;

import java.util.Date;
import java.util.List;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
public class Member {
	@NotBlank(message = "공백이나 빈칸일 수 없습니다 ")
	private String userId;
	private String password;
	private List<String> hobbyList;
	private int coin;
	private String email;
	private String userName;
	private Date dateofBirth;
	
}
