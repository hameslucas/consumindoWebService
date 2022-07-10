package br.com.cep.consumindocepwebservice;


import br.com.cep.consumindocepwebservicee.entidade.Endereco;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;


/**
 * Created by andersondebrito on 6/25/2017.
 */
public class CepRest {

    private Client client;
    private WebResource webResource;

    public CepRest() {
        ClientConfig clientConfig = new DefaultClientConfig(GensonProvider.class);
        client = Client.create(clientConfig);
        //Utilizado para imprimir as operacoes no console
        client.addFilter(new LoggingFilter(System.out));
        webResource = client.resource("https://viacep.com.br/ws/");
    }


    public Endereco pesquisaCep(String cep) {
        return webResource.path(cep).path("/json").get(Endereco.class);
//        return webResource.path(cep).path("/json").get(new GenericType<Endereco>() {
//        });
    }

    public static void main(String... args) {
        CepRest notaREST = new CepRest();

        Endereco endereco = notaREST.pesquisaCep("88101020");

        System.out.println("");
        System.out.println("Cep: " + endereco.getCep());
        System.out.println("Logradouro: " + endereco.getLogradouro());
        System.out.println("Bairro: " + endereco.getBairro());
    }
}
