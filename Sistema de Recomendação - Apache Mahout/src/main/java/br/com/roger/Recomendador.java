package br.com.roger;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;

import java.io.File;
import java.io.IOException;


//Nesta classe est� a rela��o dos modelos de filmes e livros para serem recomendados
public class Recomendador {

    public DataModel getModeloLivros() throws IOException {
        
    	//Arquivo usado com a base de usu�rios, os c�digos dos livros e as notas atribu�das
        return getModelo("livros.csv");
    }

    private DataModel getModelo(String path) throws IOException {
        File file = new File("src/main/resources/" + path);
        return new FileDataModel(file);
    }

    public DataModel getModeloDeFilmes() throws IOException {
    	
    	//Arquivo usado com a base de usu�rios, os c�digos dos filmes e as notas atribu�das        
       return getModelo("filmes.csv");
    }

}
