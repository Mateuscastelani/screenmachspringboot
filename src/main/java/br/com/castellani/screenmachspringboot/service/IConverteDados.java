package br.com.castellani.screenmachspringboot.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe) throws Exception;
}
