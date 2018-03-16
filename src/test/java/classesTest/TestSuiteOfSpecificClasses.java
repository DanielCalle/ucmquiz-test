package classesTest;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import classes.Areas;

@RunWith(Categories.class)
@IncludeCategory(Areas.class)
//@ExcludeCategory(.class)
@SuiteClasses({ CalculatorWithInterfaceTest.class })
public class TestSuiteOfSpecificClasses {}