import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by Shehroz Alam on 12/03/2017.
 */


public class DataBaseAccess {
    public static void main(String[] Args) {

        LearnWord learnWord = new LearnWord();
        String inputParah = "";
        learnWord.learnWord(inputParah);





            String processWord = (String) dictionaryDocument.get("word"); //casting key to string
            ArrayList<Integer> myArray = (ArrayList<Integer>) aFindIterable.get(myWord);
            final AtomicInteger biggestEmo = new AtomicInteger(0);
            myArray.forEach(myEmotions -> {
                if (myEmotions > biggestEmo.get()) {
                    biggestEmo.set(myEmotions);
                }

                myEmotions
            });

            System.out.println(myArray);

        }
    }



}
