package br.com.roger;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

import java.io.IOException;
import java.util.List;

//Recomendação de Filmes
public class RecomendaFilmes {
    public static void main(String[] args) throws IOException, TasteException {
        DataModel filmes = new Recomendador().getModeloDeFilmes();
        Recommender recommender = new RecomendadorBuilder().buildRecommender(filmes);
        
        
        //As recomendações são listadas para o usuário solicitado
        //Recebe as informações dos usuários eo número de recomendações do usuário
        //O primeiro parâmetro é o usuário e o segundo o número de recomendações
        
        List<RecommendedItem> recommendations = recommender.recommend(96, 4);
        for (RecommendedItem recommendation : recommendations) {
            System.out.println("Você pode gostar deste filme");
            System.out.println(recommendation);
        }


    }
}
