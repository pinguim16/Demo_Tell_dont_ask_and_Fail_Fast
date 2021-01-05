# Principio / Padrão - Tell, don't ask e Fail Fast

O padrão consiste primeiramente em enviar para a classe o metodo responsável que irá realizar a operação.
Após a criação do método, verificamos se em seu escopo possui alguma validação a ser executada como um aninhamento de ifs. 
Caso exista iremos inverter lógica para realizar a falha em primeiro lugar, pois assim evitamos que a mesma repasse em todos os ifs.

## After 

    @GetMapping("/notapply")
    public void example(@RequestBody Post post) throws ExceptionCustom {
        if(post.getStatus().equals(Status.DRAFT)){
            post.setStatus(Status.PUBLISH);
        }else if(post.getStatus().equals(Status.PUBLISH)){
            post.setStatus(Status.REMOVE);
        }else if(post.getStatus().equals(Status.REMOVE)){
            post.setStatus(Status.DRAFT);
        }else{
            throw new ExceptionCustom("Don't found Status !");
        }
    }

