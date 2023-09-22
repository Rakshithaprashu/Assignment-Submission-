package sh.radical.samplecar.inputs;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sh.radical.samplecar.models.Award;
import sh.radical.samplecar.models.Owner;

@NoArgsConstructor
@Getter
public class CreateCarInput {

	public String name;

	public Owner owner;

	public String vehicleType;

	public List<Award> awards;
}
