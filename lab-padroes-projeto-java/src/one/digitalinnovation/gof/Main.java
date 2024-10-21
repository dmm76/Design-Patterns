package one.digitalinnovation.gof;

import one.digitalinnovation.gof.facade.Facade;
import one.digitalinnovation.gof.singleton.SingletonEager;
import one.digitalinnovation.gof.singleton.SingletonLazy;
import one.digitalinnovation.gof.singleton.SingletonLazyHolder;

public class Main {
    
    public static void main(String[] args) {
        //Lazy 
        SingletonLazy lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);

        //Eager
        SingletonEager eager = SingletonEager.getInstancia();
        System.out.println(eager);

        //LazyHolder
        SingletonLazyHolder lazyHolder = SingletonLazyHolder.getInstancia();
        System.out.println(lazyHolder);
        
        //FACADE
    Facade facade = new Facade();
    facade.migrarCliente("Venilton", "87020-080");

    }
}
