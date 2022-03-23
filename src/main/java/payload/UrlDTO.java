package payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UrlDTO implements Serializable {
	private String url;
	private String name;
	private String subname;
	private String infoUrl;
	private String type;
	private String ext;
	private boolean downloadable;
	private String quality;
	private boolean audio;
	private boolean noAudio;
	private String itag;
	private int filesize;
}