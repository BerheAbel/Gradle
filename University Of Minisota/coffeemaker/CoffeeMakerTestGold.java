mport static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.ncsu.csc326.coffeemaker.CoffeeMaker;
import edu.ncsu.csc326.coffeemaker.Recipe;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

public class CoffeeMakerTest {

	private CoffeeMaker coffeeMaker;
	private Recipe recipe1;
	private Recipe recipe2;
	private Recipe recipe3;
	private Recipe recipe4;

	@BeforeEach
	public void setUp() {
		coffeeMaker = new CoffeeMaker();
		recipe1 = new Recipe();
		recipe1.setName("Coffee");
		recipe1.setAmtCoffee("3");
		recipe1.setAmtMilk("1");
		recipe1.setAmtSugar("1");
		recipe1.setAmtChocolate("0");
		recipe1.setPrice("50");

		recipe2 = new Recipe();
		recipe2.setName("Latte");
		recipe2.setAmtCoffee("3");
		recipe2.setAmtMilk("3");
		recipe2.setAmtSugar("1");
		recipe2.setAmtChocolate("0");
		recipe2.setPrice("100");

		recipe3 = new Recipe();
		recipe3.setName("Mocha");
		recipe3.setAmtCoffee("3");
		recipe3.setAmtMilk("1");
		recipe3.setAmtSugar("1");
		recipe3.setAmtChocolate("3");
		recipe3.setPrice("150");

		recipe4 = new Recipe();
		recipe4.setName("Hot Chocolate");
		recipe4.setAmtCoffee("0");
		recipe4.setAmtMilk("3");
		recipe4.setAmtSugar("1");
		recipe4.setAmtChocolate("3");
		recipe4.setPrice("100");
	}

	@Test
	public void testAddRecipe() {
		assertTrue(coffeeMaker.addRecipe(recipe1));
	}

	@Test
	public void testAddDuplicateRecipe() {
		assertTrue(coffeeMaker.addRecipe(recipe1));
		assertFalse(coffeeMaker.addRecipe(recipe1));
	}

	@Test
	public void testAddMaxRecipe() {
		assertTrue(coffeeMaker.addRecipe(recipe1));
		assertTrue(coffeeMaker.addRecipe(recipe2));
		assertTrue(coffeeMaker.addRecipe(recipe3));
		assertFalse(coffeeMaker.addRecipe(recipe4));
	}

	@Test
	public void testDeleteRecipe() {
		coffeeMaker.addRecipe(recipe1);
		assertEquals("Coffee", coffeeMaker.deleteRecipe(0));
	}

	@Test
	public void testDeleteNonexistentRecipe() {
		assertEquals(null, coffeeMaker.deleteRecipe(0));
	}

	@Test
	public void testEditRecipe() {
		coffeeMaker.addRecipe(recipe1);
		Recipe newRecipe = new Recipe();
		newRecipe.setName("New Coffee");
		newRecipe.setAmtCoffee("4");
		newRecipe.setAmtMilk("1");
		newRecipe.setAmtSugar("2");
		newRecipe.setAmtChocolate("0");
		newRecipe.setPrice("75");
		assertEquals("New Coffee", coffeeMaker.editRecipe(0, newRecipe));
	}

	@Test
	public void testEditNonexistentRecipe() {
		Recipe newRecipe = new Recipe();
		newRecipe.setName("New Coffee");
		newRecipe.setAmtCoffee("4");
		newRecipe.setAmtMilk("1");
		newRecipe.setAmtSugar("2");
		newRecipe.setAmtChocolate("0");
		newRecipe.setPrice("75");
		assertEquals(null, coffeeMaker.editRecipe(0, newRecipe));
	






