package Estoque;

import Automoveis.Automovel;
import Pessoas.Cliente;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Serializador {
    public static void gravar(String nome_arquivo, Object objeto) throws IOException {
        FileOutputStream arquivo = new FileOutputStream(nome_arquivo);
        ObjectOutputStream gravador = new ObjectOutputStream(arquivo);
        gravador.writeObject(objeto);
        gravador.close();
        arquivo.close();
    }
    public static Object ler(String nome_arquivo) throws IOException, ClassNotFoundException {
        FileInputStream arquivo = new FileInputStream(nome_arquivo);
        ObjectInputStream restaurador = new ObjectInputStream(arquivo);
        Object objeto = restaurador.readObject();
        restaurador.close();
        arquivo.close();
        return objeto;
    }
    public static HashMap<Automovel,Integer> lerhash (String nome_arquivo) throws IOException, ClassNotFoundException{
        FileInputStream arquivo = new FileInputStream(nome_arquivo);
        ObjectInputStream restaurador = new ObjectInputStream(arquivo);
        HashMap<Automovel, Integer> hashMap = (HashMap<Automovel, Integer>) restaurador.readObject();
        restaurador.close();
        arquivo.close();
        return hashMap;
    }

    public static ArrayList<Cliente> lerarray (String nome_arquivo) throws IOException, ClassNotFoundException{
        FileInputStream fileIn = new FileInputStream(nome_arquivo);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ArrayList<Cliente> list = (ArrayList<Cliente>) in.readObject();
        in.close();
        fileIn.close();
        return list;
    }
}

