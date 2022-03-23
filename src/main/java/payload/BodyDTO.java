package payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BodyDTO implements Serializable {
	private String id;
	private MetaDTO meta;
	private String thumb;
	private List<String> videoQuality;
	private List<UrlDTO> url;

}