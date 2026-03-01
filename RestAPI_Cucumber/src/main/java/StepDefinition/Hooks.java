package StepDefinition;

import Utils.APIResources;
import org.junit.*;
import io.cucumber.java.Before;

import java.io.IOException;

import static Utils.APIResources.AddPlaceAPI;

public class Hooks {

    @Before("@DeletePlace")
    public void runBeforeTestcase() throws IOException {

        StepDefinitions def = new StepDefinitions();
        if(StepDefinitions.place_id==null) {
            def.add_place_payload();

            //instead of pass the value we need to pass the parameter here
            def.user_Calls_With_Http_Request(String.valueOf(AddPlaceAPI), "post");
        }
    }
}
