package io.github.mlanlazc.services;

import io.github.mlanlazc.exceptions.ApiException;
import io.github.mlanlazc.http.*;
import io.github.mlanlazc.http.util.HttpHeaders;
import io.github.mlanlazc.http.util.HttpUrl;
import io.github.mlanlazc.models.BaseModel;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PetsService extends BaseService implements PetsClient {

  public PetsService(OkHttpClient httpClient, String serverUrl) {
    super(httpClient, serverUrl);
  }

  /**
   * @summary List all pets
   * @param {Integer} [limit] - How many items to return at one time (max 100)
   */
  public java.util.List<io.github.mlanlazc.models.Pet> listPets(Integer limit) throws ApiException {
    String url = HttpUrl
      .builder(this.serverUrl)
      .addPathParameter("pets")
      .addOptionalQueryParameter("limit", limit)
      .build();
    Request request = new Request.Builder().url(url).get().build();
    Response response = this.execute(request);

    return ModelConverter.convert(
      response,
      new com.fasterxml.jackson.core.type.TypeReference<java.util.List<io.github.mlanlazc.models.Pet>>() {}
    );
  }

  /**
   * @summary Create a pet
   */
  public String createPets(io.github.mlanlazc.models.Pet input) throws ApiException {
    String url = HttpUrl.builder(this.serverUrl).addPathParameter("pets").build();
    RequestBody requestBody = RequestBody.create(
      Objects.requireNonNull(ModelConverter.modelToJson(input)),
      okhttp3.MediaType.parse("application/json; charset=utf-8")
    );
    Request request = new Request.Builder().url(url).post(requestBody).build();
    Response response = this.execute(request);

    try {
      return response.body().string();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * @summary Info for a specific pet
   * @param {String} petId - The id of the pet to retrieve
   */
  public io.github.mlanlazc.models.Pet showPetById(String petId) throws ApiException {
    String url = HttpUrl
      .builder(this.serverUrl)
      .addPathParameter("pets")
      .addPathParameter(String.valueOf(petId))
      .build();
    Request request = new Request.Builder().url(url).get().build();
    Response response = this.execute(request);

    return ModelConverter.convert(
      response,
      new com.fasterxml.jackson.core.type.TypeReference<io.github.mlanlazc.models.Pet>() {}
    );
  }
}
