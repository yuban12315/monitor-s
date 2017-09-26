package dbs;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by HastuneMiku on 2017/8/16.
 */
public class MongoDB {
    private static MongoCollection<Document>collection=null;

    public static MongoCollection<Document>getCollection(){
        if(collection==null){
            MongoClient mongoClient=new MongoClient("127.0.0.1",27017);

            MongoDatabase mongoDatabase=mongoClient.getDatabase("Monitor");
            return mongoDatabase.getCollection("admin");
        }
        return collection;
    }

    public  static void main(String args[]){
        try {
            MongoCollection<Document>collection1=getCollection();
            FindIterable<Document> findIterable = collection1.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while(mongoCursor.hasNext()){
                System.out.println(mongoCursor.next());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
