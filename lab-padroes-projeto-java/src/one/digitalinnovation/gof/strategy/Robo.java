package one.digitalinnovation.gof.strategy;

public class Robo {

    //Propriedade do Robo
    private Comportamento comportamento;

    //Metodo SET para mudar o comportamento do Robo
    public void setComportamento(Comportamento comportamento){
        this.comportamento = comportamento;
    }

    public void mover(){
        comportamento.mover();
    }


}
