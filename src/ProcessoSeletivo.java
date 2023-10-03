import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
    
        List<String> candidadosSelecionados = selecionaCandidatos();

        System.out.println("\nCandidatos Selecionados: ");
        candidadosSelecionados.forEach(System.out::println);
        System.out.println("\n");
        candidadosSelecionados.stream().forEach(c -> {
            entraEmContato(c);
        });

    }

    public static void entraEmContato(String candidato){

        int tentativasContato = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            
            atendeu = atender();
            continuarTentando = !atendeu;

            if (continuarTentando) {
                tentativasContato++;
            }
            else {
                System.out.println("CONTATO REALIZADO COM SUCESSO!");
            }

        } while (continuarTentando && tentativasContato < 3);

        if (atendeu) {
            System.out.println("\nContato estabelecido com " + candidato + " na " + tentativasContato + " tentativa");
        }
        else {
            System.out.println("\nNao conseguimos contato com " + candidato + ". Numero maximo de tentativas alcancadas");
        }

    }

    public static boolean atender(){
        return new Random().nextInt(3) == 1;
    } 

    public static List<String> selecionaCandidatos(){
        List<String> candidatos = new ArrayList<String>(Arrays.asList("FELIPE", "MARCIA", "JULIA", "JORGE", "AUGUSTO", "FABRICIO"));
        List<String> candidatosSelecionadosList = new ArrayList<>();

        int candidatosSelecionados = 0;

        int i = 0;

        while (candidatosSelecionados < 5 && i < candidatos.size()) {

            String candidato = candidatos.get(i);
            double salarioPretendido = valorPretendidoRandom();

            System.out.println("Candidato(a) " + candidato + " solicitou salario de " + salarioPretendido);
            boolean selecionado = analisarCandidato(salarioPretendido, candidato);

            if (selecionado) {
                candidatosSelecionadosList.add(candidato);
            }

            i++;
        }

        return candidatosSelecionadosList;

    }

    public static double valorPretendidoRandom(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    public static boolean analisarCandidato(Double salarioPretendidoCandidato, String nomeCandidato){

        boolean selecionado = false;

        Double salarioBase = 2000.0;

        if (salarioBase > salarioPretendidoCandidato) {
            System.out.println("LIGAR PARA O CANDIDATO " + nomeCandidato);
            selecionado = true;
        }
        else if (salarioPretendidoCandidato.equals(salarioBase)) {
            System.out.println("LIGAR PARA O CANDIDATO "+ nomeCandidato +" COM CONTRA PROPOSTA");
        }
        else {
            System.out.println("AGUARDANDO RESPOSTA DOS DEMAIS CANDIDADOS");
        }


        return selecionado;

    }
}
