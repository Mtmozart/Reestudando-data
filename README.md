# Data e Hora Global x Data e Hora Local

## Diferença entre Data e Hora Global e Local

- **Data e Hora Global (UTC)**: Armazenada sem considerar o fuso horário, a data global é representada em um formato ISO, como `2024-08-18T12:00:00.000Z`, onde o "Z" indica o Tempo Universal Coordenado (UTC).

- **Data e Hora Local**: Inclui o fuso horário do sistema, sendo representada, por exemplo, como `Sun Aug 18 2024 12:00:00 GMT-0300 (Brasília Standard Time)`.

A diferença entre essas duas datas pode ser calculada para determinar a duração, ou seja, o tempo decorrido entre os dois instantes.

## Quando Usar a Data Local?

- Utilize a data local quando o fuso horário não é relevante para pessoas em outros fusos horários.
- Exemplos: Sistemas de região única e planilhas como Excel.

## Quando Usar a Data Global?

- Utilize a data global quando o momento exato é relevante para pessoas em outros fusos horários, pois o dado se adaptará ao fuso horário do servidor que o processar.
- Exemplos: Sistemas multi-região e aplicações web.

## Timezone e Fuso Horário

### GMT e UTC

- **GMT (Greenwich Mean Time)**: É o tempo médio de Greenwich, usado como referência para fusos horários ao redor do mundo. Baseado no tempo solar médio no meridiano de Greenwich, Londres.

- **UTC (Tempo Universal Coordenado)**: É o padrão de tempo usado mundialmente como referência para fusos horários. Ele é baseado em uma combinação precisa do tempo atômico internacional (TAI) e o tempo solar médio no meridiano de Greenwich (semelhante ao GMT, mas mais exato).

Fusos horários ao redor do mundo são determinados com base no UTC (Tempo Universal Coordenado) e, historicamente, no GMT (Hora Média de Greenwich).

### Exemplos de Fusos Horários

- **Brasília, Brasil**: Durante o horário padrão, Brasília segue o fuso horário UTC-3, ou seja, três horas atrás do UTC.
- **Reino Unido**: Durante o horário padrão, o Reino Unido segue o UTC, mas durante o horário de verão, os relógios são adiantados em uma hora, ficando no fuso horário UTC+1.

### Identificação de Fusos Horários

Muitas linguagens de programação e tecnologias usam nomes específicos para fusos horários no formato `Região/Cidade`. Esses nomes ajudam a identificar corretamente o fuso horário e ajustar datas e horários de acordo com mudanças regionais e horários de verão. Exemplos incluem:

- `US/Pacific`: Refere-se ao fuso horário do Pacífico nos Estados Unidos.
- `America/Sao_Paulo`: Refere-se ao fuso horário de São Paulo, Brasil.

Esses nomes são úteis para garantir precisão e compatibilidade em aplicações que precisam lidar com diferentes fusos horários globalmente.

## Padrão ISO 8601 para Datas e Horas

O padrão ISO 8601 é uma norma internacional para a representação de datas e horas. Ele define formatos claros e consistentes para expressar datas e horários, tanto locais quanto globais.
Obs: Caso queira que uma data converta-se para o padrão ISO 8601, use o toString(), pois, por padrão as classes gerarão o texto para o padrão em destaque.
### Exemplos de Data-Hora Local

- `2022-07-21`: Representa uma data sem uma hora específica.
- `2022-07-21T14:52`: Representa uma data e hora local, sem segundos.
- `2022-07-22T14:52:09`: Representa uma data e hora local, incluindo segundos.
- `2022-07-22T14:52:09.4073`: Representa uma data e hora local, incluindo milissegundos.

### Exemplos de Data-Hora Global (UTC)

- `2022-07-23T14:52:09Z`: Representa uma data e hora em UTC, com "Z" indicando que está em Tempo Universal Coordenado.
- `2022-07-23T14:52:09.254935Z`: Representa uma data e hora em UTC, com precisão de microsegundos.
- `2022-07-23T14:52:09-03:00`: Representa uma data e hora com o deslocamento de fuso horário, indicando que está 3 horas atrás do UTC.


# Principais Tipos Java para Manipulação de Datas e Horas (Versão 8+)

Com o lançamento do Java 8, a linguagem trouxe um novo pacote de classes para manipulação de datas e horas, denominado `java.time`. Este pacote resolve muitas das limitações do antigo `java.util.Date` e `java.util.Calendar`, oferecendo uma API mais intuitiva, segura e orientada a objetos. A seguir, exploraremos os principais tipos de data e hora introduzidos, incluindo suas funcionalidades e cenários de uso.

## Data-Hora Local

### `LocalDate`

- **Descrição**: `LocalDate` representa uma data (dia, mês, ano) sem qualquer informação de horário ou fuso horário. É ideal para representar aniversários, datas de vencimento e outras datas significativas que não precisam de um horário específico.
- **Exemplo de uso**:
  ```java
  LocalDate agora = LocalDate.now(); // Retorna a data atual no formato YYYY-MM-DD
  
  //Passando uma string para LocalDate
  LocalDate conversao = LocalDate.parse("2024-07-20"); //Formato YYYY/MM/DD  
  LocalDate aniversário = LocalDate.of(1990, Month.AUGUST, 18); // Cria uma data específica  
  ```

### `LocalDateTime`

- **Descrição**: `LocalDateTime` combina uma data (dia, mês, ano) com uma hora (hora, minuto, segundo e nanossegundo), mas ainda sem qualquer fuso horário. Ele é usado para representar momentos específicos no tempo, como agendamentos ou marcações de eventos locais.
- **Exemplo de uso**:
  ```java
  LocalDateTime agora = LocalDateTime.now(); // Retorna a data e hora atual no formato YYYY-MM-DDTHH:MM:SS
  LocalDateTime convertido = LocalDateTime.parse("2024-07-20T01:30:26");//Formato YYYY/MM/DDTHH:MM:SS 
  LocalDateTime reuniao = LocalDateTime.of(2024, Month.AUGUST, 18, 15, 30); // Cria uma data e hora específica
  ```

## Data-Hora Global

### `Instant`

- **Descrição**: `Instant` representa um ponto específico na linha do tempo em UTC (Tempo Universal Coordenado). 
Ele é útil para registrar momentos em sistemas distribuídos onde a exatidão temporal entre fusos horários é crucial. Um `Instant` é uma boa escolha para representar timestamps ou datas que precisam ser consistentes globalmente.
- **Exemplo de uso**:
  ```java
  Instant timestamp = Instant.now(); // Retorna o momento atual no UTC -YYYY-MM-DDTHH:MM:SSZ
  Instant converte = Instant.parse("2024-07-20T01:30:26Z");//Apenas converte
  Instant converteInstant= Instant.parse("2024-08-19T17:05:26-03:00");//Converte o horário que passo para o UTC.****
  Instant momentoEspecifico = Instant.parse("2024-08-18T15:30:00Z"); // Cria um instante específico
  ```

## Duração

### `Duration`

- **Descrição**: `Duration` representa um intervalo de tempo, normalmente medido em segundos ou nanossegundos. Ele é utilizado para calcular a diferença entre dois `Instant` ou `LocalDateTime`. Este tipo é útil para operações como medir tempos de execução, agendar tarefas com intervalo fixo ou determinar o tempo decorrido entre dois eventos.
- **Exemplo de uso**:
  ```java
  Duration duration = Duration.ofHours(5); // Cria uma duração de 5 horas
  Duration between = Duration.between(startTime, endTime); // Calcula a duração entre dois instantes
  ```

## Outros

### `ZoneId`

- **Descrição**: `ZoneId` representa um fuso horário específico, como "America/Sao_Paulo" ou "Europe/London". Ele é usado em combinação com outras classes de data e hora para aplicar o fuso horário correto a uma data ou hora.
- **Exemplo de uso**:
  ```java
  ZoneId zoneId = ZoneId.of("America/Sao_Paulo"); // Cria uma zona para o fuso horário de São Paulo
  ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.now(), zoneId); // Combina a data e hora com o fuso horário
  ```

### `ChronoUnit`

- **Descrição**: `ChronoUnit` é uma enumeração que define unidades de tempo, como dias, meses, anos, horas, etc. Ele é útil para realizar operações de cálculo, como adicionar ou subtrair períodos de tempo.
- **Exemplo de uso**:
  ```java
  LocalDate nextWeek = LocalDate.now().plus(1, ChronoUnit.WEEKS); // Adiciona uma semana à data atual
  long daysBetween = ChronoUnit.DAYS.between(startDate, endDate); // Calcula o número de dias entre duas datas
  ```

## Formatando datas
Usa-se como referência o DateTimeFormatter, seguindo o link para acesso:
[DateTimeFormatter](https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html)]

Para criar uma formatação, basta importar o DateTimeFormatter, nele você colocar o padrão que quer, onde deve-se colocar as strings recomendadas pela documentação, conforme exemplo:

```java
    //Formatação para LocalDate
   DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
   LocalDate conversao = LocalDate.parse("20/07/2024", formatacao);

   //Formatação para LocalDateTime
   DateTimeFormatter formatacao2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
   LocalDateTime conversao2 = LocalDateTime.parse("20/07/2024 02:30", formatacao2);
  ```

Obs: o DateTimeFormatter também pode ser passado dentro dos parenteses.

```java
    //Formatação para LocalDate
   DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
   LocalDate conversao = LocalDate.parse("20/07/2024", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
```

