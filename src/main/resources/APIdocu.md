## How to consume the Species API

Get the API instance:

For that, you will need to get the API instance onEnable and save it somewhere easily for you to retrieve.
DO NOT GET THE API INSTANCE EVERYTIME YOU NEED IT. GENERATE ONE AND KEEP IT

```java example-good
private static API api;

public void onEnable(){
    api = Ergos_Species.getAPI();  
}

public static API getAPI(){
    return api;
}
```

You can then use the API object to retrieve all the Data you want. 

```java example-good
private static API api;

public String getPlayersSpeciesAsDislay(Player player){
    return api.getSpecies(player).getType().getDisplayName();
}
```