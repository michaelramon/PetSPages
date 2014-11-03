package framework.factories;



import framework.data.CustomersData;
import framework.data.ImportProductData;

public class DataFactory {

	public CustomersData customersData(){
		return new CustomersData();
	}
	public ImportProductData productData(){
		return new ImportProductData();
	}

}
