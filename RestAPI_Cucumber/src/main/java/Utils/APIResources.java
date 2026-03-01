package Utils;


//enum is a special class in java and it is collection of constants or methods in java
public enum APIResources {

    //All are constant Path - declared string name exactly (String values inside)
    //generate methods and constructors for it.
    AddPlaceAPIs("/maps/api/place/add/json"),
    AddPlaceAPI("/maps/api/place/add/json"),
    getPlaceAPI("/maps/api/place/get/json"),
    deletePlaceAPI("/maps/api/place/delete/json");

    private String resource;

    //constructor
    APIResources(String resourcename) {
        this.resource = resourcename;
    }

    public String getresourcename() {
        return resource;
    }

}
