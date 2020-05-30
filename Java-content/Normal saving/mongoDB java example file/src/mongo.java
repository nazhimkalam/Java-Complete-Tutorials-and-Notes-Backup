import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class mongo {
    public static void main(String[] args) {
        // Creating a Mongo client
        MongoClient mongo = new MongoClient( "localhost" , 27017 );

        // Accessing the database
        MongoDatabase database = mongo.getDatabase("myDb");

        // Retrieving a collection
        MongoCollection<Document> collection = database.getCollection("collectionOne");
        System.out.println("Collection myCollection selected successfully");
        collection.updateOne(Filters.eq("title", "MongoDB"), Updates.set("likes", 45125));
        System.out.println("Document update successfully...");

        //deletion of a document from a collection
        collection.deleteOne(Filters.eq("title", "MongoDB"));
        System.out.println("Document deleted successfully...");

        // Retrieving the documents after updation
        // Getting the iterable object
        FindIterable<Document> iterDoc = collection.find();
        int i = 1;
        // Getting the iterator
        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            i++;
        }

        //Displaying the collection name sin the database
        for(String name : database.listCollectionNames()){
            System.out.println(name);
        }
    }
}
