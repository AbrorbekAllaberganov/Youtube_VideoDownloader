package payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubtitleDTO implements Serializable {
	private String token;
	private List<String> language;

}