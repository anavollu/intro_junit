package test.carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import carrinho.Carrinho;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {
    private Carrinho carrinho;
    private Produto produtoA;
    private Produto produtoB;

    @BeforeEach
    public void inicializa() {
        carrinho = new Carrinho();
    }
    
    @DisplayName("Testa a adi��o de itens")
    @Test
    public void testAdicionaItens() {
    	produtoA = new Produto("Produto A", 0);
    	produtoB = new Produto("Produto B", 0);
    	
    	carrinho.addItem(produtoA);
    	carrinho.addItem(produtoB);
    	
    	Assertions.assertEquals(2, carrinho.getQtdeItems());
    }
    
    @DisplayName("Testa a remo��o de itens")
    @Test
    public void testRemoveItens() throws ProdutoNaoEncontradoException {
    	Produto produtoA = new Produto("Produto A", 0);
    	Produto produtoB = new Produto("Produto B", 0);
    	Produto produtoC = new Produto("Produto C", 0);
    	
    	carrinho.addItem(produtoA);
    	carrinho.addItem(produtoB);
    	carrinho.addItem(produtoC);
    	
    	Assertions.assertEquals(3, carrinho.getQtdeItems());
    	carrinho.removeItem(produtoA);
    	
    	Assertions.assertEquals(2, carrinho.getQtdeItems());
    	carrinho.removeItem(produtoB);
    	
    	Assertions.assertEquals(1, carrinho.getQtdeItems());
    }

    @DisplayName("Testa o retorno do valor total do carrinho")
    @Test
    public void testRetornaValorTotal() {
        produtoA = new Produto("Produto A", 20);
        produtoB = new Produto("Produto B", 20);

        carrinho.addItem(produtoA);
        carrinho.addItem(produtoB);

        Assertions.assertEquals(40, carrinho.getValorTotal());
    }

    @DisplayName("Testa o retorno da quantidade total no carrinho")
    @Test
    public void testRetornaQtdTotal() {
        Produto produtoA = new Produto("Produto A", 0);
		Produto produtoB = new Produto("Produto B", 0);

        carrinho.addItem(produtoA);
        carrinho.addItem(produtoA);
        carrinho.addItem(produtoB);
        carrinho.addItem(produtoB);

        double getQtdeItems = carrinho.getQtdeItems();

        assertEquals(getQtdeItems, 4);
    }

    @DisplayName("Testa o esvazia carrinho remove todos os produtos")
    @Test
    public void testEsvaziaCarrinho() {
        Produto produtoA = new Produto("Produto A", 20);
		Produto produtoB = new Produto("Produto B", 20);

		carrinho.addItem(produtoA);
		carrinho.addItem(produtoB);

		carrinho.esvazia();

		Assertions.assertEquals(0, carrinho.getQtdeItems());
    }
}