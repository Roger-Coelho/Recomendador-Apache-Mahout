package br.com.roger;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.common.RandomUtils;

import java.io.IOException;

//Classe referente ao Avaliador
//H� a medi��o da taxa de erro da recomenda��o
public class Avaliador {
    public static void main(String[] args) throws IOException, TasteException {
        
    	//O m�todo usetestseed permite fixar valores para testes, impedindo resultados aleat�rios a cada teste
        RandomUtils.useTestSeed();
        
        //Usa para o modelo de an�lise
        DataModel modelo = new Recomendador().getModeloDeFilmes();
        
        //Realiza o c�lculo da m�dia absoluta dos testes para informar a taxa de erro
        RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
        RecommenderBuilder builder = new RecomendadorBuilder();
        
        //Aqui � informada a taxa de 90% para treino e 10% para teste
        double erro = evaluator.evaluate(builder, null, modelo, 0.9, 1.0);
        System.out.println("A taxa de erro desse sistema de recomenda��o atualmente �: ");
        System.out.printf("%.5f",erro);

    }
}