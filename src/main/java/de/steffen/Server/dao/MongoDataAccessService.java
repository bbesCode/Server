package de.steffen.Server.dao;

import com.mongodb.DB;
import com.mongodb.client.*;
import de.steffen.Server.model.Person;
import org.bson.Document;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("Mongodao")
public class MongoDataAccessService  {

    final MongoClient mongoClient;
    final MongoDatabase userDatabase;
    final MongoCollection<Document> userCollection;


    public MongoDataAccessService(){
        mongoClient = MongoClients.create(
                "mongodb+srv://bbes:bbes4ever@projektdb-3wcrj.mongodb.net/test?retryWrites=true&w=majority");

        userDatabase = mongoClient.getDatabase("ProjektDB");
        userCollection = userDatabase.getCollection("userCollection");
    }

    public Document createUserDocument(String id, String name){
        return new Document("id", id).append("name",name);
    }


    public int insertUser(String id, String name) {
        userCollection.insertOne(createUserDocument(id,name));
        return 1;
    }


    public Document selectUserById(String id) {
        Document student = userCollection.find(new Document("id", id)).first();
        return student;

    }

    public List<Document> selectAllUsers(){
        MongoCursor<Document> cursor = userCollection.find().iterator();
        List<Document> userList = new ArrayList<Document>();
        try {
            while (cursor.hasNext()) {
                userList.add(cursor.next());
            }
        } finally {
            cursor.close();
        }
        return userList;
    }


    public int deleteUserById(String id) {
        Document userMaybe = selectUserById(id);
        if(userMaybe == null){
            return 0;
        }
        userCollection.deleteOne(userMaybe);
        return 1;
    }


}
