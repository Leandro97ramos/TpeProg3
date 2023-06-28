//la metrica es la cantidad de veces que se llama a backtraking
List<Tunel> back(Grafo g){

    List<Tunel> parcial;
    back(parcial, 0);
}

back(List<Tunel> parcial, int indice, List<Tunel> tuneles){

    if(indice == tuneles.size()){
        if(esSolucion(parcial)){

            parcial.kms > mejor.kms

        }
    }else{
        Tunel tunel = tuneles.get(indice);

        parcial.add(tunel);
        back(parcial, indice + 1, tuneles);
        parcial.remove(tunel);

        back(parcial, indice + 1, tuneles);

    }
}

boolean esSolucion(List<Tunel> parcial, int cantidadEstaciones){
    UnionFind uf = new UnionFind(cantidadEstaciones);
    for(Tunel t : parcial){
        uf.union(t.getEstacionOrigen() -1 , t.getEstacionDestino() -1);
    }

}    List<Tunel> tuneles = g.obtenerArcos();
