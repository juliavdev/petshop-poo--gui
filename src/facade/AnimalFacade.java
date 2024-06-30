package facade;

import java.util.ArrayList;

import model.Animal;

public class AnimalFacade {
	
	public static ArrayList<Animal> animais = new ArrayList<Animal>();
	public static int sequenciaCodigo = 1;
	
	public static Animal carregar(int codigo) {
		for (Animal animal : animais) {
			if(animal.getCodigo() == codigo)
				return animal;
		}
		return null;
	}
	
	public static void adicionar (Animal animal) {
		animal.setCodigo(sequenciaCodigo);
		animais.add(animal);
		sequenciaCodigo++;
	}
	
	public static void alterar (Animal animalAlterar) {
		Animal animal = carregar(animalAlterar.getCodigo());
		animal.setNome(animalAlterar.getNome());
		animal.setEspecie(animalAlterar.getEspecie());
	}
	
	public static void remover(int codigo) {
		Animal animal = carregar(codigo);
		if(animal != null)
			animais.remove(animal);
	}
	
	
}

