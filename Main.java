package br.edu.fatecpg.StreamLambda.View;

import br.edu.fatecpg.StreamLambda.Service.ConsomeApi;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        try {
            System.out.println("Esses foram os email dos clientes que mandaram a sua opinião sobre o produto de nossa empresa");

            String respostaJson = ConsomeApi.fazerRequisicao();

            Pattern padrao = Pattern.compile("\"email\": \"(.*?)\"");
            Matcher matcher = padrao.matcher(respostaJson);

            List<String> emails = matcher.results()
                    .map(result -> result.group(1))
                    .collect(Collectors.toList());

            emails.forEach(email -> System.out.println(" " + email));


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            // dando bug sem esse kraio...
            Thread.currentThread().interrupt();
        }

    }

}
