// Brandon Andre

public class Wrapper {

	public static void main(String[] arg){
		
		//Declare test variables for the add integers method.
		Integer a1 = 5;
		Integer b1 = 4;
		
		//Declare test variables for the divide float method.
		Float a2 = 5f;
		Float b2 = 0f;
		
		//Instantiate the Wrapper class.
		Wrapper wrapper = new Wrapper();
		
		System.out.println(wrapper.addIntegers(a1, b1));
		System.out.println(wrapper.divideFloats(a2, b2));
	}
	
	public Long addIntegers(Integer a, Integer b) {
		//Before Java 5
		Long ao = new Long(a.longValue());
		Long bo = new Long(b.longValue());
		
		//Return the expression.
		return (ao + bo);
	}

	//Brandon Andre
	public Double divideFloats(Float a, Float b) {
		//After Java 5
		Double ao = a.doubleValue();
		Double bo = b.doubleValue();
		
		/*
		 * 	//Before Java 5
		 *  Double ao = new Double(a.doubleValue());
		 *  Double bo = new Double(b.doubleValue());
		 */
		
		//Declare a variable to store the expression.
		Double expression = ao/bo;
		
		//Check if the expression is infinite or NaN, if so return null.
		if (expression.isInfinite() || expression.isNaN()){
			return null;
		} else {
			//Expression is normal, just return it.
			return expression;
		}
	}

}
