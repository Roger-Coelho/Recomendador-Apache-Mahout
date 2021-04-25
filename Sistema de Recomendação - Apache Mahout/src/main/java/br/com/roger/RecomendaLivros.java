package br.com.roger;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

import java.io.IOException;
import java.util.List;

//Recomenda��o de Livros
public class RecomendaLivros {

	public static void main(String[] args) throws TasteException, IOException {
		DataModel produtos = new Recomendador().getModeloLivros();


		Recommender recommender = new RecomendadorBuilder().buildRecommender(produtos);

		//As recomenda��es s�o listadas para o usu�rio solicitado
		//O primeiro par�metro � o usu�rio e o segundo o n�mero de recomenda��es		
        
		//O primeiro par�metro � o usu�rio e o segundo o n�mero de recomenda��es
		System.out.println("Usu�rio 1");
        List<RecommendedItem> recommendations = recommender.recommend(1, 4);
        for (RecommendedItem recommendation : recommendations) {
            System.out.println("Usu�rio 1, estes livros combinam com voc�:");
            System.out.println(recommendation);
        }

      //O primeiro par�metro � o usu�rio e o segundo o n�mero de recomenda��es
        System.out.println("Usu�rio 2");
        recommendations = recommender.recommend(96, 4);
        for (RecommendedItem recommendation : recommendations) {
            System.out.println("Usu�rio 2, estes livros combinam com voc�:");
            System.out.println(recommendation);
        }

       
    }
}
