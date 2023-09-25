package sh.radical.testrr.rest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface DefaultService {
	@GET
	Call<String> r1(@Body String payload);
}
