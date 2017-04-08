/**
 * Created by Shehroz Alam on 19/03/2017.
 */
import edu.stanford.nlp.simple.*;
import edu.stanford.nlp.models.sentiment.*;

public class SentimentAnalysis {
    public void analyzeSentiment (String line) {
        // create
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        int mainSentiment = 0;
        if (line != null && line.length() > 0) {
            int longest = 0;
            Annotation annotation = pipeline.process(line);
            out.println(annotation.toShorterString());

            /*for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
                Tree tree = sentence.get(SentimentCoreAnnotations.AnnotatedTree.class);
                int sentiment = RNNCoreAnnotations.getPredictedClass(tree);
                String partText = sentence.toString();
                if (partText.length() > longest) {
                    mainSentiment = sentiment;
                    longest = partText.length();
                }

            }*/
        }
        /*if (mainSentiment == 2 || mainSentiment > 4 || mainSentiment < 0) {
            return 0;
        } else {
            System.out.println(mainSentiment);
        }

        return mainSentiment;*/
    }
}
