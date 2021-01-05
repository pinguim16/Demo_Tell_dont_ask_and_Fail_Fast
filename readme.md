# Principio / Padrão - Tell, don't ask e Fail Fast

O padrão normalmente consiste em refatorar o método que possui uma lógica ciclomática. 
Ao refatorar, devemos dar prioridade a falha que poderá ocorrer e eliminar os aninhamentos de ifs.



*Passos realizados :*
* Ao iniciar a refatoração do método, verificamos se em seu escopo possui alguma validação a ser executada como um aninhamento de ifs. 
* Caso exista iremos inverter lógica para realizar a falha em primeiro lugar, pois assim evitamos que a mesma repasse em todos os ifs.
* Ao final movemos o método que irá executar para o enum e assim executará conforme o status enviado.


## Before

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
    
## After

    @GetMapping("/apply")
    public void example(@RequestBody Post post) throws ExceptionCustom {

        if(post.getStatus().equals(Status.ERROR)){
            throw new ExceptionCustom("Don't found Status !");
        }
        post.getStatus().alterStatus(post);
    }

