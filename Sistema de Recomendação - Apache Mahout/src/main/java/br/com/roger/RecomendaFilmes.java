package br.com.roger;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

import java.io.IOException;
import java.util.List;

//Recomenda��o de Filmes
public class RecomendaFilmes {
    public static void main(String[] args) throws IOException, TasteException {
        DataModel filmes = new Recomendador().getModeloDeFilmes();
        Recommender recommender = new RecomendadorBuilder().buildRecommender(filmes);
        
        
        //As recomenda��es s�o listadas para o usu�rio solicitado
        //Recebe as informa��es dos usu�rios eo n�mero de recomenda��es do usu�rio
        //O primeiro par�metro � o usu�rio e o segundo o n�mero de recomenda��es
        
        List<RecommendedItem> recommendations = recommender.recommend(96, 4);
        for (RecommendedItem recommendation : recommendations) {
            System.out.println("Voc� pode gostar deste filme");
            System.out.println(recommendation);
        }


    }
}
