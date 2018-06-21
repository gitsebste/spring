/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import com.example.demo.domain.Item;
import com.example.demo.domain.Location;
import com.example.demo.domain.Person;
import com.example.demo.domain.Unit;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.UnitRepository;
import com.example.demo.service.ItemService;
import com.example.demo.service.LocationService;
import com.example.demo.service.PersonService;
import com.example.demo.service.UnitService;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author device02
 */

@Component
public class MessingWithData {
    
                //@Autowired
    private  ItemRepository itemRepository;
    //@Autowired
    private  PersonRepository personRepository;
        //@Autowired
    private      UnitRepository unitRepository;
    private      LocationRepository locationRepository;

    public LocationRepository getLocationRepository() {
        return locationRepository;
    }
@Autowired
    public void setLocationRepository(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public ItemRepository getItemRepository() {
        return itemRepository;
    }
@Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public PersonRepository getPersonRepository() {
        return personRepository;
    }
@Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public UnitRepository getUnitRepository() {
        return unitRepository;
    }
@Autowired
    public void setUnitRepository(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }
        
        
        
        public  String hostAndPort = "http://localhost:8081/";
        public  String[] repositories = new String[]{"units","persons","items","locations"};
    
        @Autowired
                    public void setUnitService(UnitService unitService) {
        this.unitService = unitService;
    }
        UnitService unitService;
                @Autowired
                    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
        PersonService personService;
                                
        ItemService itemService;
@Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }
LocationService locationService;
@Autowired
    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }
        
    public   void getData() {
        
        Iterable<Unit> units = unitService.getAll();
        for(Unit tmp : units)
            System.out.println(tmp);
               
        Iterable<Person> persons = personService.getAll();                
        for(Person tmp : persons)
            System.out.println(tmp);
        
        Iterable<Item> items = itemService.getAll();                
        for(Item tmp : items)
            System.out.println(tmp);
        
        //locations
        Iterable<Location> locations = locationService.getAll();                
        for(Location tmp : locations)
            System.out.println(tmp);
                
        /*
ArrayList<Unit> units = getUnits(hostAndPort+repositories[0]);
        for(Unit tmp : units)
            System.out.println(tmp);
        
        ArrayList<Person> persons = getPersons(hostAndPort+repositories[1]);
        for(Person tmp : persons)
            System.out.println(tmp);

                ArrayList<Item> items = getItems(hostAndPort+repositories[2]);
        for(Item tmp : items)
            System.out.println(tmp);

        ArrayList<Location> locations = getLocations(hostAndPort+repositories[3]);
        for(Location tmp : locations)
            System.out.println(tmp);
*/
    }
        
        
        
//        public static <T extends Object> T getObj(String url,Class<T> type){
//            T ret  = new T();
//    return type.cast("");
//}
        



    public   void saveData() {
        itemRepository.deleteAll();personRepository.deleteAll();
        unitRepository.deleteAll();locationRepository.deleteAll();
        
                        Person p = new Person();
                p.setName("Jan");p.setLastName("Kowalski");p.setEmail("email@email.com");
                
                                Unit u2 = new Unit();
                u2.setName("Wydział Telekomunikacji, Informatyki i Elektrotechniki");
                u2.setShortName("WTIE"); 		            
                
                Location location = new Location();
                location.setBuilding((float) 2.5);
                location.setDescription("Tutaj studenci WTIE załatwiją formalności...");
                location.setFloor(0);
                location.setName("Dziekanat WTIE");
                location.setRoom(120);
                
                Item i = new Item();i.setCode("item000001");i.setName("n");i.setDescription("d");
		i.setPerson(p);  i.setUnit(u2);i.setLocation(location);
                itemRepository.save(i);

                        Person p2 = new Person();
                p2.setName("Jan");p2.setLastName("Nowak");p2.setEmail("email2@email.com");
                personRepository.save(p2);
                Unit u = new Unit();
                u.setName("Wydział Zarządzania");
                u.setShortName("WZ"); 		            
                unitRepository.save(u);
//                Unit u2 = new Unit();
//                u2.setName("Wydział Telekomunikacji, Informatyki i Elektrotechniki");
//                u2.setShortName("WTIE"); 		            
//                unitRepository.save(u2);
    }

    public   ArrayList<Unit> getUnits(String url) {
        ResponseEntity<Object> response = getResponseObject(url);
        ArrayList<Unit> ret = new ArrayList<>();
        int i=0;
        LinkedHashMap body = (LinkedHashMap)response.getBody();
        if(!(body.containsKey("_embedded"))){                        
                        if(!(body.containsKey("name"))){
                            ret.add(null);return ret;
                        }
            ret.add(getUnitFromLinkedHashMap(body));
            return ret;
        }
        else
        for(Object o : 
                ((ArrayList) (((LinkedHashMap) 
        ((body).get("_embedded"))).get(repositories[0]))) ){
            Unit tmp = getUnitFromLinkedHashMap((LinkedHashMap)o);
    ret.add(tmp);
}        
assertThat(response.getStatusCode(), equalTo(HttpStatus.OK)); 
return ret;
    }
        public   ArrayList<Person> getPersons(String url) {
        ResponseEntity<Object> response = getResponseObject(url);
        ArrayList<Person> ret = new ArrayList<>();
        int i=0;
        LinkedHashMap body = (LinkedHashMap)response.getBody();
        if(!(body.containsKey("_embedded"))){                        
                        if(!(body.containsKey("name"))){
                            ret.add(null);return ret;
                        }
            ret.add(getPersonFromLinkedHashMap(body));
            return ret;
        }
        else
        for(Object o : 
                ((ArrayList) (((LinkedHashMap) 
        ((body).get("_embedded"))).get(repositories[1]))) ){
            Person tmp = getPersonFromLinkedHashMap((LinkedHashMap)o);
    ret.add(tmp);
}        
assertThat(response.getStatusCode(), equalTo(HttpStatus.OK)); 
return ret;
    }


    private Person getPersonFromLinkedHashMap(LinkedHashMap linkedHashMap) throws NumberFormatException {
        Person tmp = new Person();
        tmp.setName((String) linkedHashMap.get("name"));
        tmp.setEmail((String) linkedHashMap.get("email"));
        tmp.setLastName((String) linkedHashMap.get("lastName"));
        LinkedHashMap links = (LinkedHashMap) (linkedHashMap).get("_links");
        LinkedHashMap self = (LinkedHashMap) (links).get("self");
        String href = (String) (self).get("href");
        tmp.setId(Integer.valueOf(href.substring(href.lastIndexOf('/') + 1)));
        return tmp;
    }

    public   ResponseEntity<Object> getResponseObject(String url) throws RestClientException {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Object> response
                = restTemplate.getForEntity(url , Object.class);
        return response;
    }
    private ArrayList<Item> getItems(String url) {
        ResponseEntity<Object> response = getResponseObject(url);
        ArrayList<Item> items = new ArrayList<>();
        int i=0;
        for(Object o : 
                ((ArrayList) (((LinkedHashMap) 
        (((LinkedHashMap)response.getBody()).get("_embedded"))).get(repositories[2]))) ){
            Item tmp = new Item();   
            tmp.setCode((String) ((LinkedHashMap)(o)).get("code"));
            tmp.setDescription((String) ((LinkedHashMap)(o)).get("description"));
            //tmp.setLocation(location);
            tmp.setName((String) ((LinkedHashMap)(o)).get("name"));
            //tmp.setPerson(person);
            //tmp.setUnit(unit);
    LinkedHashMap links = (LinkedHashMap) ((LinkedHashMap)(o)).get("_links");
    tmp.setPerson(getPerson(links));
    tmp.setUnit(getUnit(links));
    tmp.setLocation(getLocation(links));
    LinkedHashMap self = (LinkedHashMap) (links).get("self");
    String href = (String) (self).get("href");
    tmp.setId(Integer.valueOf(href.substring(href.lastIndexOf('/') + 1)));
    items.add(tmp);
}        
assertThat(response.getStatusCode(), equalTo(HttpStatus.OK)); 
return items;
    }

    private Person getPerson(LinkedHashMap links) {
            LinkedHashMap self = (LinkedHashMap) (links).get("person");
    String href = (String) (self).get("href");
    return getPersons(href).get(0);
    }    

    private Unit getUnitFromLinkedHashMap(LinkedHashMap body) {
        Unit unit = new Unit();            
            unit.setName((String) body.get("name"));
            unit.setShortName((String) body.get("shortName"));
    LinkedHashMap links = (LinkedHashMap) body.get("_links");
    LinkedHashMap self = (LinkedHashMap) (links).get("self");
    String href = (String) (self).get("href");
    unit.setId(Integer.valueOf(href.substring(href.lastIndexOf('/') + 1)));
    return unit;
    }

    private Unit getUnit(LinkedHashMap links) {
                    LinkedHashMap self = (LinkedHashMap) (links).get("unit");
    String href = (String) (self).get("href");
    return getUnits(href).get(0);
    }

    private ArrayList<Location> getLocations(String url) {
ResponseEntity<Object> response = getResponseObject(url);
        ArrayList<Location> ret = new ArrayList<>();
        int i=0;
        LinkedHashMap body = (LinkedHashMap)response.getBody();
        if(!(body.containsKey("_embedded"))){                        
                        if(!(body.containsKey("name"))){
                            ret.add(null);return ret;
                        }
            ret.add(getLocationFromLinkedHashMap(body));
            return ret;
        }
        else
        for(Object o : 
                ((ArrayList) (((LinkedHashMap) 
        ((body).get("_embedded"))).get(repositories[3]))) ){
    ret.add(getLocationFromLinkedHashMap((LinkedHashMap)o));
}        
assertThat(response.getStatusCode(), equalTo(HttpStatus.OK)); 
return ret;
    }

    private Location getLocationFromLinkedHashMap(LinkedHashMap body) {
                Location ret = new Location();            
            ret.setName((String) body.get("name"));
            ret.setBuilding((float) (double) body.get("building"));
            ret.setDescription((String) body.get("description"));
            ret.setFloor((int) body.get("floor"));
            ret.setRoom((float) (double) body.get("room"));
    LinkedHashMap links = (LinkedHashMap) body.get("_links");
    LinkedHashMap self = (LinkedHashMap) (links).get("self");
    String href = (String) (self).get("href");
    ret.setId(Integer.valueOf(href.substring(href.lastIndexOf('/') + 1)));
    return ret;
    }

    private Location getLocation(LinkedHashMap links) {
                            LinkedHashMap self = (LinkedHashMap) (links).get("location");
    String href = (String) (self).get("href");
    return getLocations(href).get(0);
    }
}
