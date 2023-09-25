package sh.radical.testrr.models;

import java.lang.Override;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Getter
@Setter
@Document
public class Mode {

	String name;

	String year;

	@Id
	String modeId;

	@Override
	public String toString() {
		return modeId;
	}

	public static String getNewModeId() {
		return UUID.randomUUID().toString();
	}
}
