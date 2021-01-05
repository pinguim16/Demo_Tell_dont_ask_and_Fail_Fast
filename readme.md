# Principio / Padrão - Tell, don't ask e Fail Fast

O padrão consiste primeiramente em enviar para a classe o metodo responsável que irá realizar a operação.
Após a criação do método, verificamos se em seu escopo possui alguma validação a ser executada como um aninhamento de ifs. 
Caso exista iremos inverter lógica para realizar a falha em primeiro lugar, pois assim evitamos que a mesma repasse em todos os ifs.