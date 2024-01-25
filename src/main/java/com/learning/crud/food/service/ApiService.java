package com.learning.crud.food.service;

import com.learning.crud.food.model.FoodItem;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {
    private static final String API_URL = "https://world.openfoodfacts.org/api/v0/product/%s?fields=product_name,allergens,code,image_url,nova_group,nutriscore_data,nutriments";

    private final HttpClient httpClient;
    private final String barcode;

    public ApiService(String barcode) throws Exception {
        this.httpClient = HttpClient.newHttpClient();
        this.barcode = barcode;
    }

    private JSONObject fetchDataRaw() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format(API_URL,this.barcode)))
                .build();
        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(ApiService::parseJson).join();
    }

    public FoodItem getFoodItem() {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        JSONObject dataRaw = fetchDataRaw();
        JSONObject productJson = dataRaw.getJSONObject("product");
        return gson.fromJson(productJson.toString(), FoodItem.class);
    }

    private static JSONObject parseJson(String responseBody) {
        return new JSONObject(responseBody);
    }


}
