package payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDTO implements Serializable {
	private boolean hasError;
	private int errorCode;
	private BodyDTO body;
}