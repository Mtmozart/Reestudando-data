import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args){

//        LocalDate d01 = LocalDate.now();
//        LocalDate conversao = LocalDate.parse("2024-07-20");
//        LocalDateTime d02 = LocalDateTime.now();
//        LocalDateTime convertido = LocalDateTime.parse("2024-07-20T01:30:26");
//        Instant conterte = Instant.parse("2024-07-20T01:30:26Z");
//        Instant converteInstant= Instant.parse("2024-08-19T17:05:26-03:00");
//
//        Instant d03 = Instant.now();


//        System.out.println(converteInstant);
//        System.out.println(d02);
//        System.out.println(d03);
//        System.out.println(conversao);
//        System.out.println(convertido);


        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate conversao = LocalDate.parse("20/07/2024", formatacao);
        System.out.println(conversao);

        DateTimeFormatter formatacao2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime conversao2 = LocalDateTime.parse("20/07/2024 02:30", formatacao2);
        System.out.println(conversao2);
    }
}