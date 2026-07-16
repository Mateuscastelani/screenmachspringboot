package br.com.castellani.screenmachspringboot.principal;

import br.com.castellani.screenmachspringboot.model.DadosSerie;
import br.com.castellani.screenmachspringboot.model.DadosTemporada;
import br.com.castellani.screenmachspringboot.service.ConsumoApi;
import br.com.castellani.screenmachspringboot.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY =  "&apikey=ddc92677";


    public void exibeMenu() throws Exception {
        System.out.println("Digite o nome da série: ");
        var nomeSerie = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();

        for(int i = 1; i<=dados.totalTemporadas(); i++) {
            json = consumo.obterDados ( ENDERECO + nomeSerie.replace(" ", "+") + "&season" + API_KEY);
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);

        }
        temporadas.forEach(System.out::println);



    }
}
