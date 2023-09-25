package sh.radical.testrr.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sh.radical.testrr.entities.UserContext;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Context {

	public UserContext userContext;

	public boolean isAuthenticated;
}
