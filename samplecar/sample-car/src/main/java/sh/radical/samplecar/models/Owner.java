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
public class Owner {

	String name;

	@Id
	String ownerId;

	@Override
	public String toString() {
		return ownerId;
	}

	public static String getNewOwnerId() {
		return UUID.randomUUID().toString();
	}
}
