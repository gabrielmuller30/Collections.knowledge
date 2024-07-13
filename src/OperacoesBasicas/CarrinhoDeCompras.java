package OperacoesBasicas;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    //atributos
    private List<Item> itemList;

    public CarrinhoDeCompras(){
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        itemList.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){
        List<Item> itensParaRemover = new ArrayList<>();
        if(!itemList.isEmpty()){
            for(Item i : itemList){
                if(i.getNome().equalsIgnoreCase(nome)){
                    itensParaRemover.add(i);
                }
            }
            itemList.removeAll(itensParaRemover);
        }else{
            System.out.println("O carrinho está vazio!");
        }
    }

    public void calcularValorTotal(){
        double valorTotal = 0d;
        if(!itemList.isEmpty()){
            for (Item item : itemList){
                double valorItem = item.getPreco() * item.getQuantidade();
                valorTotal = valorTotal + valorItem;//pode usar também valorTotal += valorItem;
            }
            System.out.println("O valor total do carrinho é: " + valorTotal); 
        }else{
            throw new RuntimeException("O carrinho está vazio.");
        }
    }

    public void exibirItens(){
        if(!itemList.isEmpty()){
            System.out.println(this.itemList);
        }else{
            System.out.println("O carrinho está vazio.");
        }
    }

    @Override
    public String toString() {
        return "CarrinhoDeCompras{" + "itens=" + itemList + "}";
    }
    
    public static void main(String[] args) {
        //Construtor do carrinho
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        //Verificar se o carrinho está vazio
        carrinhoDeCompras.exibirItens();

        //Adicionando itens ao carrinho
        carrinhoDeCompras.adicionarItem("fone de ouvido JBL TUNE", 371.33, 2);
        carrinhoDeCompras.adicionarItem("Creatina Monohidratada 1kg - Souldiers Nutrition", 270.90, 2);
        carrinhoDeCompras.adicionarItem("Xbox Series X", 2344.99, 1);
        carrinhoDeCompras.adicionarItem("Camiseta Brasil Growth", 44.99, 1);

        //exibir os itens do carrinho
        carrinhoDeCompras.exibirItens();

        //Calcular o valor de tudo
        carrinhoDeCompras.calcularValorTotal();

        //Remover item
        carrinhoDeCompras.removerItem("Camiseta Brasil Growth");

        //exibir
        carrinhoDeCompras.exibirItens();

        //calcular novamente
        carrinhoDeCompras.calcularValorTotal();
    }
}