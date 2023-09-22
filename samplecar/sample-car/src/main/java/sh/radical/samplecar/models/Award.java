package sh.radical.samplecar.models;

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
public class Award {

	String name;

	String year;

	@Id
	String awardId;

	@Override
	public String toString() {
		return awardId;
	}

	public static String getNewAwardId() {
		return UUID.randomUUID().toString();
	}
}
