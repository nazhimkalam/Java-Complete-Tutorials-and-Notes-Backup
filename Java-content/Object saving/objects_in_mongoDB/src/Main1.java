import com.google.gson.Gson;
import com.mongodb.Block;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        List<Collection<Object>> data = new ArrayList<>();

        MongoClient mongoClient = new MongoClient("localhost",27017);                           // Connect with default settings i.e. localhost:27017
        MongoDatabase db = mongoClient.getDatabase("test");      // Get database "test". Creates one if it doesn't exist
        MongoCollection<Document> collection = db.getCollection("sampleCollection");

        //------------------------------------------------------------------------------------------- Create java object
        Employee employee = new Employee();
        employee.setNo(1L);
        employee.setName("yogesh");

        Employee employee1 = new Employee();
        employee1.setNo(38);
        employee1.setName("Nazhim");
        //---------------------------------------------------------------------------- Deserialize object to json string
        Gson gson = new Gson();
        String json = gson.toJson(employee);
        String json1 = gson.toJson(employee1);
        //---------------------------------------------------------------------------- Parse to bson document and insert
        Document doc = Document.parse(json);
        Document doc1 = Document.parse(json1);
        collection.insertOne(doc);
        collection.insertOne(doc1);
//        collection.drop();                                                                     //dropping the collection
        System.out.println("Object employee successfully inserted");
        //----------------------------------------------------------------------- Retrieve to ensure object was inserted
        FindIterable<Document> iterable = db.getCollection("sampleCollection").find();
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document.values());             // See below to convert document back to Employee
                data.add(document.values());
            }
        });

        //-----------------------------------------------------------------------


        System.out.println("These are the data contained in the data array list");
        for(int index = 0; index < data.size(); index++){
            System.out.println("----------------------Employee details number" + (index+1)  +"------------------------");
            System.out.println("The employee id is " + data.get(index).toArray()[1]);
            System.out.println("The employee name is " + data.get(index).toArray()[2]);
            System.out.println("---------------------------------------------------------------");
        }
    }
}
