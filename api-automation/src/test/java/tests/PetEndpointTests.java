package tests;

import base.BaseTest;
import fluent.FluentAPI;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class PetEndpointTests extends BaseTest {

    FluentAPI api = new FluentAPI();

    // Utility method to generate a random Pet ID
    private int generateRandomId() {
        return new Random().nextInt(10000) + 1;
    }

    @Test(description = "Create a new pet with valid data.")
    public void testCreatePet() {
        int petId = generateRandomId();
        String endpoint = "/pet";
        String payload = "{ \"id\": " + petId + ", \"name\": \"TestPet\", \"status\": \"available\" }";

        Response response = api.post(endpoint, payload);

        Assert.assertEquals(response.statusCode(), 200, "Failed to create the pet.");
        Assert.assertEquals(response.jsonPath().getInt("id"), petId, "Pet ID mismatch.");
        Assert.assertEquals(response.jsonPath().getString("name"), "TestPet", "Pet name mismatch.");
        Assert.assertEquals(response.jsonPath().getString("status"), "available", "Pet status mismatch.");
    }

    @Test(description = "Get an existing pet by its ID.")
    public void testGetPetById() {
        int petId = 123; // Assumes pet ID 123 exists
        String endpoint = "/pet/" + petId;

        Response response = api.get(endpoint);

        Assert.assertEquals(response.statusCode(), 200, "Failed to fetch the pet."+petId);
        Assert.assertEquals(response.jsonPath().getInt("id"), petId, "Pet ID mismatch.");
    }

    @Test(description = "Update an existing pet's status.")
    public void testUpdatePet() {
        int petId = 123; // Assumes pet ID 123 exists
        String endpoint = "/pet";
        String updatedPayload = "{ \"id\": " + petId + ", \"name\": \"UpdatedPet\", \"status\": \"sold\" }";

        Response response = api.put(endpoint, updatedPayload);

        Assert.assertEquals(response.statusCode(), 200, "Failed to update the pet.");
        Assert.assertEquals(response.jsonPath().getString("name"), "UpdatedPet", "Pet name was not updated.");
        Assert.assertEquals(response.jsonPath().getString("status"), "sold", "Pet status was not updated.");
    }

    @Test(description = "Delete an existing pet by its ID.")
    public void testDeletePet() {
        int petId = 123; // Assumes pet ID 123 exists
        String endpoint = "/pet/" + petId;

        Response deleteResponse = api.delete(endpoint);
        Assert.assertEquals(deleteResponse.statusCode(), 200, "Failed to delete the pet.");

        Response getResponse = api.get(endpoint);
        Assert.assertEquals(getResponse.statusCode(), 404, "Deleted pet still exists.");
    }

    @Test(description = "Attempt to fetch a non-existent pet.")
    public void testGetNonExistentPet() {
        int invalidPetId = 999999;
        String endpoint = "/pet/" + invalidPetId;

        Response response = api.get(endpoint);

        Assert.assertEquals(response.statusCode(), 404, "Expected 404 for invalid pet ID.");
    }
}
