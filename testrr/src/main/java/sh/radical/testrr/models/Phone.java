package sh.radical.testrr.models;

import java.lang.Override;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import sh.radical.testrr.models.Mode;
import sh.radical.testrr.models.Owner;

@NoArgsConstructor
@Getter
@Setter
@Document
public class Phone {

	@Id
	String phoneId;

	String name;

	Owner owner;

	String phoneType;

	List<Mode> model;

	@Override
	public String toString() {
		return phoneId;
	}

	public static String getNewPhoneId() {
		return UUID.randomUUID().toString();
	}
}
