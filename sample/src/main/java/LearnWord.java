//pseudo code=========================*************************************

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class LearnWord {
    public void learnWord(String inputText) {
        //processing text sentence by sentence.
        String processText = inputText.toLowerCase();
        Pattern getSentenceRegEx = Pattern.compile("([\\w*+\\s]*+[.!?])"); //get sentence
        Matcher sentenceMatcher = getSentenceRegEx.matcher(processText);
        while (sentenceMatcher.find()) { //each sentence taken into consideration
            String processSentence = sentenceMatcher.group();
            SentimentAnalysis getSentiment = new SentimentAnalysis();
            int sentenceSentiment =
                    getSentiment.analyzeSentiment(processSentence);
            boolean isPositive = false;
            final short negativeSentiment = 0;
            final short positiveSentiment = 0;

            if (sentenceSentiment >= positiveSentiment) {
                isPositive = true;
            } else if (sentenceSentiment <= negativeSentiment) {
                isPositive = false;
            }
            assignEmotions(processSentence, isPositive);

        }


    }

    //This function assigns emotions to every new word
    public void assignEmotions(String readString, boolean isPositive) {
        Pattern justOneWord = Pattern.compile("([\\w*+\\s]*+[.!?])"); //get sentence
        Matcher sentenceMatcher = justOneWord.matcher(readString);
        HashMap wordsFound = new HashMap();//to store the words found in dicitonary

        while (sentenceMatcher.find()) {
            String mySingleWord = sentenceMatcher.group();
            if (!Utils.isStopWord(mySingleWord)) { //here check for unwanted words(STOP WORDS) (e.g "if" "what" "when")
                //db operation will execute here
                MongoCollection<Document> mongoCollection = Utils.mongoAccess("Dictionary");
                BasicDBObject query = new BasicDBObject();
                query.put("word", mySingleWord);

                //This block of code is used to check if the word
                //does not exist in the dictionary
                if(mongoCollection.count(query) == 0L)//the word does not exist, now teach!
                {
                    //create a document in Mongo dictionary for this word
                    //every word is a seperate document
                    Document myWordDocument = new Document();
                    myWordDocument.put("word", mySingleWord); //create the word
                    //positive emotion list
                    List<EmotionsEnum> positiveEmotions = new ArrayList<>(); //list of positive emotions enums
                    //inside this list are objects of enums, creating hashmaps!
                    Map<EmotionsEnum, Float> happiness = new HashMap<>();
                    //compute value for emotions and put it in hashmap
                    //create a generic function which computes the value for each emotion enum

                    myWordDocument.put()
                    mongoCollection.insertOne();
                }

                //This is used if the word exists already in the dicitonary
                //It can also be improved later on if wanted
                //comment this section out for that!

                /*FindIterable<Document> findIterable = mongoCollection.find( query );
                for (Document matchedDocument : findIterable) {

                }*/ //This is if the word is existing and you want to improve it


                if (isPositive) { //will access the positive emotions of the word in our dictionary
                    //positive emotions are as follows
                    // [HAPPY, CONTENT, CALM, INTRIGUED, NOSTALGIC]#
                    //pseudo code
                    MongoCollection<Document> dictionary = Utils.mongoAccess("Dictionary");
                    //add all the words in the array that are existing in the dicitonary
                    for(int i = 0; i<mySentence.length; ++i)
                    {
                        if(dictionary.find(mySentence[i]));
                        wordsFound.put(mySentence[i],i); //putting words inside the hashmap with the index
                    }
                    FindIterable<Document> findIterable = mongoCollection.find(myWord);


                } else { // will access the positive emotions of the word in our dictionary
                    //negative emotions are as follows
                    // [SAD, FRUSTRATED, ANGER, BORED, INTRIGUED, NOSTALGIC]
                }
            }

        }

    }


}