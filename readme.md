# Principio / Padrão - Tell, don't ask e Fail Fast

O padrão Tell, Don't Ask (Diga,não pergunte) é o principio de Orientção a Objetos, se observamos o código abaixo primeiro fazemos uma pergunta para depois tomar um decisão.

    NotaFiscal nf = new NotaFiscal();
    double valor;
    if (nf.getValorSemImposto() > 10000)  {
     valor = 0.06 * nf.getValor();
    }
    else {
     valor = 0.12 * nf.getValor();
    }

Quando temos esse tipo de código que pergunta e depois toma a decisão, esse códgido não está seguindo o padrão Tell, don't ask.

O código abaixo já está implementando o padrão :
    
    NotaFiscal nf = new NotaFiscal();
    double valor = nf.calculaValorImposto();

É obvio que a implementação está dentro do calculaValorImposto, pois não temos como fugir da regra, mas desta forma estamos delegando para a classe responsável. Sempre que tivermos código seguindo o padrão do primeiro exemplo, estamos aplicando o padrão procedural utilizado muito em linguagens como C.
O principio poder ser utilizado para quebrar uma lógica ciclomática e transferir a responsabilidade desse mesmo método para uma classe ou enum.


Na sequência aplicamos o principio Tell, Don't ask and e o Fail Fast, que consiste em dar prioridade a falha que poderá ocorrer e eliminar os aninhamentos de ifs.

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

