package sh.radical.testrr.inputs;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sh.radical.testrr.models.Mode;
import sh.radical.testrr.models.Owner;

@NoArgsConstructor
@Getter
public class UpdatePhoneInput {

	public String name;

	public Owner owner;

	public String phoneType;

	public List<Mode> model;
}
