import java.util.ArrayList;
import java.util.List;


public class Franquia { 
	
	private String nome;
	private String descricao;
	private Image imagem;
	private List restaurantes;

	public Franquia(String nome, String descricao, Image imagem) {
		this.nome = nome;
		this.descricao = descricao;
		this.imagem = imagem;
		this.restaurantes = new ArrayList<Restaurante>();
	}

	public String getNome() {
		return this.nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public Image getImagem() {
		return this.imagem;
  	}

  	public List getRestaurantes(){
  		return this.restaurantes;
  	}

  	public adiciona_restaurante(Restaurante restaurante){
  		this.restaurantes.add(restaurante);
  	}
}

public class Restaurante {

	private String nome;
	private String endereco;
	private String cidade;
	private Image imagem;
	
	public Restaurante(String nome, String endereco, String cidade, Image imagem) {
		this.nome = nome;
		this.endereco = endereco;
		this.cidade = cidade;
		this.imagem = imagem;
	}

	public String getNome() {
		return this.nome;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public String getCidade() {
		return this.cidade;
	}

	public Image getImagem() {
		return this.imagem;
  	}
}

// Instâncias Franquia:

Franquia franquiaUm = new Franquia('Franquia 1', 'Essa é a franquia 1', imagem);
Franquia franquiaDois = new Franquia('Franquia 2', 'Essa é a franquia 2', imagem);
Franquia franquiaTres = new Franquia('Franquia 3', 'Essa é a franquia 3', imagem);
Franquia franquiaQuatro = new Franquia('Franquia 4', 'Essa é a franquia 4', imagem);

// Instâncias Restaurante:

Restaurante restauranteUm = new Restaurante('Restaurante 1', 'Rua 1, n1', 'Balneário Camboriú', imagem);
Restaurante restauranteDois = new Restaurante('Restaurante 2', 'Rua 2, n2', 'Itajaí', imagem);
Restaurante restauranteTres = new Restaurante('Restaurante 3', 'Rua 3, n3', 'Itapema', imagem);

Restaurante restauranteQuatro = new Restaurante('Restaurante 4', 'Rua 4, n4', 'Balneário Camboriú', imagem);
Restaurante restauranteCinco = new Restaurante('Restaurante 5', 'Rua 5, n5', 'Itajaí', imagem);
Restaurante restauranteSeis = new Restaurante('Restaurante 6', 'Rua 6, n6', 'Itapema', imagem);

Restaurante restauranteSete = new Restaurante('Restaurante 7', 'Rua 7, n7', 'Balneário Camboriú', imagem);
Restaurante restauranteOito = new Restaurante('Restaurante 8', 'Rua 8, n8', 'Itajaí', imagem);
Restaurante restauranteNove = new Restaurante('Restaurante 9', 'Rua 9, n9', 'Itapema', imagem);

Restaurante restauranteDez = new Restaurante('Restaurante 10', 'Rua 10, n10', 'Balneário Camboriú', imagem);
Restaurante restauranteOnze = new Restaurante('Restaurante 11', 'Rua 11, n11', 'Itajaí', imagem);
Restaurante restauranteDoze = new Restaurante('Restaurante 12', 'Rua 12, n12', 'Itapema', imagem);

// Adiciona Restaurantes:

franquiaUm.adiciona_restaurante(restauranteUm)
franquiaUm.adiciona_restaurante(restauranteDois)
franquiaUm.adiciona_restaurante(restauranteTres)

franquiaDois.adiciona_restaurante(restauranteQuatro)
franquiaDois.adiciona_restaurante(restauranteCinco)
franquiaDois.adiciona_restaurante(restauranteSeis)

franquiaTres.adiciona_restaurante(restauranteSete)
franquiaTres.adiciona_restaurante(restauranteOito)
franquiaTres.adiciona_restaurante(restauranteNove)

franquiaQuatro.adiciona_restaurante(restauranteDez)
franquiaQuatro.adiciona_restaurante(restauranteOnze)
franquiaQuatro.adiciona_restaurante(restauranteDoze)