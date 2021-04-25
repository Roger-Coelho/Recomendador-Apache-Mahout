package br.com.roger;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

import java.io.IOException;
import java.util.List;

//Recomendação de Livros
public class RecomendaLivros {

	public static void main(String[] args) throws TasteException, IOException {
		DataModel produtos = new Recomendador().getModeloLivros();


		Recommender recommender = new RecomendadorBuilder().buildRecommender(produtos);

		//As recomendações são listadas para o usuário solicitado
		//O primeiro parâmetro é o usuário e o segundo o número de recomendações		
        
		//O primeiro parâmetro é o usuário e o segundo o número de recomendações
		System.out.println("Usuário 1");
        List<RecommendedItem> recommendations = recommender.recommend(1, 4);
        for (RecommendedItem recommendation : recommendations) {
            System.out.println("Usuário 1, estes livros combinam com você:");
            System.out.println(recommendation);
        }

      //O primeiro parâmetro é o usuário e o segundo o número de recomendações
        System.out.println("Usuário 2");
        recommendations = recommender.recommend(96, 4);
        for (RecommendedItem recommendation : recommendations) {
            System.out.println("Usuário 2, estes livros combinam com você:");
            System.out.println(recommendation);
        }

       
    }
}
