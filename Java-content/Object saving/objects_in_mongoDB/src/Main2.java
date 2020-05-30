import com.google.gson.Gson;
import com.mongodb.*;

import java.util.Scanner;

public class Main2{
    public static void main(String[] args) {
        System.out.println("Enter 's' to save or enter 'l' to load...");
        Scanner input = new Scanner(System.in);
        String option = input.next();

        switch (option.toLowerCase()){
            case "s":
                save();
                break;
            case "l":
                load();
                break;
        }
    }
    public static void save(){
        //---------------------------------------------------------
        Employee ep1 = new Employee();
        ep1.setName("Nazhim");
        //---------------------------------------------------------
        MongoClient mongoClient = new MongoClient("localhost",27017);
        System.out.println("Mongo connection is successful");

        DB database = mongoClient.getDB("myDatabaseMain2");
        System.out.println("Database successfully created");

        DBCollection collection = database.getCollection("myCollectionMain2");
        System.out.println("Collection successfully created");

        collection.drop();
        System.out.println("Collection successfully dropped");

        Gson gson = new Gson();
        String json = gson.toJson(ep1);

        BasicDBObject basicDBObject = new BasicDBObject("ep1",json);
        collection.insert(basicDBObject);
        System.out.println("Object successfully saved");

    }

    // Since we are using a Basic Object instead of a Document to insert data it's best to use 'DB'

    public static void load(){
        MongoClient mongoClient = new MongoClient("localhost",27017);
        System.out.println("Mongo connection is successful");

        DB database = mongoClient.getDB("myDatabaseMain2");
        System.out.println("Database successfully loaded");

        DBCollection collection = database.getCollection("myCollectionMain2");
        System.out.println("Collection successfully loaded");

        DBCursor cursor = collection.find();
        System.out.println("Collecting the data from the collection into cursor is successful");

        Gson gson = new Gson();

        for(DBObject object : cursor){
            String name = (String) object.get("ep1");
            Employee loadObject = gson.fromJson(name, Employee.class);
            System.out.println(loadObject.getName());
        }


    }

}