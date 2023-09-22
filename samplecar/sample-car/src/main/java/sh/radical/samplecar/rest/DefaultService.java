package sh.radical.samplecar.rest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface DefaultService {
	@GET
	Call<String> c1(@Body String payload);
}
