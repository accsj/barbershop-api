//Essa é uma API Restful para lidar com o agendamento de consultas.

Motivação para a criação dela: Ao frequentar lugares do meu cotidiano como dentista ou até mesmo um barbeiro, me questionei em como eles lidavam com o agendamento de consultas, em grande parte não tem um sistema robusto,
muitos ainda utilizam por exemplo excel. Portanto eu decidi criar uma api que lidasse com o agendamento de consulta. Eu criei ela com o pensamento de que um usuário poderia tanto ser um cliente quanto um funcionário, onde um funcionário poderia ter ou não uma especialidade,
optei por não utilizar a abstração do usuário pois isso traria uma complexidade a mais para o código e regras de negócios a serem seguidas, portanto eu optei pela herança de composição. A minha visão como um todo é de posteriormente adicionar um gateway de pagamentos, pois a minha ideia principal é realizar uma platarfoma de consultas.

//Visão geral

A minha visão geral com a aplicação é de que o usuário acesso o website, crie sua conta no dentista ou barbearia, seja o que for (eu tentei escrever de um jeito que posteriormente para refatorar para algum caso especifico de uso, ficasse mais fácil),
pudesse criar sua conta e agendar sua consulta com o profissional que ela escolher com a especialidade desejada, minha idealização para esse negócio é de que caso o usuário opte por realizar o agendamento online ele pagaria um valor simbólico para manter o agendamento, pois a empresa poderia ter prejuizo caso ele desmarcasse em cima da hora, então a partir do momento em que
um usuário coloca seu dinheiro em risco (nem que seja simbólico) ele se preocuparia em reagendar para obter o reembolso ou cancelar posteriormente (por isso disse que iria implementar um gateway de pagamentos), então a ideia é que
a empresa consiga consultas de forma autônoma pelo website onde seja atualizado automaticamente na tabela para todos os clientes e funcionários.

//Implementações futuras

Atualmente estou utilizando o id incrementado, porém eu planejo mudar para o UUIDv7 e até mesmo futuramente experimentar por exemplo o SnowflakeId (curiosidade de saber como funciona esse algoritmo complexo que é útil para gerações de id com unicidade em grande escala).
Planejo como disse anteriormente implementar um gateway de pagamentos, onde eu posso agendar reembolsos de forma dinâmica baseados em uma data ou solicitação de um cliente.
E por último criar toda a parte de web design e implementar a minha idealização com o framework angular.

Stacks utilizadas: Java, Spring, MySQL, Docker (planejo utilizar para deploy e já tenho experiência com o containers), e futuramente para frontend Angular e TypeScirpt.
