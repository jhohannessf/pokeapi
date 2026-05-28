package contratos;

//O <T> é um Generic — significa que essa interface funciona para qualquer tipo de objeto, não só Pokemon.
//Assim você poderia reutilizar para buscar CEPs, filmes, etc.

public interface IConsulta<T> {
    T buscar(String busca);
}
