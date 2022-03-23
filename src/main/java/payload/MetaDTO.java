package payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MetaDTO implements Serializable {
	private String title;
	private String source;
	private String duration;
	private String tags;
	private SubtitleDTO subtitle;

}