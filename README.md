# JokenpoClientServer

Atividade realizada para a APS da matéria de Sistemas distribuídos da Faculdade Anhembi Morumbi.

# Atividade proposta:
Jokenpô é uma brincadeira de recreação para crianças com origem no Japão. O jogo consiste em escolher entre pedra,papel ou tesoura e dependendo da combinação realizada é determinado um vencedor. As combinações são as seguintes:
•Pedra ganhada tesoura (amassando-a ou quebrando-a).
•Tesoura ganhado papel (cortando-o).
•Papel ganhada pedra(embrulhando-a).

Faça um programa em Java, onde teremos dois tipos de jogos:
•Jogador Vs CPU: o jogador será o usuário do programa e o outro um computador que irá escolher de maneira aleatória uma das três opções de jogo. 
•Jogador Vs Jogador: Serão dois jogadores conectados cada um em uma máquina jogando um contra o outro. 

O programa deve determinar sempre quem foi o vencedor entre o usuário e o computador e entre os dois jogadores, e informar aos usuários em cada rodada e ao finalizar a partida o número de vitórias, derrotas e empates. Para terminar o programa, será necessário realizar uma maneira de fazê-lo parar.

# Desenvolvimento:
Como o professor ensinou em sala como fazer um servidor se comunicar com clientes estilo "Sala de bate papo" onde existem varios clientes conversando entre si em um unico grupo, acordei com o professor de manter o estilo de chat e adicionar a função jogo, onde quando o usuário digita "!jogo" ele informa se é do time vermelho ou azul. Todas as vitorias são contabilizadas no servidor para ou o time vermelho, ou o time azul, ou o servidos, ou empates.

Para ver os resultados é necessário digitar "!resultados" no chat.
