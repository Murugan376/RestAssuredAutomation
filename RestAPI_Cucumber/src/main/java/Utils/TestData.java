package Utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.AddPlace;
import pojo.DeletePlace;
import pojo.Locationloc;

import java.util.Arrays;

public class TestData {



    public AddPlace addPlacePayload() {

        AddPlace place = new AddPlace();
        place.setAccuracy(90);
        place.setName("Murugan");
        place.setPhone_number("(+91) 94590189102");
        place.setAddress("29, side layout, cohen 09");
        place.setWebsite("http://google.com");
        place.setLanguage("Tamil");

        Locationloc loc = new Locationloc();
        loc.setLat(79.383494);
        loc.setLng(77.427362);

        place.setLocation(loc);
        place.setTypes(Arrays.asList("shoe park", "shop"));

        return place;
    }

    public AddPlace addPlacePayloadWithParamter(String name, String language, String address) {

        AddPlace place = new AddPlace();
        place.setAccuracy(90);
        place.setName(name);
        place.setPhone_number("(+91) 983 893 3937");
        place.setAddress(address);
        place.setWebsite("http://google.com");
        place.setLanguage(language);

        Locationloc loc = new Locationloc();
        loc.setLat(79.383494);
        loc.setLng(77.427362);

        place.setLocation(loc);
        place.setTypes(Arrays.asList("shoe park", "shop"));

        return place;
    }

    public DeletePlace deletePlace(String placeid) {

        DeletePlace deletePlace = new DeletePlace();
        deletePlace.setPlaceid(placeid);
        return deletePlace;
    }


}
