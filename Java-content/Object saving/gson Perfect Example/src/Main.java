import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Nazhim");
        student.setAge(18);

      /*  //saving object
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB database = mongoClient.getDB("objects");
        DBCollection dbCollection = database.getCollection("collectionObject");
        try{
            Gson gson = new Gson();
            String json = gson.toJson(student);
            BasicDBObject basicDBObject = new BasicDBObject("Student object",json);
            dbCollection.insert(basicDBObject);

        }
        catch (Exception e){
            System.out.println("something went wrong");
        }*/

        //loading object
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("objects");
        MongoCollection<Document> collection = database.getCollection("collectionObject");
        FindIterable<Document> data = collection.find();
        Gson gson = new Gson();
        for(Document obj : data){
            String job = (String) obj.get("Student object");
            Student Std = gson.fromJson(job,Student.class);
            System.out.println(Std.getName());
            System.out.println("-----------------");
            System.out.println(job);
        }


    }
}
