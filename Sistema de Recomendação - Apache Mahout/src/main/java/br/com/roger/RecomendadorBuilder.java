package br.com.roger;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;


//Esta classe construímos o recomendador
public class RecomendadorBuilder implements RecommenderBuilder {
    public Recommender buildRecommender(DataModel model) throws TasteException {
        
    	//Construção das recomendações com base na similaridade entre usuários
        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
        
        //Pega o valor da maior similaridade da vizinhança entre usuários
        UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
        
        //Realiza a recomendação baseada no usuário, que é retornada no recomendador
        UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
        return recommender;
    }
}
